package org.acme.services.concretes;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.entities.Board;
import org.acme.entities.converter.DTOConverter;
import org.acme.entities.dtos.BoardDTO;
import org.acme.repository.BoardRepository;
import org.acme.services.abstracts.BoardService;
import org.acme.services.abstracts.StatusService;

import java.util.List;

@ApplicationScoped
public class BoardManager implements BoardService {


    @Inject
    BoardRepository boardRepository;

    @Inject
    StatusService statusService;
    @Override
    public List<Board> getAll() {
        return boardRepository.listAll();
    }

    @Override
    public BoardDTO findById(Integer id) {
        DTOConverter converter = new DTOConverter(statusService);
        return converter.convertBoardToDTO(boardRepository.findById((long) id));
    }
}
