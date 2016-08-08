package zhang.lao.console.service;

import org.springframework.stereotype.Service;
import zhang.lao.mybatis.auto.dao.SysNavMapper;
import zhang.lao.mybatis.auto.dao.SysNavRoleMapper;
import zhang.lao.mybatis.auto.dao.SysUserRoleMapper;
import zhang.lao.mybatis.auto.model.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tech6 on 2016/6/15.
 */
@Service
public class NavService {

    @Resource
    private SysUserRoleMapper sysUserRoleMapper;
    @Resource
    private SysNavRoleMapper sysNavRoleMapper;
    @Resource
    private SysNavMapper sysNavMapper;
    public boolean permissions(Long navId, Long user_id) {
        SysUserRoleExample sysUserRoleExample = new SysUserRoleExample();
        sysUserRoleExample.createCriteria().andSuIdEqualTo(user_id);
        List<SysUserRole> sysUserRoles = sysUserRoleMapper.selectByExample(sysUserRoleExample);
        if(sysUserRoles!=null&&sysUserRoles.size()>0){
            for (SysUserRole sysUserRole : sysUserRoles){
                SysNavRoleExample sysNavRoleExample = new SysNavRoleExample();
                sysNavRoleExample.createCriteria().andNavIdEqualTo(navId).andRoleIdEqualTo(sysUserRole.getRoleId());
                if(sysNavRoleMapper.countByExample(sysNavRoleExample)>0){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasNext(Long navId) {
        SysNavExample sysNavExample = new SysNavExample();
        sysNavExample.createCriteria().andStatusEqualTo((short) 1).andPidEqualTo(navId);

        return sysNavMapper.countByExample(sysNavExample)>0;

    }

}
