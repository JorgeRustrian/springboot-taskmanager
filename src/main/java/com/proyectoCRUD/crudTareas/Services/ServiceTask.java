package com.proyectoCRUD.crudTareas.Services;

import com.proyectoCRUD.crudTareas.Dto.TaskDto;
import com.proyectoCRUD.crudTareas.Dto.TaskUpdateDto;
import com.proyectoCRUD.crudTareas.Entity.Task;
import com.proyectoCRUD.crudTareas.Exception.TaskException;
import com.proyectoCRUD.crudTareas.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceTask {
    @Autowired
    private TaskRepository taskRepository;
    public List<?> listarTareas(){
        return taskRepository.findAllActivas().stream()
                .map(task-> new TaskDto(

                        task.getTitle(),
                        task.getDescription(),
                        task.getStatus(),
                        task.getDue_date(),
                        task.getActive()
                ))
                .collect(Collectors.toList());

    }
    public TaskDto tarea(long id){
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskException(id));

 return new TaskDto(

                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getDue_date(),
                task.getActive()
        );}

    public Task guardarTarea(TaskDto taskDdto){
        Task task = new Task();
        task.setTitle(taskDdto.getTitle());
        task.setDescription(taskDdto.getDescription());
        task.setStatus(taskDdto.getStatus());
        task.setDue_date(taskDdto.getDue_date());
        task.setActive(taskDdto.getActive());
        return taskRepository.save(task);
    }
    // Metodo que actualiza todos lso campos de una pagina
    public Task actualizarTareaTotal(Long id, TaskDto taskDto){
Task existente =  taskRepository.findById(id)
        .orElseThrow(()-> new TaskException(id));
        existente.setTitle(taskDto.getTitle());
        existente.setDescription(taskDto.getDescription());
        existente.setStatus(taskDto.getStatus());
        existente.setDue_date(taskDto.getDue_date());
        existente.setActive(taskDto.getActive());
        return  taskRepository.save(existente);
    }
    // Este es para la peticion patch, solo actualiza los campos que nos lleguen
    public Task actualizarTareaParcial(long id, TaskUpdateDto taskParcial){
        Task existente = taskRepository.findById(id)
                .orElseThrow(()-> new TaskException(id));
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
        if(taskParcial.getActive()){
            existente.setActive(taskParcial.getActive());
        }
        return  taskRepository.save(existente);
    }
    public void  eliminarTarea(long id){
       Task tarea =  taskRepository.findById(id)
               .orElseThrow(()-> new TaskException(id));
       tarea.setActive(false);
       taskRepository.save(tarea);
    }
}
