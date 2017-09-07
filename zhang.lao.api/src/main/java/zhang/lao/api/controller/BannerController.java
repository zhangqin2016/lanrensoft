package zhang.lao.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zhang.lao.api.pojo.BannerResp;
import zhang.lao.api.service.BannerService;
import zhang.lao.pojo.api.resp.ApiRespData;

import java.util.List;

/**
 * Created by Administrator on 2017/9/7.
 */

@RestController
public class BannerController {

        @Autowired
        private BannerService bannerService;

    @RequestMapping("/api/index/banner")
    public ApiRespData<List<BannerResp>> getBanner(){
        return bannerService.getBannerIndex();
    }
}
