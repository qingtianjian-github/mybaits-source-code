package com.jiagouedu.resultset;

import com.jiagouedu.binding.MapperMethod;

import java.sql.PreparedStatement;

/**
 * @author cjw
 */
public interface ResultSetHandler {

    /**
     * 处理结果集
     *
     * @param statement
     * @param mapperMethod
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T handler(PreparedStatement statement, MapperMethod mapperMethod) throws Exception;
}
