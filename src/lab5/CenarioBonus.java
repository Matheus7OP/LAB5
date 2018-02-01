package lab5;

/**
 * Classe que representa um cenário com
 * bônus no sistema.
 * 
 * @author Matheus Oliveira Pereira
 */
public class CenarioBonus extends Cenario {
	private int bonus;
	
	/**
	 * Construtor do objeto CenarioBonus.
	 * 
	 * @param descricao a descricao do cenario
	 * @param id o id do cenario
	 * @param bonus o bonus do cenario
	 */
	public CenarioBonus(String descricao, int id, int bonus) {
		super(descricao, id);
		
		if(bonus < 0) {
			throw new IllegalArgumentException("O valor do bônus não pode ser negativo");
		}
		
		this.temBonus = true;
		this.bonus = bonus;
	}
	
	/**
	 * Retorna o bônus do cenário.
	 * 
	 * @return o bonus do cenário
	 */
	public int getBonus() {
		return this.bonus;
	}
	
	@Override
	public String toString() {
		String info = super.toString() + " - " + this.bonus;
		return info;
	}
}
