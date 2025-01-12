//package com.project.diplomation.data.models.entities;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Set;
//
//@Entity
//@Table(name = "user")
//@Getter
//@Setter
//public class User extends BaseEntity implements UserDetails {
////    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    private long id;
//    private String username;
//    private String password;
//    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
//    private Set<Role> authorities;
//    private boolean accountNonExpired;
//    private boolean accountNonLocked;
//    private boolean credentialsNonExpired;
//    private boolean enabled;
//}
