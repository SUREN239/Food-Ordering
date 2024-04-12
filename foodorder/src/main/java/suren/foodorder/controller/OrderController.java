package suren.foodorder.controller;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import suren.foodorder.exception.OrderNotFoundException;
import suren.foodorder.model.Orderings;
import suren.foodorder.repository.OrderRepo;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderRepo orderRepo;

    @PostMapping("/orders")
    public Orderings newOrder(@RequestBody Orderings newOrder){
        return orderRepo.save(newOrder);
    }

    @GetMapping("/orders")
    public List<Orderings> getAllOrders(){
        return orderRepo.findAll();
    }

    @GetMapping("/orders/{id}")
    public Orderings getOrderById(@PathVariable Long id){
        return orderRepo.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
    }

    @PutMapping("/orders/{id}")
    Orderings updateOrder(@RequestBody Orderings newOrder, @PathVariable Long id){
        return orderRepo.findById(id)
                .map(order -> {
                    order.setProductname(newOrder.getProductname());
                    order.setPrice(newOrder.getPrice());
                    order.setOrderdate(newOrder.getOrderdate());
                    return orderRepo.save(order);
                }).orElseThrow(()->new OrderNotFoundException(id));
    }

    @DeleteMapping("/orders/{id}")
    String deleteOrder(@PathVariable Long id){
        if(!orderRepo.existsById(id)){
            throw new OrderNotFoundException(id);
        }
        orderRepo.deleteById(id);
        return "order with id "+id+" has been deleted success.";
    }
}
