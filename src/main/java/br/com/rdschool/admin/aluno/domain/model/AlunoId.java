package br.com.rdschool.admin.aluno.domain.model;

import java.util.UUID;

import org.springframework.util.Assert;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@Getter
@NoArgsConstructor
public class AlunoId {
	
	private UUID id;

	private AlunoId(UUID id) {
		Assert.notNull(id, "Id should not be null.");
		this.id = id;
	}
	
	public static AlunoId generate() {
		return new AlunoId(UUID.randomUUID());
	}
	
	public static AlunoId fromString(String value) {
		return new AlunoId(UUID.fromString(value));
	}
	
	@Override
	public String toString() {
		return id.toString();
	}
}
