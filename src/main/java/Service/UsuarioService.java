import java.util.List;
import java.util.Map;

public class UsuarioService {

    private final Map<Integer, Usuario> usuarios;

    public UsuarioService() {
        this.usuarios = new HashMap<>();
    }

    public void incluir(Usuario usuario) {
        usuarios.put(usuario.getID(), usuario);
    }

    public List<Usuario> obterLista() {
        return List.copyOf(usuarios.values());
    }
}
