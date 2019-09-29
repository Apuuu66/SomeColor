package com.guier.validator.controller;

import org.springframework.web.bind.annotation.RestController;
@RestController
public class UserController {



//    @PostMapping("/save/serial")
//    public Object save(@RequestBody UserVO userVO) {
//        String mobile = userVO.getMobile();
//
//        //手动逐个 参数校验~ 写法
//        if (StringUtils.isBlank(mobile)) {
//            return RspDTO.paramFail("mobile:手机号码不能为空");
//        } else if (!Pattern.matches("^[1][3,4,5,6,7,8,9][0-9]{9}$", mobile)) {
//            return RspDTO.paramFail("mobile:手机号码格式不对");
//        }
//
//        //抛出自定义异常等~写法
//        if (StringUtils.isBlank(userVO.getUsername())) {
//            throw new BizException(Constant.PARAM_FAIL_CODE, "用户名不能为空");
//        }
//
//        // 比如写一个map返回
//        if (StringUtils.isBlank(userVO.getSex())) {
//            Map<String, Object> result = new HashMap<>(5);
//            result.put("code", Constant.PARAM_FAIL_CODE);
//            result.put("msg", "性别不能为空");
//            return result;
//        }
//        //.........各种写法 ...
//        userService.save(userVO);
//        return RspDTO.success();
//    }
}
