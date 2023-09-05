package br.com.adocao;


import br.com.pet.PetEntity;
import br.com.tutor.TutorEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity(name = "tbl_adocao")
@Table(name = "tbl_adocao")
public class AdocaoEntity {

    @Id
    @GeneratedValue(generator = "seq_tbl_adocao_pk", strategy = GenerationType.SEQUENCE)
    @Column(name = "pk_long_id")
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, mappedBy = "tbl_tutor")
    @JoinColumn(name = "fk_long_tutor_id", referencedColumnName = "pk_long_tutor_id")
    private TutorEntity tutor;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, mappedBy = "tbl_pet")
    @JoinColumn(name = "fk_long_pet_id", referencedColumnName = "pk_long_pet_id")
    private PetEntity pet;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "dt_adocao_data")
    private Date data;

}
