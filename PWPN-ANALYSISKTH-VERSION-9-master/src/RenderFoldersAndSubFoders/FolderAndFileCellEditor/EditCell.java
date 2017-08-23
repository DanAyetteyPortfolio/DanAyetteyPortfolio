package RenderFoldersAndSubFoders.FolderAndFileCellEditor;

import RenderFoldersAndSubFoders.SubFolders;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeNode;
import java.awt.*;
import java.util.EventObject;

/**
 * Created by Ayettey on 22/03/2017.
 */
public class EditCell extends DefaultTreeCellEditor {
    public EditCell(JTree tree, DefaultTreeCellRenderer renderer) {
        super(tree, renderer);

    }
Icon icon =new ImageIcon(getClass().getResource("/PwpIcons/actions/menu-open.png"));;
    @Override
    public Object getCellEditorValue() {
        String value= (String) super.getCellEditorValue();
        return new SubFolders(value,icon);
    }

    @Override
    public Component getTreeCellEditorComponent(JTree tree, Object value, boolean isSelected, boolean expanded, boolean leaf, int row) {
            if(isSelected){
                setBorderSelectionColor(new Color(0xFFD0DC));
                System.out.println("SELECTED");
            }
        return super.getTreeCellEditorComponent(tree, value, isSelected, expanded, leaf, row);
    }

    @Override
    public boolean isCellEditable(EventObject event) {


        return super.isCellEditable(event) && ((TreeNode) lastPath.getLastPathComponent()).getAllowsChildren();


    }
}
