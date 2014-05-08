
package br.com.sgce.entity;

public enum TipoFuncionario {
    
    PROFESSOR("Professor"),
    SECRETARIA("Secretaria"),
    GESTOR("Gestor");
    
    private String descricao;

	   TipoFuncionario(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
    
}
