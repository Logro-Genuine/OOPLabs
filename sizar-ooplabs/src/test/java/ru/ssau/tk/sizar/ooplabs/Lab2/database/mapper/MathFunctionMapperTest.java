package ru.ssau.tk.sizar.ooplabs.Lab2.database.mapper;

import org.junit.jupiter.api.Test;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.dto.MathFunctionDTO;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.entities.MathFunctionEntity;

import static org.junit.jupiter.api.Assertions.*;

class MathFunctionMapperTest {
    @Test
    void testDTOToEntity(){
        MathFunctionDTO mathFunctionDTO = new MathFunctionDTO(3L,"MathFunctionTest", 5, -10.0, 10.0);
        MathFunctionEntity mathFunctionEntity = MathFunctionMapper.toEntity(mathFunctionDTO);

        assertEquals(mathFunctionEntity.getId(), mathFunctionDTO.getId());
        assertEquals(mathFunctionEntity.getFuncName(), mathFunctionDTO.getFuncName());
        assertEquals(mathFunctionEntity.getPointsCount(), mathFunctionDTO.getPointsCount());
        assertEquals(mathFunctionEntity.getXTo(), mathFunctionDTO.getXTo());
        assertEquals(mathFunctionEntity.getXFrom(), mathFunctionDTO.getXFrom());
    }
    @Test
    void testEntityToDTO(){
        MathFunctionEntity mathFunctionEntity = new MathFunctionEntity(1L, "MathFunctionTest", 5, -10.0, 10.0, null);
        MathFunctionDTO mathFunctionDTO = MathFunctionMapper.toDTO(mathFunctionEntity);

        assertEquals(mathFunctionEntity.getId(), mathFunctionDTO.getId());
        assertEquals(mathFunctionEntity.getFuncName(), mathFunctionDTO.getFuncName());
        assertEquals(mathFunctionEntity.getPointsCount(), mathFunctionDTO.getPointsCount());
        assertEquals(mathFunctionEntity.getXTo(), mathFunctionDTO.getXTo());
        assertEquals(mathFunctionEntity.getXFrom(), mathFunctionDTO.getXFrom());

    }

}