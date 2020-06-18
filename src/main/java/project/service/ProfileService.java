package project.service;

import project.model.Profile;

import java.util.List;

public interface ProfileService {
    List<Profile> getAllProfilesPage(int pageSize, int pageNumber);
    List<Profile> getAllProfiles();
    List<Profile> getAllProfilesBySystem(String sysName, int pageSize, int pageNumber);
    Long getProfilesCountBySystemAltName(String sysName);
    Long getProfilesCount();
}
