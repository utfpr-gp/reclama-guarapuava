/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.bean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import br.edu.utfpr.model.Occurrence;
import br.edu.utfpr.model.Category;
import br.edu.utfpr.model.service.CategoryService;
import br.edu.utfpr.model.service.OccurrenceService;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;

import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author tnks
 */
@ManagedBean
public class ChartBean implements Serializable {

    private PieChartModel pieModel1;
    private BarChartModel barModel1; // Ocorrencias por Bairro
    private BarChartModel barModel2; // Ocorrencias por Categoria
    private BarChartModel barModel3; // Ocorrencias por Status
    private List<Occurrence> ocurrencesList;
    private OccurrenceService os = new OccurrenceService();
    private CategoryService cs = new CategoryService();
    List<Category> categoryList = new ArrayList<Category>();

    @PostConstruct
    public void init() {
        ocurrencesList = new ArrayList<>();

        createChartModels();
    }

    public List<Occurrence> getOcurrencesList() {
        return ocurrencesList;
    }

    public PieChartModel getPieModel1() {
        return pieModel1;
    }

    public BarChartModel getBarModel1() {
        return barModel1;
    }

    public BarChartModel getBarModel2() {
        return barModel2;
    }

    public BarChartModel getBarModel3() {
        return barModel3;
    }

    private void createChartModels() {
        createPieModel1();

        createBarModel1();
        createBarModel2();
        createBarModel3();
    }

    private void createPieModel1() {
        pieModel1 = new PieChartModel();

        ocurrencesList = os.findAll();
        int resto = 0;
        for (Occurrence occurrence : ocurrencesList) {
            int total = os.getByNeighborhood(occurrence.getNeighborhood().getId()).size();

            String neighborhood = occurrence.getNeighborhood().getName();
//            System.out.println("ocorrencia: ------"
//                    + "bairro: " + neighborhood + ""
//                    + "\n quantidade: " + total);

            if (total > 0) {
                pieModel1.set(neighborhood, total);
            } else {
                resto += total;
            }
        }
        pieModel1.set("Outros", resto);

        pieModel1.setTitle("Gráfico por Bairro");
        pieModel1.setLegendPosition("w");
    }

    private BarChartModel initBarModel1() {
        barModel1 = new BarChartModel();
        ocurrencesList = os.findAll();
        int total = 0;

        ChartSeries serie = new ChartSeries();
        for (Occurrence occurrence : ocurrencesList) {
            int valor = os.getByNeighborhood(occurrence.getNeighborhood().getId()).size();

            String neighborhood = occurrence.getNeighborhood().getName();
            if (valor > 1) {
                serie.set(neighborhood, valor);

            } else {
                total += valor;
            }
        }

        serie.set("Outros", total);
        barModel1.addSeries(serie);
        return barModel1;
    }

    private BarChartModel initBarModel2() {
        barModel2 = new BarChartModel();

        int total = 0;
        categoryList = cs.findAll();
        ChartSeries serie = new ChartSeries();
        for (Category category : categoryList) {
            String categoria = category.getName();
            int qtd = category.getOccurrences().size();
            if (qtd > 1) {
                serie.set(categoria, qtd);
            } else {
                total += qtd;
            }
        }
        serie.set("Outros", total);
        barModel2.addSeries(serie);
        return barModel2;
    }

    private BarChartModel initBarModel3() {
        barModel3 = new BarChartModel();
        ocurrencesList = os.findAll();
        int soluc = 0;
        int naoSoluc = 0;
        int urgente = 0;
        for (Occurrence occurrence : ocurrencesList) {
            switch (occurrence.getStatus()) {
                case "Solucionado":
                    soluc++;
                    break;
                case "Não Solucionado":
                    naoSoluc++;
                    break;
                case "Urgente":
                    urgente++;
                    break;
            }
        }
        ChartSeries serie = new ChartSeries();
        serie.set("Solucionado", soluc);
        serie.set("Não Solucionado", naoSoluc);
        serie.set("Urgente", urgente);

        barModel3.addSeries(serie);
        return barModel3;

    }

    private void createBarModel1() {
        barModel1 = initBarModel1();
        barModel1.setTitle("Ocorrências por bairro");
        barModel1.setLegendPosition("ne");

        Axis xAxis = barModel1.getAxis(AxisType.X);
        xAxis.setLabel("Bairros");

        Axis yAxis = barModel1.getAxis(AxisType.Y);
        yAxis.setLabel("Ocorrências");
        yAxis.setMin(1);
        yAxis.setMax(10);
    }

    private void createBarModel2() {
        barModel2 = initBarModel2();
        barModel2.setTitle("Ocorrências por Categoria");
        barModel2.setLegendPosition("ne");

        Axis xAxis = barModel2.getAxis(AxisType.X);
        xAxis.setLabel("Categorias");

        Axis yAxis = barModel2.getAxis(AxisType.Y);
        yAxis.setLabel("Ocorrências");
        yAxis.setMin(1);
        yAxis.setMax(10);

    }

    private void createBarModel3() {
        barModel3 = initBarModel3();
        barModel3.setTitle("Ocorrências por Status");
        barModel3.setLegendPosition("ne");

        Axis xAxis = barModel3.getAxis(AxisType.X);
        xAxis.setLabel("Status");

        Axis yAxis = barModel3.getAxis(AxisType.Y);
        yAxis.setLabel("Ocorrências");
        yAxis.setMin(1);
        yAxis.setMax(10);

    }
}
