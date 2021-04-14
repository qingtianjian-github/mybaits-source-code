package com.jiagouedu.session;

import com.jiagouedu.binding.MapperMethod;

import java.sql.SQLException;

/**
 * 操作数据库方法接口
 *
 * @author cjw
 */
public interface SqlSession extends Cloneable {

    /**
     * selectOne方法
     *
     * @param mapperMethod
     * @param statement
     * @param <T>
     * @return
     */
    <T> T selectOne(MapperMethod mapperMethod, Object statement) throws Exception;

    /**
     * 获取mapper映射
     *
     * @param classType
     * @return
     */
    <T> T getMapper(Class<T> classType);
}
