package main;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;
import net.sourceforge.jFuzzyLogic.rule.Rule;

public class TipperTest {

	public static void main(String[] args) {
		
		FIS fis = FIS.load("src/resource/tipperMandani.fcl", true); // MANDANI
		//FIS fis = FIS.load("src/resource/tipperSingleton.fcl", true); // USANDO SINGLETON
		//FIS fis = FIS.load("src/resource/tipperTS.fcl", true); // TAKAGI-SUGENO
			
		//APRESENTA AS VARIÁVEIS MODELADAS
        JFuzzyChart.get().chart(fis.getFunctionBlock("tipper"));
		
        //SETA AS ENTRADAS
	    fis.setVariable("service", 3);
	    fis.setVariable("food", 7);
	    
	    //AVALIA
	    fis.evaluate();

	    //MOSTRA O GRÁFICO DA VARIÁVEL DE SAÍDA
        Variable tip = fis.getFunctionBlock("tipper").getVariable("tip");
        JFuzzyChart.get().chart(tip, tip.getDefuzzifier(), true);

        //PRINTA VARIÁVEL DE SAÍDA    
        System.out.println(tip.getValue());
        
        //MOSTRA CADA REGRA COM O VALOR DE ATIVAÇÃO
        for( Rule r : fis.getFunctionBlock("tipper").getFuzzyRuleBlock("No1").getRules() )
          System.out.println(r);
	}

}
