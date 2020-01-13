package br.com.rdschool.admin.turma.domain.model;

import com.totvs.tjf.repository.aggregate.AggregateRepository;

public interface TurmaDomainRepository extends AggregateRepository<Turma, String> {
	
}