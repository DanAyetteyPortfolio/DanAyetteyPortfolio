package EventHandlers;

import RenderFoldersAndSubFoders.CreateFolders;
import PwpCreateComponents.PopUpMenuListComponents;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.awt.event.*;

/**
 * Created by Ayettey on 13/02/2017.
 */
public class ProjectModelEventHandler extends PopUpMenuListComponents implements MouseListener,ActionListener{

    private CreateFolders CreateFolders;
    private JMenuItem eventModelHandlerItems;
    private JPopupMenu eventModelHandlerPopupMenu;
    private JMenu eventModelHandlerMenu;
    private PopUpMenuListComponents popUpMenuList;
    private DefaultMutableTreeNode leafs;
    private TreePath[]paths;
    private DefaultTreeModel leafsModel;
    private JTree treeNodes;
    public String getItemNames;
    private JPopupMenu popupMenu;


    public ProjectModelEventHandler(CreateFolders CreateFolders){

        this.CreateFolders = CreateFolders;



    }



    public ProjectModelEventHandler(PopUpMenuListComponents popUpMenuList){
        this.popUpMenuList=popUpMenuList;
    }

    @Override
    public void mouseClicked(MouseEvent e) {







    }



    @Override
    public void mousePressed(MouseEvent e) {


        try {


            //DefaultMutableTreeNode newNodes;
            //TreePath path = CreateFolders.treeNodes.getSelectionPath();
            //Object node = path.getLastPathComponent();
            //Object nodeNotSelected = CreateFolders.treeNodes.getModel().getRoot();
           // newNodes = (DefaultMutableTreeNode) path.getLastPathComponent();


           // if ((e.getModifiers() & InputEvent.BUTTON3_MASK) != 0 && CreateFolders.treeNodes.getSelectionCount() > 0) {
               //  businessPopUpMenu(e.getX(), e.getY(), CreateFolders.treeNodes, newNodes.getUserObject().toString());

            //
            // String getNodeSetText = node.toString();
            //
            // if (nodeNotSelected.equals(node)) {
            //
            //     eventModelHandlerMenu.setEnabled(false);
            // }
            //
            //
            // // System.out.println( popUpMenuList.userObject.toString());
            // //  businessPopUpMenu(e.getX(), e.getY(), CreateFolders.treeNodes,getNodeSetText);
            //
            // if (getNodeSetText.equals("Business Model")) {
            //     //    getItemNames=getNodeSetText;
            //
            //     businessPopUpMenu(e.getX(), e.getY(), CreateFolders.treeNodes, getNodeSetText);
            //
            //     System.out.println("Here");
            // }
            //
            // //allBusinessActivities(CreateFolders.treeNodes,getNodeSetText,CreateFolders.getIcon());
            // //applicationModelPopUpMenu(e.getX(),e.getY(),CreateFolders.treeNodes);
            //
            //
            // else if (getNodeSetText.equals("Business Interactive")) {
            //     System.out.println(node);
            //     getItemNames = getNodeSetText;
            //     //  businessPopUpMenu(e.getX(), e.getY(), CreateFolders.treeNodes,getNodeSetText);
            //     //allBusinessActivities(CreateFolders.treeNodes,getNodeSetText,CreateFolders.getIcon());
            //     //applicationModelPopUpMenu(e.getX(),e.getY(),CreateFolders.treeNodes);
            //
            // } else if (getNodeSetText.equals("Application")) {
            //     System.out.println(node);
            //     getItemNames = getNodeSetText;
            //     applicationModelPopUpMenu(e.getX(), e.getY(), CreateFolders.treeNodes, getNodeSetText);
            //
            // } else if (getNodeSetText.equals("Technology")) {
            //     getItemNames = getNodeSetText;
            //     System.out.println(node);
            //     technologyModelPopUpMenu(e.getX(), e.getY(), CreateFolders.treeNodes, getNodeSetText);
            // } else if (getNodeSetText.equals("Motivation")) {
            //     getItemNames = getNodeSetText;
            //     System.out.println(node);
            //     motivationModelPopUpMenu(e.getX(), e.getY(), CreateFolders.treeNodes, getNodeSetText);
            //
            // } else if (getNodeSetText.equals("Implementation And Migration")) {
            //     getItemNames = getNodeSetText;
            //     System.out.println(node);
            //     implementationAndMigrationModelPopUpMenu(e.getX(), e.getY(), CreateFolders.treeNodes, getNodeSetText);
            //
            // } else if (getNodeSetText.equals("Connector")) {
            //     getItemNames = getNodeSetText;
            //     System.out.println(node);
            //     connectorModelPopUpMenu(e.getX(), e.getY(), CreateFolders.treeNodes, getNodeSetText);
            //
            // } else if (getNodeSetText.equals("Relations")) {
            //     getItemNames = getNodeSetText;
            //     System.out.println(node);
            //     relationsPopUpMenu(e.getX(), e.getY(), CreateFolders.treeNodes, getNodeSetText);
            //
            // } else if (getNodeSetText.equals("Views")) {
            //     getItemNames = getNodeSetText;
            //     System.out.println(node);
            //     viewsModelsPopUpMenu(e.getX(), e.getY(), CreateFolders.treeNodes, getNodeSetText);
            //
            // } else if (getNodeSetText.equals("Default View")) {
            //     getItemNames = getNodeSetText;
            //     System.out.println(node);
            //     defaultViewPopUpMenu(e.getX(), e.getY(), CreateFolders.treeNodes, getNodeSetText);
            //
            // } else if (getNodeSetText.equals("Network Analysis")) {
            //     getItemNames = getNodeSetText;
            //     System.out.println(newNodes.getUserObject());
            //     networkAnalysisPopUpMenu(e.getX(), e.getY(), CreateFolders.treeNodes, getNodeSetText);
            //
            // } else {
            //     trimLeafs(e.getX(), e.getY(), CreateFolders.treeNodes);
            // }
                //else if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                //          .getBusinessInteractionAndDefaultView().equals("Business Role")){
                //      setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //      //tree.setToolTipText("Business Actor");
                //
                //
                //  }else if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                //          .getBusinessInteractionAndDefaultView().equals("Business Collaboration")){
                //      setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //      //tree.setToolTipText("Business Actor");
                //
                //
                //  }if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                //          .getBusinessInteractionAndDefaultView().equals("Business Interface")){
                //      setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //      //tree.setToolTipText("Business Actor");
                //
                //
                //  }else if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                //          .getBusinessInteractionAndDefaultView().equals("Business Function")){
                //      setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //      //tree.setToolTipText("Business Actor");
                //
                //
                //  }if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                //          .getBusinessInteractionAndDefaultView().equals("Business Process")){
                //      setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //      //tree.setToolTipText("Business Actor");
                //
                //
                //  }else if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                //          .getBusinessInteractionAndDefaultView().equals("Business Event")){
                //      setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //      tree.setToolTipText("Default View");
                //
                //
                //  }else if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                //          .getBusinessInteractionAndDefaultView().equals("Business Product")){
                //      setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //      //tree.setToolTipText("Business Actor");
                //
                //
                //  }else if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                //          .getBusinessInteractionAndDefaultView().equals("Business Contract")){
                //      setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //      //tree.setToolTipText("Business Actor");
                //
                //
                //  }else if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                //          .getBusinessInteractionAndDefaultView().equals("Business Service")){
                //      setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //      //tree.setToolTipText("Business Actor");
                //
                //
                //  }else if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                //          .getBusinessInteractionAndDefaultView().equals("Business Value")){
                //      setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //      //tree.setToolTipText("Business Actor");
                //
                //
                //  }else if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                //          .getBusinessInteractionAndDefaultView().equals("Business Meaning")){
                //      setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //      //tree.setToolTipText("Business Actor");
                //
                //
                //  }
                //
                //  else if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                //          .getBusinessInteractionAndDefaultView().equals("Business Representation")){
                //      setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //      //tree.setToolTipText("Business Actor");
                //
                //
                //  }else if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                //          .getBusinessInteractionAndDefaultView().equals("Business Representation")){
                //      setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //      //tree.setToolTipText("Business Actor");
                //
                //
                //  }else if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                //          .getBusinessInteractionAndDefaultView().equals("Business Object")){
                //      setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //      //tree.setToolTipText("Business Actor");
                //
                //
                //  }
                //  else if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                //          .getBusinessInteractionAndDefaultView().equals("Location")){
                //      setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //      //tree.setToolTipText("Business Actor");
                //
                //
                //  }
                //  else if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                //          .getBusinessInteractionAndDefaultView().equals("Application Component")){
                //      setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //      //tree.setToolTipText("Business Actor");
                //
                //
                //  }
                //
                //  else if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                //          .getBusinessInteractionAndDefaultView().equals("Application Collaboration")){
                //      setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //      //tree.setToolTipText("Business Actor");
                //
                //
                //  }
                //  else if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                //          .getBusinessInteractionAndDefaultView().equals("Application Component")){
                //      setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //      //tree.setToolTipText("Business Actor");
                //
                //
                //  }
                //  else if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                //          .getBusinessInteractionAndDefaultView().equals("Application Interface")){
                //      setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //      //tree.setToolTipText("Business Actor");
                //
                //
                //  }
                //  else if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                //          .getBusinessInteractionAndDefaultView().equals("Application Service")){
                //      setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //      //tree.setToolTipText("Business Actor");
                //
                //
                //  }
                //  if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                //          .getBusinessInteractionAndDefaultView().equals("Application Function")){
                //      setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //      //tree.setToolTipText("Business Actor");
                //
                //
                //  }
                //  else if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                //          .getBusinessInteractionAndDefaultView().equals("Application Interaction")){
                //      setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //      //tree.setToolTipText("Business Actor");
                //
                //
                //  }
                //  if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                //          .getBusinessInteractionAndDefaultView().equals("Data Object")){
                //      setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //      //tree.setToolTipText("Business Actor");
                //
                //
                //  }
                //
                //  if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                //          .getBusinessInteractionAndDefaultView().equals("Artifact")){
                //      setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //      //tree.setToolTipText("Business Actor");
                //
                //
                //  }
                //  if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                //          .getBusinessInteractionAndDefaultView().equals("Communication Path")){
                //      setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //      //tree.setToolTipText("Business Actor");
                //
                //
                //  }
                //  if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                //          .getBusinessInteractionAndDefaultView().equals("Networking")){
                //      setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //      //tree.setToolTipText("Business Actor");
                //
                //
                //  }
                //  else if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                //          .getBusinessInteractionAndDefaultView().equals("Infrastructure Interface")){
                //      setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //      //tree.setToolTipText("Business Actor");
                //
                //
                //  }
                //  else if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                //          .getBusinessInteractionAndDefaultView().equals("Infrastructure Function")){
                //      setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //      //tree.setToolTipText("Business Actor");
                //
                //
                //  }  else if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                //          .getBusinessInteractionAndDefaultView().equals("Infrastructure Service")){
                //      setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //      //tree.setToolTipText("Business Actor");
                //
                //
                //  }
                //
                //
                //  else if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                //          .getBusinessInteractionAndDefaultView().equals("Node")){
                //      setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //      //tree.setToolTipText("Business Actor");
                //
                //
                //  }
                //  if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                //          .getBusinessInteractionAndDefaultView().equals("System Software")){
                //      setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //      //tree.setToolTipText("Business Actor");
                //
                //
                //  }
                //  else if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                //          .getBusinessInteractionAndDefaultView().equals("Device")){
                //      setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //      //tree.setToolTipText("Business Actor");
                //
                //
                //  }
                //  else if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                //          .getBusinessInteractionAndDefaultView().equals("Stakeholder")){
                //      setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //      //tree.setToolTipText("Business Actor");
                //
                //
                //  }
                //  if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                //          .getBusinessInteractionAndDefaultView().equals("Driver")){
                //      setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //      //tree.setToolTipText("Business Actor");
                //
                //
                //  }  else if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                //          .getBusinessInteractionAndDefaultView().equals("Infrastructure Service")){
                //      setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //      //tree.setToolTipText("Business Actor");
                //
                //
                //  }
                //
                //
                //  else if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                //          .getBusinessInteractionAndDefaultView().equals("Assessment")){
                //      setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //      //tree.setToolTipText("Business Actor");
                //
                //
                //  }
                //  else if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                //          .getBusinessInteractionAndDefaultView().equals("Goal")){
                //      setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //      //tree.setToolTipText("Business Actor");
                //
                //
                //  }
                //  else if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                //          .getBusinessInteractionAndDefaultView().equals("Principle")){
                //      setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //      //tree.setToolTipText("Business Actor");
                //
                //
                //  }
                //  else if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                //          .getBusinessInteractionAndDefaultView().equals("Assessment")){
                //      setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //      //tree.setToolTipText("Business Actor");
                //
                //
                //  }
                //  else if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                //          .getBusinessInteractionAndDefaultView().equals("Requirement")){
                //      setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //      //tree.setToolTipText("Business Actor");
                //
                //
                //  }
                //  else if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                //          .getBusinessInteractionAndDefaultView().equals("Constraint")){
                //      setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //      //tree.setToolTipText("Business Actor");
                //
                //
                //  }
                //
                //
                //
                //  else if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                //          .getBusinessInteractionAndDefaultView().equals("Work Package")){
                //      setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //      //tree.setToolTipText("Business Actor");
                //
                //
                //  }
                //  else if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                //          .getBusinessInteractionAndDefaultView().equals("Deliverable")){
                //      setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //      //tree.setToolTipText("Business Actor");
                //
                //
                //  }
                //  else if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                //          .getBusinessInteractionAndDefaultView().equals("Plateau")){
                //      setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //      //tree.setToolTipText("Business Actor");
                //
                //
                //  }
                //
                //  else if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                //          .getBusinessInteractionAndDefaultView().equals("Gap")){
                //      setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //      //tree.setToolTipText("Business Actor");
                //
                //
                //  }
                //
                //  else if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                //          .getBusinessInteractionAndDefaultView().equals("Junction")){
                //      setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //      //tree.setToolTipText("Business Actor");
                //
                //
                //  }
                //  else if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                //          .getBusinessInteractionAndDefaultView().equals("And Junction")){
                //      setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //      //tree.setToolTipText("Business Actor");
                //
                //
                //  }
                //
                //  else if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                //          .getBusinessInteractionAndDefaultView().equals("Or Junction")){
                //      setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //      //tree.setToolTipText("Business Actor");
                //
                //
                //  }
                //  else if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                //          .getBusinessInteractionAndDefaultView().equals("Sketch View")){
                //      setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //      //tree.setToolTipText("Business Actor");
                //
                //
                //  }
                //  else if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                //          .getBusinessInteractionAndDefaultView().equals("PwnPr3d View")){
                //      setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //      //tree.setToolTipText("Business Actor");
                //
                //
                //}
           // }

        } catch (NullPointerException x) {
            x.printStackTrace();
            CreateFolders.treeNodes.setSelectionRow(CreateFolders.treeNodes.getRowCount());


        }

    }



    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    @Override
    public void actionPerformed(ActionEvent e) {



    }
}
