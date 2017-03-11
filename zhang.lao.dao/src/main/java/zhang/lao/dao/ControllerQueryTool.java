package zhang.lao.dao;

import com.alibaba.fastjson.JSON;

import com.lz.mybatis.jdbc.auto.model.AppInfo;
import com.lz.mybatis.jdbc.auto.model.AppInfoExample;
import com.lz.mybatis.jdbc.auto.model.AppToken;
import com.lz.mybatis.jdbc.auto.model.AppTokenExample;
import com.lz.mybatis.jdbc.auto.model.SysNav;
import com.lz.mybatis.jdbc.auto.model.SysNavExample;
import com.lz.mybatis.jdbc.auto.model.SysNavRole;
import com.lz.mybatis.jdbc.auto.model.SysNavRoleExample;
import com.lz.mybatis.jdbc.auto.model.SysReqUrl;
import com.lz.mybatis.jdbc.auto.model.SysReqUrlExample;
import com.lz.mybatis.jdbc.auto.model.SysReqUrlRole;
import com.lz.mybatis.jdbc.auto.model.SysReqUrlRoleExample;
import com.lz.mybatis.jdbc.auto.model.SysRole;
import com.lz.mybatis.jdbc.auto.model.SysRoleExample;
import com.lz.mybatis.jdbc.auto.model.SysUser;
import com.lz.mybatis.jdbc.auto.model.SysUserExample;
import com.lz.mybatis.jdbc.auto.model.SysUserRole;
import com.lz.mybatis.jdbc.auto.model.SysUserRoleExample;
/**
 *
 */
public class ControllerQueryTool {

    public static  AppInfoExample.Criteria setAppInfoCriteria(String querys,AppInfoExample.Criteria criteria){
        AppInfo appInfo = JSON.parseObject(querys, AppInfo.class);
               if(appInfo.getAppKey()!=null){
           criteria.andAppKeyEqualTo(appInfo.getAppKey());
          }
       if(appInfo.getAppSecret()!=null){
           criteria.andAppSecretEqualTo(appInfo.getAppSecret());
          }
       if(appInfo.getAppRemark()!=null){
           criteria.andAppRemarkEqualTo(appInfo.getAppRemark());
          }
       if(appInfo.getAppName()!=null){
           criteria.andAppNameEqualTo(appInfo.getAppName());
          }
       if(appInfo.getAppType()!=null){
           criteria.andAppTypeEqualTo(appInfo.getAppType());
          }
       if(appInfo.getStatus()!=null){
           criteria.andStatusEqualTo(appInfo.getStatus());
          }

        return criteria;
    }

    public static  String setAppInfoCriteria(String querys,StringBuffer sql , String alias){
                AppInfo appInfo = JSON.parseObject(querys, AppInfo.class);
                       if(appInfo.getAppKey()!=null){
           sql.append(" and ").append(alias).append(".app_key").append(" = '").append(appInfo.getAppKey()).append(" ' ");
          }
       if(appInfo.getAppSecret()!=null){
           sql.append(" and ").append(alias).append(".app_secret").append(" = '").append(appInfo.getAppSecret()).append(" ' ");
          }
       if(appInfo.getAppRemark()!=null){
           sql.append(" and ").append(alias).append(".app_remark").append(" = '").append(appInfo.getAppRemark()).append(" ' ");
          }
       if(appInfo.getAppName()!=null){
           sql.append(" and ").append(alias).append(".app_name").append(" = '").append(appInfo.getAppName()).append(" ' ");
          }
       if(appInfo.getAppType()!=null){
           sql.append(" and ").append(alias).append(".app_type").append(" = '").append(appInfo.getAppType()).append(" ' ");
          }
       if(appInfo.getStatus()!=null){
           sql.append(" and ").append(alias).append(".status").append(" = '").append(appInfo.getStatus()).append(" ' ");
          }

                return sql.toString();
            }
    public static  AppTokenExample.Criteria setAppTokenCriteria(String querys,AppTokenExample.Criteria criteria){
        AppToken appToken = JSON.parseObject(querys, AppToken.class);
               if(appToken.getToken()!=null){
           criteria.andTokenEqualTo(appToken.getToken());
          }
       if(appToken.getOpenid()!=null){
           criteria.andOpenidEqualTo(appToken.getOpenid());
          }
       if(appToken.getExpiresTime()!=null){
           criteria.andExpiresTimeEqualTo(appToken.getExpiresTime());
          }

        return criteria;
    }

