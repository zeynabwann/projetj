package com.ism.core.factory;
import com.ism.repository.RepositoryClient;
import com.ism.repository.RepositoryUser;
import com.ism.repository.database.ClientRepositoryBD;
import com.ism.repository.list.UserRepositoryList;

public class Factory {
    private Factory(){

    }
    private static ClientRepositoryBD repositoryClient=null;
    private static RepositoryUser repositoryUser = null;
    public static RepositoryClient getInstancRepositoryClient(){
        if (repositoryClient == null) {
            repositoryClient=new ClientRepositoryBD();
            
        }
        return (RepositoryClient) repositoryClient;
    }
    public static RepositoryUser getInstancRepositoryUser(){
        if (repositoryUser == null) {
            repositoryUser=new UserRepositoryList();
            
        }
        return repositoryUser;
    }

    }
    

