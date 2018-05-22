package zhang.lao.build.mybatis.jdbc.auto.tool;

import com.alibaba.fastjson.JSON;

import zhang.lao.build.mybatis.jdbc.auto.model.AppInfo;
import zhang.lao.build.mybatis.jdbc.auto.model.AppInfoExample;
import zhang.lao.build.mybatis.jdbc.auto.model.BoTest;
import zhang.lao.build.mybatis.jdbc.auto.model.BoTestExample;
import zhang.lao.build.mybatis.jdbc.auto.model.SysDictionary;
import zhang.lao.build.mybatis.jdbc.auto.model.SysDictionaryExample;
import zhang.lao.build.mybatis.jdbc.auto.model.SysFile;
import zhang.lao.build.mybatis.jdbc.auto.model.SysFileExample;
import zhang.lao.build.mybatis.jdbc.auto.model.SysNav;
import zhang.lao.build.mybatis.jdbc.auto.model.SysNavExample;
import zhang.lao.build.mybatis.jdbc.auto.model.SysNavRole;
import zhang.lao.build.mybatis.jdbc.auto.model.SysNavRoleExample;
import zhang.lao.build.mybatis.jdbc.auto.model.SysReqUrl;
import zhang.lao.build.mybatis.jdbc.auto.model.SysReqUrlExample;
import zhang.lao.build.mybatis.jdbc.auto.model.SysReqUrlGroup;
import zhang.lao.build.mybatis.jdbc.auto.model.SysReqUrlGroupExample;
import zhang.lao.build.mybatis.jdbc.auto.model.SysReqUrlRole;
import zhang.lao.build.mybatis.jdbc.auto.model.SysReqUrlRoleExample;
import zhang.lao.build.mybatis.jdbc.auto.model.SysReqUrlWhiteList;
import zhang.lao.build.mybatis.jdbc.auto.model.SysReqUrlWhiteListExample;
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
       if(appInfo.getStatus()!=null){
           criteria.andStatusEqualTo(appInfo.getStatus());
          }

        return criteria;
    }


    public static  BoTestExample.Criteria setBoTestCriteria(String querys,BoTestExample.Criteria criteria){
        BoTest boTest = JSON.parseObject(querys, BoTest.class);
               if(boTest.getName()!=null){
           criteria.andNameEqualTo(boTest.getName());
          }
       if(boTest.getBirthday()!=null){
           criteria.andBirthdayEqualTo(boTest.getBirthday());
          }
       if(boTest.getAge()!=null){
           criteria.andAgeEqualTo(boTest.getAge());
          }
       if(boTest.getSex()!=null){
           criteria.andSexEqualTo(boTest.getSex());
          }

        return criteria;
    }


    public static  SysDictionaryExample.Criteria setSysDictionaryCriteria(String querys,SysDictionaryExample.Criteria criteria){
        SysDictionary sysDictionary = JSON.parseObject(querys, SysDictionary.class);
               if(sysDictionary.getCode()!=null){
           criteria.andCodeEqualTo(sysDictionary.getCode());
          }
       if(sysDictionary.getValue()!=null){
           criteria.andValueEqualTo(sysDictionary.getValue());
          }
       if(sysDictionary.getDes()!=null){
           criteria.andDesEqualTo(sysDictionary.getDes());
          }
       if(sysDictionary.getName()!=null){
           criteria.andNameEqualTo(sysDictionary.getName());
          }
       if(sysDictionary.getDefaultValue()!=null){
           criteria.andDefaultValueEqualTo(sysDictionary.getDefaultValue());
          }

        return criteria;
    }


    public static  SysFileExample.Criteria setSysFileCriteria(String querys,SysFileExample.Criteria criteria){
        SysFile sysFile = JSON.parseObject(querys, SysFile.class);
               if(sysFile.getFileName()!=null){
           criteria.andFileNameEqualTo(sysFile.getFileName());
          }
       if(sysFile.getFileType()!=null){
           criteria.andFileTypeEqualTo(sysFile.getFileType());
          }
       if(sysFile.getFileHeight()!=null){
           criteria.andFileHeightEqualTo(sysFile.getFileHeight());
          }
       if(sysFile.getFileWidth()!=null){
           criteria.andFileWidthEqualTo(sysFile.getFileWidth());
          }
       if(sysFile.getFileSize()!=null){
           criteria.andFileSizeEqualTo(sysFile.getFileSize());
          }
       if(sysFile.getFileUrl()!=null){
           criteria.andFileUrlEqualTo(sysFile.getFileUrl());
          }
       if(sysFile.getLocal()!=null){
           criteria.andLocalEqualTo(sysFile.getLocal());
          }
       if(sysFile.getFileMd5()!=null){
           criteria.andFileMd5EqualTo(sysFile.getFileMd5());
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
       if(sysReqUrl.getGroupId()!=null){
           criteria.andGroupIdEqualTo(sysReqUrl.getGroupId());
          }

        return criteria;
    }


    public static  SysReqUrlGroupExample.Criteria setSysReqUrlGroupCriteria(String querys,SysReqUrlGroupExample.Criteria criteria){
        SysReqUrlGroup sysReqUrlGroup = JSON.parseObject(querys, SysReqUrlGroup.class);
               if(sysReqUrlGroup.getName()!=null){
           criteria.andNameEqualTo(sysReqUrlGroup.getName());
          }
       if(sysReqUrlGroup.getDescription()!=null){
           criteria.andDescriptionEqualTo(sysReqUrlGroup.getDescription());
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


    public static  SysReqUrlWhiteListExample.Criteria setSysReqUrlWhiteListCriteria(String querys,SysReqUrlWhiteListExample.Criteria criteria){
        SysReqUrlWhiteList sysReqUrlWhiteList = JSON.parseObject(querys, SysReqUrlWhiteList.class);
               if(sysReqUrlWhiteList.getUrl()!=null){
           criteria.andUrlEqualTo(sysReqUrlWhiteList.getUrl());
          }
       if(sysReqUrlWhiteList.getName()!=null){
           criteria.andNameEqualTo(sysReqUrlWhiteList.getName());
          }
       if(sysReqUrlWhiteList.getDescription()!=null){
           criteria.andDescriptionEqualTo(sysReqUrlWhiteList.getDescription());
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
