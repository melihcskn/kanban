package org.acme.services.abstracts;

import org.acme.entities.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTask();
}
