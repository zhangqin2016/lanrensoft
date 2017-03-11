package com.lz.auto;

import com.lz.auto.build.BuildFactory;
import com.lz.auto.model.Table;
import com.lz.auto.utils.GetTable;
import com.lz.kit.LogKit;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by tech6 on 2016/6/29.
 */
public class Main {

    public static void main(String[] args) throws SQLException {
        LogKit.info("开始生成");
        String src = "d:/autolaozhang/";
        LogKit.info("生成位置:"+src);
        BuildFactory buildFactory = new BuildFactory();
        List<Table> listTable = GetTable.tables();
        buildFactory.createController().build(listTable, src + "controler/");
        buildFactory.createForm().build(listTable, src + "html/");
        buildFactory.createGrid().build(listTable, src + "html/");
        buildFactory.createDao().build(listTable, src + "dao/");
        buildFactory.createDaoXml().build(listTable, src + "daoXml/");
        buildFactory.createService().build(listTable, src + "servie/");
        LogKit.info("生成成功");
    }
}
