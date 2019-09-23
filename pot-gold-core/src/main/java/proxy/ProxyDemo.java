package proxy;


public class ProxyDemo {

	public static void main(String[] args) {
		UserServiceImpl serviceImpl = new UserServiceImpl();
		ProxyFactory factory=new ProxyFactory(serviceImpl);
		UserService user = (UserService)factory.getProxyObject();
		System.out.println("原来对象的hashCode值"+serviceImpl.hashCode());
		user.print();
	}

}
