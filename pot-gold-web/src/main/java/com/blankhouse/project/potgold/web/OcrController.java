package com.blankhouse.project.potgold.web;

import com.blankhouse.project.potgold.config.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author hujia
 * @date 2019/6/26
 * @since 1.0.0
 */

@Api(value = "图片识别", description = "pdf识别，一期开发功能", position = 100, protocols = "http")
@RestController
@RequestMapping("ocr")
public class OcrController {


    private static String UPLOADED_FOLDER = "E://temp//";


    @ApiOperation(value = "文件上传", notes = "")
    @PostMapping("/upload")
    public BaseResult singleFileUpload(@RequestParam("file") MultipartFile file) throws Exception{
        if (file.isEmpty()) {
            return BaseResult.failWithCodeAndMsg(500, "Please select a file to upload");
        }

        // Get the file and save it somewhere
        byte[] bytes = file.getBytes();
        Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
        Files.write(path, bytes);
        return BaseResult.successWithData(file.getOriginalFilename());

    }

}
