# todos

- code.quarkus.io
    https://code.quarkus.io/
- Example code
- Show reactive / imperative
- Start in Dev Mode
- Show localhost
- Show endpoint
- Show hot reload
- Show dev ui
- Add dependency
- Show hot reload
- Show reactive score
- Show native

- Continuous Testing

- Dev Services (add DB)

```
<dependency>
    <groupId>io.quarkus</groupId>
    <artifactId>quarkus-jdbc-postgresql</artifactId>
</dependency>
<dependency>
    <groupId>io.quarkus</groupId>
    <artifactId>quarkus-hibernate-orm-panache</artifactId>
</dependency>
```

- Add Todo

```
@Entity
public class Todo extends PanacheEntity{
    public String title;
    public String description;
    public boolean isDone = false;
}
```

Service

```
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
```

- Spring ? https://quarkus.io/guides/spring-web

```
<dependency>
    <groupId>io.quarkus</groupId>
    <artifactId>quarkus-spring-web</artifactId>
</dependency>
```

```
@RestController
@RequestMapping("/spring/todo")
public class TodoSpringResource {

    @GetMapping
    public List<Todo> todos() {
        return Todo.listAll();
    }
    
    @PostMapping
    @Transactional
    public void addTodo(Todo todo) {
        todo.persistAndFlush();
    }
}
```

- GraphQL ? remember void. Might have to restart ??

```
<dependency>
    <groupId>io.quarkus</groupId>
    <artifactId>quarkus-smallrye-graphql</artifactId>
</dependency>
```

mutation add{
  addTodo(todo: { 
    		title:"Security"
        description:"What about security ?"
    		isDone: false}
  		){
    id
  }
}

- Security ? https://quarkus.io/guides/security-overview-concept

```
<dependency>
    <groupId>io.quarkus</groupId>
    <artifactId>quarkus-oidc</artifactId>
</dependency>
```

( remove security ?)

- Kubernetes / Openshift

```
<dependency>
    <groupId>io.quarkus</groupId>
    <artifactId>quarkus-kubernetes</artifactId>
</dependency>
<dependency>
    <groupId>io.quarkus</groupId>
    <artifactId>quarkus-openshift</artifactId>
</dependency>
```