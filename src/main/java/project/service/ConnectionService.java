package project.service;

import project.model.Connection;
import project.model.Profile;

import java.util.List;

public interface ConnectionService {
    List<Connection> getAllConnections(int pageSize, int pageNumber);
    Long getConnectionsCount();
}
