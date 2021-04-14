package com.jiagouedu.implement;

import com.jiagouedu.binding.MapperMethod;

import java.sql.SQLException;

/**
 * 操作数据库执行器
 *
 * @author cjw
 */
public interface Executor {

    /**
     * 查询方法
     *
     * @param mapperMethod
     * @param statement
     * @param <T>
     * @return
     */
    <T> T query(MapperMethod mapperMethod, Object statement) throws SQLException, Exception;
}
