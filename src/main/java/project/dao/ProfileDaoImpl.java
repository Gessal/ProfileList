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
    public List<Profile> getAllProfiles(int pageSize, int pageNumber) {
        return entityManager.createQuery("SELECT p FROM Profile p", Profile.class)
                .setFirstResult(pageSize * (pageNumber - 1))
                .setMaxResults(pageSize)
                .getResultList();
    }

    @Override
    public List<Profile> getAllProfilesBySystemAltName(String sysName, int pageSize, int pageNumber) {
        return entityManager
                .createQuery("SELECT p FROM Profile p JOIN p.profileSystems s WHERE s.altName = :sysName", Profile.class)
                .setParameter("sysName", sysName)
                .setFirstResult(pageSize * (pageNumber - 1))
                .setMaxResults(pageSize)
                .getResultList();
    }

    @Override
    public Long getProfilesCountBySystemAltName(String sysName) {
        return entityManager.createQuery("SELECT COUNT(p.id) FROM Profile p JOIN p.profileSystems s WHERE s.altName = :sysName", Long.class)
                .setParameter("sysName", sysName)
                .getSingleResult();
    }

    @Override
    public Long getProfilesCount() {
        return entityManager.createQuery("SELECT COUNT(p.id) FROM Profile p", Long.class).getSingleResult();
    }
}
