package project.dao;

import project.model.Profile;
import project.model.ProfileSystem;

import java.util.List;

public interface SystemDao {
    List<ProfileSystem> getAllSystems();
}