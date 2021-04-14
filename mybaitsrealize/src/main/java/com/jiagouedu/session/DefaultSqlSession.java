package com.jiagouedu.session;


import com.jiagouedu.binding.MapperMethod;
import com.jiagouedu.binding.MapperProxy;
import com.jiagouedu.implement.Executor;

import java.lang.reflect.Proxy;
import java.sql.SQLException;

/**
 * 操作数据库方法接口实现类
 *
 * @author cjw
 */
public class DefaultSqlSession implements SqlSession {

    /**
     * 资源文件配置类对象
     */
    private Configuration configuration;

    /**
     * 执行器对象
     */
    private Executor executor;

    /**
     * 构造函数,为configuration和executor赋值
     *
     * @param configuration
     * @param executor
     */
    public DefaultSqlSession(Configuration configuration, Executor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    /**
     * selectOne方法
     *
     * @param statement
     * @param <T>
     * @return
     */
    @Override
    public <T> T selectOne(MapperMethod mapperMethod, Object statement) throws Exception {
        System.out.println("DefaultSqlSession selectOne invoke...");
        return executor.query(mapperMethod,statement);
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    /**
     * 获取映射实体,调用代理类
     *
     * @param classType
     * @return
     */
    @Override
    public <T> T getMapper(Class<T> classType) {
        return (T) Proxy.newProxyInstance(classType.getClassLoader(), new Class[]{classType}, new MapperProxy<>(this, classType));
    }

    public Executor getExecutor() {
        return executor;
    }
}
