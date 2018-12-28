package zhang.lao.console.controller.front;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import zhang.lao.build.mybatis.jdbc.auto.model.BoContactUs;
import zhang.lao.build.mybatis.jdbc.auto.model.BoWebNews;
import zhang.lao.build.mybatis.jdbc.auto.model.BoWebNewsExample;
import zhang.lao.build.tool.ListUtils;
import zhang.lao.build.tool.UUIDTool;
import zhang.lao.dao.base.BoContactUsDao;
import zhang.lao.dao.base.BoWebNewsDao;
import zhang.lao.pojo.console.resp.HttpResult;
import zhang.lao.pojo.console.resp.HttpResultUtil;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/5/8.
 */
@Controller
public class IndexController
{

    @Resource
    private BoContactUsDao boContactUsDao;
    @Resource
    private BoWebNewsDao boWebNewsDao;
    @RequestMapping("/")
    public String index(){
        return "front/index";
    }

    @RequestMapping("/{page}")
    public String index(@PathVariable String page){
        return "front/"+page;
    }


    @RequestMapping(value = "/contact/send",method = {RequestMethod.POST})
    public String contactSend(BoContactUs boContactUs){
        boContactUs.setId(UUIDTool.getUUID());
        boContactUs.setLinkTime(new Date());
        boContactUs.setLinkState(0);
        boContactUsDao.insertSelective(boContactUs);
        return "redirect:/contact";
    }

    @RequestMapping("/news/list/json/{type}")
    public @ResponseBody HttpResult newsList(@PathVariable int type){
        BoWebNewsExample boWebNewsExample =new BoWebNewsExample();
        boWebNewsExample.createCriteria().andNewsTypeEqualTo(type).andPublishEqualTo(1);
        List<BoWebNews> boWebNews = boWebNewsDao.selectByExample(boWebNewsExample);
        return HttpResultUtil.buildSuccess(boWebNews);
    }
    @RequestMapping("/news/list/{type}")
    public String newsListPage(@PathVariable int type, ModelMap modelMap){
        switch (type){
            //新闻类型_select_1:普通新闻|2:项目简介|3:成果展示|4:建设进
            case 1:
                modelMap.put("headTitle","新闻中心");
                break;
            case 2:
                modelMap.put("headTitle","项目简介");
                break;
            case 3:
                modelMap.put("headTitle","成果展示");
                break;
            case 4:
                modelMap.put("headTitle","建设进展");
                break;

        }
        BoWebNewsExample boWebNewsExample =new BoWebNewsExample();
        boWebNewsExample.createCriteria().andNewsTypeEqualTo(type).andPublishEqualTo(1);
        List<BoWebNews> boWebNews = boWebNewsDao.selectByExample(boWebNewsExample);
        modelMap.put("newsList",boWebNews);
        return "front/news";
    }

    @RequestMapping("/news/detail/{id}")
    public String newsList(@PathVariable String id,ModelMap modelMap){
        BoWebNews  boWebNews = boWebNewsDao.selectByPrimaryKey(id);
        int type = boWebNews.getNewsType();
        switch (type){
            //新闻类型_select_1:普通新闻|2:项目简介|3:成果展示|4:建设进
            case 1:
                modelMap.put("headTitle","新闻中心");
                break;
            case 2:
                modelMap.put("headTitle","项目简介");
                break;
            case 3:
                modelMap.put("headTitle","成果展示");
                break;
            case 4:
                modelMap.put("headTitle","建设进展");
                break;

        }
        modelMap.put("news",boWebNews);
        return "front/newsDetail";
    }
}
