package au.com.brand;

import jakarta.annotation.security.RolesAllowed;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import java.util.List;

@Path("/todo")
public class TodoResource {

    @GET
    @RolesAllowed("user")
    public List<Todo> todos() {
        return Todo.listAll();
    }
    
    @POST
    @Transactional
    @RolesAllowed("admin")
    public void addTodo(Todo todo) {
        todo.persistAndFlush();
    }
}
