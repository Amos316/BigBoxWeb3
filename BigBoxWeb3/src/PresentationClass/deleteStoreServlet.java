package PresentationClass;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BusinessClass.Store;
import DatabaseClass.BigBoxDAO;
import DatabaseClass.BigBoxFactory;

/**
 * Servlet implementation class deleteStoreServlet
 */
@WebServlet("/deleteStoreServlet")
public class deleteStoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/DeleteStores.jsp";
		String storeNum = request.getParameter("StoreNumber");
		BigBoxDAO dao = BigBoxFactory.getBigBoxDAO();
		Store s = new Store();
		s.setStoreNum(storeNum);
		dao.deleteStore(s);
		url = "/DeleteStores.jsp";
		
		getServletContext()
		.getRequestDispatcher(url)
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

}
