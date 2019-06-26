# pot-gold  第一桶金


####项目启动
1. 执行sql脚本：SQL_Scripts/init.sql
2. 测试数据库连接：UserMapperTest
3. 项目启动类：GoldWebApplication.java

####项目目标
- pdf上传，根据条件进行文字识别然后返回匹配的章节、段落

####已有功能介绍
- swagger：http://localhost:8080/swagger-ui.html
    1. (避坑)实体类中，Integer/Long类型的属性加@ApiModelProperty时，必须要给example参数赋值，且值必须为数字类型。

####TODO
- 图片上传
- 部署脚本

