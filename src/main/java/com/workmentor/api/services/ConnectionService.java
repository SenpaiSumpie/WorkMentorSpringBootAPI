package com.workmentor.api.services;

import com.workmentor.api.models.Connection;
import com.workmentor.api.repositories.ConnectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConnectionService {

    private ConnectionRepository connectionRepository;

    public ConnectionService( ConnectionRepository connectionRepository){
        this.connectionRepository = connectionRepository;
    }

    public Connection AddNewConnection(Connection connection){
        return connectionRepository.save(connection);
    }

    public List<Connection> GetAllConnections(){
        return connectionRepository.findAll();
    }

    public Connection GetConnectionById(String id){
        return connectionRepository.findById(Integer.parseInt(id)).orElse(null);
    }

    public Connection UpdateConnection(Connection connection){
        return connectionRepository.save(connection);
    }

    public boolean DeleteConnection(Connection connection){
        connectionRepository.delete(connection);
        return true;
    }
}
