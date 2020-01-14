package br.com.rdschool.admin.turma.amqp.events;

import java.util.Collection;

import br.com.rdschool.admin.aluno.domain.model.AlunoId;
import br.com.rdschool.admin.disciplina.domain.model.DisciplinaId;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

@Data
@Builder
@ToString
public final class TurmaCriadaEvent {

	public static final transient String NAME = "TurmaCriadaEvent";
	
	@NonNull
	private String turmaId;
	@NonNull
	private String descricao;
	@NonNull
	private Integer numeroVagas;
	@NonNull
	private Integer anoLetivo;
	@NonNull
	private Integer periodoLetivo;
	
	private Collection<AlunoId> alunosId;

	private Collection<DisciplinaId> disciplinasId;
	
}
