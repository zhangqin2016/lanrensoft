package com.baidu.ueditor;

import com.baidu.ueditor.define.State;

import java.io.File;

/**
 * Created by - on 2016/11/15.
 */
public class YhyUeEdit {

    State state;
    File file;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public YhyUeEdit(State state, File file) {
        this.state = state;
        this.file = file;
    }

    public YhyUeEdit(State state) {
        this.state = state;
    }

    public YhyUeEdit() {
    }
}
