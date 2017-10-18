package com.leedopoem.ljh.friendlyteacher.data.entity;

import lombok.Data;

/**
 * Created by ljh on 17-10-2.
 */

@Data
public class Result {
    private Message message;

    public Result(Message message) {
        this.message = message;
    }
}
