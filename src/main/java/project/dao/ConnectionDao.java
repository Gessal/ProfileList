package project.dao;

import project.model.Connection;
import project.model.Profile;

import java.util.List;

public interface ConnectionDao {
    List<Connection> getAllConnections(int pageSize, int pageNumber);
    Long getConnectionsCount();
}