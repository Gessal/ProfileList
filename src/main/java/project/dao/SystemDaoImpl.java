package project.dao;

import org.springframework.stereotype.Repository;
import project.model.Profile;
import project.model.ProfileSystem;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class SystemDaoImpl implements SystemDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ProfileSystem> getAllSystems() {
        return entityManager.createQuery("SELECT s FROM ProfileSystem s", ProfileSystem.class).getResultList();
    }
}
