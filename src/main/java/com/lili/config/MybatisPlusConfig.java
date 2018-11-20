package com.lili.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 描述: Mybatis-Plus配置文件

 * @create 2018-04-08 下午7:22
 */
@Configuration
@MapperScan("com.lili.dao")
public class MybatisPlusConfig {
//    @Value("${mybatis-plus.typeAliasesPackage}")
//    private String typeAliasesPackage;
//
//    /**
//     * (配置这个 yml的配置不生效)
//     * @param dataSource
//     * @param resourceLoader
//     * @param globalConfiguration
//     * @return
//     * @throws Exception
//     */
//    @Bean("mybatisSqlSession")
//    public SqlSessionFactory sqlSessionFactory(DataSource dataSource, ResourceLoader resourceLoader, GlobalConfiguration globalConfiguration) throws Exception {
//        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
//        sqlSessionFactory.setDataSource(dataSource);
//        sqlSessionFactory.setTypeAliasesPackage(typeAliasesPackage);
//        MybatisConfiguration configuration = new MybatisConfiguration();
//        configuration.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
//        configuration.setJdbcTypeForNull(JdbcType.NULL);
//        sqlSessionFactory.setConfiguration(configuration);
//        sqlSessionFactory.setGlobalConfig(globalConfiguration);
//         return sqlSessionFactory.getObject();
//    }
//    @Bean
//    public GlobalConfiguration globalConfiguration() {
//        //逻辑删除  必须要配置sqlsessionfactory
//        GlobalConfiguration conf = new GlobalConfiguration(new LogicSqlInjector());
//        conf.setLogicDeleteValue("0");
//        conf.setLogicNotDeleteValue("1");
//        //0:"数据库ID自增", 1:"用户输入ID",2:"全局唯一ID (数字类型唯一ID)", 3:"全局唯一ID UUID";
//        conf.setIdType(3);
//        //字段策略 0:"忽略判断",1:"非 NULL 判断"),2:"非空判断"
//        conf.setFieldStrategy(2);
//        //驼峰下划线转换
//        conf.setDbColumnUnderline(true);
//        //mapper xml热更新
//        conf.setRefresh(true);
//        return conf;
//    }
}
