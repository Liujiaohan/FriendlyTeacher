package com.leedopoem.ljh.friendlyteacher.data.entity;

import lombok.Data;

/**
 * Created by ljh on 17-10-2.
 */

@Data
public class Message {
    private String result;
    private String lid;
    public Message(String result,String lid) {
        this.result = result;
        this.lid=lid;
    }
}
