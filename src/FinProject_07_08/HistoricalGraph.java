/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FinProject_07_08;

import PairHandlers.EURGBP;
import PairHandlers.EURJPY;
import PairHandlers.EURUSD;
import PairHandlers.GBPJPY;
import PairHandlers.GBPUSD;
import PairHandlers.USDJPY;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleInsets;

/**
 *
 * @author Admin
 */
public class HistoricalGraph {
    public static JFreeChart getHistoricalGraph(DatabaseConnection dbc){
      TimeSeriesCollection dataset= new TimeSeriesCollection();      
      ArrayList<ArrayList<Object>> objects = new EURGBP(dbc).getAllData();
      TimeSeries series1 = new TimeSeries("EURGBP");
      for(int i=0;i<objects.get(0).size();i++){
          double a= (double)objects.get(0).get(i);
          Date bb = (Date)objects.get(1).get(i);
          series1.addOrUpdate(new Year(bb),a);
      }
      dataset.addSeries(series1);
      XYDataset dataset1 = dataset;
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
            "Historical plot",
            "for all pairs",
            "Primary Range Axis",
            dataset1,
            true,
            true,
            false
        );

        chart.setBackgroundPaint(Color.white);
        chart.setBorderVisible(true);
        chart.setBorderPaint(Color.BLACK);
        TextTitle subtitle = new TextTitle("Six datasets and six range axes.");
        chart.addSubtitle(subtitle);
        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setOrientation(PlotOrientation.VERTICAL);
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);

        plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
        XYItemRenderer renderer = plot.getRenderer();
        renderer.setSeriesPaint(0, Color.black);

        // AXIS 2
        NumberAxis axis2 = new NumberAxis("Range Axis 2");
        axis2.setAutoRangeIncludesZero(false);
        axis2.setLabelPaint(Color.red);
        axis2.setTickLabelPaint(Color.red);
        plot.setRangeAxis(1, axis2);
        plot.setRangeAxisLocation(1, AxisLocation.BOTTOM_OR_LEFT);
        dataset= new TimeSeriesCollection();      
        objects = new EURJPY(dbc).getAllData();
        TimeSeries series2 = new TimeSeries("EUR/JPY");
        for(int i=0;i<objects.get(0).size();i++){
            double a= (double)objects.get(0).get(i);
            Date bb = (Date)objects.get(1).get(i);
            series2.addOrUpdate(new Year(bb),a);
        }
        dataset.addSeries(series2);
        XYDataset dataset2 =dataset;
        plot.setDataset(1, dataset2);
        plot.mapDatasetToRangeAxis(1, 1);
        XYItemRenderer renderer2 = new StandardXYItemRenderer();
        renderer2.setSeriesPaint(0, Color.red);
        plot.setRenderer(1, renderer2);

        // AXIS 3
        NumberAxis axis3 = new NumberAxis("Range Axis 3");
        axis3.setLabelPaint(Color.blue);
        axis3.setTickLabelPaint(Color.blue);
        //axis3.setPositiveArrowVisible(true);
        plot.setRangeAxis(2, axis3);
        dataset= new TimeSeriesCollection();      
        objects = new EURUSD(dbc).getAllData();
        TimeSeries series3 = new TimeSeries("EUR/USD");
        for(int i=0;i<objects.get(0).size();i++){
            double a= (double)objects.get(0).get(i);
            Date bb = (Date)objects.get(1).get(i);
            series3.addOrUpdate(new Year(bb),a);
        }
        dataset.addSeries(series3);
        XYDataset dataset3 =dataset;
        plot.setDataset(2, dataset3);
        plot.mapDatasetToRangeAxis(2, 2);
        XYItemRenderer renderer3 = new StandardXYItemRenderer();
        renderer3.setSeriesPaint(0, Color.blue);
        plot.setRenderer(2, renderer3);

        // AXIS 4
        NumberAxis axis4 = new NumberAxis("Range Axis 4");
        axis4.setLabelPaint(Color.green);
        axis4.setTickLabelPaint(Color.green);
        plot.setRangeAxis(3, axis4);
        dataset= new TimeSeriesCollection();      
        objects = new GBPJPY(dbc).getAllData();
        TimeSeries series4 = new TimeSeries("GBP/JPY");
        for(int i=0;i<objects.get(0).size();i++){
            double a= (double)objects.get(0).get(i);
            Date bb = (Date)objects.get(1).get(i);
            series4.addOrUpdate(new Year(bb),a);
        }
        dataset.addSeries(series4);
        XYDataset dataset4 = dataset;
        plot.setDataset(3, dataset4);
        plot.mapDatasetToRangeAxis(3, 3);

        XYItemRenderer renderer4 = new StandardXYItemRenderer();
        renderer4.setSeriesPaint(0, Color.green);
        plot.setRenderer(3, renderer4);
        
        //AXIS 5
        NumberAxis axis5 = new NumberAxis("Range Axis 5");
        axis5.setLabelPaint(Color.MAGENTA);
        axis5.setTickLabelPaint(Color.MAGENTA);
        plot.setRangeAxis(4, axis5);
        dataset= new TimeSeriesCollection();      
        objects = new GBPUSD(dbc).getAllData();
        TimeSeries series5 = new TimeSeries("GBP/USD");
        for(int i=0;i<objects.get(0).size();i++){
            double a= (double)objects.get(0).get(i);
            Date bb = (Date)objects.get(1).get(i);
            series5.addOrUpdate(new Year(bb),a);
        }
        dataset.addSeries(series5);
        XYDataset dataset5 = dataset;
        plot.setDataset(4, dataset5);
        plot.mapDatasetToRangeAxis(4, 4);

        XYItemRenderer renderer5 = new StandardXYItemRenderer();
        renderer5.setSeriesPaint(0, Color.MAGENTA);
        plot.setRenderer(4, renderer5);
        
        //AXIS 6
        NumberAxis axis6 = new NumberAxis("Range Axis 6");
        axis6.setLabelPaint(Color.orange);
        axis6.setTickLabelPaint(Color.orange);
        plot.setRangeAxis(5, axis6);
        dataset= new TimeSeriesCollection();      
        objects = new USDJPY(dbc).getAllData();
        TimeSeries series6 = new TimeSeries("USD/JPY");
        for(int i=0;i<objects.get(0).size();i++){
            double a= (double)objects.get(0).get(i);
            Date bb = (Date)objects.get(1).get(i);
            series6.addOrUpdate(new Year(bb),a);
        }
        dataset.addSeries(series6);
        XYDataset dataset6 = dataset;
        plot.setDataset(5, dataset6);
        plot.mapDatasetToRangeAxis(5, 5);

        XYItemRenderer renderer6 = new StandardXYItemRenderer();
        renderer6.setSeriesPaint(0, Color.orange);
        plot.setRenderer(5, renderer6);

        return chart;
  }
    
    public static JFreeChart getHistoricalVolatilityGraph(DatabaseConnection dbc){
        TimeSeriesCollection dataset= new TimeSeriesCollection();      
        ArrayList<ArrayList<Object>> objects = new EURGBP(dbc).getAllData();
        TimeSeries series1 = new TimeSeries("EURGBP");
        ArrayList<Float> temp = new ArrayList<>();
        int j=0;
        for(int i=30;i<objects.get(0).size();i+=30){
            series1.addOrUpdate(new Year((Date)objects.get(1).get(i)),getVolFromPeriod(objects.get(0).subList(i-30, i)));
            j=i;
        }
        if(j-objects.get(0).size()<=0)
            series1.addOrUpdate(new Year((Date)objects.get(1).get(objects.get(0).size()-1))
                    ,getVolFromPeriod(objects.get(0).subList(objects.get(0).size()-31, objects.get(0).size()-1)));
        dataset.addSeries(series1);
        XYDataset dataset1 = dataset;
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
            "Historical plot",
            "for all pairs",
            "Primary Range Axis - EUR/GBP volatility",
            dataset1,
            true,
            true,
            false
        );
                chart.setBackgroundPaint(Color.white);
        chart.setBorderVisible(true);
        chart.setBorderPaint(Color.BLACK);
        TextTitle subtitle = new TextTitle("Six datasets and six range axes.");
        chart.addSubtitle(subtitle);
        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setOrientation(PlotOrientation.VERTICAL);
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
        XYItemRenderer renderer = plot.getRenderer();
        renderer.setSeriesPaint(0, Color.black);

        // AXIS 2
        NumberAxis axis2 = new NumberAxis("Range Axis 2");
        axis2.setAutoRangeIncludesZero(false);
        axis2.setLabelPaint(Color.red);
        axis2.setTickLabelPaint(Color.red);
        plot.setRangeAxis(1, axis2);
        plot.setRangeAxisLocation(1, AxisLocation.BOTTOM_OR_LEFT);
        dataset= new TimeSeriesCollection();      
        objects = new EURJPY(dbc).getAllData();
        TimeSeries series2 = new TimeSeries("EUR/JPY");
        temp = new ArrayList<>();
        j=0;
        for(int i=30;i<objects.get(0).size();i+=30){
            series2.addOrUpdate(new Year((Date)objects.get(1).get(i)),getVolFromPeriod(objects.get(0).subList(i-30, i)));
            j=i;
        }
        if(j-objects.get(0).size()<=0)
            series2.addOrUpdate(new Year((Date)objects.get(1).get(objects.get(0).size()-1))
                    ,getVolFromPeriod(objects.get(0).subList(objects.get(0).size()-31, objects.get(0).size()-1)));
        dataset.addSeries(series2);
        XYDataset dataset2 =dataset;
        plot.setDataset(1, dataset2);
        plot.mapDatasetToRangeAxis(1, 1);
        XYItemRenderer renderer2 = new StandardXYItemRenderer();
        renderer2.setSeriesPaint(0, Color.red);
        plot.setRenderer(1, renderer2);

        // AXIS 3
        NumberAxis axis3 = new NumberAxis("Range Axis 3");
        axis3.setLabelPaint(Color.blue);
        axis3.setTickLabelPaint(Color.blue);
        plot.setRangeAxis(2, axis3);
        dataset= new TimeSeriesCollection();      
        objects = new EURUSD(dbc).getAllData();
        TimeSeries series3 = new TimeSeries("EUR/USD");
        temp = new ArrayList<>();
        j=0;
        for(int i=30;i<objects.get(0).size();i+=30){
            series3.addOrUpdate(new Year((Date)objects.get(1).get(i)),getVolFromPeriod(objects.get(0).subList(i-30, i)));
            j=i;
        }
        if(j-objects.get(0).size()<=0)
            series3.addOrUpdate(new Year((Date)objects.get(1).get(objects.get(0).size()-1))
                    ,getVolFromPeriod(objects.get(0).subList(objects.get(0).size()-31, objects.get(0).size()-1)));
        dataset.addSeries(series3);
        XYDataset dataset3 =dataset;
        plot.setDataset(2, dataset3);
        plot.mapDatasetToRangeAxis(2, 2);
        XYItemRenderer renderer3 = new StandardXYItemRenderer();
        renderer3.setSeriesPaint(0, Color.blue);
        plot.setRenderer(2, renderer3);

        // AXIS 4
        NumberAxis axis4 = new NumberAxis("Range Axis 4");
        axis4.setLabelPaint(Color.green);
        axis4.setTickLabelPaint(Color.green);
        plot.setRangeAxis(3, axis4);
        dataset= new TimeSeriesCollection();      
        objects = new GBPJPY(dbc).getAllData();
        TimeSeries series4 = new TimeSeries("GBP/JPY");
        temp = new ArrayList<>();
        j=0;
        for(int i=30;i<objects.get(0).size();i+=30){
            series4.addOrUpdate(new Year((Date)objects.get(1).get(i)),getVolFromPeriod(objects.get(0).subList(i-30, i)));
            j=i;
        }
        if(j-objects.get(0).size()<=0)
            series4.addOrUpdate(new Year((Date)objects.get(1).get(objects.get(0).size()-1))
                    ,getVolFromPeriod(objects.get(0).subList(objects.get(0).size()-31, objects.get(0).size()-1)));
        dataset.addSeries(series4);
        XYDataset dataset4 = dataset;
        plot.setDataset(3, dataset4);
        plot.mapDatasetToRangeAxis(3, 3);

        XYItemRenderer renderer4 = new StandardXYItemRenderer();
        renderer4.setSeriesPaint(0, Color.green);
        plot.setRenderer(3, renderer4);
        
        //AXIS 5
        NumberAxis axis5 = new NumberAxis("Range Axis 5");
        axis5.setLabelPaint(Color.MAGENTA);
        axis5.setTickLabelPaint(Color.MAGENTA);
        plot.setRangeAxis(4, axis5);
        dataset= new TimeSeriesCollection();      
        objects = new GBPUSD(dbc).getAllData();
        TimeSeries series5 = new TimeSeries("GBP/USD");
        temp = new ArrayList<>();
        j=0;
        for(int i=30;i<objects.get(0).size();i+=30){
            series5.addOrUpdate(new Year((Date)objects.get(1).get(i)),getVolFromPeriod(objects.get(0).subList(i-30, i)));
            j=i;
        }
        if(j-objects.get(0).size()<=0)
            series5.addOrUpdate(new Year((Date)objects.get(1).get(objects.get(0).size()-1))
                    ,getVolFromPeriod(objects.get(0).subList(objects.get(0).size()-31, objects.get(0).size()-1)));
        dataset.addSeries(series5);
        XYDataset dataset5 = dataset;
        plot.setDataset(4, dataset5);
        plot.mapDatasetToRangeAxis(4, 4);

        XYItemRenderer renderer5 = new StandardXYItemRenderer();
        renderer5.setSeriesPaint(0, Color.MAGENTA);
        plot.setRenderer(4, renderer5);
        
        //AXIS 6
        NumberAxis axis6 = new NumberAxis("Range Axis 6");
        axis6.setLabelPaint(Color.orange);
        axis6.setTickLabelPaint(Color.orange);
        plot.setRangeAxis(5, axis6);
        dataset= new TimeSeriesCollection();      
        objects = new USDJPY(dbc).getAllData();
        TimeSeries series6 = new TimeSeries("USD/JPY");
        temp = new ArrayList<>();
        j=0;
        for(int i=30;i<objects.get(0).size();i+=30){
            series6.addOrUpdate(new Year((Date)objects.get(1).get(i)),getVolFromPeriod(objects.get(0).subList(i-30, i)));
            j=i;
        }
        if(j-objects.get(0).size()<=0)
            series6.addOrUpdate(new Year((Date)objects.get(1).get(objects.get(0).size()-1))
                    ,getVolFromPeriod(objects.get(0).subList(objects.get(0).size()-31, objects.get(0).size()-1)));
        dataset.addSeries(series6);
        XYDataset dataset6 = dataset;
        plot.setDataset(5, dataset6);
        plot.mapDatasetToRangeAxis(5, 5);

        XYItemRenderer renderer6 = new StandardXYItemRenderer();
        renderer6.setSeriesPaint(0, Color.orange);
        plot.setRenderer(5, renderer6);
        
        return chart;
    }
    
    private static double getVolFromPeriod(List<Object> a){
        VolatilityCalc volc = new VolatilityCalc();
        ArrayList<Float> as = new ArrayList<>();
        for(Object i:a){
            as.add((Float)i);
        }
        return volc.calculateVolatility(30, as, 30);
        
    }
}
