package zhang.lao.build.auto.build;

import zhang.lao.build.auto.model.Table;

import java.util.List;

/**
 * Created by tech6 on 2016/6/16.
 */
public interface IBuild {
    void build(List<Table> tables, String src,boolean isReplace);
    void build(List<Table> tables, String src);
}
