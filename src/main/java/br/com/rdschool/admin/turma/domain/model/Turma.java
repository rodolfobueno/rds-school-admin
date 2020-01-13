package br.com.rdschool.admin.turma.domain.model;

import static br.com.rdschool.admin.shared.util.CollectionUtils.unmodifiableNullSafe;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotNull;

import com.totvs.tjf.core.stereotype.Aggregate;
import com.totvs.tjf.core.stereotype.AggregateIdentifier;

import br.com.rdschool.admin.aluno.domain.model.AlunoId;
import br.com.rdschool.admin.disciplina.domain.model.DisciplinaId;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Aggregate
@NoArgsConstructor
public class Turma {

	@NotNull
	@AggregateIdentifier
	private TurmaId id;

	private String nome;
	private Integer anoLetivo;
	private Integer periodoLetivo;
	private Integer numeroVagas;
	private Collection<AlunoId> alunosId = new HashSet<>();
	private Collection<DisciplinaId> disciplinasId = new HashSet<>();

	@Builder
	public Turma(@NotNull TurmaId id, 
			@NotNull String nome, 
			@NotNull Integer anoLetivo, 
			@NotNull Integer periodoLetivo,
			@NotNull Integer numeroVagas, 
			Set<AlunoId> alunosId, 
			Set<DisciplinaId> disciplinasId) {
		super();
		this.id = id;
		this.nome = nome;
		this.anoLetivo = anoLetivo;
		this.periodoLetivo = periodoLetivo;
		this.numeroVagas = numeroVagas;
		this.alunosId = unmodifiableNullSafe(alunosId);
		this.disciplinasId = unmodifiableNullSafe(disciplinasId);
	}

}
