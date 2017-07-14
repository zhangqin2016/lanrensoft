package zhang.lao.service.console.base;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import zhang.lao.build.kit.LogKit;
import zhang.lao.build.kit.Prop;
import zhang.lao.build.kit.PropKit;
import zhang.lao.build.mybatis.jdbc.auto.tool.ControllerQueryTool;
import zhang.lao.build.tool.ToolClassSearcher;
import zhang.lao.build.tool.UUIDTool;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import zhang.lao.dao.base.SysReqUrlDao;
import zhang.lao.build.mybatis.jdbc.auto.model.SysReqUrl;
import zhang.lao.build.mybatis.jdbc.auto.model.SysReqUrlExample;
import zhang.lao.build.tool.LzStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import zhang.lao.pojo.console.req.BootStrapGridReq;
import zhang.lao.pojo.console.resp.BootStrapGridResp;

import zhang.lao.pojo.console.resp.HttpResult;
import zhang.lao.pojo.console.resp.HttpResultUtil;

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
@Service
public class SysReqUrlService{
	@Resource
	private SysReqUrlDao modelDao;
	@Resource
	private JdbcTemplate jdbcTemplate;
	public String add(){
		return "console/sysReqUrl/sysReqUrl_form";
	}

	public String edit(ModelMap modelMap,String id){
		modelMap.put("sysReqUrl", modelDao.selectByPrimaryKey(id));
		return "console/sysReqUrl/sysReqUrl_form";
	}

	public String list(){
		return "console/sysReqUrl/sysReqUrl_table";
	}

	public
	BootStrapGridResp json(BootStrapGridReq bootGridReq){
		Page page = PageHelper.offsetPage(bootGridReq.getOffset(), bootGridReq.getLimit());
		if(bootGridReq.getSort()!=null) {
			page.setOrderBy(LzStringUtils.chageStringUpCaseAnd_(bootGridReq.getSort()) + " " + bootGridReq.getOrder());
		}
		SysReqUrlExample sysReqUrlExample = new SysReqUrlExample();
		ControllerQueryTool.setSysReqUrlCriteria(bootGridReq.getQuery(),sysReqUrlExample.createCriteria());
		List<SysReqUrl> sysReqUrlList = modelDao.selectByExample(sysReqUrlExample);
		return new BootStrapGridResp(page.getTotal(),sysReqUrlList);
	}

	public 
	HttpResult save(String formObjectJson){
			SysReqUrl sysReqUrl= JSON.parseObject(formObjectJson,SysReqUrl.class);
			String id=sysReqUrl.getId();
			if (id!=null) {
				modelDao.updateByPrimaryKeySelective(sysReqUrl);
				return HttpResultUtil.buildSuccess();
			}else{
				sysReqUrl.setId(UUIDTool.getUUID());
				modelDao.insertSelective(sysReqUrl);
				return HttpResultUtil.buildSuccess();
			}


	}

	public  HttpResult delete(String ids){
		String[]idsa=ids.split(",");
		for (String id : idsa) {
			modelDao.deleteByPrimaryKey(String.valueOf(id));
		}
		return HttpResultUtil.buildSuccess();
	}


	public   HttpResult getListReq() {
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
		return HttpResultUtil.buildSuccess();
	}
}
