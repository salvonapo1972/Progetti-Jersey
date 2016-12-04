package it.test.rest.hello;

import javax.json.JsonException;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.simple.JSONObject;


/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/myresource")
public class MyResource {

	 @GET
	    @Produces("application/json")
	    public Response defaultReverser() throws JsonException {
	 
	        StringBuilder sb = new StringBuilder();
	        sb.append("ANKARA");
	 
	        JSONObject jsonObject = new JSONObject();
	        jsonObject.put("original", sb.toString());
	        jsonObject.put("reversed", sb.reverse().toString());
	 
	        String result = "" + jsonObject;
	        return Response.status(200).entity(result).build();
	    }
	 
	    @Path("{word}")
	    @GET
	    @Produces("application/json")
	    public Response reverser(@PathParam("word") String word) throws JsonException {
	 
	        StringBuilder sb = new StringBuilder();
	        sb.append(word);
	 
	        JSONObject jsonObject = new JSONObject();
	        jsonObject.put("original", sb.toString());
	        jsonObject.put("reversed", sb.reverse().toString());
	 
	        String result = "" + jsonObject;
	        return Response.status(200).entity(result).build();
	    }
}
