package com.blankhouse.project.potgold.config;

import com.blankhouse.project.potgold.common.bean.BizException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(BizException.class)
    @ResponseBody
    public BaseResult handleError1(BizException e) {
        e.printStackTrace();
        return BaseResult.failWithCodeAndMsg(409, e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public BaseResult handleError2(Exception e) {
        e.printStackTrace();
        return BaseResult.failWithCodeAndMsg(500, "全局异常");
    }
}
