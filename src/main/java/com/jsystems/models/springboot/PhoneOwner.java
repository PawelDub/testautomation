package com.jsystems.models.springboot;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Pawel_D on 2017-05-04.
 */


@Entity
@Table(name = "phone_owner")
public class PhoneOwner {

    @Id
    @Column(name = "id_phone")
    private Long idPhone;

    @Column(name = "nr_phone", unique = true)
    private String nrPhone;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    public PhoneOwner() {
    }

    public PhoneOwner(Long idPhone, String nrPhone, String name, String surname) {
        this.idPhone = idPhone;
        this.nrPhone = nrPhone;
        this.name = name;
        this.surname = surname;
    }

    public Long getIdPhone() {
        return idPhone;
    }

    public void setIdPhone(Long idPhone) {
        this.idPhone = idPhone;
    }
}