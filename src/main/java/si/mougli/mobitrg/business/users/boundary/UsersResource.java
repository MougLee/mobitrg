package si.mougli.mobitrg.business.users.boundary;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import si.mougli.mobitrg.business.users.entity.User;

@Path("users")
public class UsersResource
{
	@Inject
	UserService userService;

	@GET
	@Path("getall")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAll()
	{
		return userService.getAll();
	}

	@GET
	@Path("get/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getById(@PathParam("id") Long id)
	{
		return userService.find(id);
	}

	@POST
	@Path("register")
	@Produces(MediaType.APPLICATION_JSON)
	public void registerUser(User user)
	{
		userService.save(user);
	}
}