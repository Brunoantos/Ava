import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InscricaoService {

    private final InscricaoRepository inscricaoRepository;

    @Autowired
    public InscricaoService(InscricaoRepository inscricaoRepository) {
        this.inscricaoRepository = inscricaoRepository;
    }

    // Adicione métodos de serviço relacionados a Inscricao
}

