package org.acme.entities.dtos;

import org.acme.entities.Status;
import org.acme.entities.Task;

import java.util.List;
import java.util.Objects;

public class BoardDTO {
    private Integer boardId;
    private List<StatusDTO> statusData;
    private List<Task> taskList;

    public BoardDTO() {
    }

    public Integer getBoardId() {
        return boardId;
    }

    public void setBoardId(Integer boardId) {
        this.boardId = boardId;
    }

    public List<StatusDTO> getStatusData() {
        return statusData;
    }

    public void setStatusData(List<StatusDTO> statusData) {
        this.statusData = statusData;
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
        if (!(o instanceof BoardDTO boardDTO)) return false;
        return Objects.equals(boardId, boardDTO.boardId) && Objects.equals(statusData, boardDTO.statusData) && Objects.equals(taskList, boardDTO.taskList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(boardId, statusData, taskList);
    }
}
