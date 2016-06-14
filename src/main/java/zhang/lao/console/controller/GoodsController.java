package zhang.lao.console.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import zhang.lao.console.ConsoleReqUrl;
import zhang.lao.mybatis.auto.dao.GoodsInfoMapper;

import javax.annotation.Resource;

/**
 * Created by tech6 on 2016/6/14.
 */
@Controller
public class GoodsController {

    @Resource
    private GoodsInfoMapper goodsInfoMapper;

    @RequestMapping(value = ConsoleReqUrl.GOODS_INFO_EDIT)
    public String edit(long id,ModelMap modelMap){

        modelMap.put("goods_info",goodsInfoMapper.selectByPrimaryKey(id));
        return "index";
    }
}
