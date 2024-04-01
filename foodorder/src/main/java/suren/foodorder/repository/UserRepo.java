package suren.foodorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import suren.foodorder.model.User;

public interface UserRepo extends JpaRepository<User,Long> {
    User findByEmail(String username);
}
