package commonLibs.contracts;

public interface AlertHandler {

	public void acceptAlert() throws Exception;
	
	public void rejectAlert() throws Exception;
	
	public void getMessageFromAlert() throws Exception;
}
