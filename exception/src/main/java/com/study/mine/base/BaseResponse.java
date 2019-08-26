package com.study.mine.base;

import com.study.mine.constant.IResponseEnum;
import com.study.mine.constant.enums.CommonResponseEnum;
import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * User: YiGui
 * Date: 2019/7/18
 */
@Data
public class BaseResponse {
    /**
     * 返回码
     */
    protected int code;
    /**
     * 返回消息
     */
    protected String message;

    public BaseResponse() {
        // 默认创建成功的回应
        this(CommonResponseEnum.SUCCESS);
    }

    public BaseResponse(IResponseEnum responseEnum) {
        this(responseEnum.getCode(), responseEnum.getMessage());
    }

    public BaseResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
