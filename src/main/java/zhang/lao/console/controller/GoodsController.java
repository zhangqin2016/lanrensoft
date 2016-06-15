package zhang.lao.console.controller;

import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zhang.lao.annotation.RepeatSubmit;
import zhang.lao.console.ConsoleReqUrl;
import zhang.lao.mybatis.auto.dao.GoodsInfoMapper;
import zhang.lao.mybatis.auto.model.GoodsInfoExample;
import zhang.lao.pojo.resault.CommonResp;

import javax.annotation.Resource;

/**
 * Created by tech6 on 2016/6/14.
 */
@Controller
public class GoodsController {

    @Resource
    private GoodsInfoMapper goodsInfoMapper;


    @RepeatSubmit(isAdd = true)
    @RequestMapping(value = ConsoleReqUrl.GOODS_INFO_EDIT)
    public String edit(long id,ModelMap modelMap){

        modelMap.put("goods_info",goodsInfoMapper.selectByPrimaryKey(id));
        return "index";
    }

    @RequestMapping(value = ConsoleReqUrl.GOODS_INFO_LIST_JSON)
    public @ResponseBody String json(int s,int p,ModelMap modelMap){
        PageHelper.startPage(p,s);
        GoodsInfoExample goodsInfoExample = new GoodsInfoExample();
        GoodsInfoExample.Criteria criteria = goodsInfoExample.createCriteria();
        criteria.andStatusEqualTo((short) 1);
        return CommonResp.getJson(CommonResp.getSuccess(goodsInfoMapper.selectByExample(goodsInfoExample)));
    }

    @RequestMapping(value = ConsoleReqUrl.GOODS_INFO_SAVE)
    @RepeatSubmit(isAdd = false)
    public @ResponseBody String save(){
        return CommonResp.getJson(CommonResp.getSuccess());
    }
}
