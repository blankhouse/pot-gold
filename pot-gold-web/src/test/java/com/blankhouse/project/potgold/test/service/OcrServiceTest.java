package com.blankhouse.project.potgold.test.service;

import com.blankhouse.project.potgold.service.OcrService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

/**
 * @author hujia
 * @date 8/10/2019
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OcrServiceTest {
    @Autowired
    private OcrService ocrService;

    @Test
    public void testFile() throws Exception {
        ocrService.testHandle(new File("/Users/harlan/Downloads/PMBOK电子书--中英文版/手机适配版/01第一部分：第1章.pdf"), null);

        //Thread.sleep(20000);
    }

    @Test
    public void testId() throws Exception {
        ocrService.testHandle(new File(""), 8L);

        //Thread.sleep(20000);
    }
}
