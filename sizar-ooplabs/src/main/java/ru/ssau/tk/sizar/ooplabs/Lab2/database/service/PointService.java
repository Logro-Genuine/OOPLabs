package ru.ssau.tk.sizar.ooplabs.Lab2.database.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.dto.PointDTO;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.entities.MathFunctionEntity;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.entities.PointEntity;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.mapper.PointMapper;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.repo.MathFunctionRepo;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.repo.PointsRepo;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class PointService {
    private final PointsRepo pointRepo;
    private final MathFunctionRepo mathFunctionRepo;

    public PointDTO create(PointDTO pointDTO) {
        PointEntity point = PointMapper.toEntity(pointDTO);
        PointEntity newPoint = pointRepo.save(point);

        return PointMapper.toDTO(newPoint);
    }

    public PointDTO read(Long id) {
        return this.pointRepo.findById(id)
                .map(PointMapper::toDTO)
                .orElse(null);
    }

    public PointDTO update(PointDTO pointDTO) {
        PointEntity point = PointMapper.toEntity(pointDTO);
        PointEntity editedPoint = this.pointRepo.save(point);

        return PointMapper.toDTO(editedPoint);
    }

    public void delete(Long id) {
        this.pointRepo.deleteById(id);
    }

    public List<PointDTO> findByFunction(Long id) {
        return mathFunctionRepo.findById(id)
                .map(this::getPointsForFunction)
                .orElse(null);
    }

    private List<PointDTO> getPointsForFunction(MathFunctionEntity function) {
        return pointRepo.findByFunction(function)
                .stream()
                .map(PointMapper::toDTO)
                .collect(Collectors.toList());
    }
}
