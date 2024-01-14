package ru.amida.advertservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.amida.advertservice.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
