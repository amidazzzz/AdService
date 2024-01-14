package ru.amida.advertservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.amida.advertservice.model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
