package ru.ssau.tk.sizar.ooplabs.Lab2.database.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.entities.MathFunctionEntity;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.entities.PointEntity;

import java.util.List;

@Repository
public interface PointsRepo extends JpaRepository<PointEntity, Long> {
    List<PointEntity> findByFuncId(Long id);
}
