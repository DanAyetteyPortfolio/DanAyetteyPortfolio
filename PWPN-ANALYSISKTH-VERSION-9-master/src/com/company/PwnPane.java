package com.company;

import EventHandlers.EditorViewHandler;
import EventHandlers.PaletteEventHandler;
import PwnAnalysis.PwnAnalysisDiagram;
import PwpCreateComponents.AnalyticDevices;
import RenderFoldersAndSubFoders.CreateFolders;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Created by Ayettey on 16/02/2017.
 */
public class PwnPane extends JPanel {


    private JPanel titlePanel;
    private String title;
    private  JTabbedPane tabbedPane=new JTabbedPane();
    private  JSplitPane[] splitLayersOfPane;
    private JEditorPane editorPane;
    private  JTabbedPane[] tabbeds;
    private CreateFolders folders=new CreateFolders();
    private PaletteEventHandler handler=new PaletteEventHandler();


    EditorViewHandler viewHandler;
    public  PwnPane(EditorViewHandler viewHandler){
        this.viewHandler=viewHandler;

    }

    public  PwnPane(){



    }



    public Component mainPanel(){

       // setLayout(new BorderLayout());
        splitLayersOfPane=new JSplitPane[4];
        tabbeds=new JTabbedPane[4];
        editorPane=new JEditorPane();
       EditorViewHandler viewHandler= new EditorViewHandler();

        createPane(this,splitLayersOfPane,folders.label,
                new JTextArea("Add documentation relating to this object here")
                ,tabbedPane,folders,folders.labels,viewHandler);




        return this;

    }





    public JComponent createPane(JPanel panel, JSplitPane[] splitLayersOfPan
            , JTextField textField, JTextArea textArea, JTabbedPane tabbeds,
                                 CreateFolders createFolders, JLabel labels, EditorViewHandler editorViewHandler){

        tabbeds=new JTabbedPane();

        UIManager.put("ScrollBar.width", 14);
        splitLayersOfPan[0]=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitLayersOfPan[0].add(projectView(tabbeds,createFolders));
        splitLayersOfPan[0].setDividerSize(1);
        splitLayersOfPan[0].setDividerLocation(240);
        splitLayersOfPan[0].setContinuousLayout(true);
        splitLayersOfPan[0].setOneTouchExpandable(true);

        tabbeds=new JTabbedPane();
        splitLayersOfPan[1]=new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splitLayersOfPan[1].add(new JScrollPane(modelProperties(tabbeds,textField,textArea,labels) ));
        splitLayersOfPan[1].setContinuousLayout(true);
        splitLayersOfPan[1].setOneTouchExpandable(true);


        splitLayersOfPan[0].setPreferredSize(new Dimension(30,30));
        splitLayersOfPan[2]=new JSplitPane(JSplitPane.VERTICAL_SPLIT,splitLayersOfPan[0],splitLayersOfPan[1]);

        splitLayersOfPan[2].setContinuousLayout(true);
        splitLayersOfPan[2].setDividerSize(20);
        splitLayersOfPan[2].setOneTouchExpandable(true);
        splitLayersOfPan[2].setDividerLocation(570);




        JPanel panel2=new JPanel();
        panel2.setPreferredSize(new Dimension(200,200));

        panel2.add(new PwnAnalysisDiagram().createLineDiagram2("",""));

        splitLayersOfPan[3]=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT ,networkModel(new JTabbedPane(),
                new JComponent[]{new Ruler(editorViewHandler.createEditorPane())
                        ,panel2}),new JScrollPane().add(palette(tabbeds, (JComponent) new AnalyticDevices().devices())));
       // analyticDevice.getHorizontalScrollBar().setValue(24);
        splitLayersOfPan[3].setContinuousLayout(true);
        splitLayersOfPan[3].setDividerLocation(660);
        splitLayersOfPan[3].setDividerSize(15);
        splitLayersOfPan[3].setOneTouchExpandable(true);
        splitLayersOfPan[3].setBackground(getBackground());
        splitLayersOfPan[0].add(splitLayersOfPan[3]);




        for(int x=0;x<splitLayersOfPan.length;x++){
            splitLayersOfPan[x].setDividerSize(15);
        }

      setLayout(new BorderLayout());

      this.add(editorViewHandler.serviceTool(),BorderLayout.NORTH);
      this.add(splitLayersOfPan[2],BorderLayout.CENTER);

