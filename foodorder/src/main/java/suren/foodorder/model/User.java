package suren.foodorder.model;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String email;
    private String number;
    private String password;
    
    // @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    // @JsonManagedReference
    //  // One user can have multiple orders


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Orderings> orders;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String pass) {
        this.password = pass;
    }

    public List<Orderings> getOrders() {
        return orders;
    }

    public void setOrders(List<Orderings> orders) {
        this.orders = orders;
    }
}
