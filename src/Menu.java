import java.util.ArrayList;
import java.util.List;

public class Menu {
    public static void main(String[] args) {

        // Get tree
        GenericTree<String> tree = buildTree();

        List<Node<String>> traversalResult = tree.getAllElements(tree.getRoot());

        for(Node<String> node : traversalResult) {
            System.out.print(node.toString());
            System.out.print(';');
        }
    }

    public static GenericTree<String> buildTree() {
        GenericTree<String> tree = new GenericTree<String>();

        Node<String> root = new Node<String>("Menu");

        Node<String> dairy = new Node<String>("Dairy");
        Node<String> produce = new Node<String>("Produce");

        Node<String> cheese = new Node<String>("Cheese");
        Node<String> cream = new Node<String>("Cream");
        Node<String> milk = new Node<String>("Milk");

        Node<String> cheddarCheese = new Node<String>("Cheddar");
        Node<String> blueCheese = new Node<String>("Blue Cheese");
        Node<String> provoloneCheese = new Node<String>("Provolone");

        tree.setRoot(root);

        root.addChild(dairy);
        root.addChild(produce);

        dairy.addChild(cheese);
        dairy.addChild(cream);
        dairy.addChild(milk);

        cheese.addChild(cheddarCheese);
        cheese.addChild(blueCheese);
        cheese.addChild(provoloneCheese);

        return tree;
    }
}
