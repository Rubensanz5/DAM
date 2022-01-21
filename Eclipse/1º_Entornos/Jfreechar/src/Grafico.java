import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;



public class Grafico {

	public static void main(String[] args) {
		DefaultPieDataset asignaturas = new DefaultPieDataset();
		
		asignaturas.setValue("Programacion", 8);
		asignaturas.setValue("Lenguaje de Marcas", 4);
		asignaturas.setValue("Sistemas Informaticos", 6);
		asignaturas.setValue("Bases de Datos", 6);
		asignaturas.setValue("Entornos de Desarrollo", 3);
		asignaturas.setValue("FOL", 3);
		
		JFreeChart grafico = ChartFactory.createPieChart("DAM", asignaturas, true, true, false);
		
		
		
		ChartFrame frame = new ChartFrame("Ejemplo", grafico);
		frame.pack();
		frame.setVisible(true);
		
		try {
			ChartUtils.saveChartAsPNG(new File("./image.png"), grafico, 300, 300);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

}
