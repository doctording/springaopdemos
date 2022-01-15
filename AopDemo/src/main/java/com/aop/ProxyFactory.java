package com.aop;

import com.bjsxt.dao.UserDAO;

import java.lang.reflect.Proxy;

/**
 * @Author mubi
 * @Date 2021/10/24 14:29
 */
public class ProxyFactory {

    public static UserDAO getUserDaoLogProxy(UserDAO userDAO) {
        LogInterceptorProxyHandler logProxy = new LogInterceptorProxyHandler();
        logProxy.setTarget(userDAO);

        UserDAO userDAOProxy =
                (UserDAO) Proxy.newProxyInstance(userDAO.getClass().getClassLoader(),
                        new Class[]{UserDAO.class}, logProxy);
        return userDAOProxy;
    }

}
