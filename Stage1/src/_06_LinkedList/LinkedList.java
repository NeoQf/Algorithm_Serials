package _06_LinkedList;

public class LinkedList<E> {

    /**
     * LinkedList类的内部类，
     * 且是私有的，所以内部可访问。
     */
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    /**
     * 获取链表中的元素个数
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 返回链表是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表的index（0-based）位置添加新的元素e；
     * 在链表中不是一个常用的操作，练习用。
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next; // pre变量往后移动
        }
        // Node node = new Node(e);
        // node.next = pre.next;
        // pre.next = node;
        pre.next = new Node(e, pre.next);
        size++;
    }

    /**
     * 在链表头添加新的节点
     *
     * 《算法4》上的写法：
     * Node oldHead = dummyHead;
     * Node dummyHead = new Node(e);
     * dummyHead.next = oldHead;
     * @param e
     */
    public void addFirst(E e) {
        /**
         * Node node = new Node(e);
         * //“指向链表的链接”。
         * //分场合，有的地方读“指向”好理解
         * node.next = dummyHead;
         * dummyHead = node;
         *
         * 这3条代码可用下面这1条语句代替
         * 好好体会一下
         */
        //dummyHead = new Node(e, dummyHead);
        //size++;
        add(0, e);
    }

    /**
     * 在链表未尾添加新的元素e
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }
}
