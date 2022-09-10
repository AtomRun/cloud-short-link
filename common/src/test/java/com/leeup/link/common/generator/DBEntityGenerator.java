package com.leeup.link.common.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class DBEntityGenerator {

    public static void main(String[] args) {
        //1. 全局配置
        GlobalConfig config = new GlobalConfig();
        // 是否⽀持AR模式
        config.setActiveRecord(true)
                // 作者
                .setAuthor("cLee")
                // ⽣成路径，最好使⽤绝对路径，windows路径是不⼀样的
                .setOutputDir("C:\\Users\\li180\\Desktop\\demo\\src\\main\\java")
                // ⽂件覆盖
                .setFileOverride(true)
                // 主键策略
                .setIdType(IdType.AUTO)
                .setDateType(DateType.ONLY_DATE)
                // 设置⽣成的service接⼝的名字的⾸字⺟是否为I，默认Service是以I开头的
                .setServiceName("%sService")
                //实体类结尾名称
                .setEntityName("%sEntity")
                //⽣成基本的resultMap
                .setBaseResultMap(true)
                //不使⽤AR模式
                .setActiveRecord(false)
                //⽣成基本的SQL⽚段
                .setBaseColumnList(true);
        //2. 数据源配置
        DataSourceConfig dsConfig = new DataSourceConfig();
        // 设置数据库类型
        dsConfig.setDbType(DbType.MYSQL).setDriverName("com.mysql.cj.jdbc.Driver")
                .setUrl("jdbc:mysql://localhost:3306/short_link_account?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai")
                .setUsername("root")
                .setPassword("secret");
        //3. 策略配置globalConfiguration中
        StrategyConfig stConfig = new StrategyConfig();
        //全局⼤写命名
        stConfig.setCapitalMode(true)
                // 数据库表映射到实体的命名策略
                .setNaming(NamingStrategy.underline_to_camel)
                //使⽤lombok
                .setEntityLombokModel(true)
                //使⽤restController注解
                .setRestControllerStyle(true)
                // ⽣成的表, ⽀持多表⼀起⽣成，以数组形式填写
                .setInclude("account", "traffic", "traffic_task");
        //4. 包名策略配置
        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent("com.leeup.link")
                .setMapper("mapper")
                .setService("service")
                .setController("controller")
                .setEntity("model")
                .setXml("mapper");
        //5. 整合配置
        AutoGenerator ag = new AutoGenerator();
        ag.setGlobalConfig(config).setDataSource(dsConfig).setStrategy(stConfig).setPackageInfo(pkConfig);
        //6. 执⾏操作
        ag.execute();
        System.out.println("======= 代码⽣成完毕 ========");
    }
}
