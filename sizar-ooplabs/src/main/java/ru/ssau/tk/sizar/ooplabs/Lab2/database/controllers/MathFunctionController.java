package ru.ssau.tk.sizar.ooplabs.Lab2.database.controllers;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.dto.MathFunctionDTO;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.service.MathFunctionService;

import java.util.List;

@RestController
@RequestMapping("/api/functions")
public class MathFunctionController {
    private final MathFunctionService mathFunctionService;

    @Autowired
    public MathFunctionController(MathFunctionService mathFunctionService) {
        this.mathFunctionService = mathFunctionService;
    }

    @GetMapping
    public ResponseEntity<List<MathFunctionDTO>> getFunctions (@RequestParam(required = false) String name){
        try {
            List<MathFunctionDTO> mathFunctions = mathFunctionService.findFunctions(name);
            return new ResponseEntity<>(mathFunctions, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<MathFunctionDTO> createFunction(@RequestBody MathFunctionDTO functionDTO) {
        MathFunctionDTO createdFunction = mathFunctionService.create(functionDTO);
        return new ResponseEntity<>(createdFunction, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFunction(@PathVariable Long id) {
        try {
            mathFunctionService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<MathFunctionDTO> updateFunction(@RequestBody MathFunctionDTO updatedFunction) {
        try {
            MathFunctionDTO updated = mathFunctionService.update(updatedFunction);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<MathFunctionDTO> readFunction(@PathVariable Long id) {
        try {
            MathFunctionDTO function = mathFunctionService.read(id);
            return new ResponseEntity<>(function, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
