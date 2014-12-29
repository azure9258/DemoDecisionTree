import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

public class DecisionTree extends JPanel implements TreeSelectionListener {
	private JTree tree;
	static DefaultMutableTreeNode Top;
	static boolean useSystemLookAndFeel = false;
	static node Root; 
	
	public DecisionTree(node root) {
		Root = root;
		
		//Create the nodes.
        Top =
            new DefaultMutableTreeNode("root");
 
        //Create a tree that allows one selection at a time.
        tree = new JTree(Top);
        tree.getSelectionModel().setSelectionMode
                (TreeSelectionModel.SINGLE_TREE_SELECTION);
 
        //Listen for when the selection changes.
        tree.addTreeSelectionListener(this);
 
        //Create the scroll pane and add the tree to it. 
        JScrollPane treeView = new JScrollPane(tree);

        //Add the scroll panes to a split pane.
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splitPane.setTopComponent(treeView);
 
        Dimension minimumSize = new Dimension(100, 50);
        treeView.setMinimumSize(minimumSize);
        splitPane.setDividerLocation(100); 
        splitPane.setPreferredSize(new Dimension(500, 300));
 
        //Add the split pane to this panel.
        add(splitPane);
	}
	
	static void createAndShowGUI(node Root) {
        if (useSystemLookAndFeel) {
            try {
                UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                System.err.println("Couldn't use system look and feel.");
            }
        }
 
        //Create and set up the window.
        JFrame frame = new JFrame("TreeDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Add content to the window.
        frame.add(new DecisionTree(Root));
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        Top.setUserObject(customer.property.get(Root.indexChoiceAttr));
        createNodes(Top, Root);
    }

	private static void createNodes(DefaultMutableTreeNode top, node root) {
        DefaultMutableTreeNode newTop = null;
 
        for(int i=0;i<root.child.size();i++){
        	if(root.child.get(i).indexChoiceAttr == -1){
        		continue;
        	}
        	newTop = new DefaultMutableTreeNode(customer.property.get(root.indexChoiceAttr) + "   (" + root.choice.get(i) + ")");
        	top.add(newTop);
        	createNodes(newTop, root.child.get(i));
        }
 
    }
	
	@Override
	public void valueChanged(TreeSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}
}