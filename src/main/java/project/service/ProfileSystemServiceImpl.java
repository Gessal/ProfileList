package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.dao.ProfileDao;
import project.dao.SystemDao;
import project.model.Profile;
import project.model.ProfileSystem;

import java.util.List;

@Service
public class ProfileSystemServiceImpl implements ProfileSystemService {

    private SystemDao dao;

    @Autowired
    public ProfileSystemServiceImpl(SystemDao dao) {
        this.dao = dao;
    }

    @Transactional
    @Override
    public List<ProfileSystem> getAllProfileSystems() {
        return dao.getAllSystems();
    }
}
