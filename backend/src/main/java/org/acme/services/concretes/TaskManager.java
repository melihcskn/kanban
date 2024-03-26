package org.acme.services.concretes;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.entities.Task;
import org.acme.repository.TaskRepository;
import org.acme.services.abstracts.TaskService;

import java.util.List;

@ApplicationScoped
public class TaskManager implements TaskService {


    @Inject
    TaskRepository taskRepository;

    @Override
    public List<Task> getAllTask() {
        return taskRepository.listAll();
    }
}
