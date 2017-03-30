

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cardapio;
import service.CardapioService;

/**
 * Servlet implementation class CrudCardapioServlet
 */
@WebServlet("/crudCardapio")
public class CrudCardapioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CrudCardapioServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idProduto = Integer.parseInt(request.getParameter("idProduto"));
		String nomeProduto = request.getParameter( "nomeProduto" );
		String descProduto = request.getParameter( "descProduto" );
		double valorProduto = Double.parseDouble(request.getParameter( "valorProduto" ));
		String dispProduto = request.getParameter( "dispProduto" );
		
		Cardapio cardapio = new Cardapio();
		cardapio.setIdProduto(idProduto);
		cardapio.setNomeProduto(nomeProduto);
		cardapio.setDescProduto(descProduto);
		cardapio.setValorProduto(valorProduto);
		cardapio.setDispProduto(dispProduto);
		
		CardapioService service = new CardapioService();
		service.criar(cardapio);
		cardapio = service.carregar(cardapio.getIdProduto());
		
		request.setAttribute("cardapio", cardapio);
		
		RequestDispatcher view = request.getRequestDispatcher("Cardapio.jsp");
		view.forward(request, response);
		
	}

}
