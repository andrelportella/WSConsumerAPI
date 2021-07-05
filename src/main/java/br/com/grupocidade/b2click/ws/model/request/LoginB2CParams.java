package br.com.grupocidade.b2click.ws.model.request;

public class LoginB2CParams {

	private String grant_type;
	private String client_id;
	private String username;
	private String password;
	private Integer ambiente;

	public String getGrant_type() {
		return this.grant_type == null ? "password" : grant_type;
	}

	public void setGrant_type(String grant_type) {
		this.grant_type = grant_type;
	}

	public String getClient_id() {
		return client_id;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAmbiente() {
		return ambiente == null ? 1 : ambiente;
	}

	public void setAmbiente(Integer ambiente) {
		this.ambiente = ambiente;
	}

}
