import java.util.List;
import java.util.Map;

public class CursoService {

    private final Map<Integer, Curso> cursos;

    public CursoService() {
        this.cursos = new HashMap<>();
    }

    public void incluir(Curso curso) {
        cursos.put(curso.getID(), curso);
    }

    public List<Curso> obterLista() {
        return List.copyOf(cursos.values());
    }
}


