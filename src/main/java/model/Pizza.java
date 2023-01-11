package model;

public class Pizza {
	
	private int idPizza;
	private String saborPizza;
	private Double precoPizza;
	private String ingredientePizza;
	
	public Pizza() {
		super();
	}

	public Pizza(int idPizza, String saborPizza, Double precoPizza, String ingredientePizza) {
		super();
		this.idPizza = idPizza;
		this.saborPizza = saborPizza;
		this.precoPizza = precoPizza;
		this.ingredientePizza = ingredientePizza;
	}


	public int getIdPizza() {
		return idPizza;
	}

	public void setIdPizza(int idPizza) {
		this.idPizza = idPizza;
	}

	public String getSaborPizza() {
		return saborPizza;
	}

	public void setSaborPizza(String saborPizza) {
		this.saborPizza = saborPizza;
	}

	public Double getPrecoPizza() {
		return precoPizza;
	}

	public void setPrecoPizza(Double precoPizza) {
		this.precoPizza = precoPizza;
	}

	public String getIngredientePizza() {
		return ingredientePizza;
	}

	public void setIngredientePizza(String ingredientePizza) {
		this.ingredientePizza = ingredientePizza;
	}
	
}
