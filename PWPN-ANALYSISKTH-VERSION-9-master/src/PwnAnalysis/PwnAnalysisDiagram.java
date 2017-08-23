package PwnAnalysis;

/**
 * Created by Ayettey on 26/04/2017.
 */
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;

public class PwnAnalysisDiagram extends JPanel {
    private String title;
    private int attackMinute;
    private int attackHours;

    public void setAttackHours(int attackHours) {
        this.attackHours = attackHours;
    }

    public void setAttackMinute(int attackMinute) {
        this.attackMinute = attackMinute;
    }

    public int getAttackHours() {
        return attackHours;
    }

    public int getAttackMinute() {
        return attackMinute;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }


    public PwnAnalysisDiagram(){


    }
    public PwnAnalysisDiagram(String title,String chartTitle) {

        JFreeChart lineChart = ChartFactory.createLineChart(
                chartTitle,
                "Attack Minutes","Attack Hours",
                createDataset(),
                PlotOrientation.VERTICAL,
                true,true,false);

        ChartPanel chartPanel = new ChartPanel( lineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 300 , 200 ) );
        chartPanel.getChart().getPlot().setBackgroundPaint(new Color(0x0EA6BA));
        lineChart.setBackgroundPaint(getBackground());

        add( chartPanel );
    }
    public ChartPanel createLineDiagram(String title,String chartTitle){


        JFreeChart lineChart = ChartFactory.createLineChart(
                "",
                "","",
                createDataset(),
                PlotOrientation.VERTICAL,
                false,false,false);
        lineChart.setBorderVisible(false);
        lineChart.getPlot().setOutlinePaint(Color.CYAN);
        lineChart.getCategoryPlot().setOutlinePaint(Color.YELLOW);
        lineChart.getCategoryPlot().getDomainAxis().setAxisLinePaint(new Color(0x21BA55));

        lineChart.setBackgroundPaint(getBackground());
        lineChart.getCategoryPlot().getDomainAxis( ).setMaximumCategoryLabelLines(50);


        ChartPanel chartPanel = new ChartPanel(lineChart,300,70,0,0,300,70,true,true,true,true,true,true);

        chartPanel.getChart().getPlot().setBackgroundPaint(new Color(0xEFF6EC));
        //chartPanel.setPreferredSize(new Dimension(400,58));




       return chartPanel;


    }


    public ChartPanel createLineDiagram2(String title,String chartTitle){


        JFreeChart lineChart = ChartFactory.createLineChart(
                "",
                "","",
                createDataset(),
                PlotOrientation.VERTICAL,
                false,false,false);
        lineChart.setBorderVisible(false);
        lineChart.getPlot().setOutlinePaint(Color.CYAN);
        lineChart.getCategoryPlot().setOutlinePaint(Color.YELLOW);
        lineChart.getCategoryPlot().getDomainAxis().setAxisLinePaint(new Color(0x21BA55));

        lineChart.setBackgroundPaint(getBackground());
        lineChart.getCategoryPlot().getDomainAxis( ).setMaximumCategoryLabelLines(50);


        ChartPanel chartPanel = new ChartPanel(lineChart,600,300,0,0,600,300,true,true,true,true,true,true);

        chartPanel.getChart().getPlot().setBackgroundPaint(new Color(0xEFF6EC));
        //chartPanel.setPreferredSize(new Dimension(400,58));




        return chartPanel;


    }

    public DefaultCategoryDataset createDataset(){

        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );

        dataset.addValue( 1 , " " , "1" );
        dataset.addValue( 2 , "" , "30" );
        dataset.addValue( 3 , "" ,  "10" );
        dataset.addValue( 4 , "" , "21" );
        dataset.addValue( 4 , "" , "50" );
        dataset.addValue( 6 , "" , "20" );

        return dataset;

    }



}
