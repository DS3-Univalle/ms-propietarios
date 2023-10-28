package com.proyectocabin.proyectojpa.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cabins")
@Data
public class Cabin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_cabin;
    @Column(name = "name" , nullable = false)
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "location")
    private String location;
    @Column(name = "price")
    private float price;
    @Column(name = "rooms")
    private int rooms;
    @Column(name = "bathrooms")
    private int bathrooms;
    @Column(name = "legal_information")
    private String legal_information;
    @Column(name = "number_people")
    private int number_people;
    @Column(name = "id_state")
    private int id_state;
}
