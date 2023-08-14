package com.bjsxt;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author mubi
 * @Date 2021/10/25 20:11
 */
@EnableAspectJAutoProxy
@Configuration
@ComponentScan("com.bjsxt")
public class LocalConfig {
}
