package si.mougli.mobitrg.business.users.boundary;

import static org.junit.Assert.assertTrue;

import javax.json.Json;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class UsersResourceTest
{
    private static final String BASE_URL = "http://localhost:8080/blogapp/resources";
    private Client client;

    // TODO: da to dela je treba importat RESTEasy client dependency
    @Before
    public void initClient() throws Exception
    {
        client = ClientBuilder.newClient();
    }

    @Test
    @Ignore
    public void testCreate() throws Exception
    {
        WebTarget target = this.client.target(BASE_URL + "/users/create");
        target.request(MediaType.APPLICATION_JSON).get(Json.class);
        // User user = new User("mou6li@gmail.com", "Balantič", "Matic", "test123");
    }

    @Test
    @Ignore
    public void testGetAll() throws Exception
    {
        WebTarget target = this.client.target(BASE_URL + "/users/getall");
        Json content = target.request(MediaType.APPLICATION_JSON).get(Json.class);

        System.out.println(content);
        assertTrue(content != null);
    }
}