import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CursoLoader implements CommandLineRunner {

    private final CursoRepository cursoRepository;

    @Autowired
    public CursoLoader(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        carregarCursos();
    }

    private void carregarCursos() {
        // Adicione aqui a lógica para carregar dados de cursos do banco de dados
        // Exemplo:
        Curso curso1 = new Curso("NomeCurso1", "DescriçãoCurso1");
        Curso curso2 = new Curso("NomeCurso2", "DescriçãoCurso2");

        cursoRepository.save(curso1);
        cursoRepository.save(curso2);

        System.out.println("Dados de cursos carregados no banco de dados.");
    }
}
