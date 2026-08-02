// com.example.demo.controller.UserController
import com.example.demo.model.User;
import com.example.demo.model.Address;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private static final Map<Long, User> STORE = new HashMap<>();
    static {
        STORE.put(1L, new User(1L, "Alice", "alice@example.com",
            Arrays.asList(new Address("123 Main St","Springfield","11111"),
                          new Address("456 Oak Ave","Shelbyville","22222"))));
        STORE.put(2L, new User(2L, "Bob", "bob@example.com",
            Collections.singletonList(new Address("789 Pine Rd","Capital City","33333"))));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id) {
        User user = STORE.get(id);
        if (user == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        long id = STORE.keySet().stream().max(Long::compareTo).orElse(0L) + 1;
        user.setId(id);
        STORE.put(id, user);
        return ResponseEntity.status(201).body(user);
    }
}