      return this;

    }




    public JComponent palette(JTabbedPane tabbeds,JComponent devices){
         tabbeds=new JTabbedPane();
        tabbeds.addTab("Palette",new ImageIcon(getClass().getResource("/PwpIcons/toolwindows/toolWindowPalette.png"))
                ,devices );

        return tabbeds;
    }

    public JComponent projectView(JTabbedPane tabbeds,CreateFolders createFolders){

        tabbeds.addTab("Project",new ImageIcon(getClass().getResource("/PwpIcons/general/projectTab.png")),
                new JScrollPane(createFolders.modelTree()));



        return new JScrollPane(tabbeds);
    }







    public JComponent networkModel(JTabbedPane tabbeds ,JComponent addComponentToTab[]){


        tabbeds.addTab("Network Model",new ImageIcon(getClass().getResource("/PwpIcons/actions/erDiagram.png")),
               new JScrollPane(addComponentToTab[0]));

        tabbeds.addTab("Analysis View",new ImageIcon(getClass().getResource("/PwpIcons/toolbarDecorator/analyze.png")),
                new JScrollPane(addComponentToTab[1]));

        return  new JScrollPane(tabbeds);

    }


    public  JComponent properties(JLabel labels,JTextField textField,JTextArea textArea ){


        GridBagConstraints constraints=new GridBagConstraints();
        GridBagLayout layout=new GridBagLayout();
        constraints.fill=GridBagConstraints.HORIZONTAL;
        constraints.anchor=GridBagConstraints.NORTH;
        constraints.insets=new Insets(5,10,5,10);

        JLabel label=new JLabel("Name:",JLabel.LEFT);
        label.setFont(new Font("",Font.PLAIN,14));


        JPanel mainPropertyPanel=new JPanel(layout);
        JPanel viewPanel=new JPanel(new BorderLayout());
        constraints.gridx=0;
        constraints.anchor=GridBagConstraints.FIRST_LINE_START;


        mainPropertyPanel.add(label,constraints);

        constraints.gridx=1;
        constraints.ipady=7;
        constraints.anchor=GridBagConstraints.FIRST_LINE_START;
        textField.setForeground(new Color(0x0B88A3));
        textField.setFont(new Font("",Font.PLAIN,14));
        mainPropertyPanel.add(textField,constraints);


        label=new JLabel("Documentation:",JLabel.LEFT);
        label.setFont(new Font("",Font.PLAIN,14));

        constraints.gridx=1;
        constraints.anchor=GridBagConstraints.FIRST_LINE_START;
        mainPropertyPanel.add(label,constraints);


        constraints.gridx=1;
        constraints.ipady=120;
        mainPropertyPanel.add(new JScrollPane(textArea),constraints);



        viewPanel.add(labels,BorderLayout.BEFORE_FIRST_LINE);
        viewPanel.add(mainPropertyPanel,BorderLayout.CENTER);



        JTabbedPane tabbed=new JTabbedPane(SwingConstants.LEFT,JTabbedPane.TOP);




        tabbed.setFont(new Font("",Font.PLAIN,13));
        tabbed.addTab("Main",null,viewPanel,"Orange");



        constraints.gridx=0;
        constraints.ipadx=40;
        mainPropertyPanel=new JPanel();

        DefaultTableModel model=new DefaultTableModel(new Object[]{"Name","Value"},new Integer(10));
        viewPanel=new JPanel();
        JTable table=new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(1200,200));



        mainPropertyPanel.add(new JScrollPane(table),constraints);

        viewPanel.add(mainPropertyPanel,BorderLayout.CENTER);
        tabbed.addTab("Property",null, viewPanel,"");


        return  tabbed;

    }



    public  Icon icon;

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }




    public   Component modelProperties(JTabbedPane tabbed,
                                        JTextField textField, JTextArea textArea, JLabel labels){


        tabbed=new JTabbedPane();
        tabbed.addTab("Model Properties",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/properties.gif")),
                new JScrollPane(properties(labels,textField,textArea)));



        tabbed.addTab("Network View",new ImageIcon(getClass().getResource("/PwpIcons/general/ellipsis.png")),
                new JScrollPane(new JTable(new DefaultTableModel(new Object[]{"Name","Value"},new Integer(34)))));

        tabbed.addTab("Network View",new ImageIcon(getClass().getResource("/PwpIcons/general/ellipsis.png")),
                new JScrollPane(new JTable()));



        return  tabbed;
    }



    class Ruler extends JScrollPane{




        @Override
        public Dimension getPreferredSize() {




            int col, row, height, width;
            Dimension dimension = null;
            width= (int) getViewport().getWidth();
            col = width / 340;

            if (col >0) {
                row = (int)(Math.ceil(25.0/col));
                height = row*340 ;
                dimension = new Dimension(width, height);
            }
            else{
                dimension = super.getPreferredSize();
            }
            return dimension;
        }



        public Ruler(Component comp){
           super(comp);


           JLabel[] corners = new JLabel[4];
           for (int i = 0; i < 4; i++) {
               corners[i] = new JLabel();
               corners[i].setBackground(new Color(0x76BCFF));
               corners[i].setOpaque(true);
           }

           JLabel rowHeader = new JLabel() {
               public void paintComponent(Graphics g) {
                   super.paintComponent(g);
                   Rectangle rect = g.getClipBounds();
                   for (int i = 50 - (rect.y % 50); i < rect.height; i += 50) {

                       g.drawLine(0, rect.y + i, 3, rect.y + i);
                       g.drawString("" + (rect.y + i), 6, rect.y + i +3);

                   }
               }

               public Dimension getPreferredSize() {




                   return new Dimension(25, (int) comp.getPreferredSize()
                           .getHeight());
               }
           };
           rowHeader.setBackground(Color.white);
           rowHeader.setOpaque(true);

           JLabel columnheader = new JLabel() {

               public void paintComponent(Graphics g) {
                   super.paintComponent(g);
                   Rectangle r = g.getClipBounds();
                   for (int i = 50 - (r.x % 50); i < r.width; i += 50) {
                       g.drawLine(r.x + i, 0, r.x + i, 3);
                       g.drawString("" + (r.x + i), r.x + i - 10, 16);
                   }
               }

               public Dimension getPreferredSize() {
                   return new Dimension((int) comp.getPreferredSize().getWidth(),
                           25);
               }
           };
           columnheader.setBackground(Color.white);
           columnheader.setOpaque(true);

           setRowHeaderView(rowHeader);
           setColumnHeaderView(columnheader);
           setCorner(JScrollPane.LOWER_LEFT_CORNER, corners[0]);
           setCorner(JScrollPane.LOWER_RIGHT_CORNER, corners[1]);
           setCorner(JScrollPane.UPPER_LEFT_CORNER, corners[2]);
           setCorner(JScrollPane.UPPER_RIGHT_CORNER, corners[3]);

           grabFocus();






    }


}
}
