package zhang.lao.service.console.skin;

/**
 * <p>
 * title:皮肤获取接口
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
public interface SkinNav {

	/**
	 * 获取皮肤html
	 * @param sys_id
	 * @return
	 */
	public String gethtml(String sys_id, String user_id, String ctxPath);
}
