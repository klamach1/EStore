package com.uciext.springfw.hw.common;



import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyLogger {

    private static Logger logger = Logger.getLogger(MyLogger.class);

	// Generic log methods
	public void logBefore() {
    	logger.info("   Log before");
    }

    public void logAfter() {
    	logger.info("   Log after");
    }
	
    public void logError() {
    	logger.info("   Log error");
    }


    // Log with parameters
    public void logBeforeParam(JoinPoint joinpoint, String param) {
    	logger.info("   Log before " + joinpoint.toString() + " parameter " + param );
    }

    public void logAfterParam(JoinPoint joinpoint, Object object) {
        logger.info("   Log after " + joinpoint.toString() + " returning " + object.toString() );
    }
	
    public void logErrorParam(JoinPoint joinpoint, Exception ex) {
    	logger.info("   Log error Param: " + ex.getMessage());
    }

    public void logAfterParamObject(JoinPoint joinpoint, Object object) {
    	logger.info("   Log after get returned: " + object);
    }
	
    // Log around - execution time in milliseconds
    public void logAroundDuration(ProceedingJoinPoint joinpoint) {
        try { 
        	logger.info("   Log before around");
            long start = System.currentTimeMillis(); 
            joinpoint.proceed(); 
            long end = System.currentTimeMillis(); 
            logger.info("   Log after around: execution took " + (end-start) + " milliseconds");
        } 
        catch (Throwable t) { 
        	logger.info("   Log Error in method: " + t.getMessage()); 
        } 
    }
}
