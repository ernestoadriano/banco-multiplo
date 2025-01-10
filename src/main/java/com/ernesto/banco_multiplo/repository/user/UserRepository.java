package com.ernesto.banco_multiplo.repository.user;

import com.ernesto.banco_multiplo.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    //UserDetails findByLogin(String login);
}
