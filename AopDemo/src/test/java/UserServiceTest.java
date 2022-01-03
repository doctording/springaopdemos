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
		u.setPassword("zhangsan");

		BeanFactory applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		UserService service = (UserService)applicationContext.getBean("userService");
		service.add(u);
	}

	@Test
	public void test() {
		User u = new User();
		u.setUsername("zhangsan");
		u.setPassword("zhangsan");

		UserDAO userDAOProxy = new UserDAOImplSqlServer();
		userDAOProxy.save(u);
		userDAOProxy.delete(u);
	}

	@Test
	public void testProxyJDK() {
		User u = new User();
		u.setUsername("zhangsan");
		u.setPassword("zhangsan");

		UserDAO userDAOProxy = ProxyFactory.getUserDaoLogProxy(new UserDAOImplMySQL());
		userDAOProxy.save(u);
		userDAOProxy.delete(u);
	}

}
