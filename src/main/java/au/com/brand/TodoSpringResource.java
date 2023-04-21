package au.com.brand;

import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
