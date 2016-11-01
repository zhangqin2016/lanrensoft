package zhang.lao.console.service;

import com.google.common.collect.Lists;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zhang.lao.console.cache.ConsoleCacheNameContanst;
import zhang.lao.console.model.bootstrapQ.QTree;
import zhang.lao.mybatis.auto.dao.SysNavMapper;
import zhang.lao.mybatis.auto.dao.SysNavRoleMapper;
import zhang.lao.mybatis.auto.dao.SysRoleMapper;
import zhang.lao.mybatis.auto.dao.SysUserRoleMapper;
import zhang.lao.mybatis.auto.model.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tech6 on 2016/8/2.
 */
@Service
public class ConsoleSysRoleServiceImp implements ConsoleSysRoleService {

    @Resource
    private  SysRoleMapper sysRoleMapper;
    @Resource
    private SysUserRoleMapper sysUserRoleMapper;
    @Resource
    private SysNavMapper sysNavMapper;
    @Resource
    private SysNavRoleMapper sysNavRoleMapper;

    public String getSelectRoleHtmlByUserId(Integer id) {
        StringBuffer div=new StringBuffer();
        List<SysRole> listRole=sysRoleMapper.selectByExample(null);
        for (SysRole sysRole : listRole) {
            String checked="";
            if(containsRole(id, sysRole)){
                checked="checked=\"checked\"";
            }
            div.append("<div class=\"checkbox\"> \r\n");
            div.append("<div class=\"custom-checkbox\"> \r\n");
            div.append("<input name=\"role_name\" type=\"checkbox\" "+checked+" id=\""+sysRole.getRoleId()+"\" value=\""+sysRole.getRoleId()+"\" > \r\n");
            div.append("<label for=\""+sysRole.getRoleId()+"\"></label> \r\n");
            div.append("</div> \r\n");
            div.append(""+sysRole.getRoleName()+"\r\n");
            div.append("</div>  \r\n");
        }
        return div.toString();
    }
    @Transactional
    @CacheEvict(value= ConsoleCacheNameContanst.consoleServiceName, allEntries=true)
    public void updateUserRole(String[] role_ids, Integer user_id) {
        SysUserRoleExample sysUserRoleExample = new SysUserRoleExample();
        sysUserRoleExample.createCriteria().andSuIdEqualTo(user_id);
        sysUserRoleMapper.deleteByExample(sysUserRoleExample);
        if(role_ids==null||role_ids.length==0){
            //不做处理
        }else{
            //添加权限
            for (String roleId : role_ids) {
                SysUserRole sysUserRole=new SysUserRole();
                sysUserRole.setRoleId(Integer.parseInt(roleId));
                sysUserRole.setSuId(user_id);
                sysUserRoleMapper.insertSelective(sysUserRole);
            }
        }

    }


    @Override
    public QTree getRoleNavJson(Integer role_id,Integer firstNavId) {
        SysNav sysNav = sysNavMapper.selectByPrimaryKey(firstNavId);

        QTree qTree = new QTree(String.valueOf(firstNavId),sysNav.getUrl(),sysNav.getName(),containNav(sysNav.getNavId(), role_id),getNext(role_id,firstNavId));
        return qTree;
    }
    private  List<QTree> getNext(Integer role_id,Integer firstNavId){
        List<QTree> list = Lists.newArrayList();
        SysNavExample query=new SysNavExample();
        query.createCriteria().andPidEqualTo(firstNavId);
        List<SysNav> listNav=sysNavMapper.selectByExample(query);
        if(listNav!=null && listNav.size()>0){
            for (SysNav sysNav : listNav) {
                QTree qTree = new QTree(String.valueOf(sysNav.getNavId()),sysNav.getUrl(),sysNav.getName(),containNav(sysNav.getNavId(), role_id),getNext(role_id,sysNav.getNavId()));
                list.add(qTree);
            }
        }
        return list;
    }

    private boolean containsRole(Integer id,SysRole sysRole){
        SysUserRoleExample sysUserRoleQuery=new SysUserRoleExample();
        sysUserRoleQuery.createCriteria().andSuIdEqualTo(id);
        List<SysUserRole>listUserRole=sysUserRoleMapper.selectByExample(sysUserRoleQuery);
        for (SysUserRole sysUserRole : listUserRole) {
            if(sysUserRole.getRoleId()==sysRole.getRoleId()){
                return true;
            }else{
                continue;
            }
        }
        return false;
    }

    @Transactional
    @CacheEvict(value= ConsoleCacheNameContanst.consoleServiceName, allEntries=true)
    public void updateRoleNavByNavIdAndRoleId(String[] navs, Integer role_id) {
        //清空角色权限菜单
        SysNavRoleExample sysNavRoleExample = new SysNavRoleExample();
        sysNavRoleExample.createCriteria().andRoleIdEqualTo(role_id);
        sysNavRoleMapper.deleteByExample(sysNavRoleExample);
        //添加角色菜单

        for (String nav_id : navs) {
            SysNavRole navRole=new SysNavRole();
            navRole.setNavId(Integer.parseInt(nav_id));
            navRole.setRoleId(role_id);
                sysNavRoleMapper.insertSelective(navRole);
        }
    }
    public boolean containNav(Integer nav_id, Integer role_id){
        SysNavRoleExample sys_nav_role_query=new SysNavRoleExample();
        sys_nav_role_query.createCriteria().andNavIdEqualTo(nav_id).andRoleIdEqualTo(role_id);
        return sysNavRoleMapper.countByExample(sys_nav_role_query)>0?true:false;
    }
}
