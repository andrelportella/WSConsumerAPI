package br.com.grupocidade.b2click.ws.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException(String message) {
		super(message);
		System.out
				.println("\n------------------------------------------ERRO------------------------------------------\n"
						+ "Erro: " + message
						+ "\n----------------------------------------------------------------------------------------\n ");
	}
}
