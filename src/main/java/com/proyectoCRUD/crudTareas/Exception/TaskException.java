package com.proyectoCRUD.crudTareas.Exception;

public class TaskException extends RuntimeException {
    public  TaskException(Long id){
        super ("Tarea con el ID: "+ id +" no encontrada");
    }
}
