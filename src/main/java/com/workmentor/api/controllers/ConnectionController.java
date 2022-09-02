package com.workmentor.api.controllers;

import com.workmentor.api.models.Connection;
import com.workmentor.api.services.ConnectionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/connections")
public class ConnectionController {

    private ConnectionService connectionService;

    public ConnectionController( ConnectionService connectionService ){
        this.connectionService = connectionService;
    }

    @CrossOrigin(origins = {"http://localhost:4200", "http://959037-workmentor.s3-website-us-west-2.amazonaws.com/"})
    @GetMapping("/{id}")
    public Connection GetConnection(@PathVariable String id){
        return connectionService.GetConnectionById(id);
    }

    @CrossOrigin(origins = {"http://localhost:4200", "http://959037-workmentor.s3-website-us-west-2.amazonaws.com/"})
    @GetMapping
    public List<Connection> GetAllConnections(){
        return connectionService.GetAllConnections();
    }

    @CrossOrigin(origins = {"http://localhost:4200", "http://959037-workmentor.s3-website-us-west-2.amazonaws.com/"})
    @PostMapping
    public Connection PostConnection(@RequestBody Connection connection){
        return connectionService.AddNewConnection(connection);
    }

    @CrossOrigin(origins = {"http://localhost:4200", "http://959037-workmentor.s3-website-us-west-2.amazonaws.com/"})
    @PutMapping
    public ResponseEntity<Connection> PutConnection(@RequestBody Connection connection){
        Connection foundConnection = connectionService.GetConnectionById(connection.getId().toString());
        if(foundConnection != null){
            Connection updatedConnection = connectionService.UpdateConnection(connection);
            return new ResponseEntity<>(updatedConnection, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin(origins = {"http://localhost:4200", "http://959037-workmentor.s3-website-us-west-2.amazonaws.com/"})
    @DeleteMapping("/delete")
    public ResponseEntity<String> DeleteConnection(@RequestBody Connection connection){
        Connection foundConnection = connectionService.GetConnectionById(connection.getId().toString());
        if(foundConnection != null){
            connectionService.DeleteConnection(connection);
            return new ResponseEntity<>("Deleted User", HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
