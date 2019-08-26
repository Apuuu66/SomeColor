package com.study.mine.exception.assertion;

import com.study.mine.base.BaseException;

import java.util.Collection;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: YiGui
 * Date: 2019/7/17
 */
@SuppressWarnings("all")
public interface IAssert {
    /**
     * 创建异常
     */
    BaseException newException(Object... args);

    BaseException newException(Throwable t, Object... args);

    default void assertNotNull(Object obj) {
        if (obj == null) {
            throw newException();
        }
    }

    default void assertNotNull(Object obj, Object... args) {
        if (obj == null) {
            throw newException(args);
        }
    }

    default void assertNotEmpty(String str) {
        if (null == str || "".equals(str.trim())) {
            throw newException();
        }
    }

    default void assertNotEmpty(String str, Object... args) {
        if (str == null || "".equals(str.trim())) {
            throw newException(args);
        }
    }

    default void assertNotEmpty(Object[] arrays) {
        if (arrays == null || arrays.length == 0) {
            throw newException();
        }
    }

    default void assertNotEmpty(Object[] arrays, Object... args) {
        if (arrays == null || arrays.length == 0) {
            throw newException(args);
        }
    }

    default void assertNotEmpty(Collection<?> c) {
        if (c == null || c.isEmpty()) {
            throw newException();
        }
    }

    default void assertNotEmpty(Collection<?> c, Object... args) {
        if (c == null || c.isEmpty()) {
            throw newException(args);
        }
    }

    default void assertNotEmpty(Map<?, ?> map) {
        if (map == null || map.isEmpty()) {
            throw newException();
        }
    }

    default void assertNotEmpty(Map<?, ?> map, Object... args) {
        if (map == null || map.isEmpty()) {
            throw newException(args);
        }
    }

    default void assertIsFalse(boolean expression) {
        if (expression) {
            throw newException();
        }
    }

    default void assertIsFalse(boolean expression, Object... args) {
        if (expression) {
            throw newException(args);
        }
    }

    default void assertIsTrue(boolean expression) {
        if (!expression) {
            throw newException();
        }
    }

    default void assertIsTrue(boolean expression, Object... args) {
        if (!expression) {
            throw newException(args);
        }
    }

    default void assertIsNull(Object obj) {
        if (obj != null) {
            throw newException();
        }
    }

    default void assertIsNull(Object obj, Object... args) {
        if (obj != null) {
            throw newException(args);
        }
    }

    default void assertFail() {
        throw newException();
    }

    default void assertFail(Object... args) {
        throw newException(args);
    }

    default void assertFail(Throwable t) {
        throw newException(t);
    }


    default void assertFail(Throwable t, Object... args) {
        throw newException(t, args);
    }

    default void assertEquals(Object o1, Object o2) {
        if (o1 == o2) {
            return;
        }
        if (o1 == null) {
            throw newException();
        }
        if (!o1.equals(o2)) {
            throw newException();
        }
    }

    default void assertEquals(Object o1, Object o2, Object... args) {
        if (o1 == o2) {
            return;
        }
        if (o1 == null) {
            throw newException(args);
        }
        if (!o1.equals(o2)) {
            throw newException(args);
        }
    }
}
