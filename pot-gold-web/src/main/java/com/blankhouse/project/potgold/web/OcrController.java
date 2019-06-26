package com.blankhouse.project.potgold.web;

import com.blankhouse.project.potgold.config.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hujia
 * @date 2019/6/26
 * @since 1.0.0
 */

@Api(value = "图片识别", description = "pdf识别，一期开发功能", position = 100, protocols = "http")
@RestController
@RequestMapping("ocr")
public class OcrController {

    @ApiOperation(value = "文件上传", notes = "")
    @RequestMapping(value = "/file", method = RequestMethod.POST)
    public BaseResult fileUpload() {
        return BaseResult.success();
    }
}
