public class Pair {

    private Bracket left;

    private Bracket right;

    public Pair(Bracket left, Bracket right) {
        this.left = left;
        this.right = right;
    }

    public Bracket getLeft() {
        return left;
    }

    public void setLeft(Bracket left) {
        this.left = left;
    }

    public Bracket getRight() {
        return right;
    }

    public void setRight(Bracket right) {
        this.right = right;
    }

    public boolean everyoneExists() {
        return left != null && right != null;
    }
}
