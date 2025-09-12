package com.proyectoCRUD.crudTareas.Repository;

import com.proyectoCRUD.crudTareas.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

// Implementa los metodos por defecto para un crud
public interface TaskRepository extends JpaRepository<Task,Long> {
    @Query("SELECT t FROM Task t WHERE t.active = true")
    List<Task> findAllActivas();

}
