package ru.ssau.tk.sizar.ooplabs.Lab2.database.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MathFunctionDTO {
    private Long id;
    private String func_name;
    private Integer points_count;
    private Double x_from;
    private Double x_to;
}
