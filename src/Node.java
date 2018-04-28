import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Node<T> {

    private T data;
    private List<Node<T>> children;
    private Node<T> parent;

    public Node() {
        super();
        children = new ArrayList<Node<T>>();
    }

    public Node(T data) {
        this();
        setData(data);
    }

    public Node<T> getParent() {
        return this.parent;
    }

    public List<Node<T>> getChildren() {
        return this.children;
    }

    public int getNumberOfChildren() {
        return getChildren().size();
    }

    public boolean hasChildren() {
        return (getNumberOfChildren() > 0);
    }

    public void setChildren(List<Node<T>> children) {
        for(Node<T> child : children) {
            child.parent = this;
        }

        this.children = children;
    }

    public void addChild(Node<T> child) {
        child.parent = this;
        children.add(child);
    }

    public void addChildAt(int index, Node<T> child) throws IndexOutOfBoundsException {
        child.parent = this;
        children.add(index, child);
    }

    public void removeChildren() {
        this.children = new ArrayList<Node<T>>();
    }

    public void removeChildAt(int index) throws IndexOutOfBoundsException {
        children.remove(index);
    }

    public Node<T> getChildAt(int index) throws IndexOutOfBoundsException {
        return children.get(index);
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String toString() {
        return getData().toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Node<?> other = (Node<?>) obj;
        if (data == null) {
            if (other.data != null) {
                return false;
            }
        } else if (!data.equals(other.data)) {
            return false;
        }
        return true;
    }
}
