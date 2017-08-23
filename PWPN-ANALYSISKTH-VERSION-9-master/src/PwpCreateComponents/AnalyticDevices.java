package PwpCreateComponents;

import EventHandlers.PaletteEventHandler;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.text.Position;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by Ayettey on 18/04/2017.
 */
public class AnalyticDevices extends JPanel{



    private JPanel technologyPanel=new JPanel(new FlowLayout(FlowLayout.TRAILING,10,10) );
    private JPanel applicationPanel=new JPanel(new FlowLayout(FlowLayout.TRAILING,10,10) );
    private JPanel businessPanel=new JPanel(new FlowLayout(FlowLayout.TRAILING,10,10) );
    private JPanel networkPanel=new JPanel(new FlowLayout(SwingConstants.VERTICAL,10,10) );
    private JPanel motivationPanel=new JPanel(new FlowLayout(FlowLayout.TRAILING,10,10) );
    private JPanel serversPanel=new JPanel(new FlowLayout(FlowLayout.TRAILING,10,10) );
    private JPanel socialPanel=new JPanel(new FlowLayout(FlowLayout.TRAILING,10,10) );
    private JPanel implementationPanel=new JPanel(new FlowLayout(FlowLayout.TRAILING,10,10) );
    private JPanel relationsPanel=new JPanel(new FlowLayout(FlowLayout.TRAILING,10,10) );
    private JPanel connectorPanel=new JPanel(new FlowLayout(FlowLayout.TRAILING,10,10) );
    private JPanel componentPanel=new JPanel( new BorderLayout());
    private JPanel shapeAndSearchPanel=new JPanel(new GridBagLayout());


    private JLabel paletteObjects;
    private JLabel paletteLoading;
    private JMenuItem listItems;
    private JPopupMenu listMenuPop;
    private JButton search;
    ArrayList<Object> items;
    private JScrollPane palettePane;
    public JList listMenu;
    private String fileUrl;
    private JScrollPane entitiesScrollbar=new  JScrollPane(this,
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);


    @Override
          public Dimension getPreferredSize() {
            int col, row, height, width;
          Dimension dimension = null;
        width= (int) entitiesScrollbar.getViewport().getSize().getWidth();
       col = width / 140;

       if (col >0) {
       row = (int)(Math.ceil(25.0/col));
       height = row*140 ;
           dimension = new Dimension(width, height);
       }
      else{
           dimension = super.getPreferredSize();
       }
       return dimension;
      }





    public Component devices(){


        setLayout(new BorderLayout());
        listOfShapes();


        networkStencils(networkPanel);
        applicationStencils(applicationPanel);
        businessStencils(businessPanel);
        technology(technologyPanel);
        motivationStencils(motivationPanel);
        serverStencils(serversPanel);
        implementationStencils(implementationPanel);
        relationsStencils(relationsPanel);
        connectorStencils(connectorPanel);
        socialMediaStencils(socialPanel);

        return entitiesScrollbar;









    }


    public JComponent networkStencils(JPanel  networkPanel){






            PaletteEventHandler eventHandler = new PaletteEventHandler();




        File setD=new File(getClass().getResource("/PwpIcons/NetworkAndActivities/").getPath());

        for(File file: setD.listFiles() ){

            if (file.getName().toLowerCase().endsWith("png")) {
                ImageIcon icon = new ImageIcon(new ImageIcon(file.getAbsolutePath()).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
                paletteObjects = new JLabel(icon, JLabel.CENTER);
                String str = file.getName();
                paletteObjects.setText(str.substring(0, str.lastIndexOf('.') + 1));

                eventHandler.createComponent(paletteObjects, paletteObjects.getLocation());



                eventHandler.createImage(file);
                networkPanel.add(paletteObjects);
            }

        }


       // entitiesScrollbar.add(connectorPanel);
        add(networkPanel,BorderLayout.CENTER);
            return this ;
        }


    public JComponent applicationStencils(JPanel applicationPanel){


        PaletteEventHandler eventHandler = new PaletteEventHandler();




        File directory = new File(getClass().getResource("/PwpIcons/Application/").getPath());
        for (File file : directory.listFiles()) {


            if (file.getName().toLowerCase().endsWith("png")) {
                ImageIcon icon = new ImageIcon(new ImageIcon(file.getAbsolutePath()).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));

                String str = file.getName();


                eventHandler.createImage(file);

                paletteObjects = new JLabel(icon,JLabel.CENTER);


                paletteObjects.setText(str.substring(0, str.lastIndexOf('.') + 1));

                eventHandler.createComponent(paletteObjects, paletteObjects.getLocation());


                applicationPanel.add(paletteObjects);











            }
        }

        return  applicationPanel;
    }
    public JComponent businessStencils(JPanel businessPanel){


        PaletteEventHandler eventHandler = new PaletteEventHandler();





        File directory = new File(getClass().getResource("/PwpIcons/Business/").getPath());
        for (File file : directory.listFiles()) {


            if (file.getName().toLowerCase().endsWith("png")) {
                ImageIcon icon = new ImageIcon(new ImageIcon(file.getAbsolutePath()).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));

                String str = file.getName();


                eventHandler.createImage(file);

                paletteObjects = new JLabel(icon,JLabel.CENTER);


                paletteObjects.setText(str.substring(0, str.lastIndexOf('.') + 1));

                eventHandler.createComponent(paletteObjects, paletteObjects.getLocation());


                 businessPanel.add(paletteObjects);



            }
        }

