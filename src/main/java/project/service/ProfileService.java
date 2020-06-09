package project.service;

import project.model.Profile;

import java.util.List;

public interface ProfileService {
    List<Profile> getAllProfiles();
    List<Profile> getAllProfilesBySystem(String sysName);
}
