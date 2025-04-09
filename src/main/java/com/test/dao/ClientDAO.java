package com.test.dao;

import com.test.entity.Client;

import java.util.List;

public interface ClientDAO {
    public List<Client> getAllClients();
    public Client getClient(int id);

    public void saveClient(Client client);

    public void deleteClient(int id);


}
