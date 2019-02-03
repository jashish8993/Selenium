package Log;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class Log4j {

	static Logger logger=LogManager.getLogger(Log4j.class);
	public static void main(String[] args) {
		BasicConfigurator.configure();
		System.out.println("hello");

		logger.info("info");
		logger.error("error");
		logger.warn("warn");
		logger.fatal("fatal");
		
	}

}
