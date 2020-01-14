package br.com.rdschool.admin.turma.api;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.totvs.tjf.api.context.stereotype.ApiGuideline;
import com.totvs.tjf.api.context.stereotype.ApiGuideline.ApiGuidelineVersion;
import com.totvs.tjf.core.validation.ValidatorService;

import br.com.rdschool.admin.turma.application.CriarTurmaCommand;
import br.com.rdschool.admin.turma.application.TurmaApplicationService;
import br.com.rdschool.admin.turma.domain.model.TurmaId;
import br.com.rdschool.admin.turma.exception.CriarTurmaException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin
@RestController
@RequestMapping(path = TurmaController.PATH, consumes = { APPLICATION_JSON_VALUE }, produces = { APPLICATION_JSON_VALUE })
@ApiGuideline(ApiGuidelineVersion.v1)
public class TurmaController {
	
	@Autowired
	private ValidatorService validador;
	
	@Autowired
	private TurmaApplicationService service;
	
	public static final String PATH = "/api/v1/turmas";
	
	@ApiOperation(value = "Criar turma.", httpMethod = "POST", consumes = APPLICATION_JSON_VALUE)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Turma criada."),
			@ApiResponse(code = 400, message = "O ajudante não pode ser criado porque está em um estado inválido.") })
	@PostMapping
	ResponseEntity<Void> criar(@RequestBody CriarTurmaCommandDto dto) {

		validador.validate(dto).ifPresent(violations -> {
			throw new CriarTurmaException(violations);
		});

		var cmd = CriarTurmaCommand
				.of(dto.getDescricao(), dto.getAnoLetivo(), dto.getNumeroVagas(), dto.getPeriodoLetivo());


		TurmaId id = service.handle(cmd);

		return ResponseEntity
				.created(ServletUriComponentsBuilder
				         .fromCurrentRequest()
				         .path("/")
				         .path(id.toString())
				         .build().toUri())
				.build();
	}

}
