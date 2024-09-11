package JPA.repository;

import JPA.entity.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    List<Tarefa> findByFinalizado(boolean finalizado);
    List<Tarefa> findByDataPrevistaFinalizacaoBeforeAndFinalizado(LocalDate data, boolean finalizado);
    List<Tarefa> findByFinalizadoAndDataPrevistaFinalizacaoBetween(boolean finalizado, LocalDate inicio, LocalDate fim);
}
