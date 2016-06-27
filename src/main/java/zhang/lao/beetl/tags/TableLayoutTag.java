package zhang.lao.beetl.tags;


import org.beetl.core.BodyContent;
import org.beetl.core.Resource;
import org.beetl.core.Tag;
import org.beetl.core.Template;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Map.Entry;

/**
 * <p>
 * title:定义layout标签，动态获取模板地址
 * </p>
 * <p>
 * description:
 * </p>
 * 
 * @author 2016 北京太阳花互动科技有限公司 All Rights Reserved.
 * @create zhangqin
 * @update
 * @version 1.0
 * @date 2016年3月18日
 */

@Service
@Scope("prototype")
public class TableLayoutTag extends Tag
{
	private String defaultLayoutName = "layoutContent";

	public String getDefaultLayoutName() {
		return defaultLayoutName;
	}

	public void setDefaultLayoutName(String defaultLayoutName) {
		this.defaultLayoutName = defaultLayoutName;
	}

	@Override
	public void render()
	{
		if (args.length == 0 || args.length > 3)
		{
			throw new RuntimeException("参数错误，期望child,map");
		}
		String layoutFile = getRelResourceId();
		if(layoutFile.indexOf("${table_skin}")!=-1){
			layoutFile=layoutFile.replace("${table_skin}", "skin_2");
		}
		Template t = this.gt.getTemplate(layoutFile, this.ctx.getResourceId());

		t.binding(ctx.globalVar);
		t.dynamic(ctx.objectKeys);

		if (args.length == 2)
		{
			Map<String, Object> map = (Map<String, Object>) args[1];
			for (Entry<String, Object> entry : map.entrySet())
			{
				t.binding(entry.getKey(), entry.getValue());
			}
		}

		BodyContent content = this.getBodyContent();
		if (args.length == 3)
		{

			t.binding((String) args[2], content);
		}
		else
		{
			t.binding(defaultLayoutName, content);
		}
		t.renderTo(ctx.byteWriter);

	}

	protected String getRelResourceId()
	{

		Resource sibling = ctx.getResource();
		return gt.getResourceLoader().getResourceId(sibling, (String) this.args[0]);

	}

}