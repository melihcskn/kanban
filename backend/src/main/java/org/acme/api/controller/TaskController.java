package org.acme.api.controller;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.entities.Task;
import org.acme.services.abstracts.TaskService;

@Path("/api/tasks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TaskController {

    private TaskService taskService;

    @Inject
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GET
    @Path("/getAll")
    public List<Task> getAll(){
        return taskService.getAllTask();
    }

    @POST
    @Transactional
    public void addTask(Task taskToAdd){
        Task temp = Task.findById(taskToAdd.getTaskId());
        if(temp == null){
            taskToAdd.persist();
        }
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public void updateTask(Integer id, Task taskToUpdate){
        Task temp = Task.findById(id);
        if(temp == null){
            throw new NotFoundException();
        }
        temp.setTaskColor(taskToUpdate.getTaskColor());
        temp.setTaskId(taskToUpdate.getTaskId());
        temp.setTaskDescription(taskToUpdate.getTaskDescription());
        temp.setStatusId(taskToUpdate.getStatusId());
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void deleteTask(Integer id){
        Task temp = Task.findById(id);
        if(temp == null){
            throw new NotFoundException();
        }
        temp.delete();
    }
}
