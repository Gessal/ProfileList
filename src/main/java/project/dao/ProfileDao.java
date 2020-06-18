package project.dao;

import project.model.Profile;

import java.util.List;

public interface ProfileDao {
    List<Profile> getAllProfilesPage(int pageSize, int pageNumber);
    List<Profile> getAllProfiles();
    List<Profile> getAllProfilesBySystemAltName(String sysName, int pageSize, int pageNumber);
    Long getProfilesCountBySystemAltName(String sysName);
    Long getProfilesCount();
}