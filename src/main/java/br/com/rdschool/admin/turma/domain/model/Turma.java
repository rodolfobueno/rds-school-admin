package br.com.rdschool.admin.turma.domain.model;

import javax.validation.constraints.NotNull;

import com.totvs.tjf.core.stereotype.Aggregate;
import com.totvs.tjf.core.stereotype.AggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Aggregate
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Turma {

	@NotNull
	@AggregateIdentifier
	private TurmaId id;
	@NotNull
	private String nome;
	@NotNull
	private Integer anoLetivo;
	@NotNull
	private Integer periodoLetivo;
	@NotNull
	private Integer numeroVagas;

}
