package zhang.lao.console.controller;

import com.alibaba.fastjson.JSON;

import zhang.lao.mybatis.auto.model.SysNav;
import zhang.lao.mybatis.auto.model.SysNavExample;
import zhang.lao.mybatis.auto.model.SysNavRole;
import zhang.lao.mybatis.auto.model.SysNavRoleExample;
import zhang.lao.mybatis.auto.model.SysRole;
import zhang.lao.mybatis.auto.model.SysRoleExample;
import zhang.lao.mybatis.auto.model.SysUser;
import zhang.lao.mybatis.auto.model.SysUserExample;
import zhang.lao.mybatis.auto.model.SysUserRole;
import zhang.lao.mybatis.auto.model.SysUserRoleExample;
/**
 *
 */
public class ControllerQueryTool {

    public static  SysNavExample.Criteria setSysNavCriteria(String querys,SysNavExample.Criteria criteria){
        SysNav sysNav = JSON.parseObject(querys, SysNav.class);
               if(sysNav.getName()!=null){
           criteria.andNameEqualTo(sysNav.getName());
          }
       if(sysNav.getUrl()!=null){
           criteria.andUrlEqualTo(sysNav.getUrl());
          }
       if(sysNav.getUrlTarget()!=null){
           criteria.andUrlTargetEqualTo(sysNav.getUrlTarget());
          }
       if(sysNav.getIconUrl()!=null){
           criteria.andIconUrlEqualTo(sysNav.getIconUrl());
          }
       if(sysNav.getSort()!=null){
           criteria.andSortEqualTo(sysNav.getSort());
          }
       if(sysNav.getPid()!=null){
           criteria.andPidEqualTo(sysNav.getPid());
          }
       if(sysNav.getStatus()!=null){
           criteria.andStatusEqualTo(sysNav.getStatus());
          }
       if(sysNav.getLevels()!=null){
           criteria.andLevelsEqualTo(sysNav.getLevels());
          }
       if(sysNav.getType()!=null){
           criteria.andTypeEqualTo(sysNav.getType());
          }

        return criteria;
    }
    public static  SysNavRoleExample.Criteria setSysNavRoleCriteria(String querys,SysNavRoleExample.Criteria criteria){
        SysNavRole sysNavRole = JSON.parseObject(querys, SysNavRole.class);
               if(sysNavRole.getNavId()!=null){
           criteria.andNavIdEqualTo(sysNavRole.getNavId());
          }
       if(sysNavRole.getRoleId()!=null){
           criteria.andRoleIdEqualTo(sysNavRole.getRoleId());
          }

        return criteria;
    }
    public static  SysRoleExample.Criteria setSysRoleCriteria(String querys,SysRoleExample.Criteria criteria){
        SysRole sysRole = JSON.parseObject(querys, SysRole.class);
        if(sysRole==null){
            return  criteria;
        }
               if(sysRole.getRoleName()!=null){
           criteria.andRoleNameEqualTo(sysRole.getRoleName());
          }
       if(sysRole.getStatus()!=null){
           criteria.andStatusEqualTo(sysRole.getStatus());
          }
       if(sysRole.getPid()!=null){
           criteria.andPidEqualTo(sysRole.getPid());
          }

        return criteria;
    }
    public static  SysUserExample.Criteria setSysUserCriteria(String querys,SysUserExample.Criteria criteria){
        SysUser sysUser = JSON.parseObject(querys, SysUser.class);
               if(sysUser.getUserName()!=null){
           criteria.andUserNameEqualTo(sysUser.getUserName());
          }
       if(sysUser.getNickName()!=null){
           criteria.andNickNameEqualTo(sysUser.getNickName());
          }
       if(sysUser.getUserPassword()!=null){
           criteria.andUserPasswordEqualTo(sysUser.getUserPassword());
          }
       if(sysUser.getUserPic()!=null){
           criteria.andUserPicEqualTo(sysUser.getUserPic());
          }
       if(sysUser.getVerifyEmail()!=null){
           criteria.andVerifyEmailEqualTo(sysUser.getVerifyEmail());
          }
       if(sysUser.getPhone()!=null){
           criteria.andPhoneEqualTo(sysUser.getPhone());
          }
       if(sysUser.getEmail()!=null){
           criteria.andEmailEqualTo(sysUser.getEmail());
          }
       if(sysUser.getCreateUserId()!=null){
           criteria.andCreateUserIdEqualTo(sysUser.getCreateUserId());
          }
       if(sysUser.getUpdateUserId()!=null){
           criteria.andUpdateUserIdEqualTo(sysUser.getUpdateUserId());
          }
       if(sysUser.getUserType()!=null){
           criteria.andUserTypeEqualTo(sysUser.getUserType());
          }
       if(sysUser.getIsAuth()!=null){
           criteria.andIsAuthEqualTo(sysUser.getIsAuth());
          }
       if(sysUser.getStatus()!=null){
           criteria.andStatusEqualTo(sysUser.getStatus());
          }

        return criteria;
    }
    public static  SysUserRoleExample.Criteria setSysUserRoleCriteria(String querys,SysUserRoleExample.Criteria criteria){
        SysUserRole sysUserRole = JSON.parseObject(querys, SysUserRole.class);
               if(sysUserRole.getSuId()!=null){
           criteria.andSuIdEqualTo(sysUserRole.getSuId());
          }
       if(sysUserRole.getRoleId()!=null){
           criteria.andRoleIdEqualTo(sysUserRole.getRoleId());
          }

        return criteria;
    }
}
