package com.jiagouedu.binding;

import com.jiagouedu.session.DefaultSqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * mapper代理类
 *
 * @param <T>
 */
public class MapperProxy<T> implements InvocationHandler {

    /**
     * defaultSqlSession对象
     */
    private final DefaultSqlSession sqlSession;

    /**
     * mapper接口
     */
    private final Class<T> mapperInterface;

    public MapperProxy(DefaultSqlSession sqlSession, Class<T> mapperInterface) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }


    /**
     * 方法实现
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //通过Configuration配置累获取MapperRegistry注册中心，根据注册中心再获取到mapper文件映射map
        MapperMethod mapperMethod = sqlSession.getConfiguration().getMapperRegistry().getKnowMappers()
                .get(method.getDeclaringClass().getName() + "." + method.getName());
        if (mapperMethod != null) {
            //调用selectOne查询方法
            return sqlSession.selectOne(mapperMethod, String.valueOf(args[0]));
        }
        return method.invoke(proxy, args);
    }
}
