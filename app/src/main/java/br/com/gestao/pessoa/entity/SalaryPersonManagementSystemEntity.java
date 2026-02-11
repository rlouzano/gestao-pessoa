package br.com.gestao.pessoa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class SalaryPersonManagementSystemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "salary_person_system_code")
    private Integer salaryPersonSystemCode;
    @Column(name = "salary_person_system_value")
    private BigDecimal salaryPersonSystemValue;
    @Column(name = "salary_active_indicator")
    private Boolean salaryActiveIndicator;
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private PersonManagementSystemEntity personManagementSystemEntity;
    @Column(name = "salary_start_date")
    private LocalDate salaryStartDate;
    @Column(name = "salary_end_date")
    private LocalDate salaryEndDate;
}
