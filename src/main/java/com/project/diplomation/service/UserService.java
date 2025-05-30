//package com.project.diplomation.service;
//
//import com.project.diplomation.data.repositories.UserRepo;
//import lombok.AllArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//@AllArgsConstructor
//public class UserService implements UserDetailsService {
//    private final UserRepo userRepo;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return this.userRepo.findByUsername(username);
//    }
//}
