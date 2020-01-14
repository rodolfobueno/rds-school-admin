package br.com.rdschool.admin.turma.application;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rdschool.admin.amqp.RDSPublisher;
import br.com.rdschool.admin.turma.amqp.events.TurmaCriadaEvent;
import br.com.rdschool.admin.turma.domain.model.Turma;
import br.com.rdschool.admin.turma.domain.model.TurmaDomainRepository;
import br.com.rdschool.admin.turma.domain.model.TurmaId;

@Service
@Transactional
public class TurmaApplicationService {

	@Autowired
	private TurmaDomainRepository turmaRepository;
	
	@Autowired
	private RDSPublisher publisher;
	
	public TurmaId handle(final CriarTurmaCommand cmd) {
		
		Turma turma = Turma.builder()
				.id(TurmaId.generate())
				.descricao(cmd.getDescricao())
				.anoLetivo(cmd.getAnoLetivo())
				.periodoLetivo(cmd.getPeriodoLetivo())
				.numeroVagas(cmd.getNumeroVagas())
				.build();
		
		//if (this.ajudanteRepository.checkIfExistsByCpf(cmd.getCpf().getNumero()))
			//throw new YMSCpfDoAjudanteDuplicadoException(cmd.getCpf().getNumero());
		
		this.turmaRepository.insert(turma);
		
		publisher.publish(TurmaCriadaEvent
								.builder()
								.turmaId(turma.getId().toString())
								.descricao(turma.getDescricao())
								.anoLetivo(turma.getAnoLetivo())
								.periodoLetivo(turma.getPeriodoLetivo())
								.numeroVagas(turma.getNumeroVagas())
								.alunosId(turma.getAlunosId())
								.disciplinasId(turma.getDisciplinasId())
								.build());
		
		return turma.getId();
	}
}
