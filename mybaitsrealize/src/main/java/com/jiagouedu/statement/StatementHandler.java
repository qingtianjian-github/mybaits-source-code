package com.jiagouedu.statement;

import com.jiagouedu.binding.MapperMethod;
import com.jiagouedu.resultset.DefaultResultSetHandler;
import com.jiagouedu.resultset.ResultSetHandler;
import com.jiagouedu.session.Configuration;
import com.jiagouedu.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * 数据结果执行器
 *
 * @author cjw
 */
public class StatementHandler {

    private Configuration configuration;

    private ResultSetHandler resultSetHandler;

    public StatementHandler(Configuration configuration) {
        this.configuration = configuration;
        resultSetHandler = new DefaultResultSetHandler();
    }

    /**
     * 查询方法
     *
     * @param <T>
     * @return
     */
    public <T> T query(MapperMethod mapperMethod, Object statement) throws Exception {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(String.format(mapperMethod.getSql(), Integer.valueOf(statement.toString())));
        //执行sql语句
        preparedStatement.execute();
        //设置结果集
        return resultSetHandler.handler(preparedStatement, mapperMethod);
    }
}
