package com.jiagouedu.factory;

import com.jiagouedu.implement.Executor;
import com.jiagouedu.implement.SimpleExecutor;
import com.jiagouedu.session.Configuration;
import com.jiagouedu.session.DefaultSqlSession;
import com.jiagouedu.session.SqlSession;

/**
 * session管理工厂默认实现
 *
 * @author cjw
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    /**
     * 初始化session方法
     *
     * @return
     */
    @Override
    public SqlSession openSession(Configuration configuration, Executor executor) {
        return new DefaultSqlSession(configuration, executor);
    }
}
