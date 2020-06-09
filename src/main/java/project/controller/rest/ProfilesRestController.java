package project.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.model.Profile;
import project.service.ProfileService;

import java.util.List;

@RestController
@RequestMapping("/profiles")
public class ProfilesRestController {

    ProfileService service;

    @Autowired
    public ProfilesRestController(ProfileService service) {
        this.service = service;
    }

    @GetMapping("/{profileSystem}")
    public ResponseEntity<List<Profile>> getProfiles(@PathVariable(value = "profileSystem") String profileSystem) {
        if (profileSystem.equals("all")) {
            return new ResponseEntity<>(service.getAllProfiles(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(service.getAllProfilesBySystem(profileSystem), HttpStatus.OK);
        }
    }
}
