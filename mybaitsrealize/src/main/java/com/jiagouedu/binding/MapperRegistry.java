package com.jiagouedu.binding;

import java.util.HashMap;
import java.util.Map;

/**
 * 映射文件注册中心
 *
 * @author cjw
 */
public class MapperRegistry {

    /**
     * 映射文件注册中心集合
     * <p>
     * key：mybatis.xml中的select id,
     * value：MapperMethod对象，封装了sql语句和返回值类型
     */
    private Map<String, MapperMethod> knowMappers = new HashMap<String, MapperMethod>();


    public void setKnowMappers(Map<String, MapperMethod> knowMappers) {
        this.knowMappers = knowMappers;
    }

    public Map<String, MapperMethod> getKnowMappers() {
        return knowMappers;
    }
}
