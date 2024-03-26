package org.acme.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "status")
public class Status{
    @Id
    @Column(name = "id")
    private Integer statusId;

    @Column(name = "name")
    private String statusName;

    @Column(name="description")
    private String statusDescription;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "taskStatus")
    @JsonManagedReference(value = "status-task")
    private List<Task> taskList;

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Status status)) return false;
        return Objects.equals(statusId, status.statusId) && Objects.equals(statusName, status.statusName) && Objects.equals(statusDescription, status.statusDescription) && Objects.equals(taskList, status.taskList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusId, statusName, statusDescription, taskList);
    }
}
