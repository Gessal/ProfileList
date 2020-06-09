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
    public List<Profile> getAllProfiles() {
        return dao.getAllProfiles();
    }

    @Transactional
    @Override
    public List<Profile> getAllProfilesBySystem(String sysName) {
        return dao.getAllProfilesBySystemAltName(sysName);
    }
}
