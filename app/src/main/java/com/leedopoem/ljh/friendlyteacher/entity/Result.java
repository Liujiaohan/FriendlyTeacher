package com.leedopoem.ljh.friendlyteacher.entity;

import lombok.Data;

/**
 * Created by ljh on 17-10-2.
 */

@Data
public class Result {
    Message message;

    public Result(Message message) {
        this.message = message;
    }
}
