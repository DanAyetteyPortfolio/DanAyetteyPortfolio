package RenderFoldersAndSubFoders;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Ayettey on 05/03/2017.
 */
public class Model {

     private String models;
     private ArrayList<Folders> nodesOfFolders=new ArrayList<Folders>() ;
     private  ImageIcon icon;
     private ImageIcon collapseIcon;


    public void setCollapseIcon(ImageIcon collapseIcon) {
        this.collapseIcon = collapseIcon;
    }


    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public void setModels(String models) {
        this.models = models;
    }

    public void setNodesOfFolders(Folders nodesOfFolders) {
        this.nodesOfFolders .add(nodesOfFolders) ;
    }

    public String getModels() {
        return models;
    }

    public ArrayList<Folders> getNodesOfFolders() {
        return nodesOfFolders;
    }

    public Icon getCollapseIcon() {
        return collapseIcon;
    }

    public Icon getIcon() {
        return icon;
    }


    @Override
    public String toString() {

        return getModels();
    }


}
