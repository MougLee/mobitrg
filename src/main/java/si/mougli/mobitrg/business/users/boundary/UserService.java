package si.mougli.mobitrg.business.users.boundary;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import si.mougli.mobitrg.business.users.entity.User;

@Stateless
public class UserService
{
	@Inject
	private EntityManager em;

	public User save(User user)
	{
		return em.merge(user);
	}

	public User find(Long id)
	{
		return em.find(User.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<User> getAll()
	{
		Query query = em.createNamedQuery(User.USER_FIND_ALL);
		return query.getResultList();
	}

	// public boolean activate(Long id) {
	// em.
	// }
}