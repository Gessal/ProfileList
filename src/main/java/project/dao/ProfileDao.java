package project.dao;

import project.model.Profile;

import java.util.List;

public interface ProfileDao {
    List<Profile> getAllProfiles();
    List<Profile> getAllProfilesBySystemAltName(String sysName);
}