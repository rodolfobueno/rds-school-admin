package br.com.rdschool.admin.disciplina.domain.model;

import java.util.UUID;

import org.springframework.util.Assert;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@Getter
@NoArgsConstructor
public class DisciplinaId {
	
	private UUID id;

	private DisciplinaId(UUID id) {
		Assert.notNull(id, "Id should not be null.");
		this.id = id;
	}
	
	public static DisciplinaId generate() {
		return new DisciplinaId(UUID.randomUUID());
	}
	
	public static DisciplinaId fromString(String value) {
		return new DisciplinaId(UUID.fromString(value));
	}
	
	@Override
	public String toString() {
		return id.toString();
	}
}
