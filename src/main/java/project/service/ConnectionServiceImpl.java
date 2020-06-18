package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.dao.ConnectionDao;
import project.dao.ProfileDao;
import project.model.Connection;
import project.model.Profile;

import java.util.List;

@Service
public class ConnectionServiceImpl implements ConnectionService {

    private ConnectionDao dao;

    @Autowired
    public ConnectionServiceImpl(ConnectionDao dao) {
        this.dao = dao;
    }

    @Transactional
    @Override
    public List<Connection> getAllConnections(int pageSize, int pageNumber) {
        return dao.getAllConnections(pageSize, pageNumber);
    }

    @Override
    public Long getConnectionsCount() {
        return dao.getConnectionsCount();
    }
}
