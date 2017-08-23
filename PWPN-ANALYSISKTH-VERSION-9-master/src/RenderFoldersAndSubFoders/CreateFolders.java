package RenderFoldersAndSubFoders;


import EventHandlers.FolderAndFileEventHandler;
import EventHandlers.PaletteEventHandler;
import RenderFoldersAndSubFoders.FolderAndFileCellEditor.TrimModels;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;
import java.awt.dnd.DropTarget;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
 * Created by Ayettey on 10/02/2017.
 */
public class CreateFolders  extends PaletteEventHandler{







    public DefaultMutableTreeNode newModels;
    public JTree treeNodes =new JTree();
    private JEditorPane pane;
    DefaultMutableTreeNode nodes;
    DefaultMutableTreeNode root;



    private ImageIcon modelIcon=new ImageIcon(getClass().getResource("/PwpIcons/actions/module.png"));
    private ImageIcon folderIcon=new ImageIcon(getClass().getResource("/PwpIcons/actions/menu-open.png"));
    private ImageIcon expandedIcon=new ImageIcon(getClass().getResource("/PwpIcons/actions/expandall.png"));
    private ImageIcon collapseIcon=new ImageIcon(getClass().getResource("/PwpIcons/actions/collapseall.png"));
    private ImageIcon defaultViewIcon = new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/models.gif"));

    public JTextField label=new JTextField(80);
    public JLabel labels=new JLabel();



    public FolderAndFileEventHandler modelHandler=new FolderAndFileEventHandler(this);





    Model modelRoot;
    private JTextField textField;
    private PaletteEventHandler handler;

    public JComponent modelTree(){



        //Initialize tree objects



        modelRoot=new Model();
        modelRoot.setModels("Models");
        modelRoot.setIcon(modelIcon);
        modelRoot.setCollapseIcon(collapseIcon);

        Folders businessModel=new Folders();
        businessModel.setNodes("Business Model");
        businessModel.setSubFolders(new SubFolders("Business Interaction",folderIcon));
        businessModel.setIcon(folderIcon);
        modelRoot.setNodesOfFolders(businessModel);






        Folders applicationModels=new Folders();
        applicationModels.setNodes("Application");
        applicationModels.setSubFolders(new SubFolders("Default View",folderIcon));
        applicationModels.setIcon(folderIcon);
        modelRoot.setNodesOfFolders(applicationModels);

        Folders technologyModels=new Folders();
        technologyModels.setNodes("Technology");
        technologyModels.setIcon(folderIcon);
        modelRoot.setNodesOfFolders(technologyModels);

        Folders motivationModels=new Folders();
        motivationModels.setNodes("Motivation");
        motivationModels.setIcon(folderIcon);
        modelRoot.setNodesOfFolders(motivationModels);

        Folders implementationAndMigrationModels=new Folders();
        implementationAndMigrationModels.setNodes("Implementation And Migration");
        implementationAndMigrationModels.setIcon(folderIcon);
        modelRoot.setNodesOfFolders(implementationAndMigrationModels);

        Folders relations=new Folders();
        relations.setNodes("Relations");
        relations.setIcon(folderIcon);
        modelRoot.setNodesOfFolders(relations);

        Folders connector=new Folders();
        connector.setNodes("Connector");
        connector.setIcon(folderIcon);
        modelRoot.setNodesOfFolders(connector);

        Folders views=new Folders();
        views.setNodes("Views");
        views.setSubFolders(new SubFolders("Default View",defaultViewIcon));
        views.setIcon(folderIcon);
        modelRoot.setNodesOfFolders(views);



        Folders networkAnalysis=new Folders();
        networkAnalysis.setNodes("Network Analysis");
        networkAnalysis.setIcon(folderIcon);
        modelRoot.setNodesOfFolders(networkAnalysis);






        //Initialize Tree Nodes
        root=new DefaultMutableTreeNode(modelRoot);







       for(Folders folders:modelRoot.getNodesOfFolders()){

            nodes=new DefaultMutableTreeNode(folders);

           for(SubFolders subFolders:folders.getSubFolders()){


               nodes.add(new DefaultMutableTreeNode(subFolders) );
           }

           root.add(nodes);




       }

        DefaultTreeModel model=new DefaultTreeModel(root);
        treeNodes=new JTree();
        treeNodes.setModel(model);
        TreeSelectionModel treeSelectionModel=treeNodes.getSelectionModel();
        treeSelectionModel.setSelectionMode(TreeSelectionModel.CONTIGUOUS_TREE_SELECTION);
        treeNodes.setSelectionModel(treeSelectionModel);




        //Set the tree cell editable true and show handle of the root
        treeNodes.setDropMode(DropMode.ON);
        treeNodes.setDragEnabled(true);
        treeNodes.setDropTarget(new DropTarget(treeNodes,modelHandler));


        treeNodes.setSelectionRow(1);

        if(treeNodes.isRowSelected(1)){

            labels.setText(treeNodes.getSelectionPath().getLastPathComponent().toString());
            label.setText(treeNodes.getSelectionPath().getLastPathComponent().toString());
            labels.setIcon(folderIcon);
            labels.setFont(new Font("",Font.PLAIN,14));
            labels.setForeground(new Color(0x0B88A3));
            //tree.setEditable(false);



        }


        treeNodes.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {


                label.setText(e.getPath().getLastPathComponent().toString());


                labels.setForeground(new Color(0x0B88A3));
                labels.setText(e.getPath().getLastPathComponent().toString());


                TreePath path=e.getPath();
                DefaultMutableTreeNode node= (DefaultMutableTreeNode) path.getLastPathComponent();

                if(( node  ).getUserObject() instanceof Folders){
                    labels.setIcon(((Folders) (node.getUserObject()) ).getIcon()  );
                    labels.setFont(new Font("",Font.PLAIN,14));

                }else {
                    labels.setIcon(((SubFolders) (node.getUserObject()) ).getIcon()  );
                    labels.setFont(new Font("",Font.PLAIN,14));

                }

                //






            }

        });

       // handler.label=new JLabel();













        treeNodes.setShowsRootHandles(true);






        treeNodes.setCellRenderer(new TrimModels());
        UIManager.put("Tree.expandedIcon",expandedIcon);
        UIManager.put("Tree.collapsedIcon",collapseIcon);


        treeNodes.addMouseListener(modelHandler);
       //treeNodes.setInvokesStopCellEditing(true);
        handler=new PaletteEventHandler();

        this.label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               // System.out.print(handler.label.getText());
                labels.setText(handler.label.getText());
                labels.setIcon(technologyModels.getIcon());
                //System.out.print(handler.label.getText());
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.print(handler.label.getText());
                labels.setText(handler.label.getText());
                System.out.print(handler.label.getText());
            }
        });

      // System.out.print("Text"+handler.label.getText());















     return treeNodes;
    }




    public JComponent modelEditor(){

        pane=new JEditorPane();



        pane.setLayout(new BorderLayout());




        return pane;
    }






}
