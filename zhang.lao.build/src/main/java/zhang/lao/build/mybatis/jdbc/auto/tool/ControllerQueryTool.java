package zhang.lao.build.mybatis.jdbc.auto.tool;

import com.alibaba.fastjson.JSON;

import zhang.lao.build.mybatis.jdbc.auto.model.AppInfo;
import zhang.lao.build.mybatis.jdbc.auto.model.AppInfoExample;
import zhang.lao.build.mybatis.jdbc.auto.model.AppToken;
import zhang.lao.build.mybatis.jdbc.auto.model.AppTokenExample;
import zhang.lao.build.mybatis.jdbc.auto.model.BoAppBanner;
import zhang.lao.build.mybatis.jdbc.auto.model.BoAppBannerExample;
import zhang.lao.build.mybatis.jdbc.auto.model.BoCmsNews;
import zhang.lao.build.mybatis.jdbc.auto.model.BoCmsNewsExample;
import zhang.lao.build.mybatis.jdbc.auto.model.BoProgectAround;
import zhang.lao.build.mybatis.jdbc.auto.model.BoProgectAroundExample;
import zhang.lao.build.mybatis.jdbc.auto.model.BoProgectGoodsImages;
import zhang.lao.build.mybatis.jdbc.auto.model.BoProgectGoodsImagesExample;
import zhang.lao.build.mybatis.jdbc.auto.model.BoProgectImages;
import zhang.lao.build.mybatis.jdbc.auto.model.BoProgectImagesExample;
import zhang.lao.build.mybatis.jdbc.auto.model.BoProject;
import zhang.lao.build.mybatis.jdbc.auto.model.BoProjectExample;
import zhang.lao.build.mybatis.jdbc.auto.model.BoProjectGoods;
import zhang.lao.build.mybatis.jdbc.auto.model.BoProjectGoodsExample;
import zhang.lao.build.mybatis.jdbc.auto.model.BoUser;
import zhang.lao.build.mybatis.jdbc.auto.model.BoUserExample;
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


    public static  BoAppBannerExample.Criteria setBoAppBannerCriteria(String querys,BoAppBannerExample.Criteria criteria){
        BoAppBanner boAppBanner = JSON.parseObject(querys, BoAppBanner.class);
               if(boAppBanner.getTitle()!=null){
           criteria.andTitleEqualTo(boAppBanner.getTitle());
          }
       if(boAppBanner.getBannerImg()!=null){
           criteria.andBannerImgEqualTo(boAppBanner.getBannerImg());
          }
       if(boAppBanner.getTarget()!=null){
           criteria.andTargetEqualTo(boAppBanner.getTarget());
          }
       if(boAppBanner.getTargetType()!=null){
           criteria.andTargetTypeEqualTo(boAppBanner.getTargetType());
          }
       if(boAppBanner.getType()!=null){
           criteria.andTypeEqualTo(boAppBanner.getType());
          }
       if(boAppBanner.getCreateTime()!=null){
           criteria.andCreateTimeEqualTo(boAppBanner.getCreateTime());
          }
       if(boAppBanner.getSort()!=null){
           criteria.andSortEqualTo(boAppBanner.getSort());
          }
       if(boAppBanner.getStatus()!=null){
           criteria.andStatusEqualTo(boAppBanner.getStatus());
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


    public static  BoProgectAroundExample.Criteria setBoProgectAroundCriteria(String querys,BoProgectAroundExample.Criteria criteria){
        BoProgectAround boProgectAround = JSON.parseObject(querys, BoProgectAround.class);
               if(boProgectAround.getProjectId()!=null){
           criteria.andProjectIdEqualTo(boProgectAround.getProjectId());
          }
       if(boProgectAround.getName()!=null){
           criteria.andNameEqualTo(boProgectAround.getName());
          }
       if(boProgectAround.getInfoImage()!=null){
           criteria.andInfoImageEqualTo(boProgectAround.getInfoImage());
          }

        return criteria;
    }


    public static  BoProgectGoodsImagesExample.Criteria setBoProgectGoodsImagesCriteria(String querys,BoProgectGoodsImagesExample.Criteria criteria){
        BoProgectGoodsImages boProgectGoodsImages = JSON.parseObject(querys, BoProgectGoodsImages.class);
               if(boProgectGoodsImages.getGoodsId()!=null){
           criteria.andGoodsIdEqualTo(boProgectGoodsImages.getGoodsId());
          }
       if(boProgectGoodsImages.getImageUrl()!=null){
           criteria.andImageUrlEqualTo(boProgectGoodsImages.getImageUrl());
          }
       if(boProgectGoodsImages.getImageName()!=null){
           criteria.andImageNameEqualTo(boProgectGoodsImages.getImageName());
          }
       if(boProgectGoodsImages.getImageType()!=null){
           criteria.andImageTypeEqualTo(boProgectGoodsImages.getImageType());
          }
       if(boProgectGoodsImages.getSort()!=null){
           criteria.andSortEqualTo(boProgectGoodsImages.getSort());
          }

        return criteria;
    }


    public static  BoProgectImagesExample.Criteria setBoProgectImagesCriteria(String querys,BoProgectImagesExample.Criteria criteria){
        BoProgectImages boProgectImages = JSON.parseObject(querys, BoProgectImages.class);
               if(boProgectImages.getProjectId()!=null){
           criteria.andProjectIdEqualTo(boProgectImages.getProjectId());
          }
       if(boProgectImages.getImageUrl()!=null){
           criteria.andImageUrlEqualTo(boProgectImages.getImageUrl());
          }
       if(boProgectImages.getImageName()!=null){
           criteria.andImageNameEqualTo(boProgectImages.getImageName());
          }
       if(boProgectImages.getImageType()!=null){
           criteria.andImageTypeEqualTo(boProgectImages.getImageType());
          }
       if(boProgectImages.getSort()!=null){
           criteria.andSortEqualTo(boProgectImages.getSort());
          }

        return criteria;
    }


    public static  BoProjectExample.Criteria setBoProjectCriteria(String querys,BoProjectExample.Criteria criteria){
        BoProject boProject = JSON.parseObject(querys, BoProject.class);
               if(boProject.getType()!=null){
           criteria.andTypeEqualTo(boProject.getType());
          }
       if(boProject.getSelfBuild()!=null){
           criteria.andSelfBuildEqualTo(boProject.getSelfBuild());
          }
       if(boProject.getTitle()!=null){
           criteria.andTitleEqualTo(boProject.getTitle());
          }
       if(boProject.getProjectDevelopers()!=null){
           criteria.andProjectDevelopersEqualTo(boProject.getProjectDevelopers());
          }
       if(boProject.getProjectInto()!=null){
           criteria.andProjectIntoEqualTo(boProject.getProjectInto());
          }
       if(boProject.getProjrctManager()!=null){
           criteria.andProjrctManagerEqualTo(boProject.getProjrctManager());
          }
       if(boProject.getProjectEstate()!=null){
           criteria.andProjectEstateEqualTo(boProject.getProjectEstate());
          }
       if(boProject.getProvince()!=null){
           criteria.andProvinceEqualTo(boProject.getProvince());
          }
       if(boProject.getCity()!=null){
           criteria.andCityEqualTo(boProject.getCity());
          }
       if(boProject.getCountry()!=null){
           criteria.andCountryEqualTo(boProject.getCountry());
          }
       if(boProject.getAddress()!=null){
           criteria.andAddressEqualTo(boProject.getAddress());
          }
       if(boProject.getDecorationLeave()!=null){
           criteria.andDecorationLeaveEqualTo(boProject.getDecorationLeave());
          }
       if(boProject.getImageCover()!=null){
           criteria.andImageCoverEqualTo(boProject.getImageCover());
          }
       if(boProject.getState()!=null){
           criteria.andStateEqualTo(boProject.getState());
          }
       if(boProject.getSort()!=null){
           criteria.andSortEqualTo(boProject.getSort());
          }

        return criteria;
    }


    public static  BoProjectGoodsExample.Criteria setBoProjectGoodsCriteria(String querys,BoProjectGoodsExample.Criteria criteria){
        BoProjectGoods boProjectGoods = JSON.parseObject(querys, BoProjectGoods.class);
               if(boProjectGoods.getTitle()!=null){
           criteria.andTitleEqualTo(boProjectGoods.getTitle());
          }
       if(boProjectGoods.getBuildArea()!=null){
           criteria.andBuildAreaEqualTo(boProjectGoods.getBuildArea());
          }
       if(boProjectGoods.getEquityPrice()!=null){
           criteria.andEquityPriceEqualTo(boProjectGoods.getEquityPrice());
          }
       if(boProjectGoods.getAdminPrice()!=null){
           criteria.andAdminPriceEqualTo(boProjectGoods.getAdminPrice());
          }
       if(boProjectGoods.getImageCover()!=null){
           criteria.andImageCoverEqualTo(boProjectGoods.getImageCover());
          }
       if(boProjectGoods.getTag()!=null){
           criteria.andTagEqualTo(boProjectGoods.getTag());
          }

        return criteria;
    }


    public static  BoUserExample.Criteria setBoUserCriteria(String querys,BoUserExample.Criteria criteria){
        BoUser boUser = JSON.parseObject(querys, BoUser.class);
               if(boUser.getNickName()!=null){
           criteria.andNickNameEqualTo(boUser.getNickName());
          }
       if(boUser.getPhoneNumber()!=null){
           criteria.andPhoneNumberEqualTo(boUser.getPhoneNumber());
          }
       if(boUser.getPassword()!=null){
           criteria.andPasswordEqualTo(boUser.getPassword());
          }
       if(boUser.getSex()!=null){
           criteria.andSexEqualTo(boUser.getSex());
          }
       if(boUser.getAge()!=null){
           criteria.andAgeEqualTo(boUser.getAge());
          }
       if(boUser.getState()!=null){
           criteria.andStateEqualTo(boUser.getState());
          }
       if(boUser.getCreateTime()!=null){
           criteria.andCreateTimeEqualTo(boUser.getCreateTime());
          }
       if(boUser.getHeadImage()!=null){
           criteria.andHeadImageEqualTo(boUser.getHeadImage());
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
       if(sysFile.getCreateTime()!=null){
           criteria.andCreateTimeEqualTo(sysFile.getCreateTime());
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
