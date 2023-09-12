package com.llmcu.spring;

import com.llmcu.spring.bean.Student;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class SpringClient {
    public static void main(String[] args) {
        // 资源（类路径表示的资源）
        Resource resource = new ClassPathResource("applicationContext.xml");
        // 工厂
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        // bean定义读取器：将读到的资源给工厂
        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        // bean定义读取器：读取资源
        beanDefinitionReader.loadBeanDefinitions(resource);

        // 使用：工厂生产bean
        Student student = defaultListableBeanFactory.getBean("student", Student.class);

        System.out.println(student.getName());
        System.out.println(student.getAge());
    }
}
