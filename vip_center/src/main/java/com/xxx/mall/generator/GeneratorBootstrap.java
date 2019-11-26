package com.xxx.mall.generator;


/**
 * @description：SSO单点登录代码生成
 * @author：liqiang
 * @date：2019-05-31 17:52
 * @warning：本内容仅限于杭州阿拉丁信息科技股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public class GeneratorBootstrap {

    public static final String JDBC_URL = "jdbc:mysql://192.168.112.31:3306/test?serverTimezone=Asia/Shanghai&autoReconnect=true&useSSL=false";
    public static final String USERNAME = "eCityArcTest";
    public static final String PASSWORD = "rickControl@test";

    public static void main(String[] args) {
        String packageName = "com.xxx.mall";
        String directoryName = "";

        GeneratorService generatorService = new GeneratorService(packageName, directoryName, JDBC_URL, USERNAME, PASSWORD);
        generatorService
                .outPutController(true)
                .outPutEntity(true)
                .outPutEntityKt(true)
                .outPutMapper(true)
                .outPutService(true)
                .outPutServiceImpl(true)
                .outPutXml(true)
                .outPutEntityQuery(true)
                .setFileOverride(true)
                .setBaseClassPackage("com.xxx.mall.base")
                .generateByTables("order");
    }
}
