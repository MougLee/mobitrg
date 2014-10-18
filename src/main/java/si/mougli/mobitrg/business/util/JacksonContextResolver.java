package si.mougli.mobitrg.business.util;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

@Provider
@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class JacksonContextResolver implements ContextResolver<ObjectMapper>
{
	private ObjectMapper objectMapper;

	public JacksonContextResolver() throws Exception
	{
		this.objectMapper = new ObjectMapper();
		this.objectMapper.registerModule(new Hibernate4Module());
		this.objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
	}

	@Override
	public ObjectMapper getContext(Class<?> objectType)
	{
		return objectMapper;
	}
}