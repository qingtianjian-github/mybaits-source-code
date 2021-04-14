package com.jiagouedu.factory;

import com.jiagouedu.session.Configuration;
import org.dom4j.DocumentException;

import java.io.IOException;

/**
 * sqlSessionFactory构建工厂
 *
 * @author cjw
 */
public class SqlSessionFactoryBuilder {

    /**
     * 读取properties.xml和resource.xml配置文件,构建MapperMethod和MapperRegistry对象
     * 返回默认sql工厂对象
     *
     * @param configuration
     * @return
     * @throws IOException
     * @throws DocumentException
     */
    public SqlSessionFactory build(Configuration configuration) throws IOException, DocumentException {
        configuration.loadConfigurations();
        return new DefaultSqlSessionFactory();
    }
}
