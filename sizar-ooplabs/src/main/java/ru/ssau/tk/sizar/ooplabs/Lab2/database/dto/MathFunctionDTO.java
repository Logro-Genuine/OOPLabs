package ru.ssau.tk.sizar.ooplabs.Lab2.database.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MathFunctionDTO {
    private Long id;
    private String funcName;
    private Integer pointsCount;
    private Double xFrom;
    private Double xTo;
}
