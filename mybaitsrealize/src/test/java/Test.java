import com.jiagouedu.factory.SqlSessionFactory;
import com.jiagouedu.factory.SqlSessionFactoryBuilder;
import com.jiagouedu.implement.SimpleExecutor;
import com.jiagouedu.mapper.UserMapper;
import com.jiagouedu.po.UserPo;
import com.jiagouedu.session.Configuration;
import com.jiagouedu.session.SqlSession;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.io.InputStream;

public class Test {

    /**
     * 测试mybatis源码
     *
     * @param args
     */
    public static void main(String[] args) throws IOException, DocumentException {
        //读取配置文件
        InputStream inputStream = Test.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
        //实例化配置类
        Configuration configuration = new Configuration();
        configuration.setInputStream(inputStream);
        //创建sqlSessionFactory管理工厂，并读取，解析xml文件，创建mapper注册中心
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        //创建执行器，里面配置一级缓存
        SimpleExecutor executor = new SimpleExecutor(configuration);
        //通过sqlSessionFactory管理工厂获取SqlSession而对象
        SqlSession sqlSession = sqlSessionFactory.openSession(configuration, executor);
        //使用动态代理：代理SqlSession实现类DefaultSqlSession类中的方法，并告诉代理类代理的类的class对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //动态代理找到根据类的class对象和方法名作为keu在MapperRegistry注册中心中找到要执行的sql和返回值
        //通过调用执行器executor.query()方法执行sql语句，返回数据
        UserPo user = userMapper.getUser(1);
        System.out.println(user);
    }
}
