package com.control.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.control.entities.Tarefa;
import com.control.services.TarefaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Tarefa")
public class TarefaController {

	private final TarefaService TarefaService;

	@Autowired
	public TarefaController(TarefaService TarefaService) {
		this.TarefaService = TarefaService;
	}

	@GetMapping("/{id}")

	public ResponseEntity<Tarefa> buscaTarefaControlId(@PathVariable Long id) {
		Tarefa Tarefa = TarefaService.getTarefaById(id);
		if (Tarefa != null) {
			return ResponseEntity.ok(Tarefa);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")

	public ResponseEntity<List<Tarefa>> buscaTodasLigacoesControl() {
		List<Tarefa> Tarefa = TarefaService.getAllTarefas();
		return ResponseEntity.ok(Tarefa);
	}

	@PostMapping("/")

	public ResponseEntity<Tarefa> saveTarefaControl(@RequestBody @Valid Tarefa Tarefa) {
		Tarefa saveTarefa = TarefaService.saveTarefa(Tarefa);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveTarefa);
	}

	@PutMapping("/{id}")

	public ResponseEntity<Tarefa> alteraTarefaControl(@PathVariable Long id, @RequestBody @Valid Tarefa Tarefa) {
		Tarefa alteraTarefa = TarefaService.changeTarefa(id, Tarefa);

		if (alteraTarefa != null) {
			return ResponseEntity.ok(Tarefa);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")

	public ResponseEntity<String> deleteTarefaControl(@PathVariable Long id) {
		boolean delete = TarefaService.deleteTarefa(id);
		if (delete) {
			return ResponseEntity.ok().body("O Tarefa foi excluido com o sucesso");
		} else {
			return ResponseEntity.notFound().build();
		}

	}
}
