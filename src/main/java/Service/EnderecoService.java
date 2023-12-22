import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    public void incluirEndereco(Endereco endereco) {
        enderecoRepository.save(endereco);
    }

    public Endereco buscarEnderecoPorCep(String cep) {
        String enderecoJson = this.webClientBuilder.baseUrl("https://viacep.com.br/ws/").build()
                .get().uri("/{cep}/json", cep)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        return converterJsonParaEndereco(enderecoJson);
    }

    public List<Endereco> listarTodosEnderecos() {
        return enderecoRepository.findAll();
    }

    public List<Endereco> buscarEnderecosPorUsuario(Usuario usuario) {

        return enderecoRepository.findByUsuario(usuario);
    }

    private Endereco converterJsonParaEndereco(String json) {

        return null;
    }
}