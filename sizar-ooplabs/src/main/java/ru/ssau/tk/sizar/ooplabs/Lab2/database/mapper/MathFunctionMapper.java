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
        dto.setFunc_name(entity.getFunc_name());
        dto.setX_from(entity.getX_from() != null ? entity.getX_from() : 0.0);
        dto.setX_to(entity.getX_to() != null ? entity.getX_to() : 0.0);
        return dto;
    }

    public static MathFunctionEntity toEntity(MathFunctionDTO dto) {
        if (dto == null) {
            return null;
        }
        MathFunctionEntity entity = new MathFunctionEntity();
        entity.setId(dto.getId());
        entity.setFunc_name(dto.getFunc_name());
        entity.setX_from(dto.getX_from());
        entity.setX_to(dto.getX_to());

        return entity;
    }
}
