package com.xml;


import java.util.*;

import org.jdom2.*;
import org.jdom2.input.SAXBuilder;

public class XMLtest {

    public static void main(String[] args) throws Exception {

        SAXBuilder sb = new SAXBuilder();

        Document doc = sb.build(XMLtest.class.getClassLoader()
                .getResourceAsStream("beans.xml"));

        Element root = doc.getRootElement();
        List list = root.getChildren("bean");

        for (int i = 0; i < list.size(); i++) {
            Element element = (Element) list.get(i);
            String id = element.getAttributeValue("id");
            String clazz = element.getAttributeValue("class");
            System.out.println("id:" + id);
            System.out.println("class:" + clazz);
        }
    }

} 