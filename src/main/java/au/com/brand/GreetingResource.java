package au.com.brand;

import io.smallrye.common.annotation.NonBlocking;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @NonBlocking
    public String hello() {
        return "Hello Coles";
    }
    
    @GET
    @Path("{name}")
    @Produces(MediaType.TEXT_PLAIN)
    @NonBlocking
    public String helloNamed(@PathParam("name") String name) {
        return "Hello " + name;
    }
    
}
