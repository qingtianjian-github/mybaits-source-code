package com.jiagouedu.factory;

import com.jiagouedu.implement.Executor;
import com.jiagouedu.session.Configuration;
import com.jiagouedu.session.SqlSession;

/**
 * @author cjw
 * session管理工厂
 */
public interface SqlSessionFactory {

    /**
     * 初始化session方法
     *
     * @param configuration
     * @param executor
     * @return
     */
    SqlSession openSession(Configuration configuration, Executor executor);
}
