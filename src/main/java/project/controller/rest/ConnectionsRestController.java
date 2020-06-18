package project.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.model.Connection;
import project.model.Profile;
import project.service.ConnectionService;
import project.service.ProfileService;

import java.util.List;

@RestController
@RequestMapping("/connections")
public class ConnectionsRestController {

    ConnectionService service;

    @Autowired
    public ConnectionsRestController(ConnectionService service) {
        this.service = service;
    }

    @GetMapping("/get/{profileSystem}")
    public ResponseEntity<List<Connection>> getConnections(@PathVariable(value = "profileSystem") String profileSystem,
                                                            @RequestParam(value = "page") int page,
                                                            @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        int curPageSize = 12;
        if (pageSize != null) {
            curPageSize = pageSize;
        }

        if (profileSystem.equals("all")) {
            return new ResponseEntity<>(
                    service.getAllConnections(curPageSize, page),
                    HttpStatus.OK);
        } else {
            //TODO
            return new ResponseEntity<>(
                    null,
                    HttpStatus.BAD_REQUEST);
        }
    }
}
