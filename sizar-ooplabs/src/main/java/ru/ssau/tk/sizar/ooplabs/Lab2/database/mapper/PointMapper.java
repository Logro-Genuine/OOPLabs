package ru.ssau.tk.sizar.ooplabs.Lab2.database.mapper;

import ru.ssau.tk.sizar.ooplabs.Lab2.database.dto.PointDTO;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.entities.MathFunctionEntity;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.entities.PointEntity;

public class PointMapper {
    public static PointEntity toEntity(PointDTO dto){
        if (dto == null) {
            return null;
        }
        PointEntity entity = new PointEntity();
        entity.setId(dto.getId());
        entity.setXValue(dto.getXValue());
        entity.setYValue(dto.getYValue());

        //MathFunctionEntity function = new MathFunctionEntity();
        //function.setId(dto.getFuncId());
        //entity.setFunc_name(function);
        return entity;
    }
    public static PointDTO toDTO(PointEntity entity){
        if (entity == null) {
            return null;
        }
        PointDTO dto = new PointDTO();
        dto.setId(entity.getId());
        //dto.setFuncId(entity.getFunctionEntity() != null ? entity.getFunctionEntity().getId() : 0);
        dto.setXValue(entity.getXValue());
        dto.setYValue(entity.getYValue());
        return dto;
    }

}
