package _11_Set;

public class LinkedListSet<E> implements Set<E> {

    private LinkedList<E> list;

    public LinkedListSet() {
        list = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    /**
     * 在之前实现的链表中，
     * 没有规定不能使用重复元素，
     * 所以这里需要对重复元素进行处理。
     * @param e
     */
    @Override
    public void add(E e) {
        if (!list.contains(e)) {    // 先查是否包含，如果不包含就添加到链表头；否则不处理
            list.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }
}
