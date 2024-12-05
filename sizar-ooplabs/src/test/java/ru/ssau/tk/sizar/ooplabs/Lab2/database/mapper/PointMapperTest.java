package ru.ssau.tk.sizar.ooplabs.Lab2.database.mapper;

import org.junit.jupiter.api.Test;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.dto.PointDTO;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.entities.MathFunctionEntity;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.entities.PointEntity;

import static org.junit.jupiter.api.Assertions.*;

class PointMapperTest {
    @Test
    void testDTOToEntity(){
        PointDTO pointDTO = new PointDTO(7L, 7.0, 0.9, 9L);
        PointEntity pointEntity = PointMapper.toEntity(pointDTO);

        assertEquals(pointDTO.getId(), pointEntity.getId());
        assertEquals(pointDTO.getXValue(), pointEntity.getXValue());
        assertEquals(pointDTO.getYValue(), pointEntity.getYValue());
        assertEquals(pointDTO.getFuncId(), pointEntity.getFunc_ent().getId());
    }

    @Test
    void testEntityToDTO(){
        MathFunctionEntity mathFunctionEntity = new MathFunctionEntity(1L, "MathFunctionTest", 5, -10.0, 10.0, null);
        PointEntity pointEntity = new PointEntity(7L, 7.0, 0.9, mathFunctionEntity);
        PointDTO pointDTO = PointMapper.toDTO(pointEntity);

        assertEquals(pointDTO.getId(), pointEntity.getId());
        assertEquals(pointDTO.getXValue(), pointEntity.getXValue());
        assertEquals(pointDTO.getYValue(), pointEntity.getYValue());
        assertEquals(pointDTO.getFuncId(), pointEntity.getFunc_ent().getId());
    }
}