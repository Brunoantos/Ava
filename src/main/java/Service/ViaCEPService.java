import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ViaCEPService {

    private final WebClient webClient;

    @Autowired
    public ViaCEPService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public ViaCEPResponse consultarCEP(String cep) {
        return webClient.get()
                .uri(cep + "/json/")
                .retrieve()
                .bodyToMono(ViaCEPResponse.class)
                .block();
    }
}
