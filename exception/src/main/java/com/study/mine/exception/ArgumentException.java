package com.study.mine.exception;

import com.study.mine.base.BaseException;
import com.study.mine.constant.IResponseEnum;

/**
 * Created by IntelliJ IDEA.
 * User: YiGui
 * Date: 2019/7/18
 */
public class ArgumentException extends BaseException {
    private static final long serialVersionUID = 1L;

    public ArgumentException(IResponseEnum responseEnum, Object[] args, String message) {
        super(responseEnum, args, message);
    }

    public ArgumentException(IResponseEnum responseEnum, Object[] args, String message, Throwable cause) {
        super(responseEnum, args, message, cause);
    }
}
