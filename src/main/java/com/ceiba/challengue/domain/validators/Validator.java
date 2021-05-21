package com.ceiba.challengue.domain.validators;

import com.ceiba.challengue.domain.exception.BibliotecBussinesBrokenException;

public class Validator {

	public static void validate(Object value, String message) throws BibliotecBussinesBrokenException {

		if (value == null || value.toString().isEmpty()) {
			throw new BibliotecBussinesBrokenException(message);
		}
	}

}
