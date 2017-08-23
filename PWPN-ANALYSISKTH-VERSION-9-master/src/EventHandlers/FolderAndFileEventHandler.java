package EventHandlers;

import PwpCreateComponents.PopUpMenuListComponents;
import RenderFoldersAndSubFoders.CreateFolders;
import RenderFoldersAndSubFoders.Folders;
import RenderFoldersAndSubFoders.SubFolders;
import com.company.PwnPane;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.*;
import java.awt.event.*;
import java.io.File;
import java.util.Enumeration;

/**
 * Created by Ayettey on 17/03/2017.
 */



public  class FolderAndFileEventHandler extends PopUpMenuListComponents implements
        MouseListener,ActionListener,DropTargetListener,ClipboardOwner {

    private ImageIcon newFolderIcon ;
    private Icon folderIcon=new ImageIcon(getClass().getResource("/PwpIcons/actions/menu-open.png"));
    private ImageIcon modelIcon=new ImageIcon(getClass().getResource("/PwpIcons/actions/module.png"));


    public JMenuItem eventModelHandlerItems=new JMenuItem();
    private JPopupMenu eventModelHandlerPopupMenu;
    private JMenu    eventModelHandlerMenu;
    private Boolean isEventModelHandlerItemsEnable=false;
    private DefaultMutableTreeNode setCloneEditedValue;


    private CreateFolders tree;
    public DefaultMutableTreeNode newNodes;
    public DefaultMutableTreeNode  insertANode;
    private Folders createFiles;
    private DefaultMutableTreeNode newFolder;
    private DefaultCellEditor path;

    private DefaultMutableTreeNode newCopyClone;
    private JTextField textField;
    private String title;

    public Icon getFolderIcon() {
        return folderIcon;
    }

    PwnPane pane;
    public FolderAndFileEventHandler( PwnPane pane) {
        this.pane = pane;

    }

    public FolderAndFileEventHandler(CreateFolders tree) {
        this.tree = tree;

    }











    private DefaultMutableTreeNode copyClone(DefaultMutableTreeNode source)

    {





        newCopyClone= (DefaultMutableTreeNode) source.clone();

        DefaultMutableTreeNode mutable=null;

        for(Enumeration enumerate=source.children();enumerate.hasMoreElements();){

            mutable=new DefaultMutableTreeNode( enumerate.nextElement());



            // newCopyClone.add(mutable);

            // cloneDrag(newCopyClone).add(mutable);


            newCopyClone.getRoot().getAllowsChildren();

            newCopyClone.add(mutable);


        }







        return newCopyClone;

    } //end of deepClone //end of deepClone

    //  newCopyClone.add(mutable);











    DefaultMutableTreeNode folderNode;
    private DefaultMutableTreeNode folderClone(DefaultMutableTreeNode source)
    {
        folderNode=(DefaultMutableTreeNode)source.clone();
        for(Enumeration enumerate=source.children();enumerate.hasMoreElements();){
            folderClone((DefaultMutableTreeNode)enumerate.nextElement());

        }

        return folderNode;
    }

    public DefaultMutableTreeNode getCopyClone(){
        return newCopyClone;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        //EditCell cell=new EditCell(tree.treeNodes, (DefaultTreeCellRenderer) tree.treeNodes.getCellRenderer());
        // getEditedValue(tree.treeNodes,cell);


        TreePath path[] = tree.treeNodes.getSelectionPaths();

        if (path != null) {

            for (int i = 0; i < path.length; i++) {
                insertANode = (DefaultMutableTreeNode) path[i].getLastPathComponent();








            }
        }


    }




    @Override
    public void mousePressed(MouseEvent e) {







        if ((e.getModifiers() & InputEvent.BUTTON3_MASK) != 0 && tree.treeNodes.getSelectionCount() > 0) {
            TreePath path=tree.treeNodes.getSelectionPath();






            try{


                insertANode = (DefaultMutableTreeNode) path.getLastPathComponent();

                Object model = tree.treeNodes.getModel().getRoot();

                final String selectedLeafOrNode = insertANode.getUserObject().toString();

                if (model.toString().equals(selectedLeafOrNode)) {
                    tree.treeNodes.setSelectionRow(1);
                    eventModelHandlerMenu.setEnabled(false);


                }


                if (((DefaultMutableTreeNode) insertANode).getUserObject() instanceof SubFolders){




                    if((getFolderIcon().toString().equals(((SubFolders) ((DefaultMutableTreeNode) insertANode).
                            getUserObject()).getIcon().toString()))){



                        System.out.println(insertANode.getSharedAncestor((DefaultMutableTreeNode) insertANode.getRoot()).children().hasMoreElements()?
                                insertANode.getUserObject():insertANode.getUserObject());


                        if((insertANode.getSharedAncestor((DefaultMutableTreeNode) insertANode.getRoot()).children().hasMoreElements())){

                            for(int x=0;x<(insertANode.getRoot()).getChildCount();x++) {
                                if ((insertANode.getSharedAncestor((DefaultMutableTreeNode) ((DefaultMutableTreeNode)
                                        insertANode.getRoot()).getChildAt(x)).toString().equals("Application"))) {
                                    applicationModelPopUpMenu(e.getX(), e.getY(), tree.treeNodes);



                                }

                                if ((insertANode.getSharedAncestor((DefaultMutableTreeNode) ((DefaultMutableTreeNode)
                                        insertANode.getRoot()).getChildAt(x)).toString().equals("Business Model"))) {
                                    businessPopUpMenu(e.getX(), e.getY(), tree.treeNodes);


                                }



                                if ((insertANode.getSharedAncestor((DefaultMutableTreeNode) ((DefaultMutableTreeNode)
                                        insertANode.getRoot()).getChildAt(x)).toString().equals("Motivation"))) {
                                    motivationModelPopUpMenu(e.getX(), e.getY(), tree.treeNodes);
                                    System.out.println("nest");

                                }
                                if ((insertANode.getSharedAncestor((DefaultMutableTreeNode) ((DefaultMutableTreeNode)
                                        insertANode.getRoot()).getChildAt(x)).toString().equals("Technology"))) {
                                    technologyModelPopUpMenu(e.getX(), e.getY(), tree.treeNodes);
                                    System.out.println("nest");

                                }





                                if ((insertANode.getSharedAncestor((DefaultMutableTreeNode) ((DefaultMutableTreeNode)
                                        insertANode.getRoot()).getChildAt(x)).toString().equals("Implementation And Migration"))) {
                                    implementationAndMigrationModelPopUpMenu(e.getX(), e.getY(), tree.treeNodes);
                                    System.out.println("nest");

                                }   if ((insertANode.getSharedAncestor((DefaultMutableTreeNode) ((DefaultMutableTreeNode)
                                        insertANode.getRoot()).getChildAt(x)).toString().equals("Relations"))) {
                                    relationsPopUpMenu(e.getX(), e.getY(), tree.treeNodes);
                                    System.out.println("nest");

                                }

                                if ((insertANode.getSharedAncestor((DefaultMutableTreeNode) ((DefaultMutableTreeNode)
                                        insertANode.getRoot()).getChildAt(x)).toString().equals("Connector"))) {
                                    connectorModelPopUpMenu(e.getX(), e.getY(), tree.treeNodes);
                                    System.out.println("nest");

                                }


                                if ((insertANode.getSharedAncestor((DefaultMutableTreeNode) ((DefaultMutableTreeNode)
                                        insertANode.getRoot()).getChildAt(x)).toString().equals("Views"))) {
                                    viewsModelsPopUpMenu(e.getX(), e.getY(), tree.treeNodes);
                                    System.out.println("next");

                                }








                            }
                        }

                    }else {
                        trimLeaves(e.getX(), e.getY(), tree.treeNodes);
                    }





                }


                if (( insertANode).getUserObject() instanceof Folders) {






                    if(getFolderIcon().toString().equals(((Folders) (insertANode).
                            getUserObject()).getIcon().toString())) {





                        if(insertANode.getUserObject().toString().equals("Business Model")){
                            businessPopUpMenu(e.getX(), e.getY(), tree.treeNodes);
                        }

                        if(insertANode.getUserObject().toString().equals("Application")){
                            applicationModelPopUpMenu(e.getX(), e.getY(), tree.treeNodes);
                        }



                        if(insertANode.getUserObject().toString().equals("Technology")){
                            technologyModelPopUpMenu (e.getX(), e.getY(), tree.treeNodes);


                        }
                        if(insertANode.getUserObject().toString().equals("Business Model")){
                            businessPopUpMenu(e.getX(), e.getY(), tree.treeNodes);
                        }
                        if(insertANode.getUserObject().toString().equals("Motivation")){
                            motivationModelPopUpMenu(e.getX(), e.getY(), tree.treeNodes);
                        }
                        if(insertANode.getUserObject().toString().equals("Implementation And Migration")){
                            implementationAndMigrationModelPopUpMenu(e.getX(), e.getY(), tree.treeNodes);
                        }
                        if(insertANode.getUserObject().toString().equals("Relations")){
                            relationsPopUpMenu(e.getX(), e.getY(), tree.treeNodes);
                        }


                        if(insertANode.getUserObject().toString().equals("Connector")){
                            connectorModelPopUpMenu(e.getX(), e.getY(), tree.treeNodes);
                        }
                        if(insertANode.getUserObject().toString().equals("Default View")){
                            viewsModelsPopUpMenu(e.getX(), e.getY(), tree.treeNodes);
                        }
                        if(insertANode.getUserObject().toString().equals("Views")){
                            viewsModelsPopUpMenu(e.getX(), e.getY(), tree.treeNodes);
                        }
                        if(insertANode.getUserObject().toString().equals("Network Analysis")){
                            viewsModelsPopUpMenu(e.getX(), e.getY(), tree.treeNodes);
                        }


                    }else {
                        trimLeaves(e.getX(), e.getY(), tree.treeNodes);
                    }




                } else {
                    applicationModelPopUpMenu(e.getX(), e.getY(), tree.treeNodes);

                }


            }catch (Exception x){

            }






        }
    }



    private void trimTree(int x,int y,JTree treeNodes){




        eventModelHandlerItems=new JMenuItem("Copy",new ImageIcon(getClass().getResource("/PwpIcons/actions/copy.png")));
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Paste" ,new ImageIcon(getClass().getResource("/PwpIcons/actions/menu-paste.png")));
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));


        if(isEventModelHandlerItemsEnable.equals(false)){
            eventModelHandlerItems.setEnabled(false);
        }if((isEventModelHandlerItemsEnable.equals(true))) {
            eventModelHandlerItems.setEnabled(true);
        }



        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);


        eventModelHandlerItems=new JMenuItem("Delete",new ImageIcon(getClass().getResource("/PwpIcons/actions/delete.png")));
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,2));
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);


        eventModelHandlerPopupMenu.add(new JSeparator());

        eventModelHandlerMenu=new JMenu("Refactor");
        eventModelHandlerItems=new JMenuItem("Move",new ImageIcon(getClass().getResource("/PwpIcons/actions/MoveTo2.png")));
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2,0));
        eventModelHandlerMenu.add(eventModelHandlerItems);




        eventModelHandlerItems.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Copy",new ImageIcon(getClass().getResource("/PwpIcons/actions/copy.png")));
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2,0));
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Delete",new ImageIcon(getClass().getResource("/PwpIcons/actions/delete.png")));
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2,0));
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems.setPreferredSize(new Dimension(300,20));
        eventModelHandlerPopupMenu.add(eventModelHandlerMenu);

        eventModelHandlerPopupMenu.add(new JSeparator());
        eventModelHandlerItems=new JMenuItem("Generate view for..");
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);



        eventModelHandlerItems=new JMenuItem("Validate model");
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);

        eventModelHandlerPopupMenu.add(new JSeparator());
        eventModelHandlerItems=new JMenuItem("Property");
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, ActionEvent.ALT_MASK));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);



        eventModelHandlerItems.setPreferredSize(new Dimension(300,20));

        TreePath path=treeNodes.getSelectionPath();
        Object node=path.getLastPathComponent();
        if(node==treeNodes.getModel().getRoot()){
            eventModelHandlerPopupMenu.setEnabled(false);
        }else {
            eventModelHandlerPopupMenu.show(treeNodes,x,y);
        }

    }
    public void trimLeaves(int x,int y,JTree treeNodes){

        eventModelHandlerPopupMenu=new JPopupMenu();
        eventModelHandlerItems=new JMenuItem("Copy",new ImageIcon(getClass().getResource("/PwpIcons/actions/copy.png")));
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Paste" ,new ImageIcon(getClass().getResource("/PwpIcons/actions/menu-paste.png")));
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);

        if(isEventModelHandlerItemsEnable.equals(false)){
            eventModelHandlerItems.setEnabled(false);
        }if((isEventModelHandlerItemsEnable.equals(true))) {
            eventModelHandlerItems.setEnabled(true);
        }

        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);



        eventModelHandlerItems=new JMenuItem("Delete",new ImageIcon(getClass().getResource("/PwpIcons/actions/delete.png")));
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,2));
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem();
        eventModelHandlerItems.setText("Duplicate");
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,3));
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);


        eventModelHandlerPopupMenu.add(new JSeparator());

        eventModelHandlerMenu=new JMenu("Refactor");
        eventModelHandlerItems=new JMenuItem("Move",new ImageIcon(getClass().getResource("/PwpIcons/actions/MoveTo2.png")));
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2,0));
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));
        eventModelHandlerMenu.add(eventModelHandlerItems);


        eventModelHandlerItems=new JMenuItem("Rename");
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2,0));
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Copy",new ImageIcon(getClass().getResource("/PwpIcons/actions/copy.png")));
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2,0));
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Delete",new ImageIcon(getClass().getResource("/PwpIcons/actions/delete.png")));
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2,0));
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems.setPreferredSize(new Dimension(300,20));
        eventModelHandlerPopupMenu.add(eventModelHandlerMenu);
        eventModelHandlerPopupMenu.add(new JSeparator());


        eventModelHandlerItems=new JMenuItem("Generate view for..");
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);



        eventModelHandlerItems=new JMenuItem("Validate model");
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);

        eventModelHandlerPopupMenu.add(new JSeparator());
        eventModelHandlerItems=new JMenuItem("Property");
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, ActionEvent.ALT_MASK));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);



        eventModelHandlerItems.setPreferredSize(new Dimension(300,20));

        TreePath path=treeNodes.getSelectionPath();
        Object node=path.getLastPathComponent();
        if(node==treeNodes.getModel().getRoot()){
            eventModelHandlerPopupMenu.setEnabled(false);
        }else {
            eventModelHandlerPopupMenu.show(treeNodes,x,y);
        }


    }
    private void trimTreeCollapse(int x,int y,JTree treeNodes){



        eventModelHandlerItems=new JMenuItem("Copy",new ImageIcon(getClass().getResource("/PwpIcons/actions/copy.png")));
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems=new JMenuItem("Paste" ,new ImageIcon(getClass().getResource("/PwpIcons/actions/menu-paste.png")));
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems=new JMenuItem(new ImageIcon(getClass().getResource("/PwpIcons/actions/delete.png")));
        eventModelHandlerItems.setText("Delete");
        items=eventModelHandlerItems.getText();
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,2));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerPopupMenu.add(new JSeparator());
        eventModelHandlerItems=new JMenuItem("Collapse",new ImageIcon(getClass().getResource("/PwpIcons/actions/collapseall.png")));
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4,0));
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);

        eventModelHandlerPopupMenu.add(new JSeparator());
        eventModelHandlerItems=new JMenuItem("Generate view for..");
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Validate model");
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);

        eventModelHandlerPopupMenu.add(new JSeparator());
        eventModelHandlerItems=new JMenuItem("Property");
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, ActionEvent.ALT_MASK));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);

        eventModelHandlerItems.setPreferredSize(new Dimension(300,20));

        TreePath path=treeNodes.getSelectionPath();
        Object node=path.getLastPathComponent();
        if(node==treeNodes.getModel().getRoot()){
            eventModelHandlerPopupMenu.setEnabled(false);
        }else {
            eventModelHandlerPopupMenu.show(treeNodes,x,y);
        }

    }



    public void getEditedValue(JTree tree,DefaultTreeCellEditor editor) {


        editor.addCellEditorListener(new CellEditorListener() {
            @Override
            public void editingStopped(ChangeEvent e) {


                tree.setCellEditor(editor);
                tree.setEditable(true);


                if (path != null) {


                    path = (DefaultCellEditor) e.getSource();
                    String edited = (String) path.getCellEditorValue();

                    DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

                    cloneEditedValue(new DefaultMutableTreeNode(edited));
                    createFiles = new Folders();

                    if ((node).getUserObject() instanceof Folders) {

                        createFiles.setSubFolders(new SubFolders(edited, ((Folders) (node).getUserObject()).getIcon()));
                        setIcon(((Folders) (node).getUserObject()).getIcon());


                    }
                    if ((node).getUserObject() instanceof SubFolders) {

                        createFiles.setSubFolders(new SubFolders(edited, ((SubFolders) (node).getUserObject()).getIcon()));


                    }


                }


            }

            @Override
            public void editingCanceled(ChangeEvent e) {

            }
        });
    }

    public DefaultMutableTreeNode businessPopUpMenu(int x,int y,JTree treeNodes){

        eventModelHandlerPopupMenu=new JPopupMenu();


        eventModelHandlerMenu=new JMenu("New");
        eventModelHandlerPopupMenu.add(eventModelHandlerMenu);

        eventModelHandlerPopupMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Folder",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/fldr_obj.gif")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));



        eventModelHandlerMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Business Actor",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-actor-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems=new JMenuItem("Business Role",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-role-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems=new JMenuItem("Business Collaboration",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-collaboration-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems=new JMenuItem("Business Interface",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-interface-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        //   eventModelHandlerMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Business Function",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-function-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems=new JMenuItem("Business Process",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-process-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems=new JMenuItem("Business Event",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-event-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems=new JMenuItem("Business Interaction",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-interaction-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        //   eventModelHandlerMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Business Product",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-product-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems=new JMenuItem("Business Contract",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-contract-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems=new JMenuItem("Business Service",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-service-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems=new JMenuItem("Business Value",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-value-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        //   eventModelHandlerMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Business Meaning",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-meaning-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems=new JMenuItem("Business Representation",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-representation-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems=new JMenuItem("Business Object",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-object-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems=new JMenuItem("Location",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-location-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems.setPreferredSize(new Dimension(200,20));

        trimTree(x,y,treeNodes);

        return (DefaultMutableTreeNode) newCopyClone;

    }


    @Override
    public void mouseReleased (MouseEvent e){

    }



    @Override
    public void mouseEntered (MouseEvent e){

        TreeSelectionModel treeSelectionModel=tree.treeNodes.getSelectionModel();
        treeSelectionModel.setSelectionMode(TreeSelectionModel.CONTIGUOUS_TREE_SELECTION);
        tree.treeNodes.setSelectionModel(treeSelectionModel);

    }





    @Override
    public void mouseExited (MouseEvent e){



    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //  if(e.getActionCommand().equals("Copy")){
        //
        //      copy();
        //  }else if(e.getActionCommand().equals("Paste")){
        //
        //       paste();
        //
        //
        //  }else if(e.getActionCommand().equals("Paste")){
        //
        //      paste();
        //
        //
        //  } else if (!e.getActionCommand().equals("Folder") & !(e.getActionCommand().equals("Rename"))
        //          &!(item.getText().equals("Duplicate")) & !(item.getText().equals("Paste"))
        //          & !(item.getText().equals("Copy")) ){
        //
        //      allBusinessActivities(tree.treeNodes,e.getActionCommand()
        //              ,eventModelHandlerItems.getIcon());
        //
        //
        //
        //
        //
        //
        //
        //
        //  }else if (!e.getActionCommand().equals("Delete")){
        //
        //  }
        //
        //  System.out.println(item.getText() +" " + e.getActionCommand() );
        //  //  }



        //}


    }


    ActionListener listenToItems(JTree treeNode, JMenuItem item) {


        TreePath path[] = tree.treeNodes.getSelectionPaths();

        if (path != null) {

            for (int i = 0; i < path.length; i++) {
                insertANode = (DefaultMutableTreeNode) path[i].getLastPathComponent();


            }




            ActionListener listiner =new  ActionListener() {


                @Override
                public void actionPerformed(ActionEvent e) {



                    try {


                        if (item.getText().equals("Delete")) {

                            delete(treeNode);

                        } else if (item.getText().equals("Folder")) {

                            newFolder(treeNode);

                        } else if ((!e.getActionCommand().equals("Folder")) && (!(e.getActionCommand().equals("Delete"))
                                && (!(e.getActionCommand().equals("Copy")) && (!(e.getActionCommand().equals("Paste"))))
                                && (!(e.getActionCommand().equals("Duplicate")) && (!(e.getActionCommand().equals("Rename")))))) {

                            allBusinessActivities(treeNode, e.getActionCommand(), item.getIcon());


                        } else if (item.getText().equals("Rename")) {

                            rename(treeNode);

                        } else if (item.getText().equals("Duplicate")) {
                            duplicate(treeNode, e.getActionCommand(), item.getIcon());


                        }
                        if (item.getText().equals("Copy")) {
                            isEventModelHandlerItemsEnable = true;
                            copy();


                        }


                        if (item.getText().equals("Paste")) {
                            paste();

                        }


                    } catch (Exception x) {
                          x.printStackTrace();
                    }

                    if (!item.getText().equals("Paste") && !item.getText().equals("Copy")
                            && !item.getText().equals("Remove") && !item.getText().equals("Paste")
                            && !item.getText().equals("Delete")) {

                        TreePath[] paths = treeNode.getSelectionPaths();
                        for (int x = 0; x < paths.length; x++) {
                            treeNode.expandPath(paths[x]);
                        }

                    }

                }
            };

            return listiner;
        }

        return this;
    }



    public void copy(){










        try {







            TreeNode getNode = (TreeNode) tree.treeNodes.getLastSelectedPathComponent();



            try {













                Point loc = tree.treeNodes.getLocation();

                TreePath destinationPath = tree.treeNodes.getSelectionPath().getParentPath();

                DefaultMutableTreeNode getLastSelectedPath = null;

                if (loc.getLocation() == null) {



                    return;

                } else {





                    getLastSelectedPath = (DefaultMutableTreeNode) destinationPath.getLastPathComponent();



                    if (getLastSelectedPath.getUserObject().equals("")) {

                        System.out.println("Hole");



                        return;

                    }











                }















                if(getNode !=null) {

                    getLastSelectedPath= (DefaultMutableTreeNode) getNode;







                    System.out.println("hate"+getLastSelectedPath);
                    DefaultMutableTreeNode node=new DefaultMutableTreeNode();
                    node.add(getLastSelectedPath);


                    copyClone(getLastSelectedPath);





                }











            } catch (Exception x) {

                x.printStackTrace();



            }











            //setClip(paths.toString());



        } catch (Exception x) {

            x.printStackTrace();

        }







    }



    public void paste(){







        try {

            System.out.println("paste");



            TreePath paths = tree.treeNodes.getSelectionPath();





            DefaultMutableTreeNode pastObjectPath=null;

            DefaultMutableTreeNode pastObject=null;

            if(paths ==null){

                return;

            }else {

                pastObjectPath= (DefaultMutableTreeNode) paths.getLastPathComponent();









                DefaultTreeModel model= (DefaultTreeModel) tree.treeNodes.getModel();



                if(pastObjectPath.getChildCount() !=-1) {



                    Folders folders=new Folders();

                    folders.setSubFolders(new SubFolders(getCopyClone().getUserObject().toString(),

                            folderIcon));





                    model.insertNodeInto(getCopyClone(),
                            (MutableTreeNode) pastObjectPath.getParent(), pastObjectPath.getChildCount());

                    //model.reload();

                    tree.treeNodes.requestFocus();







                    DefaultTreeModel model_1 = (DefaultTreeModel) tree.treeNodes.getModel();



                    // DefaultTreeModel model = (DefaultTreeModel) tree.treeNodes.getModel();







                    tree.treeNodes.setSelectionPath(paths);



                    tree.treeNodes.setExpandsSelectedPaths(true);









                    tree.treeNodes.expandPath(paths);

                }else {

                    return;

                }

            }



































        } catch (Exception x) {

            x.printStackTrace();



        }



    }



    public void rename(JTree treeNodes) {


        try{

            DefaultMutableTreeNode node;

            TreePath[] paths = treeNodes.getSelectionPaths();
            DefaultTreeModel model = (DefaultTreeModel) treeNodes.getModel();

            for (int i=0;i<paths.length;i++){




                //  new Folders().setSubFolders(new SubFolders());
                node= (DefaultMutableTreeNode) paths[i].getLastPathComponent();



                treeNodes.setEditable(true);
                treeNodes.startEditingAtPath(paths[i]);




                // createFiles.setSubFolders(new SubFolders(node.getUserObject().toString(),icon));
                // model.insertNodeInto(node=new DefaultMutableTreeNode());




            }

        }catch (NullPointerException x){

        }



    }


    public void newFolder(JTree treeNodes) {



        TreePath[] paths = treeNodes.getSelectionPaths();
        DefaultTreeModel model = (DefaultTreeModel) treeNodes.getModel();
        Icon dialogIcon = new ImageIcon(getClass().getResource("/PwpIcons/actions/newFolder.png"));











        try {



            UIManager.put("OptionPane.minimumSize", new Dimension(400, 130));

            userObject = JOptionPane.showInputDialog(null, "Enter a new directory name", "New Folder"
                    , SwingConstants.CENTER, dialogIcon, null, null);


            folderClone(new DefaultMutableTreeNode(userObject.toString()));



            while (userObject.equals(""))


                userObject = JOptionPane.showInputDialog(null , "The text must not be empty",
                        "New Folder", SwingConstants.CENTER, dialogIcon, null, null);

            folderClone(new DefaultMutableTreeNode(userObject.toString()));
            copyClone(new DefaultMutableTreeNode(userObject.toString()));


            folderClone(new DefaultMutableTreeNode( userObject.toString()));








            createFiles=new Folders();
            for(int i=0;i<paths.length;i++){
                if((userObject.toString().startsWith(userObject.toString()))) {

                    createFiles.setSubFolders(new SubFolders(userObject.toString(),getFolderIcon()));



                }




                newNodes= (DefaultMutableTreeNode) paths[i].getLastPathComponent();

                for(int x=0;x<createFiles.getSubFolders().size();x++) {


                    newFolder = new DefaultMutableTreeNode(createFiles.getSubFolders().get(x));
                    model.insertNodeInto(newFolder, newNodes, newNodes.getChildCount());

                }




                treeNodes.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
                ToolTipManager.sharedInstance( ).registerComponent(treeNodes);






                treeNodes.expandPath(paths[i]);
            }

        }

        catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"No folder was created","Empty message",JOptionPane.OK_OPTION);

        }





    }








    DefaultMutableTreeNode cloneEditedValue(DefaultMutableTreeNode node){
        setCloneEditedValue= (DefaultMutableTreeNode) node.clone();
        for(Enumeration enumerate=node.children();enumerate.hasMoreElements();){
            setCloneEditedValue=cloneEditedValue((DefaultMutableTreeNode) enumerate.nextElement());
        }
        return setCloneEditedValue;
    }

    public DefaultMutableTreeNode getCloneValue() {
        return setCloneEditedValue;
    }


    @Override
    public void dragEnter(DropTargetDragEvent dtde) {





    }

    @Override
    public void dragOver(DropTargetDragEvent dtde) {



    }

    @Override
    public void dropActionChanged(DropTargetDragEvent dtde) {

    }

    @Override
    public void dragExit(DropTargetEvent dte) {



    }

    @Override
    public void drop(DropTargetDropEvent dtde) {

        TreeNode getNode = (TreeNode) tree.treeNodes.getLastSelectedPathComponent();

        try {

            Transferable filesTobeTransfer = dtde.getTransferable();
            DataFlavor[] typeOfDataToBeTransfer = filesTobeTransfer.getTransferDataFlavors();


            // removeDragNodeAfterDropped= (DefaultMutableTreeNode) getNode.getParent();
            System.out.println(filesTobeTransfer);


            Point loc = dtde.getLocation();
            TreePath destinationPath = tree.treeNodes.getPathForLocation(loc.x, loc.y);
            DefaultMutableTreeNode getLastSelectedPath = null;
            if (typeOfDataToBeTransfer.length == -1) {
                dtde.rejectDrop();
                return;
            } else {
                //  for(int i=0;i<typeOfDataToBeTransfer.length;i++){


                // if(typeOfDataToBeTransfer[i].match(typeOfDataToBeTransfer[i])){
                //  System.out.println(typeOfDataToBeTransfer[i].getMimeType());


                getLastSelectedPath = (DefaultMutableTreeNode) destinationPath.getLastPathComponent();

                if (getLastSelectedPath.getUserObject().equals("")) {
                    System.out.println("Hole");
                    dtde.rejectDrop();
                    return;
                }


                if (dtde.getDropAction() == DnDConstants.ACTION_COPY) {


                } else {

                    System.out.println("not drag");
                    System.out.println("Enter");

                }


            }




            UIManager.put("OptionPane.minimumSize",new Dimension(460,100));
            String path = new File(getLastSelectedPath.toString()).getAbsolutePath();
            Object option=  JOptionPane.showInputDialog(null,"You are about to move object to "
                            +getLastSelectedPath + " directory, processed ?",
                    "Move",JOptionPane.OK_CANCEL_OPTION,new ImageIcon(),null ,path
            );



            if(option !=null) {
                TreePath seek= (TreePath) tree.treeNodes.getSelectionPath();
                DefaultMutableTreeNode find= (DefaultMutableTreeNode) seek.getLastPathComponent();

                if(((DefaultMutableTreeNode)find).getUserObject() instanceof  Folders) {
                    if (folderIcon.toString().equals((((Folders) ((DefaultMutableTreeNode) find).getUserObject())).getIcon().toString())) {
                        getLastSelectedPath.add((MutableTreeNode) getNode);
                        System.out.println("Pass through");

                        DefaultTreeModel model = (DefaultTreeModel) tree.treeNodes.getModel();
                        model.reload();
                        ;
                        if(!getLastSelectedPath.getAllowsChildren()) {
                            getLastSelectedPath.remove(getLastSelectedPath);
                            tree.treeNodes.setSelectionPath(destinationPath);
                            tree.treeNodes.setExpandsSelectedPaths(true);
                        }

                        if (getLastSelectedPath.getUserObject() != null)
                            // filesDrag.add(folder.getSubNode());
                            tree.treeNodes.setSelectionPath(destinationPath);
                        tree.treeNodes.setExpandsSelectedPaths(true);
                    }

                }if(((DefaultMutableTreeNode)find).getUserObject() instanceof  SubFolders){



                    if(getNode.toString().equals(getNode.toString()))
                        getLastSelectedPath.add((MutableTreeNode) getNode);


                    DefaultTreeModel model = (DefaultTreeModel) tree.treeNodes.getModel();

                    // DefaultTreeModel model = (DefaultTreeModel) tree.treeNodes.getModel();
                    model.reload();
//                    model.insertNodeInto((MutableTreeNode) getLastSelectedPath.children(), (MutableTreeNode) find.getParent(),find.getChildCount());


                    if (getLastSelectedPath.getUserObject() != null)
                        // filesDrag.add(folder.getSubNode());
                        tree.treeNodes.setSelectionPath(destinationPath);
                    tree.treeNodes.setExpandsSelectedPaths(true);
                }


            }else {
                dtde.rejectDrop();
                return;
            }




            // DefaultMutableTreeNode filesDrag = new DefaultMutableTreeNode();
            //Folders folder = new Folders();
            //folder.setSubFolders(new SubFolders(getLastSelectedPath.getUserObject().toString(), icon));
            //folder.setSubNode(getLastSelectedPath);



            // tree.treeNodes.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
            //ToolTipManager.sharedInstance( ).registerComponent(tree.treeNodes);






            tree.treeNodes.expandPath(destinationPath);
            dtde.rejectDrop();
            System.out.println("Drop failed: " + dtde);

        } catch (Exception e) {
            e.printStackTrace();
            dtde.rejectDrop();
        }
    }





    public void networkAnalysisPopUpMenu(int x,int y,JTree treeNodes,String itemNames){


        eventModelHandlerPopupMenu=new JPopupMenu();
        eventModelHandlerPopupMenu.setBorder(new LineBorder(new Color(130, 173, 255),1,true));
        eventModelHandlerMenu=new JMenu("New");
        eventModelHandlerPopupMenu.add(eventModelHandlerMenu);

        eventModelHandlerPopupMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Folder",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/fldr_obj.gif")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Business Actor",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-actor-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Business Role",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-role-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Business Collaboration",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-collaboration-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Business Interface",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-interface-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Business Function",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-function-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Business Process",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-process-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Business Event",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-event-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Business Interaction",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-interaction-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Business Product",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-product-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Business Contract",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-contract-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Business Service",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-service-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Business Value",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-value-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Business Meaning",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-meaning-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Business Representation",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-representation-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Business Object",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-object-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Location",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-location-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerMenu.add(new JSeparator());

        eventModelHandlerItems.setPreferredSize(new Dimension(200,20));

        trimTree(x,y,treeNodes);





    }

    public DefaultMutableTreeNode applicationModelPopUpMenu(int x,int y,JTree treeNodes){

        eventModelHandlerPopupMenu=new JPopupMenu();


        eventModelHandlerMenu=new JMenu("New");
        eventModelHandlerPopupMenu.add(eventModelHandlerMenu);


        eventModelHandlerPopupMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Folder",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/fldr_obj.gif")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Application Component",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/application-component-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems=new JMenuItem("Application Collaboration",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/application-collaboration-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems=new JMenuItem("Application Interface",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/application-interface-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems=new JMenuItem("Application Service",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/application-service-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));
        eventModelHandlerMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Application Function",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/application-function-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems=new JMenuItem("Application Interaction",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/application-interaction-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems=new JMenuItem("Data Object",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/application-data-object-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));


        eventModelHandlerItems.setPreferredSize(new Dimension(200,20));
        trimTree(x,y,treeNodes);


        return newCopyClone;
    }
    public void technologyModelPopUpMenu(int x,int y,JTree treeNodes){

        eventModelHandlerPopupMenu=new JPopupMenu();
        eventModelHandlerPopupMenu.setBorder(new LineBorder(new Color(130, 173, 255),1,true));
        eventModelHandlerMenu=new JMenu("New");
        eventModelHandlerPopupMenu.add(eventModelHandlerMenu);

        eventModelHandlerPopupMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Folder",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/fldr_obj.gif")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Artifact",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/technology-artifact-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems=new JMenuItem("Communication Path",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/technology-communication-path-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems=new JMenuItem("Network",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/technology-network-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Infrastructure Interface",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/technology-infra-interface-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        //   eventModelHandlerMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Infrastructure Function",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/technology-function-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems=new JMenuItem("Infrastructure Service",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/technology-infra-service-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems=new JMenuItem("Node",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/technology-node-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems=new JMenuItem("System Software",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/technology-system-software-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        //   eventModelHandlerMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Device",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/technology-device-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));


        eventModelHandlerItems.setPreferredSize(new Dimension(200,20));





        trimTree(x,y,treeNodes);




    }
    public void motivationModelPopUpMenu(int x,int y,JTree treeNodes){

        eventModelHandlerPopupMenu=new JPopupMenu();
        eventModelHandlerPopupMenu.setBorder(new LineBorder(new Color(130, 173, 255),1,true));
        eventModelHandlerMenu=new JMenu("New");
        eventModelHandlerPopupMenu.add(eventModelHandlerMenu);

        eventModelHandlerPopupMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Folder",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/fldr_obj.gif")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Stakeholder",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/stakeholder-filled-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems=new JMenuItem("Driver",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/driver-filled-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems=new JMenuItem("Assessment",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/assessment-filled-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems=new JMenuItem("Goal",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/goal-filled-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems=new JMenuItem("Principle",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/principle-filled-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems=new JMenuItem("Requirement",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/requirement-filled-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems=new JMenuItem("Constraint",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/constraint-filled-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));


        eventModelHandlerItems.setPreferredSize(new Dimension(200,20));




        trimTree(x,y,treeNodes);




    }
    public void implementationAndMigrationModelPopUpMenu(int x,int y,JTree treeNodes){


        eventModelHandlerPopupMenu=new JPopupMenu();
        eventModelHandlerPopupMenu.setBorder(new LineBorder(new Color(130, 173, 255),1,true));
        eventModelHandlerMenu=new JMenu("New");
        eventModelHandlerPopupMenu.add(eventModelHandlerMenu);

        eventModelHandlerPopupMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Folder",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/fldr_obj.gif")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Work Package",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/workpackage-filled-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems=new JMenuItem("Deliverable",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/deliverable-filled-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems=new JMenuItem("Plateau",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/plateau-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems=new JMenuItem("Gap",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/gap-filled-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems.setPreferredSize(new Dimension(200,20));



        trimTree(x,y,treeNodes);



    }
    public void connectorModelPopUpMenu(int x,int y,JTree treeNodes){


        eventModelHandlerPopupMenu=new JPopupMenu();
        eventModelHandlerPopupMenu.setBorder(new LineBorder(new Color(130, 173, 255),1,true));
        eventModelHandlerMenu=new JMenu("New");
        eventModelHandlerPopupMenu.add(eventModelHandlerMenu);

        eventModelHandlerPopupMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Folder",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/fldr_obj.gif")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Junction",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/junction-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems=new JMenuItem("And Junction",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/junction-and-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems=new JMenuItem("Or Junction",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/junction-or-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));



        eventModelHandlerItems.setPreferredSize(new Dimension(200,20));






        trimTree(x,y,treeNodes);


    }
    public void relationsPopUpMenu(int x,int y,JTree treeNodes){

        eventModelHandlerPopupMenu=new JPopupMenu();
        eventModelHandlerPopupMenu.setBorder(new LineBorder(new Color(130, 173, 255),1,true));
        eventModelHandlerMenu=new JMenu("New");
        eventModelHandlerPopupMenu.add(eventModelHandlerMenu);

        eventModelHandlerPopupMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Folder",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/fldr_obj.gif")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));




        eventModelHandlerItems.setPreferredSize(new Dimension(200,20));
        trimTree(x,y,treeNodes);




    }
    public void viewsModelsPopUpMenu(int x,int y,JTree treeNodes){


        eventModelHandlerPopupMenu=new JPopupMenu();
        eventModelHandlerPopupMenu.setBorder(new LineBorder(new Color(130, 173, 255),1,true));
        eventModelHandlerMenu=new JMenu("New");
        eventModelHandlerPopupMenu.add(eventModelHandlerMenu);

        eventModelHandlerItems=new JMenuItem("Sketch View",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/sketch-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems=new JMenuItem("Or Junction",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/junction-or-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerPopupMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Folder",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/fldr_obj.gif")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerMenu.add(new JSeparator());

        ImageIcon pwp3Icon=new ImageIcon(new ImageIcon(getClass().getResource("/PwpIcons/windowDecorator/favicon.png")).getImage().getScaledInstance(16,16,1));
        eventModelHandlerItems=new JMenuItem("PwnPr3d View",pwp3Icon);
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems=new JMenuItem("Sketch View",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/sketch-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Blank Canvas");
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems=new JMenuItem("Canvas From Template");
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));



        eventModelHandlerItems.setPreferredSize(new Dimension(200,20));


        trimTreeCollapse(x,y,treeNodes);
        //trimTree(x,y,treeNodes);


    }

    public void defaultViewPopUpMenu(int x,int y,Component treeNode3){

        eventModelHandlerPopupMenu=new JPopupMenu();
        eventModelHandlerPopupMenu.setBorder(new LineBorder(new Color(130, 173, 255),1,true));
        eventModelHandlerMenu=new JMenu("New");
        eventModelHandlerPopupMenu.add(eventModelHandlerMenu);

        eventModelHandlerPopupMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Folder",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/fldr_obj.gif")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

       // eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("PwnPr3d View");
        eventModelHandlerMenu.add(eventModelHandlerItems);
       // eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems=new JMenuItem("Sketch View",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/sketch-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
       // eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Blank Canvas");
        eventModelHandlerMenu.add(eventModelHandlerItems);
        //eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems=new JMenuItem("Canvas From Template");
        eventModelHandlerMenu.add(eventModelHandlerItems);
       // eventModelHandlerItems.addActionListener(listenToItems(treeNodes,eventModelHandlerItems));



        eventModelHandlerItems.setPreferredSize(new Dimension(300,20));

         JPopupMenu p= new JPopupMenu();
       p.show(treeNode3,x,y);

    }

    @Override
    public void lostOwnership(Clipboard clipboard, Transferable contents) {

    }
}








