package JPA;

import JPA.entity.Tarefa;
import JPA.repository.TarefaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class JpaApplicationTests {

	@Autowired
	private TarefaRepository tarefaRepository;

	@Test
	void contextLoads() {
		// Testa se o contexto do Spring foi carregado corretamente
	}

	@Test
	void testarInsercaoTarefa() {
		Tarefa tarefa = new Tarefa();
		tarefa.setTitulo("Teste de Tarefa");
		tarefa.setDescricao("Descrição da tarefa de teste");
		tarefa.setDataPrevistaFinalizacao(LocalDate.now().plusDays(7));

		Tarefa tarefaSalva = tarefaRepository.save(tarefa);

		assertNotNull(tarefaSalva.getId());
	}
}
