package ru.ssau.tk.sizar.ooplabs.Lab2.database.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.entities.UserEntity;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findByUsername(String username);
}
