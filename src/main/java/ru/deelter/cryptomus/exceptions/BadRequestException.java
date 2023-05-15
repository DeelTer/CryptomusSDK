package ru.deelter.cryptomus.exceptions;

public class BadRequestException extends RuntimeException {

	public BadRequestException(String response) {
		super(response);
	}

}
