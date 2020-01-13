package br.com.rdschool.admin.turma.application;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rdschool.admin.turma.domain.model.Turma;
import br.com.rdschool.admin.turma.domain.model.TurmaDomainRepository;
import br.com.rdschool.admin.turma.domain.model.TurmaId;

@Service
@Transactional
public class TurmaApplicationService {

	@Autowired
	private TurmaDomainRepository turmaRepository;
	
//	@Autowired
//	private YMSPublisher ymsPublisher;
	
	public TurmaId handle(final CriarTurmaCommand cmd) {
		
		Turma ajudante = Turma.builder()
				.id(TurmaId.generate())
				.nome(cmd.getNome())
				.anoLetivo(cmd.getAnoLetivo())
				.periodoLetivo(cmd.getPeriodoLetivo())
				.numeroVagas(cmd.getNumeroVagas())
				.build();
		
		//if (this.ajudanteRepository.checkIfExistsByCpf(cmd.getCpf().getNumero()))
			//throw new YMSCpfDoAjudanteDuplicadoException(cmd.getCpf().getNumero());
		
		this.turmaRepository.insert(ajudante);
		
//		ymsPublisher.publish(AjudanteCriadoEvent
//								.builder()
//								.ajudanteId(ajudante.getId().toString())
//								.nome(ajudante.getNome())
//								.cpf(ajudante.getCpf().getNumero())
//								.arquivoCpf(ajudante.getCpf().getArquivo())
//								.build());
		
		return ajudante.getId();
	}
}
