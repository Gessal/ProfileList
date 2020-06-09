package project.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.model.ProfileSystem;
import project.service.ProfileSystemService;

import java.util.List;

@RestController
@RequestMapping("/systems")
public class SystemsRestController {

    ProfileSystemService service;

    @Autowired
    public SystemsRestController(ProfileSystemService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProfileSystem>> getSystems() {
            return new ResponseEntity<>(service.getAllProfileSystems(), HttpStatus.OK);
    }
}
