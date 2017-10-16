package com.leedopoem.ljh.friendlyteacher.entity;

import lombok.Data;

/**
 * Created by ljh on 17-10-2.
 */

@Data
public class Message {
    String result;

    public Message(String result) {
        this.result = result;
    }
}
