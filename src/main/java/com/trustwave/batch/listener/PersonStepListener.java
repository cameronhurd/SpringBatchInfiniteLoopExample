package com.trustwave.batch.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ExecutionContext;

public class PersonStepListener implements StepExecutionListener {
    
    private final Logger _log = LoggerFactory.getLogger(PersonStepListener.class);
 
    private static final String REPITITIONS_LEFT = "repititionsLeft";
    
    @Override
    public void beforeStep(StepExecution stepExecution) {
        String loadDate = stepExecution.getJobParameters().getString("loadDate");
        _log.info("Before Step, load date parameter {}", loadDate);
    }
    
    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        Long repititions = stepExecution.getJobParameters().getLong("repititions");
        _log.info("After Step, repititions parameter {}", repititions);
        
        ExecutionContext jobExecutionContext = stepExecution.getJobExecution().getExecutionContext();
        Long repititionsLeft = jobExecutionContext.getLong(REPITITIONS_LEFT, repititions);
        
        jobExecutionContext.put(REPITITIONS_LEFT, --repititionsLeft);
        
        return repititionsLeft > 0 ? new ExitStatus("CONTINUE") : new ExitStatus("COMPLETED");
    }
}
