package auto.build;

import auto.model.Table;

import java.util.List;

/**
 * Created by tech6 on 2016/6/16.
 */
public interface BuildService {
    void build(List<Table> tables, String src);
}
