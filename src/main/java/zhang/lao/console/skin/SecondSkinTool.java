package zhang.lao.console.skin;

import org.springframework.stereotype.Component;
import zhang.lao.console.service.NavService;
import zhang.lao.mybatis.auto.dao.SysNavMapper;
import zhang.lao.mybatis.auto.model.SysNav;
import zhang.lao.mybatis.auto.model.SysNavExample;

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
	private SysNavMapper navMapper;

	public  String getNav(SysNav sysNav,Integer user_id,String ctxPath){


	//	if(navService.permissions(sysNav.getNavId(), user_id)){
		if(navService.hasNext(sysNav.getNavId())){
			return getThreeNav(sysNav,ctxPath);
		}else{
			return getSecoundNav(sysNav,ctxPath);
		}
//		}else{
//			return "";
//		}
	}

	/**
	 * 获取一级菜单
	 * @return
	 */
	public  String getFirstNav(Integer user_id,String ctxPath){
		StringBuffer sb=new StringBuffer();
		SysNavExample sysNavExample = new SysNavExample();
		sysNavExample.createCriteria().andPIdEqualTo(0).andStatusEqualTo(new Short("1"));
		List<SysNav> list = navMapper.selectByExample(sysNavExample);
		for (SysNav nav : list) {
		//	if(navService.permissions(nav.getNavId(), user_id)){
				if(navService.hasNext(nav.getNavId())){
					sb.append("<li> \r\n");
					sb.append("<a href=\""+ctxPath+"/console/nav/trun/first?nav_id="+nav.getNavId()+"\">"+nav.getName()+"</a>\r\n");
					sb.append("</li> \r\n");
				}else{
					sb.append("<li> \r\n");
					sb.append("<a href=\""+ctxPath+nav.getUrl()+"\">"+nav.getName()+"</a>\r\n");
					sb.append("</li> \r\n");
				}
		//	}else{
		//		return "";
		//	}
		}
		return sb.toString();

	}

	/**
	 * 获取二级菜单
	 * @param sysNav
	 * @return
	 */
	public  String getSecoundNav(SysNav sysNav, String ctxPath){
		StringBuffer sb=new StringBuffer();
		sb.append("<li class=\"bg-palette2\">                                                       \r\n");
		sb.append("<a href=\""+ctxPath+sysNav.getUrl()+"\">                                                                    \r\n");
		sb.append("	<span class=\"menu-content block\">                                             \r\n");
		sb.append("		<span class=\"menu-icon\"><i class=\"block fa fa-desktop fa-lg\"></i></span>\r\n");
		sb.append("		<span class=\"text m-left-sm\">"+sysNav.getName()+"</span>                                     \r\n");
		sb.append("	</span>                                                                         \r\n");
		sb.append("	<span class=\"menu-content-hover block\">                                       \r\n");
		sb.append("		"+sysNav.getName()+"                                                                     \r\n");
		sb.append("	</span>                                                                         \r\n");
		sb.append("</a>                                                                             \r\n");
		sb.append("</li>                                                                             \r\n");
		return sb.toString();

	}
	/**
	 * 获取三级菜单
	 * @param sysNav
	 * @return
	 */
	public  String getThreeNav(SysNav sysNav, String ctxPath){
		StringBuffer sb=new StringBuffer();
		sb.append("<li class=\"openable bg-palette3\">                                                       \r\n");
		sb.append("<a href=\"#\">                                                                    \r\n");
		sb.append("	<span class=\"menu-content block\">                                             \r\n");
		sb.append("		<span class=\"menu-icon\"><i class=\"block fa fa-desktop fa-lg\"></i></span>\r\n");
		sb.append("		<span class=\"text m-left-sm\">"+sysNav.getName()+"</span>                                     \r\n");
		sb.append("<span class=\"submenu-icon\"></span>  \r\n");
		sb.append("	</span>                                                                         \r\n");
		sb.append("	<span class=\"menu-content-hover block\">                                       \r\n");
		sb.append("		"+sysNav.getName()+"                                                                     \r\n");
		sb.append("	</span>                                                                         \r\n");
		sb.append("</a>                                                                             \r\n");
		sb.append("<ul class=\"submenu\">\r\n");
		SysNavExample sys_nav_query=new SysNavExample();
		 sys_nav_query.createCriteria().andStatusEqualTo((short) 1).andPIdEqualTo(sysNav.getNavId());
		List<SysNav>listNav= navMapper.selectByExample(sys_nav_query);
		for (SysNav sysNav2 : listNav) {
			sb.append("<li><a href=\""+ctxPath+sysNav2.getUrl()+"\"><span class=\"submenu-label\">"+sysNav2.getName()+"</span></a></li>\r\n");
		}
		sb.append("</ul>     \r\n");
		sb.append("</li>                                                                             \r\n");
		return sb.toString();

	}
}
