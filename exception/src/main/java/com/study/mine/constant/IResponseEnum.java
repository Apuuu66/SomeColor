package com.study.mine.constant;

/**
 * Created by IntelliJ IDEA.
 * User: YiGui
 * Date: 2019/7/18
 * Time: 12:35
 */
public interface IResponseEnum {
    /**
     * 获取返回码
     * @return 返回码
     */
    int getCode();

    /**
     * 获取返回信息
     * @return 返回信息
     */
    String getMessage();
}
