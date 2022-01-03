import com.bjsxt.LocalConfig;
import com.bjsxt.model.User;
import com.bjsxt.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//Dependency Injection
//Inverse of Control
public class UserServiceTest {

	@Test 
	public void testAdd() throws Exception {
        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(LocalConfig.class);

		UserService service = (UserService)ctx.getBean("userService");
        Assert.assertNotNull(service);
		service.add(new User());

		service.destroy();
	}

}
