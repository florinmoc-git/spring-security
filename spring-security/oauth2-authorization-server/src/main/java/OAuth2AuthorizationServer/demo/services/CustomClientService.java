package OAuth2AuthorizationServer.demo.services;

import OAuth2AuthorizationServer.demo.entities.Client;
import OAuth2AuthorizationServer.demo.repositories.ClientRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CustomClientService implements RegisteredClientRepository {

    private final ClientRepository clientRepository;

    public CustomClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void save(RegisteredClient registeredClient) {
        clientRepository.save(Client.from(registeredClient));
    }

    @Override
    public RegisteredClient findById(String id) {
        var client =
                clientRepository.findById(Integer.valueOf(id))
                        .orElseThrow();
        return Client.from(client);
    }

    @Override
    public RegisteredClient findByClientId(String clientId) {
        var client =
                clientRepository.findByClientId(clientId)
                        .orElseThrow();
        return Client.from(client);
    }
}
