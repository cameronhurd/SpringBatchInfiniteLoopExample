-- Add fractional seconds to batch step execution to address bug with identical start times for repeated step
alter table BATCH_STEP_EXECUTION modify column start_time datetime(6);
alter table BATCH_STEP_EXECUTION modify column end_time datetime(6);
alter table BATCH_STEP_EXECUTION modify column last_updated datetime(6);