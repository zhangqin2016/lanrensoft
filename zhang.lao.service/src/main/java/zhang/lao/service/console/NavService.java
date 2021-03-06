package zhang.lao.service.console;

import zhang.lao.build.mybatis.jdbc.auto.model.SysNavExample;
import zhang.lao.build.mybatis.jdbc.auto.model.SysNavRoleExample;
import zhang.lao.build.mybatis.jdbc.auto.model.SysUserRole;
import zhang.lao.build.mybatis.jdbc.auto.model.SysUserRoleExample;
import org.springframework.stereotype.Service;
import zhang.lao.dao.base.SysNavDao;
import zhang.lao.dao.base.SysNavRoleDao;
import zhang.lao.dao.base.SysUserRoleDao;
import zhang.lao.pojo.console.login.LoginUserModel;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 张钦 on 2016/6/15.
 */
@Service
public class NavService {

    @Resource
    private SysUserRoleDao sysUserRoleDao;
    @Resource
    private SysNavRoleDao sysNavRoleDao;
    @Resource
    private SysNavDao sysNavDao;
    public boolean permissions(String navId, LoginUserModel loginUserModel) {
        SysUserRoleExample sysUserRoleExample = new SysUserRoleExample();
        sysUserRoleExample.createCriteria().andSuIdEqualTo(loginUserModel.getUser_id());
        List<SysUserRole> sysUserRoles = sysUserRoleDao.selectByExample(sysUserRoleExample);
        if(sysUserRoles!=null&&sysUserRoles.size()>0){
            for (SysUserRole sysUserRole : sysUserRoles){
                SysNavRoleExample sysNavRoleExample = new SysNavRoleExample();
                sysNavRoleExample.createCriteria().andNavIdEqualTo(navId).andRoleIdEqualTo(sysUserRole.getRoleId());
                if(sysNavRoleDao.countByExample(sysNavRoleExample)>0){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasNext(String navId) {
        SysNavExample sysNavExample = new SysNavExample();
        sysNavExample.createCriteria().andStatusEqualTo((short) 1).andPidEqualTo(navId);

        return sysNavDao.countByExample(sysNavExample)>0;

    }

}
