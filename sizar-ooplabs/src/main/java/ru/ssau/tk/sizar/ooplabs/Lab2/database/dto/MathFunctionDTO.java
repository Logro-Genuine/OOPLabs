package ru.ssau.tk.sizar.ooplabs.Lab2.database.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MathFunctionDTO {
    private Long id;
    private String funcName;
    private Integer pointsCount;
    private Double xFrom;
    private Double xTo;
}
