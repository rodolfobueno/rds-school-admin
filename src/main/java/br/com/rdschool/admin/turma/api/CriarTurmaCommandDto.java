package br.com.rdschool.admin.turma.api;

import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CriarTurmaCommandDto {

	@NotNull(message = "{CriarTurmaCommandDto.descricao.NotNull}")
	@Size(min = 8, max = 160, message = "{CriarTurmaCommandDto.descricao.Size}")
	private String descricao;

	@NotNull(message = "{CriarTurmaCommandDto.anoLetivo.NotNull}")
	private Integer anoLetivo;

	@NotNull(message = "{CriarTurmaCommandDto.periodoLetivo.NotNull}")
	private Integer periodoLetivo;

	@NotNull(message = "{CriarTurmaCommandDto.numeroVagas.NotNull}")
	private Integer numeroVagas;
	
	private Set<String> alunosId;
	
	private Set<String> disciplinasId;

}
