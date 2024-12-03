package ru.ssau.tk.sizar.ooplabs.Lab2.database.mappers;

import ru.ssau.tk.sizar.ooplabs.Lab2.database.dto.MathFunctionDTO;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.entities.MathFunctionEntity;

public class MathFuncMapper {
    public MathFunctionEntity DTOToEntity(MathFunctionDTO mathFunctionDTO){
        if (mathFunctionDTO == null){return null;}
        MathFunctionEntity mathFunctionEntity = new MathFunctionEntity();
        mathFunctionEntity.setId(mathFunctionDTO.getId());
        mathFunctionEntity.setFunc_name(mathFunctionDTO.getFunc_name());
        mathFunctionEntity.setX_to(mathFunctionDTO.getX_to());
        mathFunctionEntity.setX_from(mathFunctionDTO.getX_from());
        mathFunctionEntity.setPoints_count(mathFunctionDTO.getPoints_count());
        return mathFunctionEntity;
    }
    public MathFunctionDTO EntityToDTO(MathFunctionEntity mathFunctionEntity){
        if (mathFunctionEntity == null){return null;}
        MathFunctionDTO mathFunctionDTO = new MathFunctionDTO();
        mathFunctionDTO.setFunc_name(mathFunctionEntity.getFunc_name());
        mathFunctionDTO.setId(mathFunctionEntity.getId());
        mathFunctionDTO.setX_to(mathFunctionEntity.getX_to());
        mathFunctionDTO.setX_from(mathFunctionEntity.getX_from());
        mathFunctionDTO.setPoints_count(mathFunctionEntity.getPoints_count());
        return mathFunctionDTO;
    }
}
