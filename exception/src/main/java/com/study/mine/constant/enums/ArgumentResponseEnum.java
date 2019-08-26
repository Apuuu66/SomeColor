package com.study.mine.constant.enums;

import com.study.mine.exception.assertion.CommonExceptionAssert;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by IntelliJ IDEA.
 * User: YiGui
 * Date: 2019/7/18
 */
@Getter
@AllArgsConstructor
public enum ArgumentResponseEnum implements CommonExceptionAssert {
    /**
     * 绑定参数校验异常
     */
    VALID_ERROR(6000, "参数校验异常"),
    ;

    /**
     * 返回码
     */
    private int code;
    /**
     * 返回消息
     */
    private String message;
}
