package zhang.lao.beetl.func;

import org.beetl.core.Context;
import org.beetl.core.Function;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * title:产生随机图片
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
public class RandomImg implements Function
{
		@Override
		public Object call(Object[] paras, Context ctx) {
			 // Object o = paras[0];

                      try
                      {
						  String path = RandomImg.class.getResource("/").toURI().getPath();
                    	  	String imgFlode = new File(path).getParentFile().getParentFile().getCanonicalPath() + File.separator
                                  + "portal_1" + File.separator + "images"+ File.separator + "bg"+ File.separator; 
                    	  List<String> ls=	getAllFile(new File(imgFlode), "jpg");
                    	  if(ls.size()==0){
                    		  ctx.byteWriter.write("1.jpg".getBytes());
                    	  }else{
                    	 Long random= Math.round( Math.random() * (ls.size()-1));
                    	  ctx.byteWriter.write(ls.get(random.intValue()).getBytes());
                    	  }
                    	  }
                      catch (IOException e)
                      {
                              throw new RuntimeException(e);
                      } catch (URISyntaxException e) {
						  e.printStackTrace();
					  }
			return "";
		}
		public static List<String> getAllFile(File file, String type) {
			List<String> list = new ArrayList<String>();
			if (file.exists()) {
				if (file.isFile()) {
					return null;
				} else {
					recursionFiles(file, list, type);
				}
			}

			return list;

		}
		private static List<String> recursionFiles(File file, List<String> lf,
				String type) {
			File[] files = file.listFiles();
			for (File file2 : files) {
				if (file2.isFile()) {
					if (type.equals("")) {
						lf.add(file2.getName());
					} else {
						if (file2.getName().endsWith("." + type)) {
							lf.add(file2.getName());
						}
					}
				}
			/*	else {
					recursionFiles(file2, lf, type);
				}*/
			}
			return lf;

		}
}