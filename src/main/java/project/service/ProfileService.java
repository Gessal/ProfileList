package project.service;

import project.model.Profile;

import java.util.List;

public interface ProfileService {
    List<Profile> getAllProfiles(int pageSize, int pageNumber);
    List<Profile> getAllProfilesBySystem(String sysName, int pageSize, int pageNumber);
    Long getProfilesCountBySystemAltName(String sysName);
    Long getProfilesCount();
}
