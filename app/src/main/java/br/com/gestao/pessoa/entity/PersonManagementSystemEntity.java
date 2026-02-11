package br.com.gestao.pessoa.entity;

import br.com.gestao.pessoa.entity.enums.DocumentType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Where;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class PersonManagementSystemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_system_code")
    private Integer personSystemCode;
    @Column(name = "person_system_name")
    private String personSystemName;
    @Column(name = "document_type_system")
    private DocumentType documentSystemType;
    @Column(name = "document_number_system")
    private Integer documentNumberSystem;
    @Column(name = "admission_date")
    private LocalDate admissionDate;
    @Column(name = "termination_date")
    private LocalDate terminationDate;
    @Column(name = "person_active_indicator")
    private Boolean personActiveIndicator;
    @Column(name = "inclusion_date")
    private LocalDate inclusionDate;
    @Column(name = "update_date")
    private LocalDate updateDate;

    @OneToMany(mappedBy = "personManagementSystemEntity", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.TRUE)
    @Where(clause = "positionActiveIndicator=1")
    private List<PositionManagementSystemEntity> positionManagementSystemEntity;

    @OneToMany(mappedBy = "personManagementSystemEntity", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.TRUE)
    @Where(clause = "salaryActiveIndicator=1")
    private List<SalaryPersonManagementSystemEntity> salaryPersonSystem;
}
