package com.proyectoCRUD.crudTareas.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity// comunicamos a spring que esta clase representa una tabla de BD
@Table(name="tasks")// le decimos a String que tabla estamos representando
@Data // Nos crea getters y setters
@NoArgsConstructor// Constructor sin arguentos
@AllArgsConstructor // Constructor con todos los argumentos
@Builder // Constructor inicializador

public class Task {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(nullable=false,name="title")
    private String title;

    @Column(name="description")
    private String description;
    @Column(name="status",nullable=false)
    private String status;
    @Column(name="created_at",nullable=false)
    private LocalDateTime created_at= LocalDateTime.now();
    @Column(name="due_date")
    private LocalDateTime due_date;
     @Column(name="active",nullable=false)
    private Boolean active;

}