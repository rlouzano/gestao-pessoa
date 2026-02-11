package br.com.gestao.pessoa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class PositionManagementSystemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_system_code")
    private Integer positionSystemCode;
    @Column(name = "position_system_name")
    private String positionSystemName;
    @Column(name = "position_active_indicator")
    private Boolean positionActiveIndicator;
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private PersonManagementSystemEntity personManagementSystemEntity;
    @Column(name = "position_start_date")
    private LocalDate positionStartDate;
    @Column(name = "position_end_date")
    private LocalDate positionEndDate;
}
