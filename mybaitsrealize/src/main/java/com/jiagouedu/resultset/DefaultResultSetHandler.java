package com.jiagouedu.resultset;

import com.jiagouedu.binding.MapperMethod;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 结果集设置
 *
 * @author cjw
 */
public class DefaultResultSetHandler implements ResultSetHandler {

    /**
     * 处理结果集
     *
     * @param statement
     * @param mapperMethod
     * @param <T>
     * @return
     * @throws Exception
     */
    @Override
    public <T> T handler(PreparedStatement statement, MapperMethod mapperMethod) throws Exception {
        System.out.println("ResultSetHandler handler invoke...");
        //结果集类型
        Object resultObject = new DefaultObjectFactory().create(mapperMethod.getType());
        //结果集
        ResultSet rs = statement.getResultSet();
        if (rs.next()) {
            int i = 0;
            for (Field field : resultObject.getClass().getDeclaredFields()) {
                setValue(resultObject, field, rs, i);
            }
        }
        return (T) resultObject;
    }

    /**
     * 设置值
     *
     * @param resultObject
     * @param field
     * @param rs
     * @param i
     */
    private void setValue(Object resultObject, Field field, ResultSet rs, int i) throws Exception {
        Method setMethod = resultObject.getClass().getMethod("set" + upperCapital(field.getName()), field.getType());
        setMethod.invoke(resultObject, getResult(field, rs));
    }

    /**
     * 获取结果集
     *
     * @param field
     * @param rs
     * @return
     */
    private Object getResult(Field field, ResultSet rs) throws SQLException {
        Class<?> type = field.getType();
        //匹配数据类型
        if (Integer.class == type) {
            return rs.getInt(field.getName());
        }
        if (String.class == type) {
            return rs.getString(field.getName());
        }
        if (Long.class == type) {
            return rs.getLong(field.getName());
        }
        return rs.getString(field.getName());
    }

    /**
     * 将数据库字段改为驼峰式命名
     *
     * @param name
     * @return
     */
    private String upperCapital(String name) {
        String first = name.substring(0, 1);
        String tail = name.substring(1);
        return first.toUpperCase() + tail;
    }
}
