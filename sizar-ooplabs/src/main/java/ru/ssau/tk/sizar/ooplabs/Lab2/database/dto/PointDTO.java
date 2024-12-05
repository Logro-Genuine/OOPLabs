package ru.ssau.tk.sizar.ooplabs.Lab2.database.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PointDTO {
    private Long id;
    private Double xValue;
    private Double yValue;
    private Long func;
}
