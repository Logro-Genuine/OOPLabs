package ru.ssau.tk.sizar.ooplabs.Lab2.database.repo;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.entities.MathFunctionEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@Transactional
@SpringBootTest
@ExtendWith(SpringExtension.class)
class MathFunctionRepoTest {
    @Autowired
    private MathFunctionRepo mathFunctionRepo;
    @Test
    void testFindByFuncName() {
        MathFunctionEntity func1 = new MathFunctionEntity(1L, "func1", 5, -10.0, 10.0, null);
        MathFunctionEntity func2 = new MathFunctionEntity(2L, "func1", 10, -1.0, 10.0, null);
        MathFunctionEntity func3 = new MathFunctionEntity(3L, "func2", 5, 3.0, 9.0, null);
        mathFunctionRepo.save(func1);
        mathFunctionRepo.save(func2);
        mathFunctionRepo.save(func3);

        List<MathFunctionEntity> functions = mathFunctionRepo.findByFuncName("func2");
        assertEquals(1, functions.size());

    }
}
