package zhang.lao.build.tool;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by zhangqin on 2017/2/14.
 */
public class MapTool {
    public static double getdistance(double pointa_lat,double pointa_lon,double pointb_lat,double pointb_lon)
    {
        double distance;
        double pi=Math.PI;
        double wj_a = Math.sin(pointa_lat * pi/ 180) * Math.sin(pointb_lat * pi/ 180);
        double wj_b = Math.cos(pointa_lat * pi/ 180) * Math.cos(pointb_lat * pi / 180) * Math.cos((pointb_lon - pointa_lon) * pi/ 180);
        if((wj_a + wj_b) <= 1 )
            distance = 6371004 *Math.acos(wj_a + wj_b) / 1000;
        else
            distance=0;
        return distance;

    }
    /**
     * 过滤坐标点
     * @param list
     * @param lng
     * @param lat
     * @return
     */
    public static JSONArray filterPoint(JSONArray list, String lng, String lat){
        JSONArray list1 = new JSONArray();
        for (int i = 0; i < list.size()-1;) {
            list1.add( list.get(i));
            int t = 0;
            for (int j=i+1;j<list.size(); j++){

                JSONObject s = (JSONObject) list.get(i);
                JSONObject e = (JSONObject) list.get(j);
                Double d =  getdistance(s.getDouble(lat),s.getDouble(lng),e.getDouble(lat),e.getDouble(lng));
                if(d*1000>300){
                    System.out.println(d*1000+"---------------------");
                    if(t>2){
                        i=j;
                        break;
                    }
                    t++;
                    continue;
                }else{
                    list1.add(e);
                   i=j+1;
                    break;
                }
            }
        }
        return list1;
    }
    /**
     * 过滤坐标点
     * @param list
     * @param lng
     * @param lat
     * @return
     */
    public static List<JSONObject> filterPoint(List<JSONObject> list, String lng, String lat){
        List<JSONObject> list1 = Lists.newArrayList();
        for (int i = 0; i < list.size()-1; i++) {
            list1.add(list.get(i));
            for (int j=i+1;j<list.size();i++){
                JSONObject s = list.get(i);
                JSONObject e = list.get(j);
               Double d =  getdistance(s.getDouble(lat),s.getDouble(lng),e.getDouble(lat),e.getDouble(lng));
               if(d>50){
                   continue;
               }else{
                   list1.add(list.get(j));
               }
            }
        }
        return list1;
    }
}
