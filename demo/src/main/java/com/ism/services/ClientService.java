package com.ism.services;

import com.ism.entities.Client;

public interface ClientService<T> extends Service<T> {
    Client searchClient(String telephone);

    Client searchClientBySurname(String surname);

}
