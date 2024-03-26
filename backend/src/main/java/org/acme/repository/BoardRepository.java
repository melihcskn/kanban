package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entities.Board;

@ApplicationScoped
public class BoardRepository implements PanacheRepository<Board> {
}
