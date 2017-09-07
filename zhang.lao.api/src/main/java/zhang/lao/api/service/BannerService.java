package zhang.lao.api.service;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhang.lao.api.pojo.BannerResp;
import zhang.lao.build.mybatis.jdbc.auto.model.BoAppBanner;
import zhang.lao.build.mybatis.jdbc.auto.model.BoAppBannerExample;
import zhang.lao.dao.base.BoAppBannerDao;
import zhang.lao.pojo.api.resp.ApiRespData;

import java.util.List;

/**
 * Created by Administrator on 2017/9/7.
 */

@Service
public class BannerService {
    @Autowired
    private BoAppBannerDao boAppBannerDao;
    public ApiRespData<List<BannerResp>> getBannerIndex(){
        List<BannerResp> bannerRespList = Lists.newArrayList();
        BoAppBannerExample boAppBannerExample = new BoAppBannerExample();
        boAppBannerExample.createCriteria().andTypeEqualTo("index").andStatusEqualTo(1);
        boAppBannerExample.setOrderByClause("sort asc");
        List<BoAppBanner> boAppBanners = boAppBannerDao.selectByExample(boAppBannerExample);
        if(boAppBanners!=null){
            for (BoAppBanner boAppBanner : boAppBanners) {
                BannerResp bannerResp = new BannerResp();
                bannerResp.setBannerImg(boAppBanner.getBannerImg());
                bannerResp.setTarget(boAppBanner.getTarget());
                bannerResp.setTargetType(boAppBanner.getTargetType());
                bannerResp.setTitle(boAppBanner.getTitle());
                bannerRespList.add(bannerResp);

            }
        }
        return ApiRespData.buildSucc(bannerRespList);
    }
}
