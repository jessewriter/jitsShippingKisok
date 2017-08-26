package jesseboyd.jitsShipping.calculations;

import java.util.logging.Logger;

public class CalculationBuilderProxy implements JitsCalculator {

	CalculationBuilder calculationBuilder;
	
	Logger log = Logger.getLogger(this.getClass().getName());
	
	public CalculationBuilderProxy(CalculationBuilder calculationBuilder) {
		this.calculationBuilder = calculationBuilder;
	}



	@Override
	public double getCost() {
		log.info("new calculation made in proxy " + calculationBuilder.getCost());
		return calculationBuilder.getCost();
		
	}

}
