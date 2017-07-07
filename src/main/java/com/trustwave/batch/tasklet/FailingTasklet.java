/* 
 * $Id: FailingTasklet.java 1710175 2017-07-07 03:26:25Z churd $
 * $Revision: 1710175 $
 * $Author: churd $
 * $Date: 2017-07-06 23:26:25 -0400 (Thu, 06 Jul 2017) $
 * Copyright (c) 2016 Trustwave Holdings, Inc.
 * All Rights Reserved.
 *
 * This software is the confidential and proprietary information
 * of Trustwave Holdings, Inc.  Use of this software is governed by
 * the terms and conditions of the license statement and limited
 * warranty furnished with the software.
 *
 * IN PARTICULAR, YOU WILL INDEMNIFY AND HOLD TRUSTWAVE HOLDINGS INC.,
 * ITS RELATED COMPANIES AND ITS SUPPLIERS, HARMLESS FROM AND AGAINST
 * ANY CLAIMS OR LIABILITIES ARISING OUT OF OR RESULTING FROM THE USE,
 * MODIFICATION, OR DISTRIBUTION OF PROGRAMS OR FILES CREATED FROM,
 * BASED ON, AND/OR DERIVED FROM THIS SOURCE CODE FILE.
 * 
 */
package com.trustwave.batch.tasklet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class FailingTasklet implements Tasklet {
    
    private static final Logger _log = LoggerFactory.getLogger(FailingTasklet.class);
    
    private final boolean _fail;
    
    public FailingTasklet(String fail) {
        super();
        _fail = Boolean.TRUE.toString().equals(fail);
    }
    
    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        
        _log.info("Fail? {}", _fail);
        
        if (_fail) {
            throw new RuntimeException("Something went wrong");
        }
        
        return RepeatStatus.FINISHED;
    }
}
