package com.trustwave.batch.model;

import java.math.BigDecimal;

public class Person {

	private String _name;
	private String _party;
	private BigDecimal _income;
	
    public String getName() {
        return _name;
    }
    public void setName(String name) {
        _name = name;
    }
    public String getParty() {
        return _party;
    }
    public void setParty(String party) {
        _party = party;
    }
    public BigDecimal getIncome() {
        return _income;
    }
    public void setIncome(BigDecimal income) {
        _income = income;
    }
}