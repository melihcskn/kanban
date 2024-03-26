package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entities.Status;

@ApplicationScoped
public class StatusRepository implements PanacheRepository<Status> {
}
