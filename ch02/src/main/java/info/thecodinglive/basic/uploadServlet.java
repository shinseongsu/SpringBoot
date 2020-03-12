package main.java.info.thecodinglive.basic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(urlPatterns = "/upload", name = "uploadServlet")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 2,
		maxFileSize = 1024 * 1024 * 10,
		maxRequestSize = 1024 * 1024 * 50,
		location = "/Users/mac/Desktop/springboot/ch02/src/upload"
)
public class uploadServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		final String path = request.getParameter("destination");
		final Part filePart = request.getPart("file");
		final String fileName = getFileName(filePart);
		final PrintWriter writer = response.getWriter();
		
		try (OutputStream out = new FileOutputStream(new File(path + File.separator + fileName));
			 InputStream filecontent = filePart.getInputStream()) {
			
			int read = 0;
			final byte[] bytes = new byte[1024];
			
			while((read = filecontent.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			
			writer.print("new File: " + fileName + path + "에 생성되었습니다.");
			
		} catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}	
	}
	
	private String getFileName(final Part part) {
		
		final String partHeader = part.getHeader("content-disposition");
		System.out.println("Part Header = {0}" + partHeader);
		
		for(String content : part.getHeader("content-disposition").split(";")) {
			if(content.trim().startsWith("filename")) {
				return content.substring(
						content.indexOf("=") +1).trim().replace("\"", "");
			}
		}
		return null;	
	}
	
	
}
