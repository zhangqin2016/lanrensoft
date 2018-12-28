package zhang.lao.build.tool;

import java.util.List;

/**
 * Created by 张钦 on 2016/6/15.
 */
public class ListUtils {

    public static <T>T getFirst(List<T> list){

        return list==null||list.size()==0?null:  list.get(0);
    }
    /**
     * 判断是否为空
     * @param list
     * @return
     */
    public static <T>boolean isEmpty(List<T> list){

        return list==null||list.size()==0;
    }

    /**
     * 判断是否为空
     * @param list
     * @return
     */
    public static <T>boolean isNotEmpty(List<T> list){

        return !isEmpty(list);
    }
}
