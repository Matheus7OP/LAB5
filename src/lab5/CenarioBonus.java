package lab5;

/**
 * Classe que representa um cenário com
 * bônus no sistema.
 * 
 * @author Matheus Oliveira Pereira
 */
public class CenarioBonus extends Cenario {
	/**
	 * Construtor do objeto CenarioBonus.
	 * 
	 * @param descricao a descricao do cenario
	 * @param id o id do cenario
	 * @param bonus o bonus do cenario
	 */
	public CenarioBonus(String descricao, int id, int bonus) {
		super(descricao, id);
		
		if(bonus <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: Bonus invalido");
		}
		
		this.bonus = bonus;
	}
	
	@Override
	public String toString() {
		String info = super.toString();

		double valorReal = ((double) this.bonus) / 100.0;
		info += String.format(" - R$ %.2f", valorReal);
		
		return info;
	}
}
