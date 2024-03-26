package org.acme.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "board")
public class Board extends PanacheEntityBase {
    @Id
    @Column(name = "id")
    private Integer boardId;

    @Column(name = "description")
    private String boardDescription;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "taskBoard")
    @JsonManagedReference(value = "board-task")
    private List<Task> taskList;

    public Integer getBoardId() {
        return boardId;
    }

    public void setBoardId(Integer boardId) {
        this.boardId = boardId;
    }

    public String getBoardDescription() {
        return boardDescription;
    }

    public void setBoardDescription(String boardDescription) {
        this.boardDescription = boardDescription;
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
        if (!(o instanceof Board board)) return false;
        return Objects.equals(boardId, board.boardId) && Objects.equals(boardDescription, board.boardDescription) && Objects.equals(taskList, board.taskList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(boardId, boardDescription, taskList);
    }
}
