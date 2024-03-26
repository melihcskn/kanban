package org.acme.entities.dtos;

import java.util.Objects;

public class StatusDTO {
    private Integer statusId;
    private String statusName;

    public Integer getStatusId() {
        return statusId;
    }

    public StatusDTO() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StatusDTO statusDTO)) return false;
        return Objects.equals(statusId, statusDTO.statusId) && Objects.equals(statusName, statusDTO.statusName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusId, statusName);
    }
}
