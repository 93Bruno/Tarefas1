

import java.io.IOException;
import java.io.PrintWriter;

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
		Cardapio cardapio = new Cardapio (idProduto, nomeProduto, descProduto, valorProduto, dispProduto);
		String oQueFazer = request.getParameter( "oQueFazer" );
		CardapioService service = new CardapioService( );
		PrintWriter out = (PrintWriter) response.getWriter( );
		
		switch (oQueFazer) {
		case "Cadastrar" :
			service.criar(cardapio);
			((java.io.PrintWriter) out).println( " <html> <body> " + cardapio.getNomeProduto() + " <p> Cadastrado com sucesso!</p></body> </html>" );
			break;
		case "Consultar" :
			cardapio = service.carregar(cardapio.getIdProduto());
			((java.io.PrintWriter) out).println( " <html> <body> " + cardapio.getIdProduto() + "-"+ cardapio.getNomeProduto() + "-" + cardapio.getDescProduto() + "-" + cardapio.getValorProduto() + "-" + cardapio.getDispProduto() + " <p> Consulta realizada com sucesso</p></body> </html>" );
			break;
		case "Remover" :
			service.excluir(cardapio.getIdProduto());
			((java.io.PrintWriter) out).println( " <html> <body> " + cardapio.getIdProduto() + "-"+ cardapio.getNomeProduto() + " <p> Excluido com sucesso!</p></body> </html>" );
			break;
		case "Atualizar" :
			service.atualizar(cardapio);
			((java.io.PrintWriter) out).println( " <html> <body> " + cardapio.getIdProduto() + "-"+ cardapio.getNomeProduto() + " <p> Atualizado com sucesso!</p></body> </html>" );
			break;
		}
		/*@SuppressWarnings("unchecked")
		
		((java.io.PrintWriter) out).println( " <html> <body> " + cardapio.getNomeProduto () + "</body> </html>" );*/
	}

}
