package info.thecodinglive.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/delcookie")
public class CookieDeleteServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println("<html><head><title> cookie 삭제 </title></head>");
		out.println("<body>");
		
		Cookie[] cookies = req.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				Cookie deleteCookie = new Cookie("jpub", "");
				deleteCookie.setMaxAge(0);
				resp.addCookie(deleteCookie);
			}
		}
		
		out.println("<a href='/readcookie'>readcookie</a></body></html>");
	}

}
