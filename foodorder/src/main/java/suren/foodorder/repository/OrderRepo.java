package suren.foodorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import suren.foodorder.model.Orderings;

public interface OrderRepo extends JpaRepository<Orderings, Long> {
    
}
