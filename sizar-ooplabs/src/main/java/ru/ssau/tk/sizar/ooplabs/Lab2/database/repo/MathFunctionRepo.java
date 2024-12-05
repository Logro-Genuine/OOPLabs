package ru.ssau.tk.sizar.ooplabs.Lab2.database.repo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.entities.MathFunctionEntity;

import java.util.List;

@Repository
public interface MathFunctionRepo extends JpaRepository<MathFunctionEntity, Long> {
    List<MathFunctionEntity> findByFunc_name(String functionType);
}