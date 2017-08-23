package RenderFoldersAndSubFoders;

import javax.swing.*;
import javax.swing.tree.MutableTreeNode;
import java.util.ArrayList;

/**
 * Created by Ayettey on 05/03/2017.
 */
public class Folders  extends CreateFolders{

    private String models;
    private String nodes;


    private ArrayList <SubFolders> subFolders=new ArrayList<>();
    private  MutableTreeNode subNode;
    private ImageIcon empty=new ImageIcon("/PwpIcons/actions/showHiddens_dark.png");
    private ImageIcon icon=new ImageIcon(getClass().getResource("/PwpIcons/actions/menu-open.png"));;
    String value;


    public Folders(String value, ImageIcon icon) {
        this.value=value;
        this.icon=icon;

    }

    public Folders(){

    }






    public void setEmpty(ImageIcon empty) {
        this.empty = empty;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }


    public Icon getEmpty() {
        return empty;
    }

    public void setModels(String models) {
        this.models = models;
    }





    public void setSubFolders(SubFolders subFolders) {
        this.subFolders.add(subFolders);
    }

    public ArrayList<SubFolders> getSubFolders() {
        return subFolders;
    }

    public void setNodes(String nodes) {
        this.nodes = nodes;
    }

    public String getNodes() {
        return nodes;
    }

    public String getModels() {
        return models;
    }

    public Icon getIcon() {
      //  if(subFolders.size()>0)
            return icon;
       // else
        //    return empty;
    }


    @Override
    public String toString() {
     return  getNodes();
    }
}
