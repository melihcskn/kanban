package org.acme.api.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.entities.Board;
import org.acme.entities.dtos.BoardDTO;
import org.acme.services.abstracts.BoardService;

import java.util.List;

@Path("/api/boards")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BoardController{

    private BoardService boardService;

    @Inject
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GET
    @Path("/getAll")
    public List<Board> getAll(){
        return boardService.getAll();
    }

    @GET
    @Path("/findById/{id}")
    public BoardDTO findById(Integer id){
        return boardService.findById(id);
    }
}
