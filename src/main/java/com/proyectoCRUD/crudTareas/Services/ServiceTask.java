package com.proyectoCRUD.crudTareas.Services;

import com.proyectoCRUD.crudTareas.Entity.Task;
import com.proyectoCRUD.crudTareas.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ServiceTask {
    @Autowired
    private TaskRepository taskRepository;
    public List<Task> listarTareas(){
        return taskRepository.findAllActivas();

    }
    public Task tarea(long id){
        return taskRepository.getById(id);
    }
    public Task guardarTarea(Task task){
        return taskRepository.save(task);
    }
    // Metodo que actualiza todos lso campos de una pagina
    public Task actualizarTareaTotal(Long id, Task taskActualizada){
Task existente =  taskRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("No existe esta tarea para actualizar"));
     existente.setTitle(taskActualizada.getTitle());
     existente.setDescription(taskActualizada.getDescription());
     existente.setStatus(taskActualizada.getStatus());
     existente.setDue_date(taskActualizada.getDue_date());
     existente.setActive(taskActualizada.getActive());
     return  taskRepository.save(existente);
    }
    // Este es para la peticion patch, solo actualiza los campos que nos lleguen
    public Task actualizarTareaParcial(long id,Task taskParcial){
        Task existente = taskRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No existe esta tarea parcial"));
        if(taskParcial.getDue_date()!=null){
            existente.setDue_date(taskParcial.getDue_date());
        }
        if(taskParcial.getTitle()!=null){
            existente.setTitle(taskParcial.getTitle());
        }
        if(taskParcial.getDescription()!=null){
            existente.setDescription(taskParcial.getDescription());
        }
        if(taskParcial.getStatus()!=null){
            existente.setStatus(taskParcial.getStatus());
        }
        if(taskParcial.getActive()!=null){
            existente.setActive(taskParcial.getActive());
        }
        return  taskRepository.save(existente);
    }
    public void  eliminarTarea(long id){
       Task tarea =  taskRepository.findById(id)
               .orElseThrow(()-> new RuntimeException("No existe esta tarea para eliminar"));
       tarea.setActive(false);
       taskRepository.save(tarea);
    }
}