        return  businessPanel;
    }


    public JComponent technology(JPanel technologyPanel){

        PaletteEventHandler eventHandler = new PaletteEventHandler();




        File directory = new File(getClass().getResource("/PwpIcons/Technology/").getPath());
        for (File file : directory.listFiles()) {


            if (file.getName().toLowerCase().endsWith("png")) {
                ImageIcon icon = new ImageIcon(new ImageIcon(file.getAbsolutePath()).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));

                String str = file.getName();


                eventHandler.createImage(file);

                paletteObjects = new JLabel(icon,JLabel.CENTER);


                paletteObjects.setText(str.substring(0, str.lastIndexOf('.') + 1));

                eventHandler.createComponent(paletteObjects, paletteObjects.getLocation());


                    technologyPanel.add(paletteObjects);




            }
        }


        return technologyPanel;
    }
    public JComponent motivationStencils(JPanel motivationPanel){


        PaletteEventHandler eventHandler = new PaletteEventHandler();




        File directory = new File(getClass().getResource("/PwpIcons/Motivation/").getPath());
        for (File file : directory.listFiles()) {


            if (file.getName().toLowerCase().endsWith("png")) {
                ImageIcon icon = new ImageIcon(new ImageIcon(file.getAbsolutePath()).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));

                String str = file.getName();


                eventHandler.createImage(file);

                paletteObjects = new JLabel(icon,JLabel.CENTER);


                paletteObjects.setText(str.substring(0, str.lastIndexOf('.') + 1));

                eventHandler.createComponent(paletteObjects, paletteObjects.getLocation());


                motivationPanel.add(paletteObjects);




            }
        }


        return motivationPanel;
    }
    public JComponent serverStencils(JPanel serversPanel){


        PaletteEventHandler eventHandler = new PaletteEventHandler();




        File directory = new File(getClass().getResource("/PwpIcons/Servers/").getPath());
        for (File file : directory.listFiles()) {


            if (file.getName().toLowerCase().endsWith("png")) {
                ImageIcon icon = new ImageIcon(new ImageIcon(file.getAbsolutePath()).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));

                String str = file.getName();


                eventHandler.createImage(file);

                paletteObjects = new JLabel(icon,JLabel.CENTER);


                paletteObjects.setText(str.substring(0, str.lastIndexOf('.') + 1));

                eventHandler.createComponent(paletteObjects, paletteObjects.getLocation());


                serversPanel.add(paletteObjects);




            }
        }


        return serversPanel;
    }


    public JComponent implementationStencils(JPanel implementationPanel){


        PaletteEventHandler eventHandler = new PaletteEventHandler();




        File directory = new File(getClass().getResource("/PwpIcons/Implementation/").getPath());
        for (File file : directory.listFiles()) {


            if (file.getName().toLowerCase().endsWith("png")) {
                ImageIcon icon = new ImageIcon(new ImageIcon(file.getAbsolutePath()).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));

                String str = file.getName();


                eventHandler.createImage(file);

                paletteObjects = new JLabel(icon,JLabel.CENTER);


                paletteObjects.setText(str.substring(0, str.lastIndexOf('.') + 1));

                eventHandler.createComponent(paletteObjects, paletteObjects.getLocation());


                implementationPanel.add(paletteObjects);




            }
        }


        return implementationPanel;
    }
    public JComponent relationsStencils(JPanel relationsPanel){

        PaletteEventHandler eventHandler = new PaletteEventHandler();




        File directory = new File(getClass().getResource("/PwpIcons/Relation/").getPath());
        for (File file : directory.listFiles()) {


            if (file.getName().toLowerCase().endsWith("png")) {
                ImageIcon icon = new ImageIcon(new ImageIcon(file.getAbsolutePath()).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));

                String str = file.getName();


                eventHandler.createImage(file);

                paletteObjects = new JLabel(icon,JLabel.CENTER);


                paletteObjects.setText(str.substring(0, str.lastIndexOf('.') + 1));

                eventHandler.createComponent(paletteObjects, paletteObjects.getLocation());


                relationsPanel.add(paletteObjects);




            }
        }


        return relationsPanel;
    }
    public JComponent connectorStencils(JPanel connectorPanel){





        PaletteEventHandler eventHandler = new PaletteEventHandler();




        File directory = new File(getClass().getResource("/PwpIcons/Connector/").getPath());
        for (File file : directory.listFiles()) {


            if (file.getName().toLowerCase().endsWith("png")) {
                ImageIcon icon = new ImageIcon(new ImageIcon(file.getAbsolutePath()).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));

                String str = file.getName();


                eventHandler.createImage(file);

                paletteObjects = new JLabel(icon,JLabel.CENTER);


                paletteObjects.setText(str.substring(0, str.lastIndexOf('.') + 1));

                eventHandler.createComponent(paletteObjects, paletteObjects.getLocation());


                connectorPanel.add(paletteObjects);




            }
        }


        return connectorPanel;
    }
    public JComponent socialMediaStencils(JPanel socialPanel){



        PaletteEventHandler eventHandler = new PaletteEventHandler();




        File directory = new File(getClass().getResource("/PwpIcons/Social/").getPath());
        for (File file : directory.listFiles()) {


            if (file.getName().toLowerCase().endsWith("png")) {
                ImageIcon icon = new ImageIcon(new ImageIcon(file.getAbsolutePath()).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));

                String str = file.getName();


                eventHandler.createImage(file);

                paletteObjects = new JLabel(icon,JLabel.CENTER);


                paletteObjects.setText(str.substring(0, str.lastIndexOf('.') + 1));

                eventHandler.createComponent(paletteObjects, paletteObjects.getLocation());


                socialPanel.add(paletteObjects);




            }
        }


        return socialPanel;
    }



