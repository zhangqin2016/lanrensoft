package zhang.lao.build.mybatis.jdbc.auto.tool;

import com.alibaba.fastjson.JSON;

import zhang.lao.build.mybatis.jdbc.auto.model.AppInfo;
import zhang.lao.build.mybatis.jdbc.auto.model.AppInfoExample;
import zhang.lao.build.mybatis.jdbc.auto.model.AppToken;
import zhang.lao.build.mybatis.jdbc.auto.model.AppTokenExample;
import zhang.lao.build.mybatis.jdbc.auto.model.BoBlog;
import zhang.lao.build.mybatis.jdbc.auto.model.BoBlogExample;
import zhang.lao.build.mybatis.jdbc.auto.model.SysNav;
import zhang.lao.build.mybatis.jdbc.auto.model.SysNavExample;
import zhang.lao.build.mybatis.jdbc.auto.model.SysNavRole;
import zhang.lao.build.mybatis.jdbc.auto.model.SysNavRoleExample;
import zhang.lao.build.mybatis.jdbc.auto.model.SysReqUrl;
import zhang.lao.build.mybatis.jdbc.auto.model.SysReqUrlExample;
import zhang.lao.build.mybatis.jdbc.auto.model.SysReqUrlRole;
import zhang.lao.build.mybatis.jdbc.auto.model.SysReqUrlRoleExample;
import zhang.lao.build.mybatis.jdbc.auto.model.SysRole;
import zhang.lao.build.mybatis.jdbc.auto.model.SysRoleExample;
import zhang.lao.build.mybatis.jdbc.auto.model.SysUser;
import zhang.lao.build.mybatis.jdbc.auto.model.SysUserExample;
import zhang.lao.build.mybatis.jdbc.auto.model.SysUserRole;
import zhang.lao.build.mybatis.jdbc.auto.model.SysUserRoleExample;
/**
* 
* @author 
* @create 
**/
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
       if(appInfo.getCreateTime()!=null){
           criteria.andCreateTimeEqualTo(appInfo.getCreateTime());
          }
       if(appInfo.getStatus()!=null){
           criteria.andStatusEqualTo(appInfo.getStatus());
          }
       if(appInfo.getUuid()!=null){
           criteria.andUuidEqualTo(appInfo.getUuid());
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
       if(appInfo.getCreateTime()!=null){
           sql.append(" and ").append(alias).append(".create_time").append(" = '").append(appInfo.getCreateTime()).append(" ' ");
          }
       if(appInfo.getStatus()!=null){
           sql.append(" and ").append(alias).append(".status").append(" = '").append(appInfo.getStatus()).append(" ' ");
          }
       if(appInfo.getUuid()!=null){
           sql.append(" and ").append(alias).append(".uuid").append(" = '").append(appInfo.getUuid()).append(" ' ");
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
       if(appToken.getCreateTime()!=null){
           criteria.andCreateTimeEqualTo(appToken.getCreateTime());
          }
       if(appToken.getExpiresTime()!=null){
           criteria.andExpiresTimeEqualTo(appToken.getExpiresTime());
          }
       if(appToken.getUuid()!=null){
           criteria.andUuidEqualTo(appToken.getUuid());
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
       if(appToken.getCreateTime()!=null){
           sql.append(" and ").append(alias).append(".create_time").append(" = '").append(appToken.getCreateTime()).append(" ' ");
          }
       if(appToken.getExpiresTime()!=null){
           sql.append(" and ").append(alias).append(".expires_time").append(" = '").append(appToken.getExpiresTime()).append(" ' ");
          }
       if(appToken.getUuid()!=null){
           sql.append(" and ").append(alias).append(".uuid").append(" = '").append(appToken.getUuid()).append(" ' ");
          }

                return sql.toString();
            }
    public static  BoBlogExample.Criteria setBoBlogCriteria(String querys,BoBlogExample.Criteria criteria){
        BoBlog boBlog = JSON.parseObject(querys, BoBlog.class);
               if(boBlog.getBlogTitle()!=null){
           criteria.andBlogTitleEqualTo(boBlog.getBlogTitle());
          }
       if(boBlog.getBlogImage()!=null){
           criteria.andBlogImageEqualTo(boBlog.getBlogImage());
          }
       if(boBlog.getUserId()!=null){
           criteria.andUserIdEqualTo(boBlog.getUserId());
          }
       if(boBlog.getBlogType()!=null){
           criteria.andBlogTypeEqualTo(boBlog.getBlogType());
          }

        return criteria;
    }

    public static  String setBoBlogCriteria(String querys,StringBuffer sql , String alias){
                BoBlog boBlog = JSON.parseObject(querys, BoBlog.class);
                       if(boBlog.getBlogTitle()!=null){
           sql.append(" and ").append(alias).append(".blog_title").append(" = '").append(boBlog.getBlogTitle()).append(" ' ");
          }
       if(boBlog.getBlogImage()!=null){
           sql.append(" and ").append(alias).append(".blog_image").append(" = '").append(boBlog.getBlogImage()).append(" ' ");
          }
       if(boBlog.getUserId()!=null){
           sql.append(" and ").append(alias).append(".user_id").append(" = '").append(boBlog.getUserId()).append(" ' ");
          }
       if(boBlog.getBlogType()!=null){
           sql.append(" and ").append(alias).append(".blog_type").append(" = '").append(boBlog.getBlogType()).append(" ' ");
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
       if(sysNav.getUuid()!=null){
           criteria.andUuidEqualTo(sysNav.getUuid());
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
       if(sysNav.getUuid()!=null){
           sql.append(" and ").append(alias).append(".uuid").append(" = '").append(sysNav.getUuid()).append(" ' ");
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
        
        return criteria;
    }

    public static  String setSysNavRoleCriteria(String querys,StringBuffer sql , String alias){
                SysNavRole sysNavRole = JSON.parseObject(querys, SysNavRole.class);
                
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
       if(sysRole.getCreateTime()!=null){
           criteria.andCreateTimeEqualTo(sysRole.getCreateTime());
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
       if(sysRole.getCreateTime()!=null){
           sql.append(" and ").append(alias).append(".create_time").append(" = '").append(sysRole.getCreateTime()).append(" ' ");
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
       if(sysUser.getCreateTime()!=null){
           criteria.andCreateTimeEqualTo(sysUser.getCreateTime());
          }
       if(sysUser.getUpdateTime()!=null){
           criteria.andUpdateTimeEqualTo(sysUser.getUpdateTime());
          }
       if(sysUser.getCreateUserId()!=null){
           criteria.andCreateUserIdEqualTo(sysUser.getCreateUserId());
          }
       if(sysUser.getUpdateUserId()!=null){
           criteria.andUpdateUserIdEqualTo(sysUser.getUpdateUserId());
          }
       if(sysUser.getUuid()!=null){
           criteria.andUuidEqualTo(sysUser.getUuid());
          }
       if(sysUser.getStatus()!=null){
           criteria.andStatusEqualTo(sysUser.getStatus());
          }
       if(sysUser.getUserType()!=null){
           criteria.andUserTypeEqualTo(sysUser.getUserType());
          }
       if(sysUser.getUserAccount()!=null){
           criteria.andUserAccountEqualTo(sysUser.getUserAccount());
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
       if(sysUser.getCreateTime()!=null){
           sql.append(" and ").append(alias).append(".create_time").append(" = '").append(sysUser.getCreateTime()).append(" ' ");
          }
       if(sysUser.getUpdateTime()!=null){
           sql.append(" and ").append(alias).append(".update_time").append(" = '").append(sysUser.getUpdateTime()).append(" ' ");
          }
       if(sysUser.getCreateUserId()!=null){
           sql.append(" and ").append(alias).append(".create_user_id").append(" = '").append(sysUser.getCreateUserId()).append(" ' ");
          }
       if(sysUser.getUpdateUserId()!=null){
           sql.append(" and ").append(alias).append(".update_user_id").append(" = '").append(sysUser.getUpdateUserId()).append(" ' ");
          }
       if(sysUser.getUuid()!=null){
           sql.append(" and ").append(alias).append(".uuid").append(" = '").append(sysUser.getUuid()).append(" ' ");
          }
       if(sysUser.getStatus()!=null){
           sql.append(" and ").append(alias).append(".status").append(" = '").append(sysUser.getStatus()).append(" ' ");
          }
       if(sysUser.getUserType()!=null){
           sql.append(" and ").append(alias).append(".user_type").append(" = '").append(sysUser.getUserType()).append(" ' ");
          }
       if(sysUser.getUserAccount()!=null){
           sql.append(" and ").append(alias).append(".user_account").append(" = '").append(sysUser.getUserAccount()).append(" ' ");
          }

                return sql.toString();
            }
    public static  SysUserRoleExample.Criteria setSysUserRoleCriteria(String querys,SysUserRoleExample.Criteria criteria){
        SysUserRole sysUserRole = JSON.parseObject(querys, SysUserRole.class);
        
        return criteria;
    }

    public static  String setSysUserRoleCriteria(String querys,StringBuffer sql , String alias){
                SysUserRole sysUserRole = JSON.parseObject(querys, SysUserRole.class);
                
                return sql.toString();
            }

}
