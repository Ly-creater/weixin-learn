package com.test.postProcess;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

/**
 * @BelongsProject: weixin-learn
 * @BelongsPackage: com.test.postProcess
 * @Author: jkl
 * @CreateTime: 2021
 * @Description:
 */
public class TestBeanFactoryPostProcessor {



    /**
     * BeanDefinitionPostProcessor
     *
     * 执行时机:所有的bean定义信息将要被加载到容器中，Bean实例还没有被初始化。
     */
    class Test2BeanDefinitionPostProcessor implements BeanDefinitionRegistryPostProcessor {

        @Override
        public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {

        }

        @Override
        public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

        }
    }

    /**
     * BeanFactoryPostProcessor
     * 执行时间:所有的Bean定义信息已经加载到容器中，但是Bean实例还没有被初始化.
     */
    class Test1BeanFactoryPostProcessor implements BeanFactoryPostProcessor {

        @Override
        public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

        }
    }


    class Test3BeanPostProcessor implements BeanPostProcessor{
        @Override
        public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
            return null;
        }

        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
            return null;
        }
    }

    class Test4BeanDefinitionPostProcessor implements InstantiationAwareBeanPostProcessor {
        /**
         * 实例化之前
         */
        @Override
        public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
            return null;
        }
        /**
         * 实例化之后
         */
        @Override
        public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
            return false;
        }
        /**
         * 初始化之前
         */
        @Override
        public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
            return null;
        }
        /**
         * 初始化之后
         */
        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
            return null;
        }

    }
}
