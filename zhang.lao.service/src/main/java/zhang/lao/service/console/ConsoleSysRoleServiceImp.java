package zhang.lao.service.console;

import com.google.common.collect.Lists;
import com.lz.mybatis.jdbc.auto.dao.*;
import com.lz.mybatis.jdbc.auto.model.*;
import com.lz.tool.UUIDTool;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zhang.lao.pojo.console.ConsoleCacheNameContanst;
import zhang.lao.pojo.console.bootstrapQ.QTree;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tech6 on 2016/8/2.
 */
@Service
public class ConsoleSysRoleServiceImp implements ConsoleSysRoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;
    @Resource
    private SysUserRoleMapper sysUserRoleMapper;
    @Resource
    private SysNavMapper sysNavMapper;
    @Resource
    private SysNavRoleMapper sysNavRoleMapper;
    @Resource
    private SysReqUrlRoleMapper sysReqUrlRoleMapper;
    @Resource
    private SysReqUrlMapper sysReqUrlMapper;
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
    public QTree getRoleNavJson(Integer role_id, Integer firstNavId) {
        SysNav sysNav = sysNavMapper.selectByPrimaryKey(firstNavId);

        QTree qTree = new QTree(String.valueOf(firstNavId),sysNav.getUrl(),sysNav.getName(),containNav(sysNav.getNavId(), role_id),getNext(role_id,firstNavId));
        return qTree;
    }

    @Override
    public QTree getRoleReqJson(Integer role_id, String reqUrl) {
        SysReqUrlExample sysReqUrlExample = new SysReqUrlExample();
        int s = reqUrl.indexOf("(")+1;
        int e = reqUrl.indexOf(")");
        if(s>e){
            s=e;
        }
        String reqUrls=reqUrl.substring(s,e);
        System.out.printf(reqUrls);
        sysReqUrlExample.createCriteria().andUrlLike(reqUrls+"%");
        List<SysReqUrl> sysReqUrls = sysReqUrlMapper.selectByExample(sysReqUrlExample);
        List<QTree> list = Lists.newArrayList();
        for (SysReqUrl sysReqUrl : sysReqUrls) {
            QTree qTree = new QTree(sysReqUrl.getId(),sysReqUrl.getUrl(),sysReqUrl.getName()+"("+sysReqUrl.getUrl()+")",containReq(sysReqUrl.getUrl(), role_id),null);
            list.add(qTree);
        }
        QTree qTreef = new QTree(UUIDTool.getUUID(),reqUrls,reqUrl,containReq(reqUrls, role_id),list);
        return  qTreef;
    }
    private  List<QTree> getNext(Integer role_id,Integer firstNavId){
        List<QTree> list = Lists.newArrayList();
        SysNavExample query=new SysNavExample();
        query.createCriteria().andPidEqualTo(firstNavId);
        List<SysNav> listNav=sysNavMapper.selectByExample(query);
        if(listNav!=null && listNav.size()>0){
            for (SysNav sysNav : listNav) {
                QTree qTree = new QTree(String.valueOf(sysNav.getNavId()),sysNav.getUrl(),sysNav.getName()+"("+sysNav.getUrl()+")",containNav(sysNav.getNavId(), role_id),getNext(role_id,sysNav.getNavId()));
                list.add(qTree);
            }
        }
        return list;
    }

    private boolean containsRole(Integer id,SysRole sysRole){
        SysUserRoleExample sysUserRoleQuery=new SysUserRoleExample();
        sysUserRoleQuery.createCriteria().andSuIdEqualTo(id).andRoleIdEqualTo(sysRole.getRoleId());
        return sysUserRoleMapper.countByExample(sysUserRoleQuery)>0;
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

    @Transactional
    public void updateRoleReqUrl(String[] reqUrls, Integer role_id) {
        //清空角色权限菜单
        SysReqUrlRoleExample sysNavRoleExample = new SysReqUrlRoleExample();
        sysNavRoleExample.createCriteria().andRoleIdEqualTo(role_id);
        sysReqUrlRoleMapper.deleteByExample(sysNavRoleExample);
        //添加角色菜单
        for (String reqUrl : reqUrls) {
            SysReqUrlRole sysReqUrlRole=new SysReqUrlRole();
          sysReqUrlRole.setId(UUIDTool.getUUID());
            sysReqUrlRole.setRoleId(role_id);
            sysReqUrlRole.setReqUrl(reqUrl);
            sysReqUrlRoleMapper.insertSelective(sysReqUrlRole);
        }

    }
    public boolean containNav(Integer nav_id, Integer role_id){
        SysNavRoleExample sys_nav_role_query=new SysNavRoleExample();
        sys_nav_role_query.createCriteria().andNavIdEqualTo(nav_id).andRoleIdEqualTo(role_id);
        return sysNavRoleMapper.countByExample(sys_nav_role_query)>0?true:false;
    }

    public boolean containReq(String reqUrl, Integer role_id){
        SysReqUrlRoleExample sysReqUrlRoleExample=new SysReqUrlRoleExample();
        sysReqUrlRoleExample.createCriteria().andRoleIdEqualTo(role_id).andReqUrlEqualTo(reqUrl);
        return sysReqUrlRoleMapper.countByExample(sysReqUrlRoleExample)>0?true:false;
    }

}
