package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.dao.ProfileDao;
import project.model.Profile;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {

    private ProfileDao dao;

    @Autowired
    public ProfileServiceImpl(ProfileDao dao) {
        this.dao = dao;
    }

    @Transactional
    @Override
    public List<Profile> getAllProfiles(int pageSize, int pageNumber) {
        return dao.getAllProfiles(pageSize, pageNumber);
    }

    @Transactional
    @Override
    public List<Profile> getAllProfilesBySystem(String sysName, int pageSize, int pageNumber) {
        return dao.getAllProfilesBySystemAltName(sysName, pageSize, pageNumber);
    }

    @Override
    public Long getProfilesCountBySystemAltName(String sysName) {
        return dao.getProfilesCountBySystemAltName(sysName);
    }

    @Override
    public Long getProfilesCount() {
        return dao.getProfilesCount();
    }
}
