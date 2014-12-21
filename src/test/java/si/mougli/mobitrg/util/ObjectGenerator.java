package si.mougli.mobitrg.util;

import si.mougli.mobitrg.business.users.entity.User;
import si.mougli.mobitrg.business.util.PasswordUtility;

public class ObjectGenerator
{

	public static final String USER_EMAIL = "michael.jordan@chicago-bulls.com";

	public static User createUser(String name, String lastname, boolean legalPerson)
	{
		User user = new User();
		user.setName(name);
		user.setLastname(lastname);
		user.setUsername(name + lastname);
		user.setActive(true);
		user.setContact(USER_EMAIL);
		user.setEmail(USER_EMAIL);
		user.setHash(PasswordUtility.generateRandomHash());
		user.setPassword("test123");

		if (legalPerson)
		{
			// TODO: add company
		}

		return user;
	}

}