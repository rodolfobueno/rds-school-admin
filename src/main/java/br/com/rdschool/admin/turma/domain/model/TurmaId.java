package br.com.rdschool.admin.turma.domain.model;

import java.util.UUID;

import org.springframework.util.Assert;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@Getter
@NoArgsConstructor
public class TurmaId {
	
	private UUID id;

	private TurmaId(UUID id) {
		Assert.notNull(id, "Id should not be null.");
		this.id = id;
	}
	
	public static TurmaId generate() {
		return new TurmaId(UUID.randomUUID());
	}
	
	public static TurmaId fromString(String value) {
		return new TurmaId(UUID.fromString(value));
	}
	
	@Override
	public String toString() {
		return id.toString();
	}
}
