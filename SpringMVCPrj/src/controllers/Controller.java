package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	public String execute(HttpServletRequest request
			, HttpServletResponse response)
					throws ClassNotFoundException, 
								SQLException, 
								ServletException, 
								IOException;
}
