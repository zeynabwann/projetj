package com.ism.repository.list;
import com.ism.entities.Client;
import com.ism.repository.RepositoryClient;


public class ClientRepositoryList  extends RepositoryListImpl<Client> implements RepositoryClient<Client>{
    @Override
    public Client selectByTelephone(String telephone){
        return list.stream()
            .filter(client-> client.getTelephone().compareTo(telephone)== 0)
            .findFirst()
            .orElse(null);
    }
    @Override
    public Client selectBySurname(String surname){
        return list.stream().filter(client-> client.getSurname().compareTo(surname)== 0)
        .findFirst()
        .orElse(null);
    }
    
}
