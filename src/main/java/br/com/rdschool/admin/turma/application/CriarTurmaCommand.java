package br.com.rdschool.admin.turma.application;

import java.util.Set;

import lombok.Data;
import lombok.Getter;

@Getter
@Data(staticConstructor = "of")
public final class CriarTurmaCommand {

	private final String descricao;
	private final Integer anoLetivo;
	private final Integer periodoLetivo;
	private final Integer numeroVagas;
	private final Set<String> disciplinasId;
	private final Set<String> alunosId;
}
