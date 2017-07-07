/* 
 * $Id: ProcessMultipleStagedFilesIT.java 1681713 2016-10-11 17:45:24Z churd $
 * $Revision: 1681713 $
 * $Author: churd $
 * $Date: 2016-10-11 13:45:24 -0400 (Tue, 11 Oct 2016) $
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
 */
package com.trustwave.batch;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/datasource.xml", 
                                   "classpath:spring/job.xml",
                                   "classpath:spring/test-config.xml"})
public class BatchJobTest {
    
    @Resource(name="personJobTestUtils")
    private JobLauncherTestUtils _jobTestUtils;
    
    @Test
    public void testLoadPersons() throws Exception {
        
        // Seems to work half the time because bug requires start time second to match for two step executions 
        // so run the test a few times
        for (long i=0; i<10; i++) {
            JobExecution execution = _jobTestUtils.launchJob(_getJobParameters("2016-10-17", i, true, 2L));
            assertEquals(ExitStatus.FAILED, execution.getExitStatus());
            
            execution = _jobTestUtils.launchJob(_getJobParameters("2016-10-17", i, false, 2L));
            assertEquals(ExitStatus.COMPLETED, execution.getExitStatus());
        }
    }
    
    private JobParameters _getJobParameters(String loadDate, Long runId, boolean fail, Long repititions) {
        Map<String, JobParameter> parameters = new HashMap<>();
        parameters.put("loadDate", new JobParameter(loadDate));
        parameters.put("runId", new JobParameter(runId));
        parameters.put("fail", new JobParameter(Boolean.toString(fail), false));
        parameters.put("repititions", new JobParameter(repititions, false));
        return new JobParameters(parameters);
    }
}