package com.jiagouedu.session;

import com.jiagouedu.binding.MapperMethod;
import com.jiagouedu.binding.MapperRegistry;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 配置类，封装resource资源文件下面的xml配置：读取xml文件加载到内存中
 *
 * @author cjw
 */
public class Configuration {

    /**
     * 输入流
     */
    private InputStream inputStream;

    /**
     * 映射文件注册中心
     */
    private MapperRegistry mapperRegistry = new MapperRegistry();

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public MapperRegistry getMapperRegistry() {
        return mapperRegistry;
    }

    /**
     * 通过dom4j读取mapper.xml中的信息
     *
     * @return
     */
    public void loadConfigurations() throws DocumentException, IOException {
        try {
            Document document = new SAXReader().read(inputStream);
            Element root = document.getRootElement();
            List<Element> elements = root.element("mappers").elements("mapper");
            for (Element mapper : elements) {
                if (mapper.attribute("resource") != null) {
                    mapperRegistry.setKnowMappers(loadXmlConfiguration(mapper.attribute("resource").getText()));
                }
                if (mapper.attribute("class") != null) {
                }
            }
        } catch (Exception e) {
            System.out.println("读取配置文件错误");
        } finally {
            inputStream.close();
        }
    }

    /**
     * 通过dom4j读取Mapper.xml中的信息
     *
     * @param resource
     * @return
     */
    private Map<String, MapperMethod> loadXmlConfiguration(String resource) throws DocumentException, ClassNotFoundException, IOException {
        Map<String, MapperMethod> map = new HashMap<>();
        InputStream is = null;
        try {
            is = this.getClass().getClassLoader().getResourceAsStream(resource);
            Document document = new SAXReader().read(is);
            Element root = document.getRootElement();
            if (root.getName().equalsIgnoreCase("mapper")) {
                String namespace = root.attribute("namespace").getText();
                for (Element select : (List<Element>) root.elements("select")) {
                    MapperMethod mapperMethod = new MapperMethod();
                    mapperMethod.setSql(select.getText().trim());
                    mapperMethod.setType(Class.forName(select.attribute("resultType").getText()));
                    //实用类+方法id作为key
                    map.put(namespace + "." + select.attribute("id").getText(), mapperMethod);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            is.close();
        }
        return map;
    }
}
