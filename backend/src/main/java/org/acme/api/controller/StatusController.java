package org.acme.api.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.acme.entities.Status;
import org.acme.entities.dtos.StatusDTO;
import org.acme.services.abstracts.StatusService;

import java.util.List;

@Path("/api/status")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StatusController {
    private StatusService statusService;

    @Inject
    public StatusController(StatusService statusService){
        this.statusService = statusService;
    }

    @GET
    @Path("/getAll")
    public List<Status> getAll(){
        return statusService.getAllStatus();
    }

    @GET
    @Path("/getAllStatus")
    public List<StatusDTO> getAllStatus(){
        return statusService.getAllStatusDTO();
    }

}
