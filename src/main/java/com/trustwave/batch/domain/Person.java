package com.trustwave.batch.domain;

import java.math.BigDecimal;

public class Person {

    private Long _id;
	private String _name;
	private String _party;
	private BigDecimal _income;
	private String _loadDate;
	private Long _runId;
	
	public Long getId() {
        return _id;
    }
	public void setId(Long id) {
        _id = id;
    }
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
    public void setLoadDate(String loadDate) {
        _loadDate = loadDate;
    }
    public String getLoadDate() {
        return _loadDate;
    }
    public void setRunId(Long runId) {
        _runId = runId;
    }
    public Long getRunId() {
        return _runId;
    }
}