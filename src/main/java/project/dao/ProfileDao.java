package project.dao;

import project.model.Profile;

import java.util.List;

public interface ProfileDao {
    List<Profile> getAllProfiles(int pageSize, int pageNumber);
    List<Profile> getAllProfilesBySystemAltName(String sysName, int pageSize, int pageNumber);
    Long getProfilesCount();
}