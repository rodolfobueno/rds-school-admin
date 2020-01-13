package br.com.rdschool.admin.turma.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import br.com.rdschool.core.TestUtils;

@RunWith(SpringRunner.class)
@ActiveProfiles(profiles = "test")
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class CriarTurmaControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
//	@Autowired
//	private TurmaDomainRepository turmaRepository;

	@Test
	public void deveCriarTurma() throws Exception{
		CriarTurmaCommandDto dto = new CriarTurmaCommandDto(
				"Ajudante test controller", 2020, 1, 1);
		
		this.mockMvc
				.perform(MockMvcRequestBuilders.post(TurmaController.PATH)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(TestUtils.objectToJson(dto)))
				.andExpect(status().is2xxSuccessful());
	}
	
	@Test
	public void naoDeveCriarTurmaComInformacoesDtoNulas() throws Exception {
		CriarTurmaCommandDto dto = new CriarTurmaCommandDto(null, null, null, null);
		
		MvcResult result = this.mockMvc
					.perform(MockMvcRequestBuilders.post(TurmaController.PATH)
					.contentType(MediaType.APPLICATION_JSON_VALUE)
					.content(TestUtils.objectToJson(dto)))
					.andExpect(status().isBadRequest())
					.andReturn();
		
		assertThat(result.getResponse().getContentAsString()).contains("CriarTurmaException");
		assertThat(result.getResponse().getContentAsString()).contains("CriarTurmaCommandDto.nome.NotNull");
		assertThat(result.getResponse().getContentAsString()).contains("CriarTurmaCommandDto.anoLetivo.NotNull");
		assertThat(result.getResponse().getContentAsString()).contains("CriarTurmaCommandDto.numeroVagas.NotNull");
		assertThat(result.getResponse().getContentAsString()).contains("CriarTurmaCommandDto.periodoLetivo.NotNull");
	}
	
	@Test
	public void deveValidarTamanhoMinimoDeNomeAoCriarTurma() throws Exception {
		CriarTurmaCommandDto dto = new CriarTurmaCommandDto("nom", 2012, 1, 1);
		
		MvcResult result = this.mockMvc
					.perform(MockMvcRequestBuilders.post(TurmaController.PATH)
					.contentType(MediaType.APPLICATION_JSON_VALUE)
					.content(TestUtils.objectToJson(dto)))
					.andExpect(status().isBadRequest())
					.andReturn();
		
		assertThat(result.getResponse().getContentAsString()).contains("CriarTurmaException");
		assertThat(result.getResponse().getContentAsString()).contains("CriarTurmaCommandDto.nome.Size");
	}
	
	
}
