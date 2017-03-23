package lz.bbs.controller;

import com.alibaba.fastjson.JSON;
import lz.bbs.mapper.UserMapper;
import lz.bbs.model.HttpResult;
import lz.bbs.tool.BuildHttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 程序猿DD
 * @version 1.0.0
 * @blog http://blog.didispace.com
 *
 */
@Controller
public class HelloController {
    @Autowired
    private UserMapper userMapper;
    @RequestMapping("/user/{name}")
    public @ResponseBody HttpResult hello(@PathVariable String name) {
        return BuildHttpResult.successData(userMapper.findByName(name));
    }

    @RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("host", "http://blog.didispace.com");
        return "index";
    }

}