package ru.ssau.tk.sizar.ooplabs.Lab2.database.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.dto.PointDTO;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.repo.MathFunctionRepo;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.service.PointService;

import java.util.List;

@RestController
@RequestMapping("/api/points")
@RequiredArgsConstructor
public class PointController {
    private final PointService pointService;
    private final MathFunctionRepo mathFunctionRepo;

    @PostMapping
    public ResponseEntity<PointDTO> createPoint(@RequestBody PointDTO pointDTO) {
        try {
            PointDTO createdPoint = pointService.create(pointDTO);
            return new ResponseEntity<>(createdPoint, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PointDTO> readPoint(@PathVariable Long id) {
        try {
            PointDTO point = pointService.read(id);
            return new ResponseEntity<>(point, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PointDTO> updatePoint(@PathVariable Long id, @RequestBody PointDTO updatedPoint) {
        updatedPoint.setId(id); // Убедитесь, что ID обновляемой точки установлен
        PointDTO point = pointService.update(updatedPoint);
        return new ResponseEntity<>(point, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePoint(@PathVariable Long id) {
        try {
            pointService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/function/{functionId}")
    public ResponseEntity<List<PointDTO>> getPointsByFunction(@PathVariable Long functionId) {
        List<PointDTO> points = pointService.findByFunction(functionId);
        if (!points.isEmpty()) {
            return new ResponseEntity<>(points, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
