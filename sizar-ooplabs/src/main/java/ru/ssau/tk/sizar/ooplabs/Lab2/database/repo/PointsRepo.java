package ru.ssau.tk.sizar.ooplabs.Lab2.database.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.entities.MathFunctionEntity;

import java.util.List;

@Repository
public interface PointsRepo extends JpaRepository<PointsRepo, Long> {
    List<PointsRepo> findPoint(MathFunctionEntity mathFunctionEntity);
}
