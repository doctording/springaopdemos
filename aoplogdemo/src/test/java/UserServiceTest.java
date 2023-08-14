import com.aop.ProxyFactory;
import com.bjsxt.dao.UserDAO;
import com.bjsxt.dao.impl.UserDAOImplMySQL;
import com.bjsxt.dao.impl.UserDAOImplSqlServer;
import com.bjsxt.model.User;
import com.bjsxt.service.UserService;
import com.bjsxt.spring.BeanFactory;
import com.bjsxt.spring.ClassPathXmlApplicationContext;
import org.junit.Test;

public class UserServiceTest {

	@Test
	public void testSpring() throws Exception {
		User u = new User();
		u.setUsername("zhangsan");
		u.setPassword("123456");

		BeanFactory applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		UserService service = (UserService)applicationContext.getBean("userService");
		service.add(u);
	}

	@Test
	public void testSpring2() throws Exception {
		User u = new User();
		u.setUsername("zhangsan");
		u.setPassword("123456");

		BeanFactory applicationContext = new ClassPathXmlApplicationContext("beans2.xml");
		UserService service = (UserService)applicationContext.getBean("userService");
		service.add(u);
	}

	@Test
	public void test() {
		User u = new User();
		u.setUsername("zhangsan");
		u.setPassword("123456");

		UserDAO userDAOProxy = new UserDAOImplSqlServer();
		userDAOProxy.save(u);
		userDAOProxy.delete(u);
	}

	/**
	 * 动态代理放松，则是一劳永逸，无需修改dao的每个方法
	 */
	@Test
	public void testProxy() {
		User u = new User();
		u.setUsername("zhangsan");
		u.setPassword("123456");

		UserDAO userDAOProxy = ProxyFactory.getUserDaoLogProxy(new UserDAOImplMySQL());
		userDAOProxy.save(u);
		userDAOProxy.delete(u);
	}

	/**
	 * 组合方法，侵入了方法，每个dao方法都要自己加上LogInterceptor的方法，才能完成aop
	 * @throws Exception
	 */
	@Test
	public void testProxyZuhe() throws Exception {
		User u = new User();
		u.setUsername("zhangsan");
		u.setPassword("123456");

		BeanFactory applicationContext = new ClassPathXmlApplicationContext("beans_zuhe.xml");
		UserService service = (UserService)applicationContext.getBean("userService");
		service.add(u);
		service.delete(u);
	}

}
