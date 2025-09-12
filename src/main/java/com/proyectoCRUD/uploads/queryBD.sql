create database task;
use task;
CREATE TABLE tasks ( id int PRIMARY KEY identity, 
title VARCHAR(100) NOT NULL, 
description TEXT, 
status VARCHAR(20) NOT NULL DEFAULT 'pendiente', 
created_at DATETIME NOT NULL DEFAULT GETDATE(),
    due_date DATETIME NOT NULL DEFAULT GETDATE() ); 
	ALTER TABLE tasks
ADD active int NOT NULL DEFAULT 1;

--Esta query crea la bd task, encargada de manejar las tareas de la app CRUD de gestion de tareas.
ALTER TABLE tasks
ALTER COLUMN active BIT NOT NULL;
ALTER TABLE tasks
DROP CONSTRAINT DF__tasks__active__3A81B327;

ALTER TABLE tasks
ALTER COLUMN active BIT NOT NULL;
select * from tasks;
