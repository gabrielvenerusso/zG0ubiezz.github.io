package JPA.service;

import JPA.entity.Tarefa;
import JPA.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public Tarefa salvarTarefa(Tarefa tarefa) {
        if (tarefa.getTitulo().length() < 5) {
            throw new IllegalArgumentException("O título deve ter pelo menos 5 caracteres.");
        }
        if (tarefa.getDataPrevistaFinalizacao() == null) {
            throw new IllegalArgumentException("Data prevista de finalização é obrigatória.");
        }
        return tarefaRepository.save(tarefa);
    }

    public List<Tarefa> listarTodasTarefas() {
        return tarefaRepository.findAll();
    }

    public Optional<Tarefa> buscarPorId(Long id) {
        return tarefaRepository.findById(id);
    }

    public Tarefa atualizarTarefa(Long id, Tarefa tarefa) {
        Optional<Tarefa> tarefaExistente = tarefaRepository.findById(id);
        if (tarefaExistente.isPresent() && !tarefaExistente.get().isFinalizado()) {
            tarefa.setId(id);
            return tarefaRepository.save(tarefa);
        } else {
            throw new IllegalArgumentException("Não é possível modificar uma tarefa finalizada.");
        }
    }

    public List<Tarefa> listarTarefasNaoFinalizadas() {
        return tarefaRepository.findByFinalizado(false);
    }

    public List<Tarefa> listarTarefasFinalizadas() {
        return tarefaRepository.findByFinalizado(true);
    }

    public List<Tarefa> listarTarefasAtrasadas() {
        return tarefaRepository.findByDataPrevistaFinalizacaoBeforeAndFinalizado(LocalDate.now(), false);
    }

    public List<Tarefa> listarTarefasNaoFinalizadasEntreDatas(LocalDate inicio, LocalDate fim) {
        return tarefaRepository.findByFinalizadoAndDataPrevistaFinalizacaoBetween(false, inicio, fim);
    }

    public void deletarTarefa(Long id) {
        Tarefa tarefa = tarefaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Tarefa não encontrada."));
        if (!tarefa.isFinalizado()) {
            tarefaRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Não é possível excluir uma tarefa finalizada.");
        }
    }

    public Tarefa finalizarTarefa(Long id) {
        Tarefa tarefa = tarefaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Tarefa não encontrada."));
        tarefa.setFinalizado(true);
        tarefa.setDataFinalizacao(LocalDate.now());
        return tarefaRepository.save(tarefa);
    }
}
