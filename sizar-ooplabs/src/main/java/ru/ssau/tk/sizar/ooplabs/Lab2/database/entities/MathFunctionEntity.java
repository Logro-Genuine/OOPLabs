package ru.ssau.tk.sizar.ooplabs.Lab2.database.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Entity
@Table(name = "functions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MathFunctionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "func_name")
    private String funcName;

    @Column(name = "points_count")
    private Integer pointsCount;

    @Column(name = "x_from")
    private Double xFrom;

    @Column(name = "x_to")
    private Double xTo;

    @OneToMany(mappedBy = "func", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PointEntity> pointEntityList;
}
