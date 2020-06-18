package project.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/get/{profileSystem}")
    public ResponseEntity<List<Profile>> getProfiles(@PathVariable(value = "profileSystem") String profileSystem,
                                                     @RequestParam(value = "page") int page,
                                                     @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        int curPageSize = 12;
        if (pageSize != null) {
            curPageSize = pageSize;
        }

        if (profileSystem.equals("all")) {
            return new ResponseEntity<>(
                    service.getAllProfilesPage(curPageSize, page),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(
                    service.getAllProfilesBySystem(profileSystem, curPageSize, page),
                    HttpStatus.OK);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Profile>> getAllProfiles() {
        return new ResponseEntity<>(
                    service.getAllProfiles(),
                    HttpStatus.OK);
    }

    @GetMapping("/add")
    public ResponseEntity<List<Profile>> addProfile(@PathVariable(value = "profileSystem") String profileSystem,
                                                     @RequestParam(value = "page") int page,
                                                     @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        int curPageSize = 12;
        if (pageSize != null) {
            curPageSize = pageSize;
        }

        if (profileSystem.equals("all")) {
            return new ResponseEntity<>(
                    service.getAllProfilesPage(curPageSize, page),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(
                    service.getAllProfilesBySystem(profileSystem, curPageSize, page),
                    HttpStatus.OK);
        }
    }
}
