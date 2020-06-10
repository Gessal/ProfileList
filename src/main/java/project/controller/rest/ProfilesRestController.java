package project.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.model.Profile;
import project.service.ProfileService;
import project.util.ModelWithTotalCount;

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
    public ResponseEntity<ModelWithTotalCount<Profile>> getProfiles(@PathVariable(value = "profileSystem") String profileSystem,
                                                     @RequestParam(value = "page") int page,
                                                     @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        int curPageSize = 14;
        if (pageSize != null) {
            curPageSize = pageSize;
        }
        Long pages = service.getProfilesCount()/curPageSize;
        if (service.getProfilesCount()%curPageSize != 0) {
            pages++;
        }

        if (profileSystem.equals("all")) {
            return new ResponseEntity<>(
                    new ModelWithTotalCount<>(service.getAllProfiles(curPageSize, page), pages),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(
                    new ModelWithTotalCount<>(service.getAllProfilesBySystem(profileSystem, curPageSize, page), pages),
                    HttpStatus.OK);
        }
    }
}
