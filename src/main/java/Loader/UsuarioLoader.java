import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UsuarioLoader implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioLoader(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        carregarUsuarios();
    }

    private void carregarUsuarios() {
        // Adicione aqui a lógica para carregar dados de usuários do banco de dados
        // Exemplo:
        Usuario usuario1 = new Usuario("Nome1", "email1@example.com");
        Usuario usuario2 = new Usuario("Nome2", "email2@example.com");

        usuarioRepository.save(usuario1);
        usuarioRepository.save(usuario2);

        System.out.println("Dados de usuários carregados no banco de dados.");
    }
}
