package com.example.userLogin.userRepository;

import org.springframework.data.repository.CrudRepository;

import com.example.userLogin.user.User;

public interface UserRepository extends CrudRepository<User, Long>{
	
	//method name follows Spring data jpa naming standard to automatically generate sql statements
	User findByUsernameAndPassword(String username, String password);

}
