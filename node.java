import java.util.ArrayList;
import java.util.List;


public class node {
	String type;
	int indexChoiceAttr;
	List<node> child = new ArrayList<node>();
	List<String> choice = new ArrayList<String>();
	node father;
	int level;
	public node(node f, int lv) {
		father = f;
		level = lv;
		indexChoiceAttr = -1;
	}
}
