package suren.foodorder.repository;

// import javax.swing.text.html.Option;

import org.springframework.data.jpa.repository.JpaRepository;
import suren.foodorder.model.User;
import java.util.Optional;


public interface UserRepo extends JpaRepository<User,Long> {
    // User findByEmail(String username);
    User findByEmail(String email);

    Optional<User> findByName(String name);
}
