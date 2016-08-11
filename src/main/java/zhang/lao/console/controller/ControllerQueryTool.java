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
    
    public static  String setSysNavCriteria(String querys,StringBuffer sql , String alias){
                SysNav sysNav = JSON.parseObject(querys, SysNav.class);
                       if(sysNav.getName()!=null){
           sql.append(" and ").append(alias).append(".name").append(" = ").append(sysNav.getName()).append(" ");
          }
       if(sysNav.getUrl()!=null){
           sql.append(" and ").append(alias).append(".url").append(" = ").append(sysNav.getUrl()).append(" ");
          }
       if(sysNav.getUrlTarget()!=null){
           sql.append(" and ").append(alias).append(".url_target").append(" = ").append(sysNav.getUrlTarget()).append(" ");
          }
       if(sysNav.getIconUrl()!=null){
           sql.append(" and ").append(alias).append(".icon_url").append(" = ").append(sysNav.getIconUrl()).append(" ");
          }
       if(sysNav.getSort()!=null){
           sql.append(" and ").append(alias).append(".sort").append(" = ").append(sysNav.getSort()).append(" ");
          }
       if(sysNav.getPid()!=null){
           sql.append(" and ").append(alias).append(".pid").append(" = ").append(sysNav.getPid()).append(" ");
          }
       if(sysNav.getStatus()!=null){
           sql.append(" and ").append(alias).append(".status").append(" = ").append(sysNav.getStatus()).append(" ");
          }
       if(sysNav.getLevels()!=null){
           sql.append(" and ").append(alias).append(".levels").append(" = ").append(sysNav.getLevels()).append(" ");
          }
       if(sysNav.getType()!=null){
           sql.append(" and ").append(alias).append(".type").append(" = ").append(sysNav.getType()).append(" ");
          }

                return sql.toString();
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
    
    public static  String setSysNavRoleCriteria(String querys,StringBuffer sql , String alias){
                SysNavRole sysNavRole = JSON.parseObject(querys, SysNavRole.class);
                       if(sysNavRole.getNavId()!=null){
           sql.append(" and ").append(alias).append(".nav_id").append(" = ").append(sysNavRole.getNavId()).append(" ");
          }
       if(sysNavRole.getRoleId()!=null){
           sql.append(" and ").append(alias).append(".role_id").append(" = ").append(sysNavRole.getRoleId()).append(" ");
          }

                return sql.toString();
            }
    public static  SysRoleExample.Criteria setSysRoleCriteria(String querys,SysRoleExample.Criteria criteria){
        SysRole sysRole = JSON.parseObject(querys, SysRole.class);
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
    
    public static  String setSysRoleCriteria(String querys,StringBuffer sql , String alias){
                SysRole sysRole = JSON.parseObject(querys, SysRole.class);
                       if(sysRole.getRoleName()!=null){
           sql.append(" and ").append(alias).append(".role_name").append(" = ").append(sysRole.getRoleName()).append(" ");
          }
       if(sysRole.getStatus()!=null){
           sql.append(" and ").append(alias).append(".status").append(" = ").append(sysRole.getStatus()).append(" ");
          }
       if(sysRole.getPid()!=null){
           sql.append(" and ").append(alias).append(".pid").append(" = ").append(sysRole.getPid()).append(" ");
          }

                return sql.toString();
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
    
    public static  String setSysUserCriteria(String querys,StringBuffer sql , String alias){
                SysUser sysUser = JSON.parseObject(querys, SysUser.class);
                       if(sysUser.getUserName()!=null){
           sql.append(" and ").append(alias).append(".user_name").append(" = ").append(sysUser.getUserName()).append(" ");
          }
       if(sysUser.getNickName()!=null){
           sql.append(" and ").append(alias).append(".nick_name").append(" = ").append(sysUser.getNickName()).append(" ");
          }
       if(sysUser.getUserPassword()!=null){
           sql.append(" and ").append(alias).append(".user_password").append(" = ").append(sysUser.getUserPassword()).append(" ");
          }
       if(sysUser.getUserPic()!=null){
           sql.append(" and ").append(alias).append(".user_pic").append(" = ").append(sysUser.getUserPic()).append(" ");
          }
       if(sysUser.getVerifyEmail()!=null){
           sql.append(" and ").append(alias).append(".verify_email").append(" = ").append(sysUser.getVerifyEmail()).append(" ");
          }
       if(sysUser.getPhone()!=null){
           sql.append(" and ").append(alias).append(".phone").append(" = ").append(sysUser.getPhone()).append(" ");
          }
       if(sysUser.getEmail()!=null){
           sql.append(" and ").append(alias).append(".email").append(" = ").append(sysUser.getEmail()).append(" ");
          }
       if(sysUser.getCreateUserId()!=null){
           sql.append(" and ").append(alias).append(".create_user_id").append(" = ").append(sysUser.getCreateUserId()).append(" ");
          }
       if(sysUser.getUpdateUserId()!=null){
           sql.append(" and ").append(alias).append(".update_user_id").append(" = ").append(sysUser.getUpdateUserId()).append(" ");
          }
       if(sysUser.getUserType()!=null){
           sql.append(" and ").append(alias).append(".user_type").append(" = ").append(sysUser.getUserType()).append(" ");
          }
       if(sysUser.getIsAuth()!=null){
           sql.append(" and ").append(alias).append(".is_auth").append(" = ").append(sysUser.getIsAuth()).append(" ");
          }
       if(sysUser.getStatus()!=null){
           sql.append(" and ").append(alias).append(".status").append(" = ").append(sysUser.getStatus()).append(" ");
          }

                return sql.toString();
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
    
    public static  String setSysUserRoleCriteria(String querys,StringBuffer sql , String alias){
                SysUserRole sysUserRole = JSON.parseObject(querys, SysUserRole.class);
                       if(sysUserRole.getSuId()!=null){
           sql.append(" and ").append(alias).append(".su_id").append(" = ").append(sysUserRole.getSuId()).append(" ");
          }
       if(sysUserRole.getRoleId()!=null){
           sql.append(" and ").append(alias).append(".role_id").append(" = ").append(sysUserRole.getRoleId()).append(" ");
          }

                return sql.toString();
            }

}
