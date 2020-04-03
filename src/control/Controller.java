package control;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CommandProcess;



public class Controller extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private Map<String, Object> commandMap = new HashMap<String, Object>();   
	
    public void init(ServletConfig config) throws ServletException {
    	
    	String props = config.getInitParameter("config");
    	Properties pr = new Properties();
    	FileInputStream f = null;
    	
    	try {
    		String configFilePath = config.getServletContext().getRealPath(props);
    		f = new FileInputStream(configFilePath);
    	    pr.load(f);	
    	    
    	} catch(IOException e) {
    		throw new ServletException(e);
    		
    	} finally {
    		if(f != null) try {
    			f.close();
    		} catch(IOException ex) {}
    	}
    	
    	Iterator keylter = pr.keySet().iterator();
    	
    	while(keylter.hasNext()) {
    		String command = (String)keylter.next();
    		String className = pr.getProperty(command);
    		try {
    			Class commandClass = Class.forName(className);
    			Object commandInstance = commandClass.newInstance();
    			commandMap.put(command, commandInstance);
    		}catch (Exception e) {
    			throw new ServletException(e);
    		}
    	}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}

	private void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String view = null;
		CommandProcess com = null;
		try {
			String command = request.getRequestURI();
			command = command.substring(request.getContextPath().length());
			com = (CommandProcess)commandMap.get(command);
			view = com.requestPro(request, response);
		} catch(Throwable e) {
			throw new ServletException(e);
		}
		if (view.startsWith("redirect:")) {
			System.out.println("controller s_url view -> "+view);
			view = view.replace("redirect:", "");
			response.sendRedirect(view);
			return;
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}
}




