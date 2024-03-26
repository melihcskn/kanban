package org.acme.entities.converter;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.entities.Board;
import org.acme.entities.Status;
import org.acme.entities.dtos.BoardDTO;
import org.acme.entities.dtos.StatusDTO;
import org.acme.services.abstracts.StatusService;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class DTOConverter {

    StatusService statusService;

    @Inject
    public DTOConverter(StatusService statusService) {
        this.statusService = statusService;
    }

    public DTOConverter() {
    }

    public BoardDTO convertBoardToDTO(Board board){
        BoardDTO temp = new BoardDTO();
        temp.setBoardId(board.getBoardId());
        temp.setTaskList(board.getTaskList());
        temp.setStatusData(statusService.getAllStatusDTO());

        return temp;
    }

    public StatusDTO convertStatusToDTO(Status status){
        StatusDTO dto = new StatusDTO();
        dto.setStatusId(status.getStatusId());
        dto.setStatusName(status.getStatusName());
        return dto;
    }

    public List<StatusDTO> convertStatusToDTO(List<Status> statusList){
        List<StatusDTO> dto = new ArrayList<>();

        statusList.forEach(status->
                dto.add(convertStatusToDTO(status)));
        return dto;
    }
}
