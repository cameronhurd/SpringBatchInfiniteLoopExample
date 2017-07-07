package com.trustwave.batch.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.util.Assert;

import com.trustwave.batch.domain.Person;

public class PersonProcessor 
    implements ItemProcessor<com.trustwave.batch.model.Person, Person> {
    
    private final Logger _log = LoggerFactory.getLogger(PersonProcessor.class);
    
    private final String _loadDate;
    private final Long _runId;
    
    public PersonProcessor(String loadDate, Long runId) {
        super();
        Assert.notNull(loadDate, "Load date cannot be null");
        Assert.notNull(runId, "Run ID cannot be null");
        
        _loadDate = loadDate;
        _runId = runId;
    }
    
    @Override
    public Person process(com.trustwave.batch.model.Person person) throws Exception {
        
        _log.info("Load Date {}, processing person with name {}", _loadDate, person.getName());
        
        Person personDomain = new Person();
        personDomain.setName(person.getName());
        personDomain.setParty(person.getParty());
        personDomain.setIncome(person.getIncome());
        personDomain.setLoadDate(_loadDate);
        personDomain.setRunId(_runId);
        return personDomain;
    }

}
