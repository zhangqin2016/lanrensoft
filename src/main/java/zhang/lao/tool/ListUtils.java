package zhang.lao.tool;

import java.util.List;

/**
 * Created by tech6 on 2016/6/15.
 */
public class ListUtils {

    public static <T>T getFirst(List<T> list){

        return list==null||list.size()==0?null:  list.get(0);
    }
}
