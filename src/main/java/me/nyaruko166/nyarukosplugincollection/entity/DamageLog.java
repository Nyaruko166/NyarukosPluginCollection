package me.nyaruko166.nyarukosplugincollection.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "DamageLog")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DamageLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "PlayerName")
    private String playerName;

    @Column(name = "TotalDamage")
    private Double totalDamage;

    @Column(name = "KillerName")
    private String killerName;

    @Column(name = "DateEnded")
    private Date dateEnded;
}