    public static  String setAppTokenCriteria(String querys,StringBuffer sql , String alias){
                AppToken appToken = JSON.parseObject(querys, AppToken.class);
                       if(appToken.getToken()!=null){
           sql.append(" and ").append(alias).append(".token").append(" = '").append(appToken.getToken()).append(" ' ");
          }
       if(appToken.getOpenid()!=null){
           sql.append(" and ").append(alias).append(".openid").append(" = '").append(appToken.getOpenid()).append(" ' ");
          }
       if(appToken.getExpiresTime()!=null){
           sql.append(" and ").append(alias).append(".expires_time").append(" = '").append(appToken.getExpiresTime()).append(" ' ");
          }

                return sql.toString();
            }
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
           sql.append(" and ").append(alias).append(".name").append(" = '").append(sysNav.getName()).append(" ' ");
          }
       if(sysNav.getUrl()!=null){
           sql.append(" and ").append(alias).append(".url").append(" = '").append(sysNav.getUrl()).append(" ' ");
          }
       if(sysNav.getUrlTarget()!=null){
           sql.append(" and ").append(alias).append(".url_target").append(" = '").append(sysNav.getUrlTarget()).append(" ' ");
          }
       if(sysNav.getIconUrl()!=null){
           sql.append(" and ").append(alias).append(".icon_url").append(" = '").append(sysNav.getIconUrl()).append(" ' ");
          }
       if(sysNav.getSort()!=null){
           sql.append(" and ").append(alias).append(".sort").append(" = '").append(sysNav.getSort()).append(" ' ");
          }
       if(sysNav.getPid()!=null){
           sql.append(" and ").append(alias).append(".pid").append(" = '").append(sysNav.getPid()).append(" ' ");
          }
       if(sysNav.getStatus()!=null){
           sql.append(" and ").append(alias).append(".status").append(" = '").append(sysNav.getStatus()).append(" ' ");
          }
       if(sysNav.getLevels()!=null){
           sql.append(" and ").append(alias).append(".levels").append(" = '").append(sysNav.getLevels()).append(" ' ");
          }
       if(sysNav.getType()!=null){
           sql.append(" and ").append(alias).append(".type").append(" = '").append(sysNav.getType()).append(" ' ");
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
           sql.append(" and ").append(alias).append(".nav_id").append(" = '").append(sysNavRole.getNavId()).append(" ' ");
          }
       if(sysNavRole.getRoleId()!=null){
           sql.append(" and ").append(alias).append(".role_id").append(" = '").append(sysNavRole.getRoleId()).append(" ' ");
          }

                return sql.toString();
            }
    public static  SysReqUrlExample.Criteria setSysReqUrlCriteria(String querys,SysReqUrlExample.Criteria criteria){
        SysReqUrl sysReqUrl = JSON.parseObject(querys, SysReqUrl.class);
               if(sysReqUrl.getUrl()!=null){
           criteria.andUrlEqualTo(sysReqUrl.getUrl());
          }
       if(sysReqUrl.getName()!=null){
           criteria.andNameEqualTo(sysReqUrl.getName());
          }
       if(sysReqUrl.getDescription()!=null){
           criteria.andDescriptionEqualTo(sysReqUrl.getDescription());
          }

        return criteria;
    }

    public static  String setSysReqUrlCriteria(String querys,StringBuffer sql , String alias){
                SysReqUrl sysReqUrl = JSON.parseObject(querys, SysReqUrl.class);
                       if(sysReqUrl.getUrl()!=null){
           sql.append(" and ").append(alias).append(".url").append(" = '").append(sysReqUrl.getUrl()).append(" ' ");
          }
       if(sysReqUrl.getName()!=null){
           sql.append(" and ").append(alias).append(".name").append(" = '").append(sysReqUrl.getName()).append(" ' ");
          }
       if(sysReqUrl.getDescription()!=null){
           sql.append(" and ").append(alias).append(".description").append(" = '").append(sysReqUrl.getDescription()).append(" ' ");
          }

                return sql.toString();
            }
    public static  SysReqUrlRoleExample.Criteria setSysReqUrlRoleCriteria(String querys,SysReqUrlRoleExample.Criteria criteria){
        SysReqUrlRole sysReqUrlRole = JSON.parseObject(querys, SysReqUrlRole.class);
               if(sysReqUrlRole.getRoleId()!=null){
           criteria.andRoleIdEqualTo(sysReqUrlRole.getRoleId());
          }
       if(sysReqUrlRole.getReqUrl()!=null){
           criteria.andReqUrlEqualTo(sysReqUrlRole.getReqUrl());
          }

        return criteria;
    }

    public static  String setSysReqUrlRoleCriteria(String querys,StringBuffer sql , String alias){
                SysReqUrlRole sysReqUrlRole = JSON.parseObject(querys, SysReqUrlRole.class);
                       if(sysReqUrlRole.getRoleId()!=null){
           sql.append(" and ").append(alias).append(".role_id").append(" = '").append(sysReqUrlRole.getRoleId()).append(" ' ");
          }
       if(sysReqUrlRole.getReqUrl()!=null){
           sql.append(" and ").append(alias).append(".req_url").append(" = '").append(sysReqUrlRole.getReqUrl()).append(" ' ");
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
           sql.append(" and ").append(alias).append(".role_name").append(" = '").append(sysRole.getRoleName()).append(" ' ");
          }
       if(sysRole.getStatus()!=null){
           sql.append(" and ").append(alias).append(".status").append(" = '").append(sysRole.getStatus()).append(" ' ");
          }
       if(sysRole.getPid()!=null){
           sql.append(" and ").append(alias).append(".pid").append(" = '").append(sysRole.getPid()).append(" ' ");
          }

                return sql.toString();
            }
    public static  SysUserExample.Criteria setSysUserCriteria(String querys,SysUserExample.Criteria criteria){
        SysUser sysUser = JSON.parseObject(querys, SysUser.class);
               if(sysUser.getNickName()!=null){
           criteria.andNickNameEqualTo(sysUser.getNickName());
          }
       if(sysUser.getUserPassword()!=null){
           criteria.andUserPasswordEqualTo(sysUser.getUserPassword());
          }
       if(sysUser.getUserPic()!=null){
           criteria.andUserPicEqualTo(sysUser.getUserPic());
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
       if(sysUser.getStatus()!=null){
           criteria.andStatusEqualTo(sysUser.getStatus());
          }

        return criteria;
    }

    public static  String setSysUserCriteria(String querys,StringBuffer sql , String alias){
                SysUser sysUser = JSON.parseObject(querys, SysUser.class);
                       if(sysUser.getNickName()!=null){
           sql.append(" and ").append(alias).append(".nick_name").append(" = '").append(sysUser.getNickName()).append(" ' ");
          }
       if(sysUser.getUserPassword()!=null){
           sql.append(" and ").append(alias).append(".user_password").append(" = '").append(sysUser.getUserPassword()).append(" ' ");
          }
       if(sysUser.getUserPic()!=null){
           sql.append(" and ").append(alias).append(".user_pic").append(" = '").append(sysUser.getUserPic()).append(" ' ");
          }
       if(sysUser.getPhone()!=null){
           sql.append(" and ").append(alias).append(".phone").append(" = '").append(sysUser.getPhone()).append(" ' ");
          }
       if(sysUser.getEmail()!=null){
           sql.append(" and ").append(alias).append(".email").append(" = '").append(sysUser.getEmail()).append(" ' ");
          }
       if(sysUser.getCreateUserId()!=null){
           sql.append(" and ").append(alias).append(".create_user_id").append(" = '").append(sysUser.getCreateUserId()).append(" ' ");
          }
       if(sysUser.getUpdateUserId()!=null){
           sql.append(" and ").append(alias).append(".update_user_id").append(" = '").append(sysUser.getUpdateUserId()).append(" ' ");
          }
       if(sysUser.getStatus()!=null){
           sql.append(" and ").append(alias).append(".status").append(" = '").append(sysUser.getStatus()).append(" ' ");
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
           sql.append(" and ").append(alias).append(".su_id").append(" = '").append(sysUserRole.getSuId()).append(" ' ");
          }
       if(sysUserRole.getRoleId()!=null){
           sql.append(" and ").append(alias).append(".role_id").append(" = '").append(sysUserRole.getRoleId()).append(" ' ");
          }

                return sql.toString();
            }

}
