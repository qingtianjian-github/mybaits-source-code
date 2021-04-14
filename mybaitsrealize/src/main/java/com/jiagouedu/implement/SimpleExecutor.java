package com.jiagouedu.implement;

import com.jiagouedu.binding.MapperMethod;
import com.jiagouedu.session.Configuration;
import com.jiagouedu.statement.StatementHandler;

/**
 * @author cjw
 * 基本执行器实现
 */
public class SimpleExecutor implements Executor {

    private Configuration configuration;

    public SimpleExecutor(Configuration configuration) {
        this.configuration = configuration;
    }


    /**
     * 查询数据
     *
     * @param mapperMethod
     * @param statement
     * @param <T>
     * @return
     */
    @Override
    public <T> T query(MapperMethod mapperMethod, Object statement) throws Exception {
        System.out.println("SimpleExecutor query invoke...");
        //正常是使用Configuration创建StatementHandler对象
        StatementHandler statementHandler = new StatementHandler(configuration);
        return statementHandler.query(mapperMethod, statement);
    }
}
