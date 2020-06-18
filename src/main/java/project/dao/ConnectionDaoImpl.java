package project.dao;

import org.springframework.stereotype.Repository;
import project.model.Connection;
import project.model.Profile;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ConnectionDaoImpl implements ConnectionDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Connection> getAllConnections(int pageSize, int pageNumber) {
        return entityManager.createQuery("SELECT c FROM Connection c", Connection.class)
                .setFirstResult(pageSize * (pageNumber - 1))
                .setMaxResults(pageSize)
                .getResultList();
    }

    @Override
    public Long getConnectionsCount() {
        return entityManager.createQuery("SELECT COUNT(c.id) FROM Connection c", Long.class).getSingleResult();
    }
}
