import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InscricaoLoader implements CommandLineRunner {

    private final InscricaoRepository inscricaoRepository;

    @Autowired
    public InscricaoLoader(InscricaoRepository inscricaoRepository) {
        this.inscricaoRepository = inscricaoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        carregarInscricoes();
    }

    private void carregarInscricoes() {
        // Adicione aqui a lógica para carregar dados de inscrições do banco de dados
        // Exemplo:
        Inscricao inscricao1 = new Inscricao(/*dados da inscrição 1*/);
        Inscricao inscricao2 = new Inscricao(/*dados da inscrição 2*/);

        inscricaoRepository.save(inscricao1);
        inscricaoRepository.save(inscricao2);

        System.out.println("Dados de inscrições carregados no banco de dados.");
    }
}
