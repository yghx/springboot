package com.kfit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Angel(QQ:412887952)
 * @version v.0.1
 */
//这个不需要添加.
//@WebServlet(urlPatterns="/myServlet1/*", description="Servlet的说明")
public class MyServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">>>>>>>>>>doGet()<<<<<<<<<<<");
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">>>>>>>>>>doPost()<<<<<<<<<<<");
		//这儿写出的编码没有乱码,说明request这边过来的数据一定
		//此时我们只需要保证浏览器正确解析编码即可,即要设置charset-utf-8
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hello World</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>这是：MyServlet1</h1>");
		out.println("</body>");
		out.println("</html>");
	}
}