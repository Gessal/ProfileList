package project.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.model.Profile;
import project.service.ConnectionService;
import project.service.ProfileService;

import java.util.List;

@RestController
@RequestMapping("/util")
public class UtilRestController {

    private ProfileService profileService;
    private ConnectionService connectionService;

    @Autowired
    public UtilRestController(ProfileService profileService, ConnectionService connectionService) {
        this.profileService = profileService;
        this.connectionService = connectionService;
    }

    @GetMapping("/profiles-count/{profileSystem}")
    public ResponseEntity<Long> getProfilesCount(@PathVariable(value = "profileSystem") String profileSystem,
                                                          @RequestParam(value = "pageSize", required = false) Integer pageSize) {

        if (profileSystem.equals("all")) {
            return new ResponseEntity<>(
                    profileService.getProfilesCount(),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(
                    profileService.getProfilesCountBySystemAltName(profileSystem),
                    HttpStatus.OK);
        }
    }

    @GetMapping("/connections-count/{profileSystem}")
    public ResponseEntity<Long> getConnectionsCount(@PathVariable(value = "profileSystem") String profileSystem,
                                                 @RequestParam(value = "pageSize", required = false) Integer pageSize) {

        if (profileSystem.equals("all")) {
            return new ResponseEntity<>(
                    connectionService.getConnectionsCount(),
                    HttpStatus.OK);
        } else {
            //TODO реализовать логику получения соединений по системе профилей, к которой принадлежат соединяемые профили
            return new ResponseEntity<>(
                    null,
                    HttpStatus.BAD_REQUEST);
        }
    }
}
