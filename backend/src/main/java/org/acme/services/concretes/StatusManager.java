package org.acme.services.concretes;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.entities.Status;
import org.acme.entities.converter.DTOConverter;
import org.acme.entities.dtos.StatusDTO;
import org.acme.repository.StatusRepository;
import org.acme.services.abstracts.StatusService;

import java.util.List;

@ApplicationScoped
public class StatusManager implements StatusService {

    @Inject
    StatusRepository statusRepository;

    @Override
    public List<Status> getAllStatus() {
        return statusRepository.listAll();
    }

    @Override
    public List<StatusDTO> getAllStatusDTO() {
        DTOConverter converter = new DTOConverter();
        return (converter.convertStatusToDTO(getAllStatus()));
    }
}
