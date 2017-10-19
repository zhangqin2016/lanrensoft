package zhang.lao.service.console;

import com.google.common.collect.Lists;
import zhang.lao.build.mybatis.jdbc.auto.model.*;
import zhang.lao.build.tool.ListUtils;
import zhang.lao.build.tool.UUIDTool;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zhang.lao.dao.base.*;
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
    private SysRoleDao sysRoleDao;
    @Resource
    private SysUserRoleDao sysUserRoleDao;
    @Resource
    private SysNavDao sysNavDao;
    @Resource
    private SysNavRoleDao sysNavRoleDao;
    @Resource
    private SysReqUrlRoleDao sysReqUrlRoleDao;
    @Resource
    private SysReqUrlDao sysReqUrlDao;
    @Resource
    private SysReqUrlGroupDao sysReqUrlGroupDao;
    @Resource
    private SysReqUrlWhiteListDao sysReqUrlWhiteListDao;
    public String getSelectRoleHtmlByUserId(String id) {
        StringBuffer div=new StringBuffer();
        List<SysRole> listRole=sysRoleDao.selectByExample(null);
        for (SysRole sysRole : listRole) {
            String checked="";
            if(containsRole(id, sysRole)){
                checked="checked=\"checked\"";
            }
            div.append("<label class=\"zq-checked-label\"> \r\n");
            div.append("<input name=\"role_name\" type=\"checkbox\" "+checked+" id=\""+sysRole.getRoleId()+"\" value=\""+sysRole.getRoleId()+"\" > \r\n");
            div.append(""+sysRole.getRoleName()+"\r\n");
            div.append("</label> \r\n");
        }
        return div.toString();
    }

    @Transactional
    @CacheEvict(value= ConsoleCacheNameContanst.consoleServiceName, allEntries=true)
    public void updateUserRole(String[] role_ids, String user_id) {
        SysUserRoleExample sysUserRoleExample = new SysUserRoleExample();
        sysUserRoleExample.createCriteria().andSuIdEqualTo(user_id);
        sysUserRoleDao.deleteByExample(sysUserRoleExample);
        if(role_ids==null||role_ids.length==0){
            //不做处理
        }else{
            //添加权限
            for (String roleId : role_ids) {
                SysUserRole sysUserRole=new SysUserRole();
                sysUserRole.setRoleId(roleId);
                sysUserRole.setSuId(user_id);
                sysUserRole.setSnrId(UUIDTool.getUUID());
                sysUserRoleDao.insertSelective(sysUserRole);
            }
        }

    }


    @Override
    public QTree getRoleNavJson(String role_id, String firstNavId) {
        SysNav sysNav = sysNavDao.selectByPrimaryKey(firstNavId);

        QTree qTree = new QTree(String.valueOf(firstNavId),sysNav.getUrl(),sysNav.getName(),containNav(sysNav.getNavId(), role_id),getNext(role_id,firstNavId));
        return qTree;
    }

    @Override
    public QTree getRoleReqJson(String role_id, String group) {
        SysReqUrlExample sysReqUrlExample = new SysReqUrlExample();
        sysReqUrlExample.createCriteria().andGroupIdEqualTo(group);
        List<SysReqUrl> sysReqUrls = sysReqUrlDao.selectByExample(sysReqUrlExample);
        List<QTree> list = Lists.newArrayList();
        SysReqUrlGroup sysReqUrlGroup = sysReqUrlGroupDao.selectByPrimaryKey(group);
        for (SysReqUrl sysReqUrl : sysReqUrls) {
            QTree qTree = new QTree(sysReqUrl.getId(),sysReqUrl.getUrl(),sysReqUrl.getName()+"("+sysReqUrl.getUrl()+")",containReq(sysReqUrl.getUrl(), role_id),null);
            list.add(qTree);
        }
        QTree qTreef = new QTree(UUIDTool.getUUID(),sysReqUrlGroup.getName(),sysReqUrlGroup.getName(),false,list);
        return  qTreef;
    }

    private  List<QTree> getNext(String role_id,String firstNavId){
        List<QTree> list = Lists.newArrayList();
        SysNavExample query=new SysNavExample();
        query.createCriteria().andPidEqualTo(firstNavId);
        List<SysNav> listNav=sysNavDao.selectByExample(query);
        if(listNav!=null && listNav.size()>0){
            for (SysNav sysNav : listNav) {
                QTree qTree = new QTree(String.valueOf(sysNav.getNavId()),sysNav.getUrl(),sysNav.getName()+"("+sysNav.getUrl()+")",containNav(sysNav.getNavId(), role_id),getNext(role_id,sysNav.getNavId()));
                list.add(qTree);
            }
        }
        return list;
    }

    private boolean containsRole(String id,SysRole sysRole){
        SysUserRoleExample sysUserRoleQuery=new SysUserRoleExample();
        sysUserRoleQuery.createCriteria().andSuIdEqualTo(id).andRoleIdEqualTo(sysRole.getRoleId());
        return sysUserRoleDao.countByExample(sysUserRoleQuery)>0;
    }

    @Transactional
    @CacheEvict(value= ConsoleCacheNameContanst.consoleServiceName, allEntries=true)
    public void updateRoleNavByNavIdAndRoleId(String[] navs, String role_id) {
        //清空角色权限菜单
        SysNavRoleExample sysNavRoleExample = new SysNavRoleExample();
        sysNavRoleExample.createCriteria().andRoleIdEqualTo(role_id);
        sysNavRoleDao.deleteByExample(sysNavRoleExample);
        //添加角色菜单

        for (String nav_id : navs) {
            SysNavRole navRole=new SysNavRole();
            navRole.setNavId(nav_id);
            navRole.setRoleId(role_id);
            navRole.setSnrId(UUIDTool.getUUID());
            sysNavRoleDao.insertSelective(navRole);
        }
    }

    @Transactional
    public void updateRoleReqUrl(String[] reqUrls, String role_id) {
        //清空角色权限菜单
        SysReqUrlRoleExample sysNavRoleExample = new SysReqUrlRoleExample();
        sysNavRoleExample.createCriteria().andRoleIdEqualTo(role_id);
        sysReqUrlRoleDao.deleteByExample(sysNavRoleExample);
        //添加角色菜单
        for (String reqUrl : reqUrls) {
            SysReqUrlRole sysReqUrlRole=new SysReqUrlRole();
            sysReqUrlRole.setId(UUIDTool.getUUID());
            sysReqUrlRole.setRoleId(role_id);
            sysReqUrlRole.setReqUrl(reqUrl);
            sysReqUrlRoleDao.insertSelective(sysReqUrlRole);
        }

    }
    public boolean containNav(String nav_id, String role_id){
        SysNavRoleExample sys_nav_role_query=new SysNavRoleExample();
        sys_nav_role_query.createCriteria().andNavIdEqualTo(nav_id).andRoleIdEqualTo(role_id);
        return sysNavRoleDao.countByExample(sys_nav_role_query)>0?true:false;
    }

    public boolean containReq(String reqUrl, String role_id){
        SysReqUrlRoleExample sysReqUrlRoleExample=new SysReqUrlRoleExample();
        sysReqUrlRoleExample.createCriteria().andRoleIdEqualTo(role_id).andReqUrlEqualTo(reqUrl);
        boolean isauth = sysReqUrlRoleDao.countByExample(sysReqUrlRoleExample)>0?true:false;
        if(!isauth){
            SysReqUrlRoleExample sysReqUrlRoleExample2=new SysReqUrlRoleExample();
            sysReqUrlRoleExample2.createCriteria().andRoleIdEqualTo(role_id).andReqUrlLike("%{%");
            List<SysReqUrlRole> sysReqUrlRoles = sysReqUrlRoleDao.selectByExample(sysReqUrlRoleExample2);
            if(sysReqUrlRoles!=null){
                for (SysReqUrlRole sysReqUrlRole : sysReqUrlRoles) {
                    String reqUrl1 = sysReqUrlRole.getReqUrl();
                    String[] sysUrls = reqUrl1.split("/");
                    String[] split1 = reqUrl.split("/");
                    boolean ism = true;
                    if(sysUrls.length == split1.length){
                        for (int i =0 ;i<sysUrls.length;i++ ){
                            if(sysUrls[i].indexOf("{")!=-1){
                                continue;
                            }else if(!sysUrls[i].equals(split1[i])){
                                ism =false;
                                break;
                            }
                        }
                    }else{
                        continue;
                    }
                    if(ism){
                        isauth=true;
                        break;
                    }
                }
            }
        }
        return isauth;
    }

    @Override
    public boolean reqInWhiteList(String reqUrl) {
        SysReqUrlWhiteListExample sysReqUrlWhiteListExample = new SysReqUrlWhiteListExample();
        sysReqUrlWhiteListExample.createCriteria().andUrlEqualTo(reqUrl);
        return sysReqUrlWhiteListDao.countByExample(sysReqUrlWhiteListExample)>0;
    }

    @Override
    public boolean reqHasRole(String reqUrl,String uid) {
        SysUserRoleExample sysUserRoleExample = new SysUserRoleExample();
        sysUserRoleExample.createCriteria().andSuIdEqualTo( uid);
        List<SysUserRole> sysUserRoles =  sysUserRoleDao.selectByExample(sysUserRoleExample);
        boolean isAuth = false;
        for (SysUserRole sysUserRole : sysUserRoles) {
            if(containReq(reqUrl,sysUserRole.getRoleId())){
                isAuth=true;
                break;
            }
        }
        return isAuth;
    }

}
