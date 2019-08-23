package com.study.mine.exception.assertion;

import com.study.mine.constant.IResponseEnum;
import com.study.mine.exception.ArgumentException;
import com.study.mine.base.BaseException;

import java.text.MessageFormat;

/**
 * Created by IntelliJ IDEA.
 * User: YiGui
 * Date: 2019/7/18
 */
public interface ArgumentExceptionAssert extends IResponseEnum, IAssert {
    @Override
    default BaseException newException(Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);

        return new ArgumentException(this, args, msg);
    }

    @Override
    default BaseException newException(Throwable t, Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);

        return new ArgumentException(this, args, msg, t);
    }
}
