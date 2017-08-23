package com.company;

import EventHandlers.EditorViewHandler;
import EventHandlers.PaletteEventHandler;
import PwpCreateComponents.MenuBarComponents;
import RenderFoldersAndSubFoders.CreateFolders;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Ayettey on 02/02/2017.
 */
public class PwnFrame extends JFrame {

    private  JTabbedPane tabbedPane=new JTabbedPane();
    private  JPanel panel;
    private  JSplitPane[] splitLayersOfPan;
    private JEditorPane editorPane;
    private  JTabbedPane[] tabbeds;
    private CreateFolders folders=new CreateFolders();
    private PaletteEventHandler handler=new PaletteEventHandler();





   public  PwnFrame()  {




       try{
           UIManager.setLookAndFeel(new WindowsLookAndFeel());


           MenuBarComponents menuBar=new MenuBarComponents();
           menuBar.setBackground(new Color(142, 208, 255));
           Container pane=getContentPane();
           pane.setLayout(new BorderLayout());


           EditorViewHandler x=new EditorViewHandler() ;
           setJMenuBar((menuBar.menuBarList(x.LocationXAndY)));


           ImageIcon icon=new ImageIcon((getClass().getResource("/PwpIcons/windowDecorator/favicon_1.png") ));
           Image image=icon.getImage();
           setIconImage(image);










              PwnPane pwnPane=new PwnPane();
              add(pwnPane.mainPanel());

               setBackground(Color.GRAY);






               setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

               setExtendedState(MAXIMIZED_BOTH);

               pack();


               setVisible(true);
           } catch (UnsupportedLookAndFeelException e) {
               e.printStackTrace();
           }
   }






}
