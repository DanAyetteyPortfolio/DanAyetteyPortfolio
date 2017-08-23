package PwpCreateComponents;

//import EventHandlers.ComponentActionEvents;

import EventHandlers.ProjectModelEventHandler;
import RenderFoldersAndSubFoders.Folders;
import RenderFoldersAndSubFoders.SubFolders;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.util.HashSet;

/**
 * Created by Ayettey on 15/02/2017.
 */
public class PopUpMenuListComponents  {


    public JMenuItem eventModelHandlerItems;
    private JPopupMenu eventModelHandlerPopupMenu;
    private JMenu    eventModelHandlerMenu;
    private ProjectModelEventHandler eventItemHandler;
   // private ComponentActionEvents eventHandler;
    public  String items;
    private List temp;
    public HashSet<String> hashTemp=new HashSet<>();
    private DefaultMutableTreeNode newFolder;
    private Folders createFiles;
    public Object userObject;
    private  Folders subFolders;
    DefaultMutableTreeNode newNodes;

    Icon icon;









    public void delete(JTree treeNodes) {


        try{

            DefaultMutableTreeNode node;

            TreePath[] paths = treeNodes.getSelectionPaths();
            DefaultTreeModel model = (DefaultTreeModel) treeNodes.getModel();
            UIManager.put("OptionPane.minimumSize",new Dimension(120,120));
            for (int i=0;i<paths.length;i++){



           Object options= JOptionPane.showConfirmDialog(null,"You about To delete "+ paths[i].getLastPathComponent().toString()+" "+", processed ? ","Delete"
                    ,SwingConstants.CENTER,JOptionPane.OK_CANCEL_OPTION,
                    new ImageIcon(getClass().getResource("/PwpIcons/actions/delete@2x.png")));



                 System.out.println(JOptionPane.CANCEL_OPTION + options.toString());
                if(Integer.parseInt(options.toString())==0){
                    node = (DefaultMutableTreeNode) paths[i].getLastPathComponent();
                    model.removeNodeFromParent(node);
                }else if(Integer.parseInt(options.toString())==1) {
                    return;


                }




            }

        }catch (NullPointerException x){
            x.printStackTrace();

        }



    }





    public DefaultTreeModel allBusinessActivities(JTree treeNodes, String itemName,Icon icon) {



        TreePath paths[] = treeNodes.getSelectionPaths();
        DefaultTreeModel model = (DefaultTreeModel) treeNodes.getModel();


          try{





              createFiles=new Folders();
              if((itemName.startsWith(itemName))) {
                  createFiles.setSubFolders(new SubFolders(itemName,icon));


              }

              for(int i=0;i<paths.length;i++){


                  newNodes= (DefaultMutableTreeNode) paths[i].getLastPathComponent();

                    for(int x=0;x<createFiles.getSubFolders().size();x++) {


                      //  if(itemName.equals("Business Model"))
                       model.insertNodeInto(newFolder = new DefaultMutableTreeNode(createFiles.getSubFolders().get(x)),
                                newNodes, newNodes.getChildCount());

                    }


                                   //model.reload();

                                   treeNodes.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
                                   ToolTipManager.sharedInstance( ).registerComponent(treeNodes);






                treeNodes.expandPath(paths[i]);
          }

            }

        catch (Exception e){
             e.printStackTrace();
            JOptionPane.showMessageDialog(null,"No component was created","Empty message",JOptionPane.OK_OPTION);

        }
      return model;
    }
    public DefaultTreeModel duplicate(JTree treeNodes, String itemName,Icon icon) {



        TreePath paths[] = treeNodes.getSelectionPaths();
        DefaultTreeModel model = (DefaultTreeModel) treeNodes.getModel();


        try{





            createFiles=new Folders();
            if((itemName.startsWith(itemName))) {
                createFiles.setSubFolders(new SubFolders(itemName,icon));


            }

            for(int i=0;i<paths.length;i++){


                newNodes= (DefaultMutableTreeNode) paths[i].getLastPathComponent();

                for(int x=0;x<createFiles.getSubFolders().size();x++) {


                    //  if(itemName.equals("Business Model"))
                    model.insertNodeInto(newFolder = new DefaultMutableTreeNode(newNodes.getUserObject()),
                            (MutableTreeNode) newNodes.getParent(), newNodes.getChildCount());

                }


                //model.reload();

                treeNodes.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
                ToolTipManager.sharedInstance( ).registerComponent(treeNodes);






                treeNodes.expandPath(paths[i]);
            }

        }

        catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"No component was created","Empty message",JOptionPane.OK_OPTION);

        }
        return model;
    }







    public void setIcon(Icon icon) {
        this.icon =  icon;



    }

    public Icon getIcon() {
        return icon;
    }





















}
