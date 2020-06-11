package project.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.model.Profile;
import project.service.ProfileService;

import java.util.List;

@RestController
@RequestMapping("/util")
public class UtilRestController {

    ProfileService service;

    @Autowired
    public UtilRestController(ProfileService service) {
        this.service = service;
    }

    @GetMapping("/profiles-count/{profileSystem}")
    public ResponseEntity<Long> getProfilesCount(@PathVariable(value = "profileSystem") String profileSystem,
                                                          @RequestParam(value = "pageSize", required = false) Integer pageSize) {

        if (profileSystem.equals("all")) {
            return new ResponseEntity<>(
                    service.getProfilesCount(),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(
                    service.getProfilesCountBySystemAltName(profileSystem),
                    HttpStatus.OK);
        }
    }
}
