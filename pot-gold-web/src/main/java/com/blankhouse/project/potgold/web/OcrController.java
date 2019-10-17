package com.blankhouse.project.potgold.web;

import com.blankhouse.project.potgold.config.BaseResult;
import com.blankhouse.project.potgold.service.OcrService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author hujia
 * @date 2019/6/26
 * @since 1.0.0
 */

@Api(value = "图片识别", description = "pdf识别，一期开发功能", position = 100, protocols = "http")
@RestController
@RequestMapping("ocr")
public class OcrController {


    private final static String OCR_PATH = "/data1/ocr";

    @Autowired
    private OcrService ocrService;


    @ApiOperation(value = "继续", notes = "")
    @PutMapping("/continue/{id}")
    public BaseResult continueTask(@PathVariable("id") Long taskId) throws Exception {

        ocrService.handle(null, taskId);
        return BaseResult.success();
    }


    @ApiOperation(value = "文件上传", notes = "")
    @PostMapping("/upload")
    public BaseResult singleFileUpload(@RequestParam("file") MultipartFile file) throws Exception{
        if (file.isEmpty()) {
            return BaseResult.failWithCodeAndMsg(500, "Please select a file to upload");
        }

        File x = ocrService.handle(file, null);

        return BaseResult.successWithData(file.getOriginalFilename());

    }

    @ApiOperation(value = "脚本导出接口", notes = "")
    @GetMapping("/bash/{id}")
    public void getBash(@PathVariable("id") Long taskId, HttpServletResponse res) throws Exception {

        InputStream inputStream = null;
        OutputStream os = null;
        try {
            os = res.getOutputStream();
            File file = ocrService.downLoad(taskId);
            inputStream = new FileInputStream(file);
            res.setHeader("content-type", "application/octet-stream");
            res.setHeader("Content-disposition", "attachment;filename=result.zip");
            res.setContentType("application/octet-stream");
            IOUtils.copy(inputStream, os);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
    }

}
