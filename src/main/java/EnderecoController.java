import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {

    private final EnderecoService enderecoService;

    @Autowired
    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @PostMapping("/incluir")
    public ResponseEntity<Void> incluirEndereco(@RequestBody Endereco endereco) {
        enderecoService.incluirEndereco(endereco);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @GetMapping("/buscarPorCep")
    public Endereco buscarEnderecoPorCep(@RequestParam String cep) {
        return enderecoService.buscarEnderecoPorCep(cep);
    }

    @GetMapping("/listarTodos")
    public List<Endereco> listarTodosEnderecos() {
        return enderecoService.listarTodosEnderecos();
    }
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluirEndereco(@PathVariable Long id) {

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
