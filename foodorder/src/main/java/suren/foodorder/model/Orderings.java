package suren.foodorder.model;

import jakarta.persistence.*;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "order")
public class Orderings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    // @ManyToOne
    // @JsonBackReference
    // @JoinColumn(name = "user_id")
    // private User user; // Many orders belong to one user

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String productname;
    private double price;
    private Date orderdate;

    
   public Orderings() {
    }
    
    public Orderings(Long id, User user, String productname, double price, Date orderdate) {
    this.id = id;
    this.user = user;
    this.productname = productname;
    this.price = price;
    this.orderdate = orderdate;
}

    // Getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getProductname() {
        return productname;
    }
    public void setProductname(String productname) {
        this.productname = productname;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public Date getOrderdate() {
        return orderdate;
    }
    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

 

    
}
