package si.mougli.mobitrg.business.users.boundary;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import si.mougli.mobitrg.business.users.entity.Role;
import si.mougli.mobitrg.business.users.entity.User;
import si.mougli.mobitrg.business.util.Resources;

@RunWith(Arquillian.class)
public class UserServiceTest
{

	@Inject
	private UserService userService;

	@Deployment
	public static WebArchive createDeployment()
	{
		return ShrinkWrap.create(WebArchive.class).addClass(User.class).addClass(UserService.class)
				.addClass(Role.class).addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
				.addClass(Resources.class).addAsWebInfResource("test-ds.xml", "test-ds.xml")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	@Test
	public void testHello()
	{
		assertEquals("Hi!", userService.sayHello());
	}
}