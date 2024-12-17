package ru.ssau.tk.sizar.ooplabs.Lab2.database.mapper;

import ru.ssau.tk.sizar.ooplabs.Lab2.database.dto.MathFunctionDTO;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.entities.MathFunctionEntity;


public class MathFunctionMapper {

    public static MathFunctionDTO toDTO(MathFunctionEntity entity) {
        if (entity == null) {
            return null;
        }
        MathFunctionDTO dto = new MathFunctionDTO();
        dto.setId(entity.getId());
        dto.setFuncName(entity.getFuncName());
        dto.setPointsCount(entity.getPointsCount());
        dto.setXFrom(entity.getXFrom());
        dto.setXTo(entity.getXTo());
        return dto;
    }

    public static MathFunctionEntity toEntity(MathFunctionDTO dto) {
        if (dto == null) {
            return null;
        }
        MathFunctionEntity entity = new MathFunctionEntity();
        entity.setId(dto.getId());
        entity.setFuncName(dto.getFuncName());
        entity.setPointsCount(dto.getPointsCount());
        entity.setXFrom(dto.getXFrom());
        entity.setXTo(dto.getXTo());

        return entity;
    }
}
