package sample.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloSample
 */
@WebServlet("/HelloSample")
public class HelloSample extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloSample() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	    // JSPに適当な文字列を渡す
		request.setAttribute("foo", "bar");
	    String name = (String) request.getAttribute("userName");
		if (name == null || "".equals(name)) {
	        request.setAttribute("userName", "Guest");
	    }

	    String view = "/WEB-INF/view/index.jsp";
	    RequestDispatcher dispatcher = request.getRequestDispatcher(view);
	    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    // formから値を取得
	    // 文字コードの指定
	    request.setCharacterEncoding("utf-8");

	    String name = request.getParameter("name");
	    //String name = new String(request.getParameter("name").getBytes("ISO-8859-1"), "UTF-8");
	    request.setAttribute("userName", name);

	    //String value = request.getParameter("name");
	    System.out.println(name);

		doGet(request, response);
	}

}
