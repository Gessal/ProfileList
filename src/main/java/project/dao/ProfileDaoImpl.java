package project.dao;

import org.springframework.stereotype.Repository;
import project.model.Profile;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProfileDaoImpl implements ProfileDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Profile> getAllProfiles() {
        return entityManager.createQuery("SELECT p FROM Profile p", Profile.class).getResultList();
    }

    @Override
    public List<Profile> getAllProfilesBySystemAltName(String sysName) {
        return entityManager
                .createQuery("SELECT p FROM Profile p JOIN p.profileSystems s WHERE s.altName = :sysName", Profile.class)
                .setParameter("sysName", sysName)
                .getResultList();
    }
}
