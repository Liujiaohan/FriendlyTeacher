package com.leedopoem.ljh.friendlyteacher.data.entity;

/**
 * Created by ljh on 17-10-30.
 */

public class LeaveWord {
    private String content;
    private String data;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public LeaveWord(String content, String data) {
        this.content = content;
        this.data = data;
    }
}
