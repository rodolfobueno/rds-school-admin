package br.com.rdschool.admin.turma.exception;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import com.totvs.tjf.api.context.stereotype.error.ApiBadRequest;

@ApiBadRequest("CriarTurmaException")
public class CriarTurmaException extends ConstraintViolationException {
	
	private static final long serialVersionUID = 7686045486654120992L;

	public CriarTurmaException(Set<? extends ConstraintViolation<?>> constraintViolations) {
		super(constraintViolations);
	}
}

