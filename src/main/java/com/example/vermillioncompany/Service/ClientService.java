package com.example.vermillioncompany.Service;

import com.example.vermillioncompany.Model.Client;
import com.example.vermillioncompany.Repository.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepo clientRepo;

    @Autowired
    public ClientService(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    public List<Client> getAllClients() {
        return clientRepo.findAll();
    }

    public Optional<Client> getClientById(Long id) {
        return clientRepo.findById(id);
    }

    public Client createClient(Client client) {
        return clientRepo.save(client);
    }

    public Client updateClient(Long id, Client updatedClient) {
        return clientRepo.findById(id).map(client -> {
            client.setClientName(updatedClient.getClientName());
            client.setContactPerson(updatedClient.getContactPerson());
            client.setContactEmail(updatedClient.getContactEmail());
            client.setPhoneNumber(updatedClient.getPhoneNumber());
            return clientRepo.save(client);
        }).orElseThrow(() -> new RuntimeException("Клиент не найден с id: " + id));
    }

    public void deleteClient(Long id) {
        clientRepo.deleteById(id);
    }
}
