package suren.foodordering.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import suren.foodordering.model.UserReg;

public interface UserRegRepo extends JpaRepository<UserReg, Long>
{

}
