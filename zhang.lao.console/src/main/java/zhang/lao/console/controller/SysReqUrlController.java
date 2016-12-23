package zhang.lao.console.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lz.kit.LogKit;
import com.lz.kit.Prop;
import com.lz.kit.PropKit;
import com.lz.mybatis.jdbc.auto.dao.SysReqUrlMapper;
import com.lz.mybatis.jdbc.auto.model.SysReqUrl;
import com.lz.mybatis.jdbc.auto.model.SysReqUrlExample;
import com.lz.tool.LzStringUtils;
import com.lz.tool.ToolClassSearcher;
import com.lz.tool.UUIDTool;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zhang.lao.annotation.RepeatSubmit;
import zhang.lao.pojo.req.console.BootStrapGridReq;
import zhang.lao.pojo.resp.console.BootStrapGridResp;
import zhang.lao.pojo.resp.console.CommonResp;
import zhang.lao.pojo.resp.console.HttpResult;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.List;

/**
 * <p>
 * title:
 * </p>
 * <p>
 * description:
 * </p>
 *
 * @create 张钦
 * @update
 * @version 1.0
 * @date
 */
@Controller
public class SysReqUrlController{
	@Resource
	private SysReqUrlMapper modelMapper;

	@RequestMapping("/console/sys_req_url/add")
	@RepeatSubmit(isAdd = true)
	public String add(){
		return "console/sysReqUrl/sysReqUrl_form";
	}

	@RepeatSubmit(isAdd = true)
	@RequestMapping("/console/sys_req_url/edit")
	public String edit(ModelMap modelMap,String id){
			modelMap.put("sysReqUrl", modelMapper.selectByPrimaryKey(id));
		return "console/sysReqUrl/sysReqUrl_form";
	}

	@RequestMapping("/console/sys_req_url/list")
	public String list(){
		return "console/sysReqUrl/sysReqUrl_table";
	}

	@RequestMapping("/console/sys_req_url/json")
	public @ResponseBody
	BootStrapGridResp json(BootStrapGridReq bootGridReq){
		Page page = PageHelper.offsetPage(bootGridReq.getOffset(), bootGridReq.getLimit());
    	if(bootGridReq.getSort()!=null) {
    		page.setOrderBy(LzStringUtils.chageStringUpCaseAnd_(bootGridReq.getSort()) + " " + bootGridReq.getOrder());
    	}
		SysReqUrlExample sysReqUrlExample = new SysReqUrlExample();
        ControllerQueryTool.setSysReqUrlCriteria(bootGridReq.getQuery(),sysReqUrlExample.createCriteria());
		List<SysReqUrl> sysReqUrlList = modelMapper.selectByExample(sysReqUrlExample);
		return new BootStrapGridResp(page.getTotal(),sysReqUrlList);
	}

	@RepeatSubmit(isAdd = false)
	@RequestMapping("/console/sys_req_url/save")
	public @ResponseBody
	HttpResult save(String formObjectJson){
		try{
		SysReqUrl sysReqUrl= JSON.parseObject(formObjectJson,SysReqUrl.class);
			String id=sysReqUrl.getId();
		if (id!=null) {
			modelMapper.updateByPrimaryKeySelective(sysReqUrl);
			return CommonResp.getSuccess();
		}else{
			modelMapper.insertSelective(sysReqUrl);
			return CommonResp.getSuccess();
		}
		}catch(Exception e){
			LogKit.error(e.getMessage(),e);
			return CommonResp.getError();
		}

	}

	@RequestMapping("/console/sys_req_url/delete")
	public @ResponseBody HttpResult delete(String ids){
		String[]idsa=ids.split(",");
		for (String id : idsa) {
		modelMapper.deleteByPrimaryKey(String.valueOf(id));
		}
		return CommonResp.getSuccess();
	}

	@Resource
	private JdbcTemplate jdbcTemplate;
	@RequestMapping("/console/sys_req_url/init")
	public  @ResponseBody HttpResult getListReq() {
		List<Class<?>> modelClasses = new ToolClassSearcher(null).search(null);// 查询所有继承BaseModel的类
		// 循环处理自动注册映射
		for (Class model : modelClasses) {
			if(model.getAnnotation(Controller.class)!=null) {
				Method[] method = model.getMethods();
				for (Method method1 : method) {
					RequestMapping r =  method1.getAnnotation(RequestMapping.class);
					if(r!=null){
						String [] s= r.value();
						for (String s1 : s) {
							if(s1.startsWith("/console")){
								if(s1.equals("/console")||s1.equals("/console/")||s1.startsWith("/console/logout")||s1.startsWith("/console/nav/trun/first")||s1.startsWith("/console/login")){
									continue;
								}
								String title="";
								Prop prop =  PropKit.use("table-description.properties");
								Enumeration e =  prop.getProperties().propertyNames();
								while (e.hasMoreElements()){
									String name = (String) e.nextElement();
									if(s1.indexOf(name)!=-1){
										title+=prop.get(name);
										break;
									}
								}
								if(s1.endsWith("/add")){
									title+="-添加页面";
								} else if(s1.endsWith("/save")){
									title+="-保存操作";
								}else if(s1.endsWith("/edit")){
									title+="-编辑页面";
								}else if(s1.endsWith("/list")){
									title+="-列表页面";
								}else if(s1.endsWith("/json")){
									title+="-列表json数据请求";
								}
								else if(s1.endsWith("/delete")){
									title+="-删除";
								}
								int c =   jdbcTemplate.queryForObject("select count(id) from sys_req_url where url=?",Integer.class,s1);
								if(c==0)
									jdbcTemplate.update("INSERT INTO sys_req_url(id,url,name,description)VALUES(?,?,?,?)", UUIDTool.getUUID(),s1,title,title);
							}

						}
					}
				}
			}
		}
		return CommonResp.getSuccess();
	}
}
