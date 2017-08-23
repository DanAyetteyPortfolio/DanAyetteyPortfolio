package PwpIcons.NetworkIcons;

import PwnAnalysis.PwnAnalysisDiagram;

import javax.swing.*;

/**
 * Created by Ayettey on 06/02/2017.
 */
public class Main extends JFrame {

    public static void main(String []agr){

       Main x= new Main();
        JPanel k=new JPanel();
        x.setContentPane(new PwnAnalysisDiagram("Data","Time"));
        x.setSize(200,200);
       x.setVisible(true);


    }





}
