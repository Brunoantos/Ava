import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class EnderecoLoader implements CommandLineRunner {

    private final EnderecoRepository enderecoRepository;
    private final WebClient.Builder webClientBuilder;

    @Autowired
    public EnderecoLoader(EnderecoRepository enderecoRepository, WebClient.Builder webClientBuilder) {
        this.enderecoRepository = enderecoRepository;
        this.webClientBuilder = webClientBuilder;
    }

    @Override
    public void run(String... args) throws Exception {

        String cep = "12345678";
        Endereco endereco = obterEnderecoPorCep(cep);

        if (endereco != null) {
            enderecoRepository.save(endereco);
            System.out.println("Endereço incluído no banco de dados: " + endereco);
        } else {
            System.out.println("Não foi possível obter o endereço para o CEP: " + cep);
        }
    }

    private Endereco obterEnderecoPorCep(String cep) {
        String enderecoJson = this.webClientBuilder.baseUrl("https://viacep.com.br/ws/").build()
                .get().uri("/{cep}/json", cep)
                .retrieve()
                .bodyToMono(String.class)
                .block();


        return converterJsonParaEndereco(enderecoJson);
    }


    private Endereco converterJsonParaEndereco(String json) {

    }
}
