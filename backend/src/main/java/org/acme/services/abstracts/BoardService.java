package org.acme.services.abstracts;

import org.acme.entities.Board;
import org.acme.entities.dtos.BoardDTO;

import java.util.List;

public interface BoardService {
    List<Board> getAll();
    BoardDTO findById(Integer id);
}
