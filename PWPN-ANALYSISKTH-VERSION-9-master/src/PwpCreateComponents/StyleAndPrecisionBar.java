package PwpCreateComponents;

import EventHandlers.EditorViewHandler;
import PwnAnalysis.PwnAnalysisDiagram;
import com.sun.java.swing.plaf.windows.WindowsBorders;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 * Created by Ayettey on 30/05/2017.
 */
public class StyleAndPrecisionBar extends EditorViewHandler {

    public JTextField precisionOfComponentsX=new JTextField(5);
    public JTextField precisionOfComponentsY=new JTextField(5);
    private JTextField precisionOfComponentsH;
    private JTextField precisionOfComponentsW;
    private JTextField precisionOfComponentsSW;
    private JTextField precisionOfComponentsSH;
    private JSeparator separator;
    private JButton[] styleButtons=new  JButton[30];
    private Border styleBorder;
    private  Color styleColor;

    public Color getStyleColor() {
        return styleColor;
    }

    public void setStyleColor(Color styleColor) {
        this.styleColor = styleColor;
    }

    public Border getStyleBorder() {
        return styleBorder;
    }

    public void setStyleBorder(Border styleBorder) {
        this.styleBorder = styleBorder;
    }

    public Component serviceKit(){

        JPanel kitPanel =new JPanel();
        kitPanel.setLayout(new GridBagLayout());


        GridBagConstraints constraints=new GridBagConstraints();




        constraints.gridx=0;
        kitPanel.add(shapeStyle(),constraints);
        kitPanel.add(new JLabel("Style",JLabel.CENTER),constraints);


        constraints.gridx=1;
        JPanel x=new PwnAnalysisDiagram().createLineDiagram("","");
        x.setSize(new Dimension(10,60));
        kitPanel.add(x,constraints);
        kitPanel.add(new JLabel("Compromised Analysis"),constraints);

        constraints.gridx=2;
        constraints.weightx=1;
        constraints.anchor=GridBagConstraints.LAST_LINE_START;

        kitPanel.add(shapeEffect(),constraints);

        constraints.anchor=GridBagConstraints.CENTER;
        constraints.insets=new Insets(0,0,0,200);
        kitPanel.add(new JLabel("Effect",JLabel.RIGHT),constraints);


        return kitPanel;

    }

    public Component shapeEffect(){





        GridBagConstraints constraints=new GridBagConstraints();


        JPanel toolPanel=new JPanel(new GridBagLayout());
        toolPanel.setBorder(new LineBorder(new Color(0x609CBA),0,true));
        toolPanel.setPreferredSize(new Dimension(100,70));


        JLabel fillFeel=new JLabel("Feel");
        fillFeel.setPreferredSize(new Dimension(30,30));
        MatteBorder border=new MatteBorder(0,0,5,0,Color.cyan);

        fillFeel.setBorder(border);
        fillFeel.setBackground(new Color(0x21BA55));




        JColorChooser chooser=new JColorChooser();
        JButton fill=new JButton(new ImageIcon(getClass().getResource("/PwpIcons/actions/Fill Color_16.png")));
        fill.setPreferredSize(new Dimension(27,20));
        fill.setBorderPainted(false);




        JButton line=new JButton(new ImageIcon(getClass().getResource("/PwpIcons/actions/Brush-16 (1).png")));
        line.setPreferredSize(new Dimension(27,20));

        JButton effect=new JButton(new ImageIcon(getClass().getResource("/PwpIcons/actions/Collage-16.png")));
        effect.setPreferredSize(new Dimension(27,20));
        effect.setBorderPainted(false);

        JButton selections=new JButton(new ImageIcon(getClass().getResource("/PwpIcons/actions/Select.png/")));
        selections.setBorder(new LineBorder(new Color(0x007ABA),1));
        selections.setBorderPainted(false);
        selections.setPreferredSize(new Dimension(27,20));



        AbstractColorChooserPanel[] colorChooserPanel= chooser.getChooserPanels();



        for(int x=0;x<colorChooserPanel.length;x++){
            if(!colorChooserPanel[x].getDisplayName().equals(colorChooserPanel[0].getDisplayName())){
                chooser.removeChooserPanel(colorChooserPanel[x]);


            }

        }





        JPopupMenu popupMenu=new JPopupMenu();
        popupMenu.add(colorChooserPanel[0]);

        JPopupMenu popupMenuEffects=new JPopupMenu();
        popupMenuEffects.add(designBar());


        fill.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                popupMenu.show(fill,e.getX(),e.getY()+50);


            }


        });



        line.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                popupMenu.show(fill,e.getX(),e.getY()+50);


            }
        });

        effect.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                popupMenuEffects.show(effect,e.getX(),e.getY()+50);


            }
        });




        colorChooserPanel[0].getColorSelectionModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                fill.setBackground(colorChooserPanel[0].getColorSelectionModel().getSelectedColor());

                // fillFeel.setBorder(new WindowsBorders.DashedBorder(colorChooserPanel[0].getColorSelectionModel().getSelectedColor(),3));

                MatteBorder border=new MatteBorder(0,0,5,0,colorChooserPanel[0].getColorSelectionModel().getSelectedColor());

                fillFeel.setBorder(border);

            }
        });






        constraints.gridx=0;
        constraints.weightx=0;


        constraints.anchor=GridBagConstraints.WEST;
        constraints.insets=new Insets(0,0,0,5);
        toolPanel.add(fill,constraints);
        toolPanel.add(line,constraints);







        constraints.gridx=2;
        constraints.weightx=0;
        constraints.insets=new Insets(0,5,0,0);
        toolPanel.add(effect,constraints);
        toolPanel.add(fillFeel,constraints);


        constraints.gridx=3;
        constraints.weightx=1;
        constraints.insets=new Insets(0,5,0,0);
        toolPanel.add(selections,constraints);



        return toolPanel;

    }

    public Component shapeStyle(){

        JPanel shapeStylePanel=new JPanel(new BorderLayout());
        JPanel stylePanel=new JPanel(new GridLayout(0,5));


        GridBagConstraints constraints=new GridBagConstraints();




        for (int x=0;x<styleButtons.length;x++){

            constraints.gridx=0;
            Random seedRandomly=new Random();
            styleButtons[x]=new JButton();
            styleButtons[x].setBackground(new Color((float) seedRandomly.nextDouble(),
                    (float) seedRandomly.nextDouble(),(float) seedRandomly.nextDouble(),(float) seedRandomly.nextDouble()));
            styleButtons[x].setPreferredSize(new Dimension(40,40));
            styleButtons[x].setBorder(new WindowsBorders.DashedBorder(new Color((float) seedRandomly.nextDouble(),
                    (float) seedRandomly.nextDouble(),(float) seedRandomly.nextDouble(),(float) seedRandomly.nextDouble()),2));

            stylePanel.add(new JList().add(styleButtons[x]));
            styleButtons[x].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    JComponent component= (JComponent) e.getComponent();

                        setStyleBorder(component.getBorder());
                        setStyleColor(component.getBackground());



                    JPanel panel=new JPanel();
                     panel.setBackground(Color.RED);
                     ImageIcon p=new ImageIcon(getClass().getResource("/PwpIcons/actions/Brush-16 (1).png"));
                    JLabel label=new JLabel("Gh");
                    label.setForeground(getStyleColor());




                }


            });



        }



        shapeStylePanel.add(stylePanel,BorderLayout.WEST);
        JScrollPane   pane=new JScrollPane(shapeStylePanel);
        pane.setPreferredSize(new Dimension(260,70));
        pane.setBorder(new LineBorder(new Color(0x609CBA),0,true));



        return pane;

    }
}
