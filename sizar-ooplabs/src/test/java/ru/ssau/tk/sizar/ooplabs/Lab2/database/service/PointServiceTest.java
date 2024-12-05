package ru.ssau.tk.sizar.ooplabs.Lab2.database.service;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.dto.MathFunctionDTO;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.dto.PointDTO;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class PointServiceTest {

    @Autowired
    private PointService pointService;

    @Autowired
    private MathFunctionService mathFunctionService;

    @Test
    public void testCreatePoint(){
        MathFunctionDTO mathFunctionDTO = new MathFunctionDTO(null, "test function", 10, -5.3, 9.0);
        MathFunctionDTO createdMathFunction = mathFunctionService.create(mathFunctionDTO);
        PointDTO pointDTO = new PointDTO(null,10.0, 10.0, createdMathFunction.getId());

        PointDTO createdPointDTO = pointService.create(pointDTO);

        assertNotNull(createdPointDTO);
        assertEquals(10.0, createdPointDTO.getXValue());
        assertEquals(10.0, createdPointDTO.getYValue());
    }
    @Test
    public void testReadPoint(){
        MathFunctionDTO mathFunctionDTO = new MathFunctionDTO(null, "test function", 10, -5.3, 9.0);
        MathFunctionDTO createdMathFunction = mathFunctionService.create(mathFunctionDTO);
        PointDTO pointDTO = new PointDTO(null,10.0, 10.0, createdMathFunction.getId());
        PointDTO createdPointDTO = pointService.create(pointDTO);

        PointDTO readPointDTO = pointService.read(createdPointDTO.getId());
        assertNotNull(readPointDTO);
        assertEquals(createdPointDTO.getId(), readPointDTO.getId());
    }
    @Test
    public void testUpdatePoint(){
        MathFunctionDTO mathFunctionDTO = new MathFunctionDTO(null, "test function", 10, -5.3, 9.0);
        MathFunctionDTO createdMathFunction = mathFunctionService.create(mathFunctionDTO);
        PointDTO pointDTO = new PointDTO(null,10.0, 10.0, createdMathFunction.getId());
        PointDTO createdPointDTO = pointService.create(pointDTO);


        createdPointDTO.setXValue(5.0);
        createdPointDTO.setYValue(9.0);
        PointDTO updatedPoint = pointService.update(createdPointDTO);

        assertNotNull(updatedPoint);
        assertEquals(5.0, updatedPoint.getXValue());
        assertEquals(9.0, updatedPoint.getYValue());
    }
    @Test
    public void testDeletePoint(){
        MathFunctionDTO mathFunctionDTO = new MathFunctionDTO(null, "test function", 10, -5.3, 9.0);
        MathFunctionDTO createdMathFunction = mathFunctionService.create(mathFunctionDTO);
        PointDTO pointDTO = new PointDTO(null,10.0, 10.0, createdMathFunction.getId());
        PointDTO createdPointDTO = pointService.create(pointDTO);

        assertNotNull(pointService.read(createdPointDTO.getId()));
        pointService.delete(createdPointDTO.getId());
        assertNull(pointService.read(createdPointDTO.getId()));
    }
}
