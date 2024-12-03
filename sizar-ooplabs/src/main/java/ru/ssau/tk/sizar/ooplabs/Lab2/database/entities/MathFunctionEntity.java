package ru.ssau.tk.sizar.ooplabs.Lab2.database.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Table(name = "functions")
@Data
public class MathFunctionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "func_name")
    private String func_name;

    @Column(name = "points_count")
    private Integer points_count;

    @Column(name = "x_from")
    private Double x_from;

    @Column(name = "x_to")
    private Double x_to;

    @OneToMany(mappedBy = "function", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PointEntity> pointEntityList;

}
