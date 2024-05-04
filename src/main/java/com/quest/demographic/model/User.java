package com.quest.demographic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name = "user_info")
public class User {

    @Id
    @Column(name = "pps_number", unique = true)
    private String pps;
    @Column(name = "user_name")
    private String name;
    @Column(name = "birth_date")
    private LocalDate dob;
    @Column(name = "contact")
    private String phone;
    @Column(name = "create_date")
    private LocalDateTime createDate;


}