public void flowEvents(JTextField textField,JList listMenu) {

    String text = textField.getText();

    for (int x = 0; x < listMenu.getModel().getSize(); x++) {


        int count = listMenu.getNextMatch(text, 0, Position.Bias.Forward);

        if (count != -1) {


            listMenu.setSelectedIndex(count);
            // palettePane.getVerticalScrollBar().setValue( listMenu.getSelectedIndex()+20);
            if (count == 1) {

                networkPanel.setVisible(false);
                entitiesScrollbar.setVisible(false);
                technologyPanel.setVisible(false);
                applicationPanel.setVisible(false);
                motivationPanel.setVisible(false);
                serversPanel.setVisible(false);
                socialPanel.setVisible(false);
                implementationPanel.setVisible(false);
                relationsPanel.setVisible(false);
                connectorPanel.setVisible(false);
                businessPanel.setVisible(true);
                add(businessPanel).setVisible(true);


                repaint();
                revalidate();
                requestFocus();

            } else if (count == 2) {

                networkPanel.setVisible(false);
                entitiesScrollbar.setVisible(false);
                technologyPanel.setVisible(false);
                applicationPanel.setVisible(true);
                motivationPanel.setVisible(false);
                serversPanel.setVisible(false);
                socialPanel.setVisible(false);
                implementationPanel.setVisible(false);
                relationsPanel.setVisible(false);
                connectorPanel.setVisible(false);
                businessPanel.setVisible(false);
                add(applicationPanel).setVisible(true);


                repaint();
                revalidate();
                requestFocus();


            }
            if (count == 3) {

                networkPanel.setVisible(false);
                entitiesScrollbar.setVisible(false);
                technologyPanel.setVisible(true);
                applicationPanel.setVisible(false);
                motivationPanel.setVisible(false);
                serversPanel.setVisible(false);
                socialPanel.setVisible(false);
                implementationPanel.setVisible(false);
                relationsPanel.setVisible(false);
                connectorPanel.setVisible(false);
                businessPanel.setVisible(false);
                add(technologyPanel).setVisible(true);


                repaint();
                revalidate();
                requestFocus();


            } else if (count == 4) {


                networkPanel.setVisible(false);
                technologyPanel.setVisible(false);
                applicationPanel.setVisible(false);
                motivationPanel.setVisible(true);
                serversPanel.setVisible(false);
                socialPanel.setVisible(false);
                implementationPanel.setVisible(false);
                relationsPanel.setVisible(false);
                connectorPanel.setVisible(false);
                businessPanel.setVisible(false);
                add(motivationPanel).setVisible(true);


                repaint();
                revalidate();
                requestFocus();


            }
            if (count == 5) {

                networkPanel.setVisible(false);
                technologyPanel.setVisible(false);
                applicationPanel.setVisible(false);
                motivationPanel.setVisible(false);
                serversPanel.setVisible(true);
                socialPanel.setVisible(false);
                implementationPanel.setVisible(false);
                relationsPanel.setVisible(false);
                connectorPanel.setVisible(false);
                businessPanel.setVisible(false);
                add(serversPanel).setVisible(true);


                repaint();
                revalidate();
                requestFocus();


            } else if (count == 6) {


                networkPanel.setVisible(false);
                technologyPanel.setVisible(false);
                applicationPanel.setVisible(false);
                motivationPanel.setVisible(false);
                serversPanel.setVisible(false);
                socialPanel.setVisible(false);
                implementationPanel.setVisible(true);
                relationsPanel.setVisible(false);
                connectorPanel.setVisible(false);
                businessPanel.setVisible(false);
                add(implementationPanel).setVisible(true);


                repaint();
                revalidate();
                requestFocus();


            }
            if (count == 7) {

                networkPanel.setVisible(true);
                technologyPanel.setVisible(false);
                applicationPanel.setVisible(false);
                motivationPanel.setVisible(false);
                serversPanel.setVisible(false);
                socialPanel.setVisible(false);
                implementationPanel.setVisible(false);
                relationsPanel.setVisible(false);
                connectorPanel.setVisible(false);
                businessPanel.setVisible(false);
                add(networkPanel).setVisible(true);


                repaint();
                revalidate();
                requestFocus();


            } else if (count == 8) {


                networkPanel.setVisible(false);
                technologyPanel.setVisible(false);
                applicationPanel.setVisible(false);
                motivationPanel.setVisible(false);
                serversPanel.setVisible(false);
                socialPanel.setVisible(false);
                implementationPanel.setVisible(false);
                relationsPanel.setVisible(true);
                connectorPanel.setVisible(false);
                businessPanel.setVisible(false);
                add(relationsPanel).setVisible(true);


                repaint();
                revalidate();
                requestFocus();


            }
            if (count == 9) {

                networkPanel.setVisible(false);
                technologyPanel.setVisible(false);
                applicationPanel.setVisible(false);
                motivationPanel.setVisible(false);
                serversPanel.setVisible(false);
                socialPanel.setVisible(false);
                implementationPanel.setVisible(false);
                relationsPanel.setVisible(false);
                connectorPanel.setVisible(true);
                businessPanel.setVisible(false);
                add(connectorPanel).setVisible(true);


                repaint();
                revalidate();
                requestFocus();


            } else if (count == 10) {


                networkPanel.setVisible(false);
                technologyPanel.setVisible(false);
                applicationPanel.setVisible(false);
                motivationPanel.setVisible(false);
                serversPanel.setVisible(false);
                socialPanel.setVisible(true);
                implementationPanel.setVisible(false);
                relationsPanel.setVisible(false);
                connectorPanel.setVisible(false);
                businessPanel.setVisible(false);
                add(socialPanel).setVisible(true);


                repaint();
                revalidate();
                requestFocus();


            }
        }
    }
}
    public JComponent listOfShapes(){


        GridBagConstraints constraints=new GridBagConstraints();

        constraints.insets=new Insets(5,0,5,10);
        constraints.gridx=0;
        constraints.anchor=GridBagConstraints.LINE_START;

        JLabel label = new JLabel("Shapes", JLabel.LEFT);
        label.setForeground(new Color(0x467AE6));
        label.setFont(new Font("",Font.PLAIN,15));
        shapeAndSearchPanel.add(label,constraints);


        constraints.gridx=1;

        JSeparator separator=new JSeparator(SwingConstants.VERTICAL);
        separator.setPreferredSize(new Dimension(1,30));
        shapeAndSearchPanel.add(separator,constraints);


        constraints.gridx=2;
        constraints.fill=GridBagConstraints.HORIZONTAL;
        constraints.weightx=1.0;


        JTextField textField=new JTextField(16);

        textField.setFont(new Font("",Font.PLAIN,13));
        textField.setText("Search");
        textField.setBorder(new EmptyBorder(0,0,0,0));

        listMenuPop=new JPopupMenu("Hint!");








        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

                JTextField getInput= (JTextField) e.getSource();

                if(textField.getText().equals("Search")){
                    textField.setText("");
                }





            }

            @Override
            public void focusLost(FocusEvent e) {
                if(textField.getText().isEmpty()){
                    textField.setText("Search");

                }


            }
        });


        search=new JButton(new ImageIcon(getClass().getResource("/PwpIcons/actions/search.png")));
        JPanel borderPanel=new JPanel(new GridBagLayout());
        Border border=BorderFactory.createLineBorder(Color.gray,1,true);
        constraints.anchor=GridBagConstraints.LINE_START;
        constraints.gridx=0;
        constraints.fill=GridBagConstraints.HORIZONTAL;
        borderPanel.add(textField,constraints);

        constraints.gridx=1;
        constraints.fill=GridBagConstraints.REMAINDER;
        constraints.anchor=GridBagConstraints.LINE_END;
        borderPanel.add(search,constraints);
        borderPanel.setBorder(border);
        borderPanel.setBackground(Color.white);

        constraints.gridx=2;
        constraints.fill=GridBagConstraints.HORIZONTAL;
        constraints.ipadx=-10;
        shapeAndSearchPanel.add(borderPanel,constraints);












        constraints.anchor=GridBagConstraints.LINE_START;
        constraints.insets=new Insets(0,-65,0,5);
        paletteLoading=new JLabel();
        paletteLoading.setIcon(new ImageIcon(getClass().getResource("/PwpIcons/Loading/loader.png")));
        paletteLoading.setPreferredSize(new Dimension(20,15));
        shapeAndSearchPanel.add(paletteLoading,constraints);




        constraints.weightx=2.0;
      //  constraints.insets=new Insets(0,-65,0,5);
        constraints.fill=GridBagConstraints.HORIZONTAL;
        String[] x={"More Shapes","Business Model",
                "Application","Technology","Motivation","Servers","Implementation and Migrations",
                "Network Analysis","Relations","Connectors","Social"};



        DefaultListModel model= new DefaultListModel();

        listMenu=new JList(model);
        listMenu.setAutoscrolls(true);

        listMenu.setFont(new Font("Sans serif",Font.PLAIN,12));
        listMenu.setBackground(new Color(0xFCFCFC));

        for(int y=0;y<x.length;y++){


            model.addElement(x[y]+"\n");
            listMenu.setSelectedIndex(7);


        }

        listMenu.setCellRenderer(new renderList());


        //listMenu.setPreferredSize(new Dimension(300,100));




        constraints.insets=new Insets(0,-65,0,5);
        shapeAndSearchPanel.add(palettePane=new JScrollPane(listMenu),constraints);
        //palettePane.setPreferredSize(new Dimension(300,200));



        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String txt=textField.getText();
                int position= listMenu.getNextMatch(txt,0, Position.Bias.Forward);
                //String getPositionElement= (String) listMenu.getModel().getElementAt(position);




                if(textField.getText().equals("")){

                    JOptionPane.showMessageDialog(new JLabel(new ImageIcon(

                    )),"The text field must not be empty","Empty field",JOptionPane.OK_OPTION);

                    return;

                } if(position==0){
                    System.out.print(position);

                    JOptionPane.showMessageDialog(new JLabel(new ImageIcon(

                    )),"The text field must not be empty","Empty field",JOptionPane.OK_OPTION);

                    return;



                }
                else if(!textField.getText().equals("Search") && !textField.getText().equals(" ")){

                    paletteObjectCommandsFlow(textField);


                }

            }
        });




        ArrayList<String> Items=new ArrayList<String>();
        for(int y=0;y<listMenu.getModel().getSize();y++) {

            Items.add(y, (String) listMenu.getModel().getElementAt(y));

            System.out.print(Items.get(y));
        }

        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                final String txt=textField.getText();
                int position= listMenu.getNextMatch(txt,0, Position.Bias.Forward);

                for(int x=0;x<Items.size();x++)
                if (e.getKeyCode()==KeyEvent.VK_ENTER){
                    if((position ==-1) && (!textField.getText().equals(Items.get(x))) ){
                        System.out.print(x + Items.get(5));

                        JOptionPane.showMessageDialog(new JLabel(new ImageIcon(

                        )),textField.getText()+" Can not be found","Search not found",JOptionPane.OK_OPTION);

                        return;



                    }
                }


            }
        });

        listMenu.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                paletteLoading.setVisible(true);
                paletteLoading.setIcon(new ImageIcon(getClass().getResource("/PwpIcons/Loading/loader.gif")));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                paletteLoading.setIcon(new ImageIcon(getClass().getResource("/PwpIcons/Loading/loader.png")));
            }

            @Override
            public void mousePressed(MouseEvent e) {


                paletteObjectFlow(textField);


            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // paletteLoading.setVisible(false);

                repaint();
                revalidate();
                requestFocus();
            }




        });





        search.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {








                final String txt=textField.getText();
                int position= listMenu.getNextMatch(txt,0, Position.Bias.Forward);

                search.setFocusable(true);
                search.getFocusCycleRootAncestor();


                if(textField.getText().equals("Search")){

                    JOptionPane.showMessageDialog(new JLabel(new ImageIcon(

                    )),textField.getText()+" can be found in the palette objects list","Empty field",JOptionPane.OK_OPTION);

                    return;

                }





                for(int x=0;x< Items.size();x++){


                    if((position ==-1) && (!textField.getText().equals(Items.get(x))) ){
                        System.out.print(x + Items.get(5));

                        JOptionPane.showMessageDialog(new JLabel(new ImageIcon(

                        )),textField.getText()+" Can not be found","Search not found",JOptionPane.OK_OPTION);

                        return;



                    } else if(!textField.getText().equals("Search") && !textField.getText().equals(" ")){

                        paletteObjectCommandsFlow(textField);


                    }



                }







                search.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode()==KeyEvent.VK_ENTER){

                        }
                        Component frame = new JFrame();
                        JOptionPane.showMessageDialog(frame , "You've Submitted the name " + textField.getText());

                    }
                });


            }














        });








        add(shapeAndSearchPanel,BorderLayout.NORTH);

        return this;

    }


    public void paletteObjectCommandsFlow(JTextField textField){

        String text=textField.getText();

        for(int x=0;x<listMenu.getModel().getSize();x++) {




            int count=listMenu.getNextMatch(text,0 , Position.Bias.Forward);

            if(count!=-1){


                listMenu.setSelectedIndex(count);
                // palettePane.getVerticalScrollBar().setValue( listMenu.getSelectedIndex()+20);
                if (count == 1) {

                    networkPanel.setVisible(false);
                    entitiesScrollbar.setVisible(false);
                    technologyPanel.setVisible(false);
                    applicationPanel.setVisible(false);
                    motivationPanel.setVisible(false);
                    serversPanel.setVisible(false);
                    socialPanel.setVisible(false);
                    implementationPanel.setVisible(false);
                    relationsPanel.setVisible(false);
                    connectorPanel.setVisible(false);
                    businessPanel.setVisible(true);
                    add(businessPanel).setVisible(true);


                    repaint();
                    revalidate();
                    requestFocus();

                } else if (count == 2) {

                    networkPanel.setVisible(false);
                    entitiesScrollbar.setVisible(false);
                    technologyPanel.setVisible(false);
                    applicationPanel.setVisible(true);
                    motivationPanel.setVisible(false);
                    serversPanel.setVisible(false);
                    socialPanel.setVisible(false);
                    implementationPanel.setVisible(false);
                    relationsPanel.setVisible(false);
                    connectorPanel.setVisible(false);
                    businessPanel.setVisible(false);
                    add(applicationPanel).setVisible(true);


                    repaint();
                    revalidate();
                    requestFocus();





                }
                if (count == 3) {

                    networkPanel.setVisible(false);
                    entitiesScrollbar.setVisible(false);
                    technologyPanel.setVisible(true);
                    applicationPanel.setVisible(false);
                    motivationPanel.setVisible(false);
                    serversPanel.setVisible(false);
                    socialPanel.setVisible(false);
                    implementationPanel.setVisible(false);
                    relationsPanel.setVisible(false);
                    connectorPanel.setVisible(false);
                    businessPanel.setVisible(false);
                    add(technologyPanel).setVisible(true);


                    repaint();
                    revalidate();
                    requestFocus();





                } else if (count == 4) {


                    networkPanel.setVisible(false);
                    technologyPanel.setVisible(false);
                    applicationPanel.setVisible(false);
                    motivationPanel.setVisible(true);
                    serversPanel.setVisible(false);
                    socialPanel.setVisible(false);
                    implementationPanel.setVisible(false);
                    relationsPanel.setVisible(false);
                    connectorPanel.setVisible(false);
                    businessPanel.setVisible(false);
                    add(motivationPanel).setVisible(true);


                    repaint();
                    revalidate();
                    requestFocus();





                }
                if (count == 5) {

                    networkPanel.setVisible(false);
                    technologyPanel.setVisible(false);
                    applicationPanel.setVisible(false);
                    motivationPanel.setVisible(false);
                    serversPanel.setVisible(true);
                    socialPanel.setVisible(false);
                    implementationPanel.setVisible(false);
                    relationsPanel.setVisible(false);
                    connectorPanel.setVisible(false);
                    businessPanel.setVisible(false);
                    add(serversPanel).setVisible(true);


                    repaint();
                    revalidate();
                    requestFocus();




                } else if (count == 6) {


                    networkPanel.setVisible(false);
                    technologyPanel.setVisible(false);
                    applicationPanel.setVisible(false);
                    motivationPanel.setVisible(false);
                    serversPanel.setVisible(false);
                    socialPanel.setVisible(false);
                    implementationPanel.setVisible(true);
                    relationsPanel.setVisible(false);
                    connectorPanel.setVisible(false);
                    businessPanel.setVisible(false);
                    add(implementationPanel).setVisible(true);


                    repaint();
                    revalidate();
                    requestFocus();




                }
                if (count == 7) {

                    networkPanel.setVisible(true);
                    technologyPanel.setVisible(false);
                    applicationPanel.setVisible(false);
                    motivationPanel.setVisible(false);
                    serversPanel.setVisible(false);
                    socialPanel.setVisible(false);
                    implementationPanel.setVisible(false);
                    relationsPanel.setVisible(false);
                    connectorPanel.setVisible(false);
                    businessPanel.setVisible(false);
                    add(networkPanel).setVisible(true);


                    repaint();
                    revalidate();
                    requestFocus();







                } else if (count == 8) {


                    networkPanel.setVisible(false);
                    technologyPanel.setVisible(false);
                    applicationPanel.setVisible(false);
                    motivationPanel.setVisible(false);
                    serversPanel.setVisible(false);
                    socialPanel.setVisible(false);
                    implementationPanel.setVisible(false);
                    relationsPanel.setVisible(true);
                    connectorPanel.setVisible(false);
                    businessPanel.setVisible(false);
                    add(relationsPanel).setVisible(true);


                    repaint();
                    revalidate();
                    requestFocus();






                }
                if (count == 9) {

                    networkPanel.setVisible(false);
                    technologyPanel.setVisible(false);
                    applicationPanel.setVisible(false);
                    motivationPanel.setVisible(false);
                    serversPanel.setVisible(false);
                    socialPanel.setVisible(false);
                    implementationPanel.setVisible(false);
                    relationsPanel.setVisible(false);
                    connectorPanel.setVisible(true);
                    businessPanel.setVisible(false);
                    add(connectorPanel).setVisible(true);


                    repaint();
                    revalidate();
                    requestFocus();






                } else if (count == 10) {


                    networkPanel.setVisible(false);
                    technologyPanel.setVisible(false);
                    applicationPanel.setVisible(false);
                    motivationPanel.setVisible(false);
                    serversPanel.setVisible(false);
                    socialPanel.setVisible(true);
                    implementationPanel.setVisible(false);
                    relationsPanel.setVisible(false);
                    connectorPanel.setVisible(false);
                    businessPanel.setVisible(false);
                    add(socialPanel).setVisible(true);


                    repaint();
                    revalidate();
                    requestFocus();






                }
            }


        }
    }

    public void paletteObjectFlow(JTextField textField) {


        int count = listMenu.getNextMatch(listMenu.getSelectedValue().toString(), 0, Position.Bias.Forward);
        String text=textField.getText();
        int count1 = listMenu.getNextMatch(text, 0, Position.Bias.Forward);
        String f = (String) listMenu.getModel().getElementAt(count);
        // items.add(c, f);
        if (count != -1 || count1!=1 ) {

            if (count == 1 || count1==1 ) {
                System.out.print("Business");
                networkPanel.setVisible(false);
                technologyPanel.setVisible(false);
                applicationPanel.setVisible(false);
                motivationPanel.setVisible(false);
                serversPanel.setVisible(false);
                socialPanel.setVisible(false);
                implementationPanel.setVisible(false);
                relationsPanel.setVisible(false);
                connectorPanel.setVisible(false);
                businessPanel.setVisible(true);
                add(businessPanel, BorderLayout.CENTER);


                repaint();
                revalidate();
                requestFocus();

            } else if (count == 2|| count1==2 ) {

                networkPanel.setVisible(false);
                technologyPanel.setVisible(false);
                applicationPanel.setVisible(true);
                motivationPanel.setVisible(false);
                serversPanel.setVisible(false);
                socialPanel.setVisible(false);
                implementationPanel.setVisible(false);
                relationsPanel.setVisible(false);
                connectorPanel.setVisible(false);
                businessPanel.setVisible(false);
                add(applicationPanel, BorderLayout.CENTER);


                repaint();
                revalidate();
                requestFocus();


            }
            if (count == 3|| count1==3 ) {

                networkPanel.setVisible(false);
                technologyPanel.setVisible(true);
                applicationPanel.setVisible(false);
                motivationPanel.setVisible(false);
                serversPanel.setVisible(false);
                socialPanel.setVisible(false);
                implementationPanel.setVisible(false);
                relationsPanel.setVisible(false);
                connectorPanel.setVisible(false);
                businessPanel.setVisible(false);
                add(technologyPanel, BorderLayout.CENTER);


                repaint();
                revalidate();
                requestFocus();


            } else if (count == 4|| count1==4 ) {


                networkPanel.setVisible(false);
                technologyPanel.setVisible(false);
                applicationPanel.setVisible(false);
                motivationPanel.setVisible(true);
                serversPanel.setVisible(false);
                socialPanel.setVisible(false);
                implementationPanel.setVisible(false);
                relationsPanel.setVisible(false);
                connectorPanel.setVisible(false);
                businessPanel.setVisible(false);
                add(motivationPanel, BorderLayout.CENTER);


                repaint();
                revalidate();
                requestFocus();


            }
            if (count == 5 || count1==5 ) {

                networkPanel.setVisible(false);
                technologyPanel.setVisible(false);
                applicationPanel.setVisible(false);
                motivationPanel.setVisible(false);
                serversPanel.setVisible(true);
                socialPanel.setVisible(false);
                implementationPanel.setVisible(false);
                relationsPanel.setVisible(false);
                connectorPanel.setVisible(false);
                businessPanel.setVisible(false);
                add(serversPanel, BorderLayout.CENTER);


                repaint();
                revalidate();
                requestFocus();


            } else if (count == 6|| count1==6 ) {


                networkPanel.setVisible(false);
                technologyPanel.setVisible(false);
                applicationPanel.setVisible(false);
                motivationPanel.setVisible(false);
                serversPanel.setVisible(false);
                socialPanel.setVisible(false);
                implementationPanel.setVisible(true);
                relationsPanel.setVisible(false);
                connectorPanel.setVisible(false);
                businessPanel.setVisible(false);
                add(implementationPanel, BorderLayout.CENTER);


                repaint();
                revalidate();
                requestFocus();


            }
            if (count == 7 || count1==7 ) {

                networkPanel.setVisible(true);
                technologyPanel.setVisible(false);
                applicationPanel.setVisible(false);
                motivationPanel.setVisible(false);
                serversPanel.setVisible(false);
                socialPanel.setVisible(false);
                implementationPanel.setVisible(false);
                relationsPanel.setVisible(false);
                connectorPanel.setVisible(true);
                businessPanel.setVisible(false);
                add(networkPanel, BorderLayout.CENTER);


                repaint();
                revalidate();
                requestFocus();


            } else if (count == 8 || count1==8 ) {


                networkPanel.setVisible(false);
                technologyPanel.setVisible(false);
                applicationPanel.setVisible(false);
                motivationPanel.setVisible(false);
                serversPanel.setVisible(false);
                socialPanel.setVisible(false);
                implementationPanel.setVisible(false);
                relationsPanel.setVisible(true);
                connectorPanel.setVisible(false);
                businessPanel.setVisible(false);
                add(relationsPanel, BorderLayout.CENTER);


                repaint();
                revalidate();
                requestFocus();


            }
            if (count == 9 || count1==9 ) {

                networkPanel.setVisible(false);
                technologyPanel.setVisible(false);
                applicationPanel.setVisible(false);
                motivationPanel.setVisible(false);
                serversPanel.setVisible(false);
                socialPanel.setVisible(false);
                implementationPanel.setVisible(false);
                relationsPanel.setVisible(false);
                connectorPanel.setVisible(true);
                businessPanel.setVisible(false);
                add(connectorPanel, BorderLayout.CENTER);


                repaint();
                revalidate();
                requestFocus();


            } else if (count == 10 || count1==10 ) {


                networkPanel.setVisible(false);
                technologyPanel.setVisible(false);
                applicationPanel.setVisible(false);
                motivationPanel.setVisible(false);
                serversPanel.setVisible(false);
                socialPanel.setVisible(true);
                implementationPanel.setVisible(false);
                relationsPanel.setVisible(false);
                connectorPanel.setVisible(false);
                businessPanel.setVisible(false);
                add(socialPanel, BorderLayout.CENTER);


                repaint();
                revalidate();
                requestFocus();


            }
        }
    }



    class renderList extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {


            JLabel label= (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);


            if(isSelected){
                label.setFont(new Font("San serif",Font.BOLD,12));
                label.setToolTipText(label.getText());
            }




            return label;
        }
    }
}
