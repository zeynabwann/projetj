package com.ism.services.impl;
import java.util.List;

import com.ism.entities.Client;

import com.ism.services.ClientService;
import com.ism.repository.Repository;
import com.ism.repository.RepositoryClient;


public class ClientServiceImpl implements ClientService<Client> {
    private final Repository<Client> clientRepository;

    public ClientServiceImpl(Repository<Client> clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void create(Client client) {
        clientRepository.insert(client);
    }

    @Override
    public List<Client> show() {
        return clientRepository.selectAll();
    }

    @Override
    public Client searchClient(String telephone) {
        return ((RepositoryClient<Client>) clientRepository).selectByTelephone(telephone);

    }

    @Override
    public Client searchClientBySurname(String surname) {
        return ((RepositoryClient<Client>) clientRepository).selectBySurname(surname);
    }

}
