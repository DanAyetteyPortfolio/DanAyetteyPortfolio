package EventHandlers;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.*;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Ayettey on 28/03/2017.
 */
public class  PaletteEventHandler  extends JPanel  {

    private static final DataFlavor FAVORS = new DataFlavor(JLabel.class, "Label Instances");
    private static final DataFlavor LOCAL_FAVORS = new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType +
            "; class=javax.swing.JLabel", "Local Label");

    private  ImageIcon paletteImages;
    public JLabel label;
    public JLabel getDragObjectText=new JLabel();
    private DragSourceListener listenToSource;
    private JPanel shapePanel;
    private JPanel shapeAndSearchPanel;
    private JList listMenu;
    private JPanel panel;
    private JPanel arrangeObjects;






    public Component paletteObjects() {




        DropTarget taget=new DropTarget(this,DnDConstants.ACTION_COPY_OR_MOVE,new DropObject());
        listenToSource= new DragObjectsListener();

        setLayout(new BorderLayout());
        GridBagConstraints constraints=new GridBagConstraints();

        constraints.gridx=0;

         //constraints.gridx=0;
       // add( shapes() ,BorderLayout.SOUTH);





    return this;
    }



    class DragObjectsListener implements DragSourceListener{

        @Override
        public void dragEnter(DragSourceDragEvent dsde) {

        }

        @Override
        public void dragOver(DragSourceDragEvent dsde) {

        }

        @Override
        public void dropActionChanged(DragSourceDragEvent dsde) {

        }

        @Override
        public void dragExit(DragSourceEvent dse) {

        }

        @Override
        public void dragDropEnd(DragSourceDropEvent dsde) {

        }
    }

    public JLabel createImage(File file) {

        ImageIcon icon = new ImageIcon(file.getPath());

        label = new JLabel(icon);
        String str=file.getName();
        label.setText(str.substring(0,str.lastIndexOf('.')+1));
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);






        return label;
    }


    public Component createComponent(Component comp,Point point) {
        DragSource source = DragSource.getDefaultDragSource();
        source.createDefaultDragGestureRecognizer(comp, DnDConstants.ACTION_COPY_OR_MOVE, new Gesture());

        JLabel label= (JLabel) comp;
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        comp.setLocation(point);
        comp.setSize(comp.getPreferredSize());
        shapePanel=new JPanel();
        shapePanel.add(label);


      repaint();

    return shapePanel;
    }



    class TransferObject implements Transferable {

        private DataFlavor[] flavor = {FAVORS, LOCAL_FAVORS};
        private JLabel label;


        TransferObject(JLabel label) {
            this.label = label;
        }


        @Override
        public DataFlavor[] getTransferDataFlavors() {
            return flavor;
        }

        @Override
        public boolean isDataFlavorSupported(DataFlavor flavor) {
            if (flavor.isFlavorJavaFileListType())
                for (int x = 0; x < this.flavor.length; x++) {
                    if (this.flavor[x].equals(flavor)) {
                        return true;
                    }
                }
            return false;
        }

        @Override
        public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {

            if (flavor.equals(FAVORS)) {
                return label;
            }
            throw new UnsupportedFlavorException(flavor);
        }


        class DragObjectsListener implements DragSourceListener {

            @Override
            public void dragEnter(DragSourceDragEvent dsde) {

            }

            @Override
            public void dragOver(DragSourceDragEvent dsde) {

            }

            @Override
            public void dropActionChanged(DragSourceDragEvent dsde) {

            }

            @Override
            public void dragExit(DragSourceEvent dse) {

            }

            @Override
            public void dragDropEnd(DragSourceDropEvent dsde) {

            }
        }

    }
        class Gesture implements DragGestureListener {

            @Override
            public void dragGestureRecognized(DragGestureEvent dge) {

                Cursor cursor = null;
                label = (JLabel) dge.getComponent();

                switch (dge.getDragAction()) {
                    case DnDConstants.ACTION_COPY:
                        cursor = DragSource.DefaultCopyDrop;
                        break;
                    case DnDConstants.ACTION_MOVE:
                        cursor = DragSource.DefaultMoveDrop;
                        break;
                    case DnDConstants.ACTION_LINK:
                        cursor = DragSource.DefaultLinkDrop;
                        break;
                }

                dge.startDrag(cursor, new TransferObject(label), new DragSourceObject());
                dge.getSourceAsDragGestureRecognizer().getComponent().revalidate();

            }
        }

        class DropObject implements DropTargetListener {

            @Override
            public void dragEnter(DropTargetDragEvent dtde) {
                if (dtde.isDataFlavorSupported(DataFlavor.javaFileListFlavor)
                        || dtde.isDataFlavorSupported(FAVORS) || dtde.isDataFlavorSupported(LOCAL_FAVORS)) {
                    return;
                }
                dtde.rejectDrag();


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

                if (dtde.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
                    dtde.acceptDrop(dtde.getDropAction());
                    Transferable transferObject = dtde.getTransferable();
                    try {
                        List list = (List) transferObject.getTransferData(DataFlavor.javaFileListFlavor);

                        Iterator iterate = list.iterator();

                        while (iterate.hasNext()) {

                            JLabel label = createImage((File) iterate.next());
                            createComponent(label,dtde.getLocation());


                        }

                        dtde.dropComplete(true);
                    } catch (UnsupportedFlavorException e) {
                        dtde.dropComplete(false);
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else if (dtde.isDataFlavorSupported(FAVORS)) {


                    try {
                        dtde.acceptDrop(DnDConstants.ACTION_MOVE);

                        Transferable transferObject = dtde.getTransferable();
                        Boolean trueFlavor = dtde.isLocalTransfer() && transferObject.isDataFlavorSupported(LOCAL_FAVORS);
                        DataFlavor getData = trueFlavor ? LOCAL_FAVORS : FAVORS;
                        JLabel label = (JLabel) transferObject.getTransferData(getData);
                        createComponent(label,dtde.getLocation());
                        dtde.dropComplete(true);


                    } catch (Exception e) {
                        dtde.dropComplete(false);

                    }
                }

            }
        }

        class DragSourceObject implements DragSourceListener {

            @Override
            public void dragEnter(DragSourceDragEvent dsde) {

            }

            @Override
            public void dragOver(DragSourceDragEvent dsde) {
                DragSourceContext context = dsde.getDragSourceContext();
                context.setCursor(new Cursor(12));

            }

            @Override
            public void dropActionChanged(DragSourceDragEvent dsde) {

            }

            @Override
            public void dragExit(DragSourceEvent dse) {

            }

            @Override
            public void dragDropEnd(DragSourceDropEvent dsde) {
                if ((dsde.getDropSuccess()) && (dsde.getDropAction() == DnDConstants.ACTION_MOVE)) {
                    //remove(label);
                    repaint();
                }

            }

        }


    }


