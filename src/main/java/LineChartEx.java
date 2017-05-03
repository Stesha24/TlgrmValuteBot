/**
 * Created by 1 on 28.02.2017.
 */

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class LineChartEx extends JFrame {
    String[] valueMass;
    String[] dateMass;
    File imageFile = new File("E:\\TlgrmValuteBot\\image\\LineChart.png");
    public LineChartEx(String[] valueMass, String[] dateMass) throws IOException {
        this.dateMass = dateMass;
        this.valueMass = valueMass;
        initUI();
    }

    private void initUI() throws IOException {

        XYDataset dataset = createDataset(valueMass, dateMass);
        JFreeChart chart = createChart(dataset);
        /*ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        add(chartPanel);

        pack();
        setTitle("");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/


    }

    XYDataset createDataset(String[] valueMass, String[] dateMass) {
        double a = 0;
        XYSeries series = new XYSeries("");
        for (int i = 0; i < dateMass.length; i++) {
            series.add(a, Double.parseDouble(valueMass[i]));
            a++;
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        return dataset;
    }

    JFreeChart createChart(XYDataset dataset) {

        JFreeChart chart = ChartFactory.createXYLineChart(
                "",
                "Dates",
                "Values",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        XYPlot plot = chart.getXYPlot();

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));

        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.white);

        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);
        NumberAxis axisR = (NumberAxis)plot.getRangeAxis();
        axisR.setRange(Double.parseDouble(valueMass[0])-2, Double.parseDouble(valueMass[valueMass.length-1])+2);
        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.BLACK);

        chart.getLegend().setFrame(BlockBorder.NONE);

        chart.setTitle(new TextTitle("",
                        new Font("Serif", java.awt.Font.BOLD, 18)
                )
        );
        //сохраняет в файл картинку
        int width = 640;
        int height = 480;
        try {
            ChartUtilities.saveChartAsPNG(imageFile, chart, width, height);
        } catch (IOException ex) {
            System.err.println(ex);
        }
        return chart;

    }

    public void Diagram(String[] valueArray, String[] dateArray) {
        SwingUtilities.invokeLater(() -> {
            LineChartEx ex = null;
            try {
                ex = new LineChartEx(valueArray, dateArray);
            } catch (IOException e) {
                e.printStackTrace();
            }
            ex.setVisible(true);
        });
    }



}