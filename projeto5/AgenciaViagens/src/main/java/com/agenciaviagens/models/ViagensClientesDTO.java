package com.agenciaviagens.models;

public class ViagensClientesDTO {

	
	private Long viagensId;
	
	
	private Long clienteId;
	
	
	private String clienteName;
    private String clienteTelefone;
    private String clienteEmail;


	public Long getViagensId() {
		return viagensId;
	}


	public void setViagensId(Long viagensId) {
		this.viagensId = viagensId;
	}


	public Long getClienteId() {
		return clienteId;
	}


	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}
	
	
	public String getClienteName() {
        return clienteName;
    }

    public void setClienteName(String clienteName) {
        this.clienteName = clienteName;
    }

    public String getClienteTelefone() {
        return clienteTelefone;
    }

    public void setClienteTelefone(String clienteTelefone) {
        this.clienteTelefone = clienteTelefone;
    }

    public String getClienteEmail() {
        return clienteEmail;
    }

    public void setClienteEmail(String clienteEmail) {
        this.clienteEmail = clienteEmail;
    }
	
	
	
	
	
}
