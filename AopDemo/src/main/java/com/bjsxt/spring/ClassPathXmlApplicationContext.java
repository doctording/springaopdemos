package com.bjsxt.spring;


import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom2.*;
import org.jdom2.input.SAXBuilder;

/**
 * 实现 BeanFactory 的上下文对象
 */
public class ClassPathXmlApplicationContext implements BeanFactory {

    // id -> object
    private Map<String, Object> beans = new HashMap<String, Object>();

    //IOC Inverse of Control DI Dependency Injection
    public ClassPathXmlApplicationContext(String xml) throws Exception {
        System.setProperty("javax.xml.parsers.SAXParserFactory", "com.sun.org.apache.xerces.internal.jaxp.SAXParserFactoryImpl");

        SAXBuilder sb = new SAXBuilder();
        Document doc = sb.build(this.getClass().getClassLoader().getResourceAsStream(xml));
        Element root = doc.getRootElement();
        List list = root.getChildren("bean");

        for (int i = 0; i < list.size(); i++) {
            Element element = (Element) list.get(i);
            String id = element.getAttributeValue("id");
            String clazz = element.getAttributeValue("class");

            //
            Object o = Class.forName(clazz).newInstance();
            System.out.println(id + ":" + clazz);
            beans.put(id, o);
	       /*
	        <bean id="u" class="com.bjsxt.dao.impl.UserDAOImplMySQL" />
			<bean id="userService" class="com.bjsxt.service.UserService" >
				<property name="userDAO" bean="u"/>
			</bean>
	        */
            // 根据如上配置，设置依赖的bean，通过反射实现
            for (Element propertyElement : element.getChildren("property")) {
                String name = propertyElement.getAttributeValue("name");
                String bean = propertyElement.getAttributeValue("bean");

                Object beanObject = beans.get(bean);

                String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
                System.out.println("method name = " + methodName);

                Method m = o.getClass().getMethod(methodName, beanObject.getClass().getInterfaces()[0]);
                m.invoke(o, beanObject);
            }
        }
    }

    @Override
    public Object getBean(String id) {
        return beans.get(id);
    }

}
