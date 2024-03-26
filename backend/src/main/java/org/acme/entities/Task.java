package org.acme.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "task")
public class Task extends PanacheEntityBase {

    @Id
    @Column(name = "id")
    private Integer taskId;

    @Column(name = "description")
    private String taskDescription;

    @Column(name = "color")
    private String taskColor;

    @Column(name = "status_id")
    private Integer statusId;

    @Column(name = "board_id")
    private Integer boardId;

    @ManyToOne(targetEntity = Status.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "status_id" ,insertable = false, updatable = false)
    @JsonBackReference(value = "status-task")
    private Status taskStatus;

    @ManyToOne(targetEntity = Board.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "board_id" ,insertable = false, updatable = false)
    @JsonBackReference(value = "board-task")
    private Board taskBoard;


    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getTaskColor() {
        return taskColor;
    }

    public void setTaskColor(String taskColor) {
        this.taskColor = taskColor;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Integer getBoardId() {
        return boardId;
    }

    public void setBoardId(Integer boardId) {
        this.boardId = boardId;
    }

    public Status getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Status taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Board getTaskBoard() {
        return taskBoard;
    }

    public void setTaskBoard(Board taskBoard) {
        this.taskBoard = taskBoard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task task)) return false;
        return Objects.equals(taskId, task.taskId) && Objects.equals(taskDescription, task.taskDescription) && Objects.equals(taskColor, task.taskColor) && Objects.equals(statusId, task.statusId) && Objects.equals(boardId, task.boardId) && Objects.equals(taskStatus, task.taskStatus) && Objects.equals(taskBoard, task.taskBoard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId, taskDescription, taskColor, statusId, boardId, taskStatus, taskBoard);
    }
}
