import java.util.*;

public class GenericTree<T> {

    private Node<T> root;

    public GenericTree() {
        super();
    }

    public Node<T> getRoot() {
        return this.root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    public int getNumberOfNodes() {
        int numberOfNodes = 0;

        if(root != null) {
            numberOfNodes = auxiliaryGetNumberOfNodes(root) + 1; //1 for the root!
        }

        return numberOfNodes;
    }

    private int auxiliaryGetNumberOfNodes(Node<T> node) {
        int numberOfNodes = node.getNumberOfChildren();

        for(Node<T> child : node.getChildren()) {
            numberOfNodes += auxiliaryGetNumberOfNodes(child);
        }

        return numberOfNodes;
    }

    public boolean exists(T dataToFind) {
        return (find(dataToFind) != null);
    }

    public Node<T> find(T dataToFind) {
        Node<T> returnNode = null;

        if(root != null) {
            returnNode = auxiliaryFind(root, dataToFind);
        }

        return returnNode;
    }

    private Node<T> auxiliaryFind(Node<T> currentNode, T dataToFind) {
        Node<T> returnNode = null;
        int i = 0;

        if (currentNode.getData().equals(dataToFind)) {
            returnNode = currentNode;
        }

        else if(currentNode.hasChildren()) {
            i = 0;
            while(returnNode == null && i < currentNode.getNumberOfChildren()) {
                returnNode = auxiliaryFind(currentNode.getChildAt(i), dataToFind);
                i++;
            }
        }

        return returnNode;
    }

    public boolean isEmpty() {
        return (root == null);
    }

    private void buildPreOrder(Node<T> node, List<Node<T>> traversalResult) {

        for(Node<T> child : node.getChildren()) {

            buildPreOrder(child, traversalResult);
        }

        traversalResult.add(node);
    }

    private void buildPreOrder(Node<T> node, List<Node<T>> traversalResult, ArrayList<String> restrictionsList) {
        for(Node<T> child : node.getChildren()) {
            if(!restrictionsList.contains(child.toString())){
                buildPreOrder(child, traversalResult, restrictionsList);
            }
        }

        traversalResult.add(node);
    }


    public List<Node<T>> getAllElements(Node<T> node) {
        List<Node<T>> traversalResult = new ArrayList<Node<T>>();

        buildPreOrder(node, traversalResult);

        return traversalResult;
    }

    public List<Node<T>> getAllElements(Node<T> node, ArrayList<String> restrictionsList) {
        List<Node<T>> traversalResult = new ArrayList<Node<T>>();

        buildPreOrder(node, traversalResult, restrictionsList);

        return traversalResult;
    }
}