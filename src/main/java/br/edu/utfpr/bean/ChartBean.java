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
import br.edu.utfpr.model.service.OccurrenceService;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author tnks
 */
@ManagedBean
public class ChartBean implements Serializable {

    private PieChartModel pieModel1;
    private BarChartModel barModel1;
    private List<Occurrence> ocurrencesList;
    private OccurrenceService os = new OccurrenceService();

    @PostConstruct
    public void init() {
        ocurrencesList = new ArrayList<>();

        createChartModels();
    }

    public List<Occurrence> getOcurrencesList() {
        return ocurrencesList;
    }

    public void setOcurrencesList(List<Occurrence> ocurrencesList) {
        this.ocurrencesList = ocurrencesList;
    }

    public PieChartModel getPieModel1() {
        return pieModel1;
    }

    private void createChartModels() {
        createPieModel1();
        createBarModel();
    }

    private void createPieModel1() {
        pieModel1 = new PieChartModel();

        ocurrencesList = os.findAll();
        int resto = 0;
        for (Occurrence occurrence : ocurrencesList) {
            int total = os.getByNeighborhood(occurrence.getNeighborhood().getId()).size();

            String neighborhood = occurrence.getNeighborhood().getName();
            System.out.println("ocorrencia: ------"
                    + "bairro: " + neighborhood + ""
                    + "\n quantidade: " + total);

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

    public BarChartModel getBarModel1() {
        return barModel1;
    }

    private BarChartModel initBarModel() {
        barModel1 = new BarChartModel();
        ocurrencesList = os.findAll();

        for (Occurrence occurrence : ocurrencesList) {
            int total = os.getByNeighborhood(occurrence.getNeighborhood().getId()).size();

            String neighborhood = occurrence.getNeighborhood().getName();
            ChartSeries serie = new ChartSeries();
            serie.set(neighborhood, total);
            barModel1.addSeries(serie);
        }
        return barModel1;
    }

    private void createBarModel() {
        barModel1 = initBarModel();
        barModel1.setTitle("Ocorrências por bairro");
        barModel1.setLegendPosition("ne");

        Axis xAxis = barModel1.getAxis(AxisType.X);
        xAxis.setLabel("Bairros");

        Axis yAxis = barModel1.getAxis(AxisType.Y);
        yAxis.setLabel("Ocorrências");
        yAxis.setMin(1);
        yAxis.setMax(50);

    }

}
