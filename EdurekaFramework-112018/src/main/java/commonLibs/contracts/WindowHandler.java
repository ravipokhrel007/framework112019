package commonLibs.contracts;

import java.util.Set;

public interface WindowHandler {

	public void switchToAnyWindow(String windowhandle) throws Exception;
	
	public void switchToAnyWindow(int childwindowindex) throws Exception;
	
	public String getWindowHandle() throws Exception;
	
	public Set<String> getWindowHandles() throws Exception;
}
