package service;

import model.Cardapio;
import dao.CardapioDAO;


public class CardapioService {
	CardapioDAO dao = new CardapioDAO();
	
	public int criar(Cardapio cardapio) {
		return dao.criar(cardapio);
	}
	
	public void atualizar(Cardapio cardapio){
		dao.atualizar(cardapio);
	}
	
	public void excluir(int idProduto){
		dao.excluir(idProduto);
	}
	
	public Cardapio carregar(int idProduto){
		return dao.carregar(idProduto);
	}

}
