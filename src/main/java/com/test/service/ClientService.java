package com.test.service;


import com.test.entity.Client;

import java.util.List;

public interface ClientService {
    public List<Client> getAllClients();

    public Client getClient(int id);

    public void saveClient(Client client);

    public void deleteClient(int id);
}
