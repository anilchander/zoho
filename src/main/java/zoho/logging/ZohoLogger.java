package zoho.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ZohoLogger {
	private Logger logger = null;
	public ZohoLogger(Object obj) {
		this.logger = LogManager.getLogger(obj.getClass().getSimpleName());
	}
	
	public void logInfo(String message) {
		this.logger.info(message);
	}
	
	public void logWarning(String message) {
		this.logger.warn(message);
	}
	
	public void logFatal(String message) {
		this.logger.fatal(message);
	}

}
