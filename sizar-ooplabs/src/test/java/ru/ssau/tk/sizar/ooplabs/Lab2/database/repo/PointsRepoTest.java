package ru.ssau.tk.sizar.ooplabs.Lab2.database.repo;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.entities.MathFunctionEntity;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.entities.PointEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
@ExtendWith(SpringExtension.class)
class PointsRepoTest {
    @Autowired
    private PointsRepo pointsRepo;
    @Autowired
    private MathFunctionRepo mathFunctionRepo;
    @Test
    void testFindByFunction() {
        MathFunctionEntity myFunction = new MathFunctionEntity(null, "func", 1, 0.0, 10.0, null);
        PointEntity point1 = new PointEntity(null, 5.0, 3.1, myFunction);
        PointEntity point2 = new PointEntity(null, 1.0, -10.001, myFunction);
        PointEntity point3 = new PointEntity(null, 3.0, 9.0, myFunction);

        mathFunctionRepo.save(myFunction);
        pointsRepo.save(point1);
        pointsRepo.save(point2);
        pointsRepo.save(point3);

        List<PointEntity> points = pointsRepo.findByFuncId(myFunction.getId());
        assertEquals(3, points.size());
    }
}