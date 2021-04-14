package com.jiagouedu.binding;

/**
 * 映射方法：封装mapper.xml（UserMapper.xml）中的方法sql和返回值resultType加载到类中
 * <p>
 * <select id="selectByPrimaryKey" resultType="BaseResultMap"></select>
 *
 * @author cjw
 */
public class MapperMethod {

    public MapperMethod() {
    }

    public MapperMethod(String sql, Class<?> type) {
        this.sql = sql;
        this.type = type;
    }

    /**
     * sql语句
     */
    private String sql;

    /**
     * 返参类型
     */
    private Class<?> type;


    public void setSql(String sql) {
        this.sql = sql;
    }

    public void setType(Class<?> type) {
        this.type = type;
    }

    public String getSql() {
        return sql;
    }

    public Class<?> getType() {
        return type;
    }
}
