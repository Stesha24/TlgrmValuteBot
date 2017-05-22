import java.awt.BasicStroke;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeTableXYDataset;
import org.jfree.data.xy.XYDataset;

/**
 * Creating graphics.
 */

public class LineChartEx extends JFrame {
    String[] valueMass;
    String[] dateMass;
    File imageFile = new File("E:\\TlgrmValuteBot\\image\\LineChart.png");

    public LineChartEx(String[] valueMass, String[] dateMass) throws IOException, ParseException {
        this.dateMass = dateMass;
        this.valueMass = valueMass;
        initUI();
    }

    private void initUI() throws IOException, ParseException {

        XYDataset dataset = createDataset(valueMass, dateMass);
        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        add(chartPanel);

        pack();
        setTitle("");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    TimeTableXYDataset createDataset(String[] valueMass, String[] dateMass) throws ParseException {
        TimeTableXYDataset dataset = new TimeTableXYDataset();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        for (int i = 0; i < valueMass.length; i++) {
            dataset.add(new Day(simpleDateFormat.parse(dateMass[i])), Double.parseDouble(valueMass[i]), "");
            System.out.println(simpleDateFormat.parse(dateMass[i]) + "\n");
        }

        return dataset;
    }

    JFreeChart createChart(XYDataset dataset) {

        DateAxis domainAxis = new DateAxis("Dates");
        domainAxis.setAutoRange(true);
        NumberAxis rangeAxis = new NumberAxis("Values");
        //исправить рэнж на макс и мин
        rangeAxis.setRange(Double.parseDouble(valueMass[0]) - 2, Double.parseDouble(valueMass[valueMass.length - 1]) + 3);

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));

        XYPlot plot = new XYPlot(dataset, domainAxis, rangeAxis, renderer);
        plot.setBackgroundPaint(Color.white);
        plot.setDomainGridlinePaint(Color.BLACK);
        plot.setRangeGridlinePaint(Color.BLACK);

        plot.setOutlinePaint(null);
        plot.setRangeGridlinesVisible(true);

        JFreeChart chart = new JFreeChart(plot);
        chart.setBackgroundPaint(Color.white);

        //сохраняет в файл картинку
        int width = 780;
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
            } catch (ParseException e) {
                e.printStackTrace();
            }
            ex.setVisible(true);
        });
    }


}