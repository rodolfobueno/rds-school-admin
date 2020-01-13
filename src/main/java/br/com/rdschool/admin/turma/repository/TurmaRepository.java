package br.com.rdschool.admin.turma.repository;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.totvs.tjf.repository.aggregate.CrudAggregateRepository;

import br.com.rdschool.admin.turma.domain.model.Turma;
import br.com.rdschool.admin.turma.domain.model.TurmaDomainRepository;

@Repository
public class TurmaRepository extends CrudAggregateRepository<Turma, String> implements TurmaDomainRepository {

	public TurmaRepository(EntityManager em, ObjectMapper mapper) {
		super(em, mapper.copy());
	}

	protected String getTableName() {
		return "turma";
	}

}
