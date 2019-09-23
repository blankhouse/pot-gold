package com.blankhouse.project.potgold.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
	//成员变量
		private Object target;//被代理的对象
		//使用有参数的构造方法设置代理对象 
		public ProxyFactory(Object target){
			this.target = target;
		}
		public Object getProxyObject(){
			return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
				public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
					System.out.println("开始代理"); //增强实现
					System.out.println("代理对象的hashCode值"+proxy.hashCode());
					Object result = method.invoke(target, args);
					System.out.println("代理结束"); //增强实现
					return result;
				}
			});
		}
}
