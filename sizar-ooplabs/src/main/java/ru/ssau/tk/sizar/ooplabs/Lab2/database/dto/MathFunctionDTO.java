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
    private String func_name;
    private Integer points_count;
    private Double x_from;
    private Double x_to;
}
