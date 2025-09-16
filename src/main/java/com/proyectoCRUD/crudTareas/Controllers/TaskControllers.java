package com.proyectoCRUD.crudTareas.Controllers;

import com.proyectoCRUD.crudTareas.Dto.TaskDto;
import com.proyectoCRUD.crudTareas.Dto.TaskUpdateDto;
import com.proyectoCRUD.crudTareas.Entity.Task;
import com.proyectoCRUD.crudTareas.Services.ServiceTask;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/tareas")
public class TaskControllers {
    @Autowired
    private ServiceTask serviceTask;
    @GetMapping("/listarTareas")
    public ResponseEntity<?> listarTareas(){

        return ResponseEntity.ok(  serviceTask.listarTareas());
    }
    @GetMapping("/listarTarea/{id}")
    public ResponseEntity<?> listarTareas(@PathVariable Integer id){

        return ResponseEntity.ok(serviceTask.tarea(id) );
    }
    @PostMapping("/guardarTarea")
    public ResponseEntity<?> guardarTarea(@Valid @RequestBody TaskDto task){
        Task nueva=serviceTask.guardarTarea(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }
    @PutMapping("/actualizacionTotal/{id}")
    public ResponseEntity<?> actualizarTareaTotal(@PathVariable long id,@Valid @RequestBody TaskDto taskDto){

        serviceTask.actualizarTareaTotal(id,taskDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskDto);
    }
    @PatchMapping("/actualizacionParcial/{id}")
    public ResponseEntity<?> actualizarTareaParcial(@PathVariable long id,@Valid @RequestBody TaskUpdateDto task){
        serviceTask.actualizarTareaParcial(id, task);
        return ResponseEntity.status(HttpStatus.OK).body(task);
    }
    @DeleteMapping("/eliminarTarea/{id}")
    public ResponseEntity<?> eliminarTarea(@PathVariable long id){
        serviceTask.eliminarTarea(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
