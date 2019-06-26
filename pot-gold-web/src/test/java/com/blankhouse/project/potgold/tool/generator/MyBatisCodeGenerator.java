package com.blankhouse.project.potgold.tool.generator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 重要 ： 关于gnereator相关的本地改动尽量不要提交！！！
 *
 * 本类不用修改，运行就行
 * 具体配置，请修改 src/test/resources/mybatis-generator/MBG_configuration.xml
 */
public class MyBatisCodeGenerator {
    public static void main(String[] args) throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        String url = System.getProperty("user.dir")+"/pot-gold-web/src/test/resources/mybatis-generator" +
                "/MBG_configuration.xml";
        File configFile = new File(url);
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }
}
