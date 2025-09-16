package com.proyectoCRUD.crudTareas.Dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskUpdateDto {
    @Size (min=3,max=100,message="Titulo debe tener entre 3 y 100 caracteres")
    private String title;
    @Size (min=3,max=100,message="Descripcion debe tener entre 3 y 100 caracteres")
    private String description;
    @Size (min=3,max=100,message="Estado debe tener entre 3 y 100 caracteres")
    private String status;
    @FutureOrPresent(message="La fecha debe ser ubicada ahora o en el futuro")
    private LocalDateTime due_date;

    private Boolean active;

}
