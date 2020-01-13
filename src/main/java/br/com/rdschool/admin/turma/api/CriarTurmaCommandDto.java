package br.com.rdschool.admin.turma.api;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CriarTurmaCommandDto {

	@NotNull(message = "{CriarTurmaCommandDto.nome.NotNull}")
	@Size(min = 8, message = "{CriarAjudanteCommandDto.nome.minSize}")
	private String nome;

	@NotNull(message = "{CriarTurmaCommandDto.anoLetivo.NotNull}")
	private Integer anoLetivo;

	@NotNull(message = "{CriarTurmaCommandDto.periodoLetivo.NotNull}")
	private Integer periodoLetivo;

	@NotNull(message = "{CriarTurmaCommandDto.numeroVagas.NotNull}")
	private Integer numeroVagas;

}
