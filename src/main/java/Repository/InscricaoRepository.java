import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscricaoRepository extends CrudRepository<Inscricao, Long> {
    // Adicione métodos personalizados, se necessário
}
