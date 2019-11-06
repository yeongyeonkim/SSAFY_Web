package com.ssafy.web;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/life.do")
public class LifeCycleServlet extends HttpServlet {
	public void init() throws ServletException{
		super.init();
		System.out.println("init()");
	}
	
	public void destroy() {
		super.destroy();
		System.out.println("destroy()");
	}
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    	System.out.println("doget()");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.print("<head>");
        out.print("<meta charset='utf-8'>");
        out.print("<title>LifeCycleServlet</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("<h1>안녕 세상</h1>");
        Calendar today = Calendar.getInstance();
        out.print(today.get(Calendar.HOUR));
        out.print(today.get(Calendar.MINUTE));
        out.print("<title>HelloServlet</title>");
        out.print("</body>");
        out.print("</html>");
        out.close();
    }
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}