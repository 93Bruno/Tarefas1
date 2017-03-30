package model;

import java.io.Serializable;

public class CardapioTO implements Serializable {
    private static final long serialVersionUID = 1L;
	private int idProduto;
	private String nomeProduto;
	private String descProduto;
	private double valorProduto;
	private String dispProduto;

	public CardapioTO() {
	}
	
	public CardapioTO(int idProduto, String nomeProduto, String descProduto, double valorProduto, String dispProduto) {
		
		this.idProduto = idProduto;
		this.nomeProduto = nomeProduto;
		this.descProduto = descProduto;
		this.valorProduto = valorProduto;
		this.dispProduto = dispProduto;
	}
   public CardapioTO( String nomeProduto, String descProduto, double valorProduto, String dispProduto) {
		
		this.nomeProduto = nomeProduto;
		this.descProduto = descProduto;
		this.valorProduto = valorProduto;
		this.dispProduto = dispProduto;
		
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getDescProduto() {
		return descProduto;
	}

	public void setDescProduto(String descProduto) {
		this.descProduto = descProduto;
	}

	public double getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(double valorProduto) {
		this.valorProduto = valorProduto;
	}
   
   public String getDispProduto() {
		return dispProduto;
	}

	public void setDispProduto(String dispProduto) {
		this.dispProduto = dispProduto;
	}

	@Override
	public String toString() {
		return "Cardápio [id=" + idProduto + ", Produto=" + nomeProduto + ", Descrição=" + descProduto + ", Valor=" + valorProduto + ",Disponibilidade="+ dispProduto+ "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CardapioTO other = (CardapioTO) obj;
		if (descProduto == null) {
			if (other.descProduto != null)
				return false;
		} else if (!descProduto.equals(other.descProduto))
			return false;
		if (dispProduto == null) {
			if (other.dispProduto != null)
				return false;
		} else if (!dispProduto.equals(other.dispProduto))
			return false;
		if (idProduto != other.idProduto)
			return false;
		if (nomeProduto == null) {
			if (other.nomeProduto != null)
				return false;
		} else if (!nomeProduto.equals(other.nomeProduto))
			return false;
		return true;
	}
}
