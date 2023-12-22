import java.util.List;
import java.util.Map;

public class InscricaoService {

    private final Map<Integer, Inscricao> inscricoes;

    public InscricaoService() {
        this.inscricoes = new HashMap<>();
    }

    public void incluir(Inscricao inscricao) {
        inscricoes.put(inscricao.getID(), inscricao);
    }

    public List<Inscricao> obterLista() {
        return List.copyOf(inscricoes.values());
    }
}

