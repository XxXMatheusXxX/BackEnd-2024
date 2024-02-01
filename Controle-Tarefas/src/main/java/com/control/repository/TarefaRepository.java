package com.control.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.control.entities.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

}
