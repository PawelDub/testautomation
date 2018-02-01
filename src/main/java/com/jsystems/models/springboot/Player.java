package com.jsystems.models.springboot;

//import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by Pawel_D on 2017-04-17.
 */

@Entity

@Table(name = "players")
public class Player {
    public Player(Long idPlayer, String name, String surname, String pesel, Double height, Double weight, Double bmi, String description, Long idClubcard, Long idTeam, Long idSport) {
        this.idPlayer    = idPlayer;
        this.name        = name;
        this.surname     = surname;
        this.pesel       = pesel;
        this.height      = height;
        this.weight      = weight;
        this.bmi         = bmi;
        this.description = description;
        this.idClubcard  = idClubcard;
        this.idTeam      = idTeam;
        this.idSport     = idSport;
    }

    @Id
    @SequenceGenerator(name = "SEQ_PLAYERS", sequenceName = "SEQ_PLAYERS")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_PLAYERS")
    @Column(name = "id_player", unique = true, nullable = false)
    private Long idPlayer;

    @Column(name = "name")
    @NotBlank(message = "Name Can not be empty")
    @Size(min = 2, max = 30)
    private String name;

    @Column(name = "surname")
    @NotBlank(message = "Surname Can not be empty")
    @Size(min = 2, max = 30)
    private String surname;

    @Column(name = "pesel", unique = true)
    @NotBlank(message = "Pesel Can not be empty")
    @Size(min = 11, max = 11)
    private String pesel;

    @Column(name = "height")
    @NotBlank(message = "Height Can not be empty")
    private Double height;

    @Column(name = "weight")
    @NotBlank(message = "Weight Can not be empty")
    private Double weight;

    private Double bmi;

    private String description;

    @Column(name = "id_clubcard", unique = true)
    @NotBlank(message = "id_clubcard Can not be empty")
    @Size(min = 8, max = 15)
    private Long idClubcard;

    @Column(name = "id_team", unique = true)
    @NotBlank(message = "id_team Can not be empty")
    @Size(min = 2, max = 5)
    private Long idTeam;

    @Column(name = "id_sport", unique = true)
    @NotBlank(message = "id_sport Can not be empty")
    @Size(min = 2, max = 5)
    private Long idSport;

    @Valid
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OrderBy("idPhone asc")
    @JoinColumn(name = "id_phone", referencedColumnName = "id_player", nullable = false, updatable = false, insertable = false)
    private List<Phone> phones;
}