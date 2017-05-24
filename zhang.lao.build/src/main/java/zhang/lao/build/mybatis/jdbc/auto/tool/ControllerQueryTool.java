package zhang.lao.build.mybatis.jdbc.auto.tool;

import com.alibaba.fastjson.JSON;

import zhang.lao.build.mybatis.jdbc.auto.model.AppInfo;
import zhang.lao.build.mybatis.jdbc.auto.model.AppInfoExample;
import zhang.lao.build.mybatis.jdbc.auto.model.AppToken;
import zhang.lao.build.mybatis.jdbc.auto.model.AppTokenExample;
import zhang.lao.build.mybatis.jdbc.auto.model.BoCmsNews;
import zhang.lao.build.mybatis.jdbc.auto.model.BoCmsNewsExample;
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


    public static  BoCmsNewsExample.Criteria setBoCmsNewsCriteria(String querys,BoCmsNewsExample.Criteria criteria){
        BoCmsNews boCmsNews = JSON.parseObject(querys, BoCmsNews.class);
               if(boCmsNews.getCreateTime()!=null){
           criteria.andCreateTimeEqualTo(boCmsNews.getCreateTime());
          }
       if(boCmsNews.getPublish()!=null){
           criteria.andPublishEqualTo(boCmsNews.getPublish());
          }
       if(boCmsNews.getAuthor()!=null){
           criteria.andAuthorEqualTo(boCmsNews.getAuthor());
          }
       if(boCmsNews.getSource()!=null){
           criteria.andSourceEqualTo(boCmsNews.getSource());
          }
       if(boCmsNews.getUpdateTime()!=null){
           criteria.andUpdateTimeEqualTo(boCmsNews.getUpdateTime());
          }
       if(boCmsNews.getCover()!=null){
           criteria.andCoverEqualTo(boCmsNews.getCover());
          }
       if(boCmsNews.getTitle()!=null){
           criteria.andTitleEqualTo(boCmsNews.getTitle());
          }
       if(boCmsNews.getNewsType()!=null){
           criteria.andNewsTypeEqualTo(boCmsNews.getNewsType());
          }
       if(boCmsNews.getIntro()!=null){
           criteria.andIntroEqualTo(boCmsNews.getIntro());
          }
       if(boCmsNews.getTag()!=null){
           criteria.andTagEqualTo(boCmsNews.getTag());
          }

        return criteria;
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


    public static  SysNavRoleExample.Criteria setSysNavRoleCriteria(String querys,SysNavRoleExample.Criteria criteria){
        SysNavRole sysNavRole = JSON.parseObject(querys, SysNavRole.class);
        
        return criteria;
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


    public static  SysUserRoleExample.Criteria setSysUserRoleCriteria(String querys,SysUserRoleExample.Criteria criteria){
        SysUserRole sysUserRole = JSON.parseObject(querys, SysUserRole.class);
        
        return criteria;
    }



}
