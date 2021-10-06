package _11_Set;

public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private BST<E> bst;

    public BSTSet() {
        bst = new BST<>();
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }


    @Override
    public void add(E e) {
        bst.add(e); // 在之前实现的BST中，就是不允许添加重复元素的。
    }


    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }


    @Override
    public void remove(E e) {
        bst.remove(e);
    }
}
