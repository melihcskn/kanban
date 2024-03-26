package org.acme.services.abstracts;

import org.acme.entities.Status;
import org.acme.entities.dtos.StatusDTO;

import java.util.List;

public interface StatusService {
    List<Status> getAllStatus();

    List<StatusDTO> getAllStatusDTO();
}
