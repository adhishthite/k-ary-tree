import java.util.ArrayList;
import java.util.List;

public class Menu {
    public static void main(String[] args) {

        // Get tree
        GenericTree<String> tree = buildTree();

        // Full traversal of the tree
        List<Node<String>> oldTraversalResult = tree.getAllElements(tree.getRoot());

        System.out.print("\nOriginal List:\t");
        for(Node<String> node : oldTraversalResult) {
            System.out.print(node.toString());
            System.out.print(';');
        }

        // Add the restrictions list and then fully iterate
        ArrayList<String> restrictionsList = new ArrayList<String>();
        restrictionsList.add("Cheese");

        List<Node<String>> newTraversalResult = tree.getAllElements(tree.getRoot(), restrictionsList);

        System.out.print("\n\nNew List with Restrictions:\t");

        for(Node<String> node : newTraversalResult) {
            System.out.print(node.toString());
            System.out.print(';');
        }
    }

    private static GenericTree<String> buildTree() {
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

        Node<String> grains = new Node<String>("Grains");
        Node<String> eggs = new Node<String>("Eggs");

        tree.setRoot(root);

        root.addChild(dairy);
        root.addChild(produce);

        dairy.addChild(cheese);
        dairy.addChild(cream);
        dairy.addChild(milk);

        cheese.addChild(cheddarCheese);
        cheese.addChild(blueCheese);
        cheese.addChild(provoloneCheese);

        produce.addChild(grains);
        produce.addChild(eggs);

        return tree;
    }
}

/**
 *
 * OUTPUT -
 *
 * Original List:	Cheddar;Blue Cheese;Provolone;Cheese;Cream;Milk;Dairy;Grains;Eggs;Produce;Menu;
 *
 * New List with Restrictions:	Cream;Milk;Dairy;Grains;Eggs;Produce;Menu;
 *
 *
 * */