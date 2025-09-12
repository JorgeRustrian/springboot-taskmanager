package com.proyectoCRUD.crudTareas.Controllers;

import com.proyectoCRUD.crudTareas.Entity.Task;
import com.proyectoCRUD.crudTareas.Services.ServiceTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/tareas")
public class TaskControllers {
    @Autowired
    private ServiceTask serviceTask;
    @GetMapping("/listarTareas")
    public ResponseEntity<?> listarTareas(){
        serviceTask.listarTareas();
        return ResponseEntity.ok().build();
    }
    @GetMapping("/listarTarea/{id}")
    public ResponseEntity<?> listarTareas(@PathVariable Integer id){
        serviceTask.tarea(id);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/guardarTarea")
    public ResponseEntity<?> guardarTarea(@RequestBody Task task){
        serviceTask.guardarTarea(task);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/actualizacionTotal/{id}")
    public ResponseEntity<?> actualizarTareaTotal(@PathVariable long id,@RequestBody Task task){
        serviceTask.actualizarTareaTotal(id,task);
        return ResponseEntity.ok().build();
    }
    @PatchMapping("/actualizacionParcial/{id}")
    public ResponseEntity<?> actualizarTareaParcial(@PathVariable long id,@RequestBody Task task){
        serviceTask.actualizarTareaParcial(id,task);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/eliminarTarea/{id}")
    public ResponseEntity<?> eliminarTarea(@PathVariable long id){
        serviceTask.eliminarTarea(id);
        return ResponseEntity.ok().build();
    }

}
