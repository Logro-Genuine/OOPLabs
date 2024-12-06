package ru.ssau.tk.sizar.ooplabs.Lab2.database.service;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.dto.MathFunctionDTO;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
@ExtendWith(SpringExtension.class)
class MathFunctionServiceTest {

    @Autowired
    private MathFunctionService mathFunctionService;

    @Test
    public void testCreateMathFunction() {
        MathFunctionDTO mathFunctionDTO = new MathFunctionDTO(6L, "create test func", 10, -5.3, 9.0);

        MathFunctionDTO createdFunction = mathFunctionService.create(mathFunctionDTO);

        assertNotNull(createdFunction);

        assertEquals(10, createdFunction.getPointsCount());
        assertEquals(-5.3, createdFunction.getXFrom());
        assertEquals(9.0, createdFunction.getXTo());
        assertEquals("create test func", createdFunction.getFuncName());
    }
    @Test
    public void testReadeMathFunction() {
        MathFunctionDTO mathFunctionDTO = new MathFunctionDTO(null, "read test func", 10, -5.3, 9.0);
        MathFunctionDTO createdFunction = mathFunctionService.create(mathFunctionDTO);

        MathFunctionDTO readFunction = mathFunctionService.read(createdFunction.getId());
        assertNotNull(readFunction);
        assertEquals(createdFunction.getId(), readFunction.getId());
    }
    @Test
    public void testUpdateMathFunction() {
        MathFunctionDTO functionDTO = new MathFunctionDTO(null, "update test func", 10, -5.3, 9.0);
        MathFunctionDTO createdFunction = mathFunctionService.create(functionDTO);

        createdFunction.setFuncName("updated test func");
        createdFunction.setPointsCount(5);
        MathFunctionDTO updatedFunction = mathFunctionService.update(createdFunction);

        assertNotNull(updatedFunction);
        assertEquals("updated test func", updatedFunction.getFuncName());
        assertEquals(5, updatedFunction.getPointsCount());
    }
    @Test
    public void testDeleteMathFunction(){
        MathFunctionDTO mathFunctionDTO = new MathFunctionDTO(null, "delete test func", 10, -5.3, 9.0);
        MathFunctionDTO createdMathFunctionDTO = mathFunctionService.create(mathFunctionDTO);

        assertNotNull(mathFunctionService.read(createdMathFunctionDTO.getId()));

        mathFunctionService.delete(createdMathFunctionDTO.getId());
        assertNull(mathFunctionService.read(createdMathFunctionDTO.getId()));
    }
}