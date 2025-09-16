package com.proyectoCRUD.crudTareas.Dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class TaskDto {
    @NotBlank(message="titulo no puede estar vacio")
    @Size(min=3,max=100,message="El titulo debe tener entre 3 y 100 caracteres")
    private String title;
    @NotBlank(message="La descripcion no puede estar vacia")
   private String description;

    @NotBlank(message="La tarea debe tener un estado")
    private String status;
    @NotNull(message="La tarea debe tener fecha de finalizacion")
    @FutureOrPresent(message="La tarea debe tener fecha de finalizacion hoy o en el futuro")
    private LocalDateTime due_date;

    @NotNull(message="La tarea debe estar activa o inactiva")
    private Boolean active;

}
