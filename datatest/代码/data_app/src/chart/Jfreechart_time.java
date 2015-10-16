package chart;

import java.awt.Font;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;


public class Jfreechart_time extends ApplicationFrame{
	static int[] commentNum=new int[24];
	
    public Jfreechart_time(String title){
        super(title);
        this.setContentPane(createPanel());
        for(int i=0;i<24;i++){
        	commentNum[i]=45;
        }
    }
    
    public static CategoryDataset createDataset(){
    	char hour='6'-'6';
        DefaultCategoryDataset dataset=new DefaultCategoryDataset();
        Get_time_mysql my=new Get_time_mysql();
        my.gettime();
        for(int i=0;i<24;i++){
        	dataset.setValue(my.shows[i],(hour+1*i)+":00" ,(hour+1*i)+"h" );
        }
        return dataset;
    }
    
    public static JFreeChart createChart(CategoryDataset dataset){
        JFreeChart chart=ChartFactory.createBarChart("chart of comment time", 
        		"time", 
                "commentNum", 
                dataset, 
                PlotOrientation.VERTICAL,
                true,
                true, 
                false);
        return chart;
    }
    
    public static JPanel createPanel(){
        JFreeChart chart =createChart(createDataset());
        return new ChartPanel(chart);
    }
    
    public static void main(String[] args){
        Jfreechart_time chart=new Jfreechart_time("chart");
        chart.pack();//以合适的大小显示
        chart.setSize(1200, 550);
        chart.setVisible(true);
    }
}