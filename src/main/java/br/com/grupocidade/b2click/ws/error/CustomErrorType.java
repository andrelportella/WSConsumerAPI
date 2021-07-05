package br.com.grupocidade.b2click.ws.error;

public class CustomErrorType {
	private String errorMessage;

	public CustomErrorType(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
