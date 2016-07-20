package com.lz.auto.build;

/**
 * Created by tech6 on 2016/6/29.
 */
public class BuildFactory {

    public FormBuild createForm() {
        return new FormBuild();
    }

    public ControllerBuild createController() {
        return new ControllerBuild();
    }

    public GridBuild createGrid() {
        return new GridBuild();
    }

    public BuildAutoTables createTables() {

        return new BuildAutoTables();
    }
}
