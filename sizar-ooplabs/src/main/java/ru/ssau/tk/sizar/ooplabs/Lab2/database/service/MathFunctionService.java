package ru.ssau.tk.sizar.ooplabs.Lab2.database.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.dto.MathFunctionDTO;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.entities.MathFunctionEntity;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.repo.MathFunctionRepo;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.mapper.MathFunctionMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MathFunctionService {

    private final MathFunctionRepo mathFunctionRepo;

    public MathFunctionDTO create(MathFunctionDTO mathFunctionDTO) {
        MathFunctionEntity mathFunctionEntity = MathFunctionMapper.toEntity(mathFunctionDTO);
        MathFunctionEntity savedEntity = mathFunctionRepo.save(mathFunctionEntity);
        return MathFunctionMapper.toDTO(savedEntity);
    }

    public MathFunctionDTO read(Long id) throws EntityNotFoundException{
        return mathFunctionRepo
                .findById((long) id)
                .map(MathFunctionMapper::toDTO)
                .orElseThrow(EntityNotFoundException::new);
    }

    public MathFunctionDTO update(MathFunctionDTO functionDTO) {
        MathFunctionEntity functionEntity = MathFunctionMapper.toEntity(functionDTO);
        MathFunctionEntity editedFunction = mathFunctionRepo.save(functionEntity);

        return MathFunctionMapper.toDTO(editedFunction);
    }

    public void delete(Long id) throws EntityNotFoundException {
        if (this.mathFunctionRepo.findById(id).isEmpty()) {
            throw new EntityNotFoundException();
        }
        this.mathFunctionRepo.deleteById((long)id);
    }

    public List<MathFunctionDTO> findFunctions(String name) throws EntityNotFoundException {
        List<MathFunctionEntity> mathFunctionEntities;

        System.out.println(name);
        if (name != null && !name.isEmpty()) {
            mathFunctionEntities = mathFunctionRepo.findByFuncName(name);
        } else {
            mathFunctionEntities = mathFunctionRepo.findAll();
        }

        return mathFunctionEntities.stream()
                .map(MathFunctionMapper::toDTO)
                .collect(Collectors.toList());
    }
}
