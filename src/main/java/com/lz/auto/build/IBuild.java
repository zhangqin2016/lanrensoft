package com.lz.auto.build;

import com.lz.auto.model.Table;

import java.util.List;

/**
 * Created by tech6 on 2016/6/16.
 */
public interface IBuild {
    void build(List<Table> tables, String src);
}
