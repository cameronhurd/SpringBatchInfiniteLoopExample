# SpringBatchInfiniteLoopExample

Setup:
Assumes database "test" exists at URL jdbc:mysql://localhost:3306/test with username root and blank password.  
This can be updated in   mysql datasource setup in src/main/resources/spring/datasource.xml.

Run at command line:
mvn test

The single test should enter an infinite loop, so you'll need to kill it.

As a work around to the bug uncomment the line 
  <jdbc:script location="com/trustwave/batch/SpringBatchDateTimeFix.sql" /> 
in src/main/resources/spring/datasource.xml.
