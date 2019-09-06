# pot-gold  第一桶金


#### 项目启动
1. 执行sql脚本：SQL_Scripts/init.sql
2. 测试数据库连接(mysql8.0版本,5.7也可以)：UserMapperTest ,目前默认连接阿里云,可自行配置连本地库
3. 项目启动类：GoldWebApplication.java

#### 项目目标
- pdf上传，根据条件进行文字识别然后返回匹配的章节、段落

#### 已有功能介绍
- swagger：http://localhost:8080/swagger-ui.html
    1. (避坑)实体类中，Integer/Long类型的属性加@ApiModelProperty时，必须要给example参数赋值，且值必须为数字类型。
- mybatis-generator:MyBatisCodeGenerator
- profile环境配置分离说明: 默认是aliyun环境(数据库连阿里云) 开发者可以自建环境目录,类比hujia-local, 暂未设置prod环境

#### TODO
- 图片上传
- 部署脚本


#### 最佳实践
1. git pull --no-ff  =  git fetch + git merge --no-ff ,可以很好保存merge历史

#### maven 打包命令 
- clean package -D skipTests=true -Paliyun



