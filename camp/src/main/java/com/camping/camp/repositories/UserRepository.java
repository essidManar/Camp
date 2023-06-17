package com.camping.camp.repositories;

import com.camping.camp.entities.Publication;
import com.camping.camp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> {
}
