package zhang.lao.service.console.skin;

import zhang.lao.build.mybatis.jdbc.auto.dao.SysNavMapper;
import zhang.lao.build.mybatis.jdbc.auto.model.SysNav;
import zhang.lao.build.mybatis.jdbc.auto.model.SysNavExample;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import zhang.lao.pojo.console.ConsoleCacheNameContanst;
import zhang.lao.service.console.NavService;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * title:第二款皮肤工具类
 * </p>
 * <p>
 * description:
 * </p>
 *
 * @author 2016 北京太阳花互动科技有限公司 All Rights Reserved.
 * @create zhangqin
 * @update
 * @version 1.0
 * @date 2016年3月9日
 */

@Component
public class SecondSkinTool {

	@Resource
	private NavService navService;
	@Resource
	private SysNavMapper sysNavMapper;

	public  String getNav(SysNav sysNav, String user_id, String ctxPath){
		if(navService.hasNext(sysNav.getNavId())){
			return getThreeNav(user_id, sysNav, ctxPath);
		}else{
			return getSecoundNav(sysNav,ctxPath);
		}
	}

	/**
	 * 获取一级菜单
	 * @return
	 */
	@Cacheable(value = ConsoleCacheNameContanst.consoleServiceName,key = "#root.methodName+#user_id")
	public  String getFirstNav(String user_id,String ctxPath){
		StringBuffer sb=new StringBuffer();
		SysNavExample sysNavExample = new SysNavExample();
		sysNavExample.createCriteria().andPidEqualTo(new String("0")).andStatusEqualTo(new Short("1"));
		sysNavExample.setOrderByClause("sort asc");
		List<SysNav> list = sysNavMapper.selectByExample(sysNavExample);
		for (SysNav nav : list) {
			String targe="_self";
			if(nav.getUrlTarget().equals("_blank")){
				targe="target='_blank'";
			}
			if(navService.permissions(nav.getNavId(), user_id)){
				if(navService.hasNext(nav.getNavId())){
					sb.append("<li class=\"layui-nav-item\"> \r\n");
					sb.append("<a  "+targe+" name='first_nav' id='first_"+nav.getNavId()+"' href=\""+ctxPath+"/console/nav/trun/first?nav_id="+nav.getNavId()+"\">"+nav.getName()+"</a>\r\n");
					sb.append("</li> \r\n");
				}else{
					sb.append("<li class=\"layui-nav-item\" > \r\n");
					sb.append("<a "+targe+" name='first_nav' id='"+nav.getNavId()+"' href=\""+ctxPath+nav.getUrl()+"\">"+nav.getName()+"</a>\r\n");
					sb.append("</li> \r\n");
				}
			}
		}
		return sb.toString();

	}

	/**
	 * 获取二级菜单
	 * @param sysNav
	 * @return
	 */
	public  String getSecoundNav(SysNav sysNav, String ctxPath){
		String targe="_self";
		if(sysNav.getUrlTarget().equals("_blank")){
			targe="target='_blank'";
		}
		StringBuffer sb=new StringBuffer();
		sb.append("   <li class=\"layui-nav-item\">\n" +
				"    <a "+targe+" id='second_"+sysNav.getNavId()+"' href=\"" + ctxPath + sysNav.getUrl() + "\">"+sysNav.getName()+"</a>\n" +
				"   </li>");
		return sb.toString();

	}
	/**
	 * 获取三级菜单
	 * @param sysNav
	 * @return
	 */
	public  String getThreeNav(String user_id , SysNav sysNav, String ctxPath){
		StringBuffer sb=new StringBuffer();
		String targe="_self";
		if(sysNav.getUrlTarget().equals("_blank")){
			targe="target='_blank'";
		}
		if(navService.permissions(sysNav.getNavId(), user_id)) {
			sb.append("   <li class=\"layui-nav-item \">\n" +
					"    <a "+targe+" id='second_"+sysNav.getNavId()+"' href=\"" + ctxPath + sysNav.getUrl() + "\">"+sysNav.getName()+"</a>\n" +
					"    ");
			sb.append("<dl class=\"layui-nav-child\">\r\n");
			SysNavExample sys_nav_query = new SysNavExample();
			sys_nav_query.createCriteria().andStatusEqualTo((short) 1).andPidEqualTo(sysNav.getNavId());
			sys_nav_query.setOrderByClause("sort asc");
			List<SysNav> listNav = sysNavMapper.selectByExample(sys_nav_query);
			for (SysNav sysNav2 : listNav) {
				String targe2 = "";
				if (sysNav2.getUrlTarget().equals("_blank")) {
					targe2 = "target='_blank'";
				}
				if (navService.permissions(sysNav2.getNavId(), user_id)) {
					sb.append("<dd><a " + targe2 + " name='three_nav'  id='three_" + sysNav2.getNavId() + "' href=\"" + ctxPath + sysNav2.getUrl() + "\">" + sysNav2.getName() + "</a></dd>");
				}
			}
			sb.append("</dl>\r\n");
			sb.append("</li>                                                                             \r\n");
		}
		return sb.toString();

	}
}
