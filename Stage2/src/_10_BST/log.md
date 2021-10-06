

        /*修改前：
           此做法下无返回值。
        // 递归终止条件：
        // 元素等于当前根节点；或者，
        // 左子树为空，且元素小于当前根节点；或者，
        // 右子树为空，且元素大于当前根节点；
        if (e.equals(node.e)) {
            return;
        } else if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
        } else if (e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            size++;
            return;
        }*/



        /*修改前：
        if (root == null) {
            root = new Node(e);
            size++;
        } else {
            add(root, e);
        }*/