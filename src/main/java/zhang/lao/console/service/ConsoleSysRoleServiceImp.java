package zhang.lao.console.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zhang.lao.mybatis.auto.dao.SysNavMapper;
import zhang.lao.mybatis.auto.dao.SysNavRoleMapper;
import zhang.lao.mybatis.auto.dao.SysRoleMapper;
import zhang.lao.mybatis.auto.dao.SysUserRoleMapper;
import zhang.lao.mybatis.auto.model.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public List<Map<String, Object>> getRoleNavHtml(Integer role_id) {

        List<Map<String, Object>> listMpa=new ArrayList<Map<String,Object>>();
            Map<String, Object> mapHtml=new HashMap<String, Object>();
            SysNavExample query=new SysNavExample();
        query.createCriteria().andLevelEqualTo(new Short("1")).andPIdEqualTo(0);
            List<SysNav> listNav=sysNavMapper.selectByExample(query);
            StringBuffer div=new StringBuffer();
            for (SysNav sysNav : listNav) {
                div.append("<!-- 一级菜单 -->\r\n");
                div.append("<div class=\"form-group\">\r\n");
                div.append("<div class=\"row\">\r\n");
                div.append("	<div class=\"col-sm-12\">\r\n");
                div.append("		<div class=\"custom-checkbox\">\r\n");
                String checked="";
                if(containNav(sysNav.getNavId(), role_id)){
                    checked="checked=\"checked\"";
                }
                div.append("			<input "+checked+" type=\"checkbox\" name=\"nav_name\" value=\""+sysNav.getNavId()+"\" id=\""+sysNav.getNavId()+"\"> <label for=\""+sysNav.getNavId()+"\"></label>\r\n");
                div.append("		</div>\r\n");
                div.append("		"+sysNav.getName()+"\r\n");
                div.append("	</div>\r\n");
                div.append("</div>\r\n");
                SysNavExample querySecound=new SysNavExample();
                querySecound.createCriteria().andLevelEqualTo(new Short("2")).andPIdEqualTo(sysNav.getpId());
                List<SysNav> listSecoundNav=sysNavMapper.selectByExample(querySecound);
                div.append("<!-- 二级菜单 -->\r\n");
                div.append("<div class=\"row\">\r\n");
                div.append("	<div class=\"col-sm-1\"></div>\r\n");
                div.append("	<div class=\"col-sm-11\">\r\n");
                for (SysNav sysSecoundNav : listSecoundNav) {
                    String checkedSecound="";
                    if(containNav(sysSecoundNav.getNavId(), role_id)){
                        checkedSecound="checked=\"checked\"";
                    }
                    div.append("		<div class=\"custom-checkbox\">\r\n");
                    div.append("			<input "+checkedSecound+" type=\"checkbox\" name=\"nav_name\" value=\""+sysSecoundNav.getNavId()+"\" id=\""+sysSecoundNav.getNavId()+"\"> <label for=\""+sysSecoundNav.getNavId()+"\"></label>\r\n");
                    div.append("		</div>\r\n");
                    div.append("		"+sysSecoundNav.getName()+"\r\n");
                }
                div.append("	</div>\r\n");
                div.append("</div>\r\n");
                div.append("</div>\r\n");
            mapHtml.put("html", div.toString());
            listMpa.add(mapHtml);
        }
        return listMpa;
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
