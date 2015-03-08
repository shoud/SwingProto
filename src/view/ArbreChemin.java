package view;

import model.Path;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.io.File;
import java.util.Collections;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public class ArbreChemin extends JPanel
{
    private DefaultMutableTreeNode selection = null;
    private File file = null;
    public ArbreChemin(File dir)
    {
        setLayout(new BorderLayout());
        // Make a tree list with all the nodes, and make it a JTree
        final JTree tree = new JTree(addNodes(null, dir));
        // Add a listener
        tree.addTreeSelectionListener(new TreeSelectionListener()
        {
            public void valueChanged(TreeSelectionEvent e)
            {
								
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) e
			    	.getPath().getLastPathComponent();

                TreeNode[] tab = node.getPath();
                String pig = "";
                for (TreeNode mot : tab)
                    pig += mot;

                System.out.println(pig);

                //String lol = (String)tree.getLastSelectedPathComponent();
                //System.out.println("You selected " + node);
                TreePath tp = new TreePath(e.getNewLeadSelectionPath());
                if(tp != null)
                {

                }

            }
        });

        // Lastly, put the JTree into a JScrollPane.
        JScrollPane scrollpane = new JScrollPane();
        scrollpane.getViewport().add(tree);
        add(BorderLayout.CENTER, scrollpane);
    }
    /** Add nodes from under "dir" into curTop. Highly recursive. */
    public DefaultMutableTreeNode addNodes(DefaultMutableTreeNode curTop, File dir)
    {
        String curPath = dir.getPath();
        DefaultMutableTreeNode curDir = new DefaultMutableTreeNode(curPath);
        if (curTop != null)
        { // should only be null at root
            curTop.add(curDir);
        }
        Vector ol = new Vector();
        String[] tmp = dir.list();
        for (int i = 0; i < tmp.length; i++)
            ol.addElement(tmp[i]);
        Collections.sort(ol, String.CASE_INSENSITIVE_ORDER);
        File f;
        Vector files = new Vector();
        // Make two passes, one for Dirs and one for Files. This is #1.
        for (int i = 0; i < ol.size(); i++) {
            String thisObject = (String) ol.elementAt(i);
            String newPath;
            if (curPath.equals("."))
                newPath = thisObject;
            else
                //newPath = curPath + File.separator + thisObject;
                newPath = File.separator + thisObject;
            if ((f = new File(newPath)).isDirectory())
                addNodes(curDir, f);
            else
                files.addElement(thisObject);
        }
        // Pass two: for files.
        for (int fnum = 0; fnum < files.size(); fnum++)
            curDir.add(new DefaultMutableTreeNode(files.elementAt(fnum)));
        return curDir;
    }

    public Dimension getMinimumSize()
    {
        return new Dimension(200, 400);
    }

    public Dimension getPreferredSize()
    {
        return new Dimension(200, 400);
    }
}

