package com.edercatini.springreview.web.domain;

public enum FederativeUnit {

	AC("AC", "Acre"), AL("AL", "Alagoas"), AM("AM", "Amazonas"), BA("BA", "Bahia"), CE("CE", "Ceará"),
	DF("DF", "Distrito Federal"), ES("ES", "Espírito Santo"), GO("GO", "Goiás"), MA("MA", "Maranhão"),
	MT("MT", "Mato Grosso"), MS("MS", "Mato Grosso do Sul"), MG("MG", "Minas Gerais"), PA("PA", "Pará"),
	PB("PB", "Paraíba"), PR("PR", "Paraná"), PE("PE", "Pernambuco"), PI("PI", "Piauí"), RJ("RJ", "Rio de Janeiro"),
	RN("RN", "Rio Grande do Norte"), RS("RS", "Rio Grande do Sul"), RO("RO", "Rondônia"), RR("RR", "Roraima"),
	SC("SC", "Santa Catarina"), SP("SP", "São Paulo"), SE("SE", "Sergipe"), TO("TO", "Tocantins");

	private String code;

	private String description;

	FederativeUnit(String code, String description) {
		this.setCode(code);
		this.setDescription(description);
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}