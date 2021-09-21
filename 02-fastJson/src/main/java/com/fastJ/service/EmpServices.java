package com.fastJ.service;

import com.fastJ.dao.EmpDao;
import com.fastJ.vo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @BelongsProject: weixin-learn
 * @BelongsPackage: com.fastJ.service
 * @Author: jkl
 * @CreateTime: 2021
 * @Description:
 */
@Service
//public class EmpServices implements BeanPostProcessor {
public class EmpServices  {
    @Autowired
    private EmpDao empDao;

    public Emp findEmpById(int id){
        return empDao.findEmpById(id)
                .orElse(
                        new Emp(id+"","the userId is not exist")
                );
    }

    public List<Emp> allEmp(){
        return empDao.allEmp();
    }


    public void saveEmp(Emp emp){
         empDao.saveEmp(emp);
    }



    @Async()
    public void  testAsync(){
        try {
            Thread.sleep(20000);
            System.out.println("threadName:"+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public void test(){
        System.out.println("test cglib");
    }

    //@Override
    //public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    //
    //    /**
    //     * jdk动态代理
    //     */
    //    Object proxyInstance = Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
    //        @Override
    //        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    //            return null;
    //        }
    //    });
    //
    //    return proxyInstance;
    //}

    public static void main(String[] args) {
        EmpServices proxy =(EmpServices) getCglibProxy(EmpServices.class);
        proxy.test();
        System.out.println("================================");
        JdkService jdkProxy = (JdkService)getJdkProxy(JdkServiceImpl.class);
        jdkProxy.sayJdk();
        new ArrayList(Collections.singleton(new int[3]));
    }

    public static Object getCglibProxy(Class clazz){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object target, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("cglib代理前------");
                Object proxy = methodProxy.invokeSuper(target, objects);
                System.out.println("cglib代理后------");
                return proxy;
            }
        });
        return enhancer.create();
    }

    public static Object getJdkProxy(Class target){
        return Proxy.newProxyInstance(target.getClassLoader(), target.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("jdk 代理前----");
                Object proxy1 = method.invoke(target.newInstance(), args);
                System.out.println("jdk 代理后----");
                return proxy1;
            }
        });
    }

}
