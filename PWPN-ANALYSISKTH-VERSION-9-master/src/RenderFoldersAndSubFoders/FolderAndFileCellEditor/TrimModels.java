package RenderFoldersAndSubFoders.FolderAndFileCellEditor;

import RenderFoldersAndSubFoders.Folders;
import RenderFoldersAndSubFoders.Model;
import RenderFoldersAndSubFoders.SubFolders;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;

/**
 * Created by Ayettey on 05/03/2017.
 */
public class TrimModels  extends DefaultTreeCellRenderer {



    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded,
                                                  boolean leaf, int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
        tree.setRowHeight(20);
        //tree.setEditable(true);
        tree.setToolTipText(((DefaultMutableTreeNode)value).getUserObject().toString());

        if(sel)
            setBackground(new Color(0xFF4F59));

        if(tree.getModel().getRoot().equals((DefaultMutableTreeNode)value ) ){

            setIcon(((Model)((DefaultMutableTreeNode)value).getUserObject()).getIcon());
            //tree.setEditable(false);



        }
        if( ((DefaultMutableTreeNode) value).getUserObject() instanceof Folders){
             //System.out.println(((DefaultMutableTreeNode) value).getUserObject().toString());
            setIcon(((Folders)((DefaultMutableTreeNode)value).getUserObject()).getIcon());







        }

        if( ((DefaultMutableTreeNode) value).getUserObject() instanceof SubFolders){
            //System.out.println(((DefaultMutableTreeNode) value).getUserObject().toString());
            setIcon(((SubFolders)((DefaultMutableTreeNode)value).getUserObject()).getIcon());

        }



        if(((DefaultMutableTreeNode)value).getUserObject() instanceof SubFolders){
            //tree.setEditable(true);
            if(((SubFolders) ((DefaultMutableTreeNode) value).getUserObject())

                    .getBusinessInteraction().equals("Business Interaction")){
                setIcon(((SubFolders)((DefaultMutableTreeNode)value).getUserObject()).getIcon());


            }

            else if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Business Actor")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                tree.setEditable(false);



            }if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Business Role")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                tree.setEditable(false);



            }if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Business Role")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());



            }if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Business Collaboration")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                tree.setEditable(false);
                //tree.setToolTipText("Business Actor");


            }if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Business Interface")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                tree.setEditable(false);


            }if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Business Function")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                tree.setEditable(false);



            }if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Business Process")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());



            }else if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Business Event")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                tree.setEditable(false);
                tree.setToolTipText("Default View");


            }if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Business Product")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                tree.setEditable(false);



            }if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Business Contract")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                tree.setEditable(false);



            }if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Business Service")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());



            }if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Business Value")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                tree.setEditable(false);



            }if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Business Meaning")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                tree.setEditable(false);



            }

            if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Business Representation")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                tree.setEditable(false);



            }if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Business Representation")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                tree.setEditable(false);



            }if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Business Object")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                tree.setToolTipText(((DefaultMutableTreeNode)value).getUserObject().toString());
                tree.setEditable(false);


            }
            if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Location")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                tree.setEditable(false);


            }
            if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Application Component")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());



            }

            if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Application Collaboration")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());



            }
            if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Application Component")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                tree.setEditable(false);



            }
            if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Application Interface")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());



            }
            if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Application Service")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());



            }
            if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Application Function")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());



            }
            if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Application Interaction")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //tree.setToolTipText("Business Actor");


            }
            if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Data Object")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //tree.setToolTipText("Business Actor");


            }

            if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Artifact")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //tree.setToolTipText("Business Actor");


            }
            if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Communication Path")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //tree.setToolTipText("Business Actor");


            }
            if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Networking")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //tree.setToolTipText("Business Actor");


            }
            if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Infrastructure Interface")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //tree.setToolTipText("Business Actor");


            }
            if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Infrastructure Function")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //tree.setToolTipText("Business Actor");


            }   if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Infrastructure Service")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //tree.setToolTipText("Business Actor");


            }


            if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Node")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //tree.setToolTipText("Business Actor");


            }
            if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("System Software")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //tree.setToolTipText("Business Actor");


            }
            if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Device")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //tree.setToolTipText("Business Actor");


            }
            if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Stakeholder")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //tree.setToolTipText("Business Actor");


            }
            if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Driver")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //tree.setToolTipText("Business Actor");


            }   if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Infrastructure Service")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //tree.setToolTipText("Business Actor");


            }


            if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Assessment")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //tree.setToolTipText("Business Actor");


            }
            if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Goal")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //tree.setToolTipText("Business Actor");


            }
            if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Principle")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //tree.setToolTipText("Business Actor");


            }
            if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Assessment")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //tree.setToolTipText("Business Actor");


            }
            if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Requirement")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //tree.setToolTipText("Business Actor");


            }
            if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Constraint")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //tree.setToolTipText("Business Actor");


            }



            if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Work Package")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //tree.setToolTipText("Business Actor");


            }
            if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Deliverable")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //tree.setToolTipText("Business Actor");


            }
            if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Plateau")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                tree.setToolTipText(((DefaultMutableTreeNode)value).getUserObject().toString());


            }

            if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Gap")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                tree.setToolTipText(((DefaultMutableTreeNode)value).getUserObject().toString());


            }

            if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Junction")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                tree.setToolTipText(((DefaultMutableTreeNode)value).getUserObject().toString());


            }
            if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("And Junction")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                tree.setToolTipText(((DefaultMutableTreeNode)value).getUserObject().toString());


            }

            if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Or Junction")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                tree.setToolTipText(((DefaultMutableTreeNode)value).getUserObject().toString());


            }




        if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                .getBusinessInteractionAndDefaultView().equals("Default View")){
            setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
            tree.setToolTipText(((DefaultMutableTreeNode)value).getUserObject().toString());


        }

    }else {
            setLeafIcon(getIcon());
            setOpenIcon(getIcon());
            setClosedIcon(getIcon());
        }

        return this;


    }
}
