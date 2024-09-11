package JPA.controller;

import JPA.entity.Tarefa;
import JPA.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    public Tarefa criarTarefa(@RequestBody Tarefa tarefa) {
        return tarefaService.salvarTarefa(tarefa);
    }

    @GetMapping
    public List<Tarefa> listarTodasTarefas() {
        return tarefaService.listarTodasTarefas();
    }

    @GetMapping("/{id}")
    public Tarefa buscarTarefaPorId(@PathVariable Long id) {
        return tarefaService.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("Tarefa não encontrada."));
    }

    @PutMapping("/{id}")
    public Tarefa atualizarTarefa(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        return tarefaService.atualizarTarefa(id, tarefa);
    }

    @GetMapping("/nao-finalizadas")
    public List<Tarefa> listarTarefasNaoFinalizadas() {
        return tarefaService.listarTarefasNaoFinalizadas();
    }

    @GetMapping("/finalizadas")
    public List<Tarefa> listarTarefasFinalizadas() {
        return tarefaService.listarTarefasFinalizadas();
    }

    @DeleteMapping("/{id}")
    public void deletarTarefa(@PathVariable Long id) {
        tarefaService.deletarTarefa(id);
    }

    @GetMapping("/atrasadas")
    public List<Tarefa> listarTarefasAtrasadas() {
        return tarefaService.listarTarefasAtrasadas();
    }

    @GetMapping("/nao-finalizadas-entre-datas")
    public List<Tarefa> listarTarefasNaoFinalizadasEntreDatas(@RequestParam("inicio") LocalDate inicio, @RequestParam("fim") LocalDate fim) {
        return tarefaService.listarTarefasNaoFinalizadasEntreDatas(inicio, fim);
    }

    @PutMapping("/finalizar/{id}")
    public Tarefa finalizarTarefa(@PathVariable Long id) {
        return tarefaService.finalizarTarefa(id);
    }
}
