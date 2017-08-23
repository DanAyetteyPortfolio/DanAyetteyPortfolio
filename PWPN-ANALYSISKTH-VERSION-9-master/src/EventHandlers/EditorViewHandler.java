package EventHandlers;


import PwnAnalysis.PwnAnalysisDiagram;
import PwpCreateComponents.StyleAndPrecisionBar;
import com.company.PwnPane;
import com.sun.java.swing.plaf.windows.WindowsBorders;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

/**
 * Created by Ayettey on 12/04/2017.
 */

public class EditorViewHandler extends JDesktopPane {

    private static final DataFlavor FLAVOR=new DataFlavor(JLabel.class,"Label Instances");
    private static final DataFlavor LOCAL_FLAVORS=new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType
            + "; class=javax.swing.JLabel","Label Instances");

   private DragSourceListener source;
   private JLabel dragComponent;
   public JLabel     LocationXAndY=new JLabel();
   private int countItem;
   private List<Component[]> connector;
   private List<Pair> connectorPairs;
   private int x;
   private int y;
    private int xAxis;
    private int yAxis;
   private boolean isConnected;
    private JButton attack;
    private JComboBox transmissionsSettings;
    private JLabel tags;
    private JPanel transmissionPanel;
    private JTextField attackTransmissionTraffic;
    private JPanel colors[];
    private JButton []tool;
    private Point point;
    private Point initialLoc;
    private Point initialLocOnScreen;
    private JInternalFrame frame;
    private JTextField precisionOfComponentsX =new JTextField(5);
    private JTextField precisionOfComponentsY =new JTextField(5);
    private JTextField precisionOfComponentsW =new JTextField(5);
    private JTextField precisionOfComponentsH =new JTextField(5);
    private JTextField precisionOfComponentsSW =new JTextField(5);
    private JTextField precisionOfComponentsSH =new JTextField(5);


    public void setLocationXAndY(JLabel locationXAndY) {
        LocationXAndY = locationXAndY;
    }

    public JLabel getLocationXAndY() {
        return LocationXAndY;
    }

    public JComponent controlPanel(Boolean control, JPanel transmissionPanel, JLabel titles,
                                   String title[], JComboBox transmissionsSettings, JPanel addAPanel){

        transmissionPanel=new JPanel();
        transmissionPanel.setBackground(transmissionPanel.getBackground());

        frame=new JInternalFrame(title[0]);
        if(control){

            GridBagConstraints constraints=new GridBagConstraints();
            GridBagLayout layout=new GridBagLayout();

            frame.setLayout(new BorderLayout());

            frame.setBorder(new LineBorder(new Color(0x8ED0FF),1,true));
            frame.setBackground(getBackground());

            constraints.fill=GridBagConstraints.VERTICAL;
            constraints.insets=new Insets(5,10,5,10);



            constraints.gridx=0;

            transmissionPanel.setLayout(layout);
            titles=new JLabel(title[1],JLabel.LEFT);
            transmissionPanel.add(titles,constraints);

            titles=new JLabel(title[2], JLabel.LEFT);
            transmissionPanel.add(titles,constraints);

            titles=new JLabel(title[3],JLabel.LEFT);
            transmissionPanel.add(titles,constraints);

            titles=new JLabel(title[4],JLabel.LEFT);
            transmissionPanel.add(titles,constraints);

            titles=new JLabel(title[5],JLabel.LEFT);
            transmissionPanel.add(titles,constraints);


            constraints.gridx=1;


            transmissionsSettings=new JComboBox(new Object[]{"Wired","Wireless"});
            transmissionPanel.add(transmissionsSettings,constraints);

            transmissionsSettings=new JComboBox(new Object[]{"UDP","TCP"});
            transmissionPanel.add(transmissionsSettings,constraints);

            transmissionsSettings=new JComboBox(new Object[]{"FIFO","LIFO"});
            transmissionPanel.add(transmissionsSettings,constraints);




            constraints.ipadx=60;
            attackTransmissionTraffic=new JTextField(10);
            transmissionPanel.add(attackTransmissionTraffic,constraints);
            constraints.gridx=1;


            attack=new JButton("Attack");
            transmissionPanel.add(attack,constraints);

            transmissionPanel.add(new JSeparator(),constraints);

            constraints.gridx=1;

            transmissionPanel.add(new JSeparator(),constraints);

            constraints.gridx=0;

            constraints.gridx=0;


            PwnAnalysisDiagram chart = new PwnAnalysisDiagram(
                    "Network Analysis" ,"");

            chart.setVisible( true );

            frame.add(chart,BorderLayout.SOUTH);

            System.out.println("ControlPanel");



               try{

                   UIManager.setLookAndFeel(new WindowsLookAndFeel());
                   JFrame.setDefaultLookAndFeelDecorated(true);

                   frame.setResizable(true);
                   frame.setClosable(false);
                   frame.setMaximizable(true);
                   frame.setIconifiable(true);
                   frame.setVisible(true);
                   frame.setFrameIcon(new ImageIcon(getClass().getResource("/PwpIcons/general/settings.png")));
                   frame.add(transmissionPanel,BorderLayout.CENTER);
                   frame.add(addAPanel,BorderLayout.NORTH);
                   frame.pack();






               } catch (UnsupportedLookAndFeelException e) {
                   e.printStackTrace();
               }


        }

        return frame;
    }

    public JPanel toolPanel(Boolean control){

        JPanel colorPanel=new JPanel(new GridLayout(2,2));
        JPanel set=new JPanel(new BorderLayout());


        JPanel panel=new JPanel();
        panel.setBorder(new BevelBorder(BevelBorder.RAISED));
        if(control){



            GridBagConstraints constraints=new GridBagConstraints();
            GridBagLayout layout=new GridBagLayout();



            set.setLayout(layout);


            constraints.fill=GridBagConstraints.VERTICAL;
            constraints.insets=new Insets(5,10,5,10);


            colorPanel.setLayout(new GridLayout(4,4));

            panel.setBorder(new LineBorder(new Color(0x8ED0FF),1,true));
            panel.setBackground(getBackground());
            panel.setLayout(new BorderLayout());



            colors=new JPanel[30];
            tool=new JButton[4];

            for(int x=0;x<colors.length;x++){
                Random seedRandomly=new Random();
                colors[x]=new JPanel();
                colors[x].setSize(new Dimension(16,16));
                colors[x].setBackground(new Color((float) seedRandomly.nextDouble(),(float)
                        seedRandomly.nextDouble(),(float) seedRandomly.nextDouble()));
                colorPanel.add(colors[x]);
                colorPanel.setVisible(true);
                colorPanel.setBackground(Color.green);
                panel.add(colorPanel,BorderLayout.CENTER);
                colors[x].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        for(int i=0;i<colors.length;i++)
                        colors[i].setToolTipText("Choose a color");
                    }
                });

            }


            tool[0]=new JButton(new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/note-16.gif")));
            tool[1]=new JButton(new ImageIcon(getClass().getResource("/PwpIcons/actions/selection-of-elements.png")));
            tool[2]=new JButton(new ImageIcon(getClass().getResource("/PwpIcons/actions/printing.png")));
            tool[3]=new JButton(new ImageIcon(getClass().getResource("/PwpIcons/actions/NetworkSyndromes.png")));

            constraints.gridx=0;
            set.add(tool[0] ,constraints);
            constraints.gridx=1;
            set.add(tool[1] ,constraints);
            constraints.gridx=2;
            set.add(tool[2] ,constraints);

            constraints.gridx=3;
            set.add(tool[3] ,constraints);








                panel.add(set,BorderLayout.NORTH);
                tool[0].setToolTipText("Note");
                tool[1].setToolTipText("Selection of elements");
                tool[2].setToolTipText("Print or make a png file");
                tool[3].setToolTipText("Network Syndrome");


            }




                panel.setVisible(true);





        return panel;
    }



  public  EditorViewHandler(){

      super();


  }




    public JComponent createEditorPane() {





        DropTarget dropTarget = new DropTarget(this, DnDConstants.ACTION_COPY_OR_MOVE, new DropObject());

        setLayout(null);

        DropObject g= new DropObject();




        LocationXAndY=new JLabel();
        setLocationXAndY(LocationXAndY);
        LocationXAndY.setBounds(5,getWidth(),200,30);
        add(LocationXAndY);






        setBackground(LocationXAndY.getBackground());

        String [] titles={"Connection Type : ", "Connection Type : ", "Transmission Type :",
                "Ordering  Type :","Attacker's  Traffic :"," Attacker : "};


        add(controlPanel(true,transmissionPanel,tags,titles,transmissionsSettings,toolPanel(true)));



        MouseAdapter mouseAdapter=new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }





            @Override
            public void mouseDragged(MouseEvent e) {


                LocationXAndY.setText("Dragging at" + e.getX() + " and " + e.getY());

                System.out.println("Dragging at" + e.getX() + " and " + e.getY());
                repaint();
            }

        };


        addMouseListener(mouseAdapter);



        return this;

         }






    public Component designBar(){

        JPanel designBarPanel=new JPanel(new GridBagLayout());
        designBarPanel.setPreferredSize(new Dimension(324,70));
        GridBagConstraints constraints=new GridBagConstraints();


        constraints.insets=new Insets(6,5,-20,3);


        constraints.gridx=0;
        JLabel label=new JLabel("Position");
        label.setHorizontalTextPosition(JLabel.CENTER);
        designBarPanel.add(label,constraints);






        constraints.gridx=1;
        constraints.weightx=0;
        constraints.insets=new Insets(6,2,2,0);

        constraints.anchor=GridBagConstraints.FIRST_LINE_START;
        label=new JLabel("X",JLabel.LEFT);
        designBarPanel.add(label,constraints);

        label=new JLabel("Y",JLabel.LEFT);
        designBarPanel.add(label,constraints);


        constraints.gridx=2;
        constraints.insets=new Insets(3,2,2,0);
        constraints.weightx=0;

        designBarPanel.add(precisionOfComponentsX,constraints);

        designBarPanel.add(precisionOfComponentsY,constraints);



        constraints.gridx=3;
        constraints.weightx=0;
        constraints.insets=new Insets(6,2,2,0);

        JLabel positionUpX=new JLabel();
        positionUpX.setIcon(new ImageIcon(getClass().getResource("/PwpIcons/actions/sortAsc.png/")));
        designBarPanel.add(positionUpX,constraints);


        constraints.insets=new Insets(-12,2,2,0);
        constraints.weightx=0;
        JLabel positionDownX=new JLabel(new ImageIcon(getClass().getResource("/PwpIcons/actions/sortDesc.png/")));
        designBarPanel.add(positionDownX,constraints);




        constraints.weightx=0;
        constraints.insets=new Insets(-20,2,2,0);
        JLabel positionUpY=new JLabel();
        positionUpY.setIcon(new ImageIcon(getClass().getResource("/PwpIcons/actions/sortAsc.png/")));
        designBarPanel.add(positionUpY,constraints);

        constraints.insets=new Insets(-13,2,2,0);
        constraints.weightx=0;
        JLabel positionDownY=new JLabel(new ImageIcon(getClass().getResource("/PwpIcons/actions/sortDesc.png/")));
        designBarPanel.add(positionDownY,constraints);

        constraints.insets=new Insets(-30,19,3,3);
        constraints.gridx=3;



        label=new JLabel("Size");
        label.setHorizontalTextPosition(JLabel.CENTER);
        designBarPanel.add(label,constraints);






        constraints.gridx=4;
        constraints.weightx=0;
        constraints.insets=new Insets(6,2,2,0);

        constraints.anchor=GridBagConstraints.FIRST_LINE_START;
        label=new JLabel("W",JLabel.LEFT);
        designBarPanel.add(label,constraints);

        label=new JLabel("H",JLabel.LEFT);
        designBarPanel.add(label,constraints);


        constraints.gridx=5;
        constraints.insets=new Insets(3,2,2,0);
        constraints.weightx=0;
        designBarPanel.add(precisionOfComponentsW,constraints);

        designBarPanel.add(precisionOfComponentsH,constraints);



        constraints.gridx=6;
        constraints.weightx=0;
        constraints.insets=new Insets(6,2,2,0);

        JLabel positionUpW=new JLabel();
        positionUpW.setIcon(new ImageIcon(getClass().getResource("/PwpIcons/actions/sortAsc.png/")));
        designBarPanel.add(positionUpW,constraints);

        constraints.insets=new Insets(-12,2,2,0);
        constraints.weightx=0;
        JLabel positionDownW=new JLabel(new ImageIcon(getClass().getResource("/PwpIcons/actions/sortDesc.png/")));
        designBarPanel.add(positionDownW,constraints);




        constraints.weightx=0;
        constraints.insets=new Insets(-20,2,2,0);
        JLabel positionUpH=new JLabel();
        positionUpH.setIcon(new ImageIcon(getClass().getResource("/PwpIcons/actions/sortAsc.png/")));
        designBarPanel.add(positionUpH,constraints);

        constraints.insets=new Insets(-13,2,2,0);
        constraints.weightx=0;
        JLabel positionDownH=new JLabel(new ImageIcon(getClass().getResource("/PwpIcons/actions/sortDesc.png/")));
        designBarPanel.add(positionDownH,constraints);

        constraints.insets=new Insets(-30,18,-40,0);
        constraints.gridx=6;
        // constraints.anchor=GridBagConstraints.CENTER;
        label=new JLabel("Scale");
        label.setHorizontalTextPosition(JLabel.CENTER);
        designBarPanel.add(label,constraints);









        constraints.gridx=7;
        constraints.weightx=0;
        constraints.insets=new Insets(6,2,2,0);

        constraints.anchor=GridBagConstraints.FIRST_LINE_START;
        label=new JLabel("W",JLabel.LEFT);
        designBarPanel.add(label,constraints);

        label=new JLabel("H",JLabel.LEFT);
        designBarPanel.add(label,constraints);


        constraints.gridx=8;
        constraints.insets=new Insets(3,2,2,0);
        constraints.weightx=1;

        designBarPanel.add(precisionOfComponentsSW,constraints);



        designBarPanel.add(precisionOfComponentsSH,constraints);


        constraints.gridx=9;
        constraints.weightx=1;
        constraints.insets=new Insets(6,2,2,0);

        constraints.anchor=GridBagConstraints.FIRST_LINE_START;
        label=new JLabel("%",JLabel.LEFT);
        designBarPanel.add(label,constraints);

        label=new JLabel("%",JLabel.LEFT);
        designBarPanel.add(label,constraints);

        constraints.gridx=10;
        constraints.weightx=1;
        constraints.insets=new Insets(6,5,2,0);
        JSeparator separator=new JSeparator(1);
        separator.setBorder(new WindowsBorders.DashedBorder(Color.BLACK,2));
        separator.setPreferredSize(new Dimension(1,16));
        designBarPanel.add(separator,constraints);

        separator=new JSeparator(1);
        separator.setBorder(new WindowsBorders.DashedBorder(Color.BLACK,2));
        separator.setPreferredSize(new Dimension(1,16));

        designBarPanel.add(separator,constraints);
        designBarPanel.setBorder(new LineBorder(new Color(0x609CBA),0,true));



        designBarPanel.revalidate();
        designBarPanel.requestFocus();
        designBarPanel.repaint();



        JPanel precisionPanel=new JPanel(new BorderLayout());
        precisionPanel.add(designBarPanel,BorderLayout.NORTH);
        precisionPanel.add(new JLabel("Precision",JLabel.CENTER),BorderLayout.SOUTH);


        return precisionPanel;
    }

    public Component serviceTool(){
        JToolBar  tool=new JToolBar("Tool Bar");
        tool.setLayout(new BorderLayout());
        GridBagConstraints constraints=new GridBagConstraints();

        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.EAST;
       //constraints.insets=new Insets(5,10,5,10);

        constraints.gridx=0;
        tool.add(designBar(),BorderLayout.WEST);
        constraints.gridx=1;
        tool.add(new JToolBar.Separator(new Dimension(10,20)));

        constraints.gridx=2;
        tool.add(new StyleAndPrecisionBar().serviceKit(),BorderLayout.CENTER);


        return  tool;
    }

    public JLabel createDragImage(File file) {

        ImageIcon icon = new ImageIcon(file.getAbsolutePath());
        JLabel label = new JLabel(icon);
        String cutExtension=file.getName();
        label.setText(cutExtension.substring(0,cutExtension.lastIndexOf('.')+1));
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);


        return label;

    }


    Collection <Component>collection;


    public void createComponents(Component comp, Point pointer) {
       // DragSource source = DragSource.getDefaultDragSource();
       // source.createDefaultDragGestureRecognizer(comp, DnDConstants.ACTION_COPY_OR_MOVE, new Gesture());



        comp.setLocation(pointer);
        comp.setSize(comp.getPreferredSize());
        add(comp);


        MouseAdapter mouseListener=new MouseAdapter() {








            @Override
            public void mousePressed(MouseEvent e) {


                for (Component[] conn : connector) {

                    JLabel borderLabel = (JLabel) e.getComponent();
                    borderLabel.setBorder(new LineBorder(Color.black, 1, true));
                    borderLabel.setSize(new Dimension(100, 70));

                }


                if ((e.getModifiers() & InputEvent.BUTTON3_MASK) != 0 && e.getClickCount() > 0) {

               new FolderAndFileEventHandler(new PwnPane()).defaultViewPopUpMenu(e.getX(), e.getY(), e.getComponent());


                }

            }



            @Override
            public void mouseDragged(MouseEvent e) {


                setAlignmentX(e.getX());
                repaint();
                revalidate();




            }



        };

        comp.addMouseListener(mouseListener);
        comp.addMouseMotionListener(mouseListener);

        repaint();

    }




    class DropObject implements DropTargetListener {







        @Override
        public void dragEnter(DropTargetDragEvent dtde) {
            if (dtde.isDataFlavorSupported(DataFlavor.javaFileListFlavor)
                    || dtde.isDataFlavorSupported(LOCAL_FLAVORS) || dtde.isDataFlavorSupported(FLAVOR)) {
                return;
            }

            dtde.rejectDrag();
        }

        @Override
        public void dragOver(DropTargetDragEvent dtde) {



        }

        @Override
        public void dropActionChanged(DropTargetDragEvent dtde) {
            LocationXAndY.setText(""+dragComponent.getX());

        }

        @Override
        public void dragExit(DropTargetEvent dte) {

        }

        @Override
        public void drop(DropTargetDropEvent dtde) {



            if (dtde.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {

                dtde.acceptDrop(DnDConstants.ACTION_MOVE);
                Transferable transferObject = dtde.getTransferable();

                try {
                    List list = (List) transferObject.getTransferData(DataFlavor.javaFileListFlavor);
                    Iterator iterator = list.iterator();

                    while (iterator.hasNext()) {

                        JLabel label = createDragImage((File) iterator.next());

                        createComponents(label, dtde.getLocation());


                    }
                    dtde.dropComplete(true);

                } catch (UnsupportedFlavorException e) {
                    dtde.dropComplete(false);
                    e.printStackTrace();
                } catch (IOException e) {

                    e.printStackTrace();
                }
            } else if (dtde.isDataFlavorSupported(FLAVOR)) {

                dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
                Transferable transferObject = dtde.getTransferable();

                try {




                    JLabel label =(JLabel) transferObject.getTransferData(FLAVOR);



                    connector=new ArrayList<>();
                    collection=new ArrayList();
                    collection.add(label);
                    connector.add(new Component[]{label});
                    connectorPairs=new ArrayList<>();
                    //connectorPairs.add();


                    countItem++;


                    if(countItem==2){

                    }



                    MouseAdapter mouseListener=new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {

                            Component comp= (Component) e.getSource();

                            initialLocOnScreen=e.getLocationOnScreen();
                            initialLoc=comp.getLocation();


                            Iterator <Component>iterator=collection.iterator();

                            while (iterator.hasNext()) {
                                 connectorPairs.add(new Pair(iterator.next(),e.getComponent()));

                            }



                            isConnected = true;

                            repaint();




                        }


                        @Override
                        public void mouseDragged(MouseEvent e) {
                           Component comp= (Component) e.getSource();

                            Point pointer=e.getLocationOnScreen();

                            xAxis=pointer.x-initialLocOnScreen.x+initialLoc.x;
                            yAxis=pointer.y-initialLocOnScreen.y+initialLoc.y;

                            comp.setLocation(xAxis,yAxis);




                             LocationXAndY.setText("Locate On Screen X : " +getX() + " Location On Screen Y " + getY()
                            +"Width : " + e.getComponent().getWidth() + "Height " + e.getComponent().getHeight());



                                 precisionOfComponentsX.setText(""+pointer.x);
                                 precisionOfComponentsY.setText(""+pointer.y);
                                 precisionOfComponentsH.setText(""+comp.getHeight());
                                 precisionOfComponentsW.setText(""+comp.getWidth());
                                 precisionOfComponentsSH.setText(""+comp.getHeight());
                                 precisionOfComponentsSW.setText(""+comp.getWidth());

                             isConnected=true;

                        }


                        @Override
                        public void mouseClicked(MouseEvent e) {

                            Component comp = (Component) e.getSource();


                            LocationXAndY.setText("Location On Screen X : " + label.getX() + " Location On Screen Y " + label.getY());
                            LocationXAndY.setSize(new Dimension(300, 10));





                        }


                    };
                    label.addMouseListener(mouseListener);
                    label.addMouseMotionListener(mouseListener);
                    createComponents(label, dtde.getLocation());
                    dtde.dropComplete(true);
                } catch (UnsupportedFlavorException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    dtde.dropComplete(false);
                    e.printStackTrace();
                }
            } else if (dtde.isDataFlavorSupported(LOCAL_FLAVORS)) {

                System.out.println("Local");

                dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
                Transferable transferObject = dtde.getTransferable();

                try {


                    JLabel label = (JLabel) transferObject.getTransferData(LOCAL_FLAVORS);
                    createComponents(label, dtde.getLocation());
                   // connect(new Component[]{});
                    dtde.dropComplete(true);
                } catch (UnsupportedFlavorException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    dtde.dropComplete(false);
                    e.printStackTrace();
                }


            }
        }





    }






    public void paint(Graphics g) {
        super.paint(g);


        g.setColor(Color.RED);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(Color.MAGENTA);
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_IN, 1f));

        if(isConnected) {
        for (Pair pair : connectorPairs )
        {
            JLabel label1 = pair.getLabel1();
            JLabel label2 = pair.getLabel2();
            Rectangle point1 = label1.getBounds();
            Rectangle point2 = label2.getBounds();


            int i = pair.howToDraw();
            if ( i == 1)
            {

                g2d.fillOval(point2.x +label2.getWidth() , point2.y + label2.getHeight() /2 ,  6 ,  6);
                g2d.fillOval( point1.x  , point1.y +label1.getHeight()/2 ,  6 ,  6);


                g.drawLine(point1.x  , point1.y + label1.getHeight() / 2 , point2.x + label2.getWidth() , point2.y  +  label2.getHeight() / 2);



            }
           else if (i == 2)
           {

               g2d.fillOval(point2.x  , point2.y + label2.getHeight() / 2 ,  6 ,  6);
               g2d.fillOval( point1.x + label1.getWidth() , point1.y  +  label1.getHeight() / 2 ,  6 ,  6);
               g.drawLine(point2.x , point2.y + label2.getHeight() / 2 , point1.x + label1.getWidth() , point1.y  +  label1.getHeight() / 2);


           }
         else if (i == 3)
         {
             g2d.fillOval(point2.x +label2.getWidth()/2 , point2.y + label2.getHeight()  ,  6 ,  6);
             g2d.fillOval( point1.x + label1.getWidth()/2 , point1.y  ,  6 ,  6);
             g.drawLine(point1.x + label1.getWidth() / 2 , point1.y , point2.x + label2.getWidth() / 2, point2.y + label2.getHeight());

         }
         else if (i == 4)
         {
             g2d.fillOval(point2.x +label2.getWidth()/2 , point2.y ,  6,  6);
             g2d.fillOval( point1.x + label1.getWidth()/2 , point1.y  +  label1.getHeight() ,  6 ,  6);
             g.drawLine(point2.x + label2.getWidth() / 2 , point2.y , point1.x + label1.getWidth() / 2, point1.y + label1.getHeight());

         }

            repaint();
        }

        }



}

    class Pair
    {
        JLabel label1 ;
        JLabel label2 ;
        private Pair(Component parent, Component child){
            this.label1 = (JLabel)parent ;
            this.label2 = (JLabel) child;
        }
        public Pair(JLabel label1, JLabel label2)
        {
            this.label1 = label1;
            this.label2 = label2;
        }
        @Override
        public String toString()
        {
            return "{"+label1.getLocation()+","+label2.getLocation()+"}";
        }
        public int howToDraw()
        {
            Point point1 = label1.getLocation();
            Point point2 = label2.getLocation();
            if (point1.x > point2.x)
            {
                return 1;
            }
            else if (point1.x < point2.x)
            {
                return 2;
            }
            else if (point1.y > point2.y)
            {
                return 3;
            }
            else if (point1.y < point2.y)
            {
                return 4;
            }
            else
                return 5;
        }
        public JLabel getLabel1()
        {
            return label1;
        }
        public JLabel getLabel2()
        {
            return label2;
        }
        @Override
        public boolean equals(Object obj)
        {
            if (obj == this)
            {
                return true;
            }
            if (obj instanceof Pair)
            {
                Pair temp = (Pair)obj;
                if ((temp.toString()).equalsIgnoreCase(this.toString()))
                {
                    return true;
                }
            }
            return false;
        }
    }








}




