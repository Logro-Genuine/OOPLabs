package ru.ssau.tk.sizar.ooplabs.Lab2.database.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "points")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PointEntity {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "x_value")
    private Double xValue;
    @Column(name = "y_value")
    private Double yValue;

    @ManyToOne
    @JoinColumn(name = "func_id", referencedColumnName = "id")
    private MathFunctionEntity func;
}
