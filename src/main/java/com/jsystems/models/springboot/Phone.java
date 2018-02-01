package com.jsystems.models.springboot;


import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Pawel_D on 2017-04-17.
 */


@Entity
@Table(name = "phones")
public class Phone {

    public Phone(String nrPhone, Long idPlayerPh) {
        this.nrPhone    = nrPhone;
        this.idPlayerPh = idPlayerPh;
    }

    @Id
    @SequenceGenerator(name = "SEQ_PHONES", sequenceName = "SEQ_PHONES")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_PHONES")
    @Column(name="id_PHONE", unique = true)
    private Long idPhone;

    @Column(name = "nr_PHONE", unique = true)
    @NotBlank(message = "Phone number can not be empty")
    @Size(min = 9, max = 12)
    private String nrPhone;

    @Column(name = "id_playerph", unique = true)
    @NotNull(message = "id_Player can not be empty")
    private Long idPlayerPh;
}