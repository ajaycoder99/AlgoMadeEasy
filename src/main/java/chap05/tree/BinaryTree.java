package chap05.tree;

import java.util.*;

public class BinaryTree{

    public static class Node {
        public int key;
        public Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    public Node root;

    public BinaryTree(int key) {
        root = new Node(key);
    }

    public BinaryTree() {
        root = null;
    }

    // Root -> Left -> Right
    public void preOrderTraversal(Node temp) {
        if (temp == null)
            return;

        System.out.print(" " + temp.key);
        preOrderTraversal(temp.left);
        preOrderTraversal(temp.right);
    }

    // Non Recursive
    public ArrayList<Integer> preOrder(Node temp) {
        ArrayList<Integer> res = new ArrayList<>();
        if (temp == null)
            return res;

        Stack<Node> s = new Stack<>();
        s.push(temp);

        while (!s.isEmpty()) {
            Node node = s.pop();
            res.add(node.key);

            if (node.right != null)
                s.push(node.right);

            if (node.left != null)
                s.push(node.left);
        }
        return res;
    }

    // Left -> Root -> Right
    public void inOrderTraversal(Node temp) {
        if (temp == null)
            return;

        inOrderTraversal(temp.left);
        System.out.print(" " + temp.key);
        inOrderTraversal(temp.right);
    }

    // Non Recursive Traversal
    public ArrayList<Integer> inOrder(Node node) {
        ArrayList<Integer> res = new ArrayList<>();
        if (node == null)
            return res;

        Stack<Node> s = new Stack<>();
        Node temp = node;

        while (temp != null || s.size() > 0) {
            while (temp != null) {
                s.push(temp);
                temp = temp.left;
            }

            temp = s.pop();

            res.add(temp.key);

            temp = temp.right;
        }
        return res;
    }

    // Left -> Right -> Root
    public void postOrderTraversal(Node temp) {
        if (temp == null)
            return;

        postOrderTraversal(temp.left);
        postOrderTraversal(temp.right);
        System.out.print(" " + temp.key);
    }

    // Non Recursive
    public ArrayList<Integer> postOrder(Node node) {
        Stack<Node> S = new Stack<Node>();
        ArrayList<Integer> list = new ArrayList<Integer>();

        if (node == null)
            return list;

        S.push(node);
        Node prev = null;

        while (!S.isEmpty()) {
            Node current = S.peek();

            /* go down the tree in search of a leaf an if so process it
            and pop stack otherwise move down */
            if (prev == null || prev.left == current || prev.right == current) {
                if (current.left != null)
                    S.push(current.left);
                else if (current.right != null)
                    S.push(current.right);
                else {
                    S.pop();
                    list.add(current.key);
                }

                /* go up the tree from left node, if the child is right
                   push it onto stack otherwise process parent and pop
                   stack */
            } else if (current.left == prev) {
                if (current.right != null)
                    S.push(current.right);
                else {
                    S.pop();
                    list.add(current.key);
                }

                /* go up the tree from right node and after coming back
                 from right node process parent and pop stack */
            } else if (current.right == prev) {
                S.pop();
                list.add(current.key);
            }

            prev = current;
        }

        return list;
    }

    // Level Order Traversal
    public void breathFirstOrder(Node node) {
        int h = findHeightOfTree(node);
        for (int i = 1; i <= h; i++)
            printGivenLevel(root, i);
    }

    void printGivenLevel(Node root, int level) {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.key + " ");
        else if (level > 1) {
            printGivenLevel(root.left, level - 1);
            printGivenLevel(root.right, level - 1);
        }
    }

    public int findHeightOfTree(Node node) {
        if (node == null)
            return 0;
        else {
            /* compute  height of each subtree */
            int lheight = findHeightOfTree(node.left);
            int rheight = findHeightOfTree(node.right);

            /* use the larger one */
            return Math.max(lheight, rheight) + 1;
        }
    }

    public void insert(Node temp, int data) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(temp);

        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();

            if (temp.left == null) {
                temp.left = new Node(data);
                break;
            } else
                q.add(temp.left);

            if (temp.right == null) {
                temp.right = new Node(data);
                break;
            } else
                q.add(temp.right);
        }
    }

    public int findMaxElementInBT(Node node) {
        if (node != null) {
            int left = findMaxElementInBT(node.left);
            int right = findMaxElementInBT(node.right);

            return Math.max(node.key, Math.max(left, right));
        }
        return Integer.MIN_VALUE;
    }

    public int findMinElementInBT(Node node) {
        if (node != null) {
            int left = findMinElementInBT(node.left);
            int right = findMinElementInBT(node.right);

            return Math.min(node.key, Math.min(left, right));
        }
        return Integer.MAX_VALUE;
    }

    public boolean findIfDataExistInTree(Node node, int data) {
        if (node == null)
            return false;
        else if (node.key == data)
            return true;

        return findIfDataExistInTree(node.left, data) || findIfDataExistInTree(node.right, data);
    }

    public Node insertRecursively(Node head, int data) {
        if(head == null){
            head = new Node(data);
            return head;
        }
        if(head.key < data) {
            head.right = insertRecursively(head.right,data);
        } else {
            head.left = insertRecursively(head.left, data);
        }
        return head;
    }

    public int findSizeOfBinaryTree(Node root) {
        if (root == null)
            return 0;

        int left = findSizeOfBinaryTree(root.left);
        int right = findSizeOfBinaryTree(root.right);

        return left + right + 1;
    }

    public int findSize(Node root) {
        if (root == null)
            return 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int count = 0;
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            count++;

            if (temp.left != null)
                queue.add(temp.left);

            if (temp.right != null)
                queue.add(temp.right);
        }
        return count;
    }

    public void deleteTree(Node root) {
        root = null;
    }

    public void reverseLevelOrderBreathFirst(Node root) {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            if (temp.left != null)
                queue.add(temp.left);

            if (temp.right != null)
                queue.add(temp.right);

            stack.push(temp);
        }

        while (!stack.isEmpty())
            System.out.print(stack.pop().key + " ");
    }

    public int findDepthOfBT(Node root) {
        if (root == null)
            return 0;

        int left = findDepthOfBT(root.left);
        int right = findDepthOfBT(root.right);

        return Math.max(left, right) + 1;
    }

    public int findDepthOfBTIterative(Node root) {
        if (root == null)
            return 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;

        while (1 == 1) {
            int nodeCount = queue.size();
            if (nodeCount == 0)
                return count;

            count++;

            while (nodeCount > 0) {
                Node newNode = queue.poll();
                if (newNode.left != null)
                    queue.add(newNode.left);
                if (newNode.right != null)
                    queue.add(newNode.right);

                nodeCount--;
            }
        }
    }

    // Depth First Search Method
    public int minDepthOfBTUsingDFS(Node root) {

        // Corner case. Should never be hit unless the code is
        // called on root = NULL
        if (root == null)
            return 0;

        // Base case : Leaf Node. This accounts for height = 1.
        if (root.left == null && root.right == null)
            return 1;

        // If left subtree is NULL, recur for right subtree
        if (root.left == null)
            return minDepthOfBTUsingDFS(root.right) + 1;

        // If right subtree is NULL, recur for left subtree
        if (root.right == null)
            return minDepthOfBTUsingDFS(root.left) + 1;

        return Math.min(minDepthOfBTUsingDFS(root.left),
                minDepthOfBTUsingDFS(root.right)) + 1;
    }

    int maxLevel = -1;
    int res = -1;

    public int findDeepestNodeInBT(Node root, int level) {
        if (root != null) {

            findDeepestNodeInBT(root.left, ++level);

            // Update level and recurse
            if (level > maxLevel) {
                res = root.key;
                maxLevel = level;
            }
            findDeepestNodeInBT(root.right, level);
        }
        return res;
    }

    /*
        Solution: The deletion of a node in binary tree can be implemented as
        • Starting at root, find the node which we want to delete.
        • Find the deepest node in the tree.
        • Replace the deepest node’s data with node to be deleted.
        • Then delete the deepest node.
     */
    public void deleteNodeInTree(Node root, int data){
        if(root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        Node temp=null;
        Node searchNode = null;
        while(!queue.isEmpty()) {
             temp = queue.poll();

            if (temp.key == data)
                searchNode = temp;

            if (temp.left != null)
                queue.add(temp.left);

            if (temp.right != null)
                queue.add(temp.right);

        }

        if(searchNode!=null)
        {
            int x = temp.key;
            deleteDeepest(root,temp);
            searchNode.key = x;
        }
    }

    public void deleteDeepest(Node root, Node delNode){
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        Node temp = null;

        // Do level order traversal until last node
        while (!q.isEmpty())
        {
            temp = q.peek();
            q.remove();

            if (temp == delNode)
            {
                temp = null;
                return;

            }
            if (temp.right!=null)
            {
                if (temp.right == delNode)
                {
                    temp.right = null;
                    return;
                }
                else
                    q.add(temp.right);
            }

            if (temp.left != null)
            {
                if (temp.left == delNode)
                {
                    temp.left = null;
                    return;
                }
                else
                    q.add(temp.left);
            }
        }
    }

    public int noOfLeavesBT(Node root)
    {
        if(root == null)
            return 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int count = 0;
        while (!queue.isEmpty()){
            Node temp = queue.poll();

            if(temp.left == null && temp.right == null)
                count++;

            if(temp.left != null)
                queue.add(temp.left);

            if(temp.right != null)
                queue.add(temp.right);
        }
        return count;
    }

    public int noOfFullNodesBT(Node root)
    {
        if(root == null)
            return 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int count = 0;
        while (!queue.isEmpty()){
            Node temp = queue.poll();

            if(temp.left != null && temp.right != null)
                count++;

            if(temp.left != null){
                queue.add(temp.left);
            }

            if(temp.right != null){
                queue.add(temp.right);
            }
        }
        return count;
    }

    public int noOfNodesWithOnlyOneChild(Node root)
    {
        if(root == null)
            return 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int count = 0;
        while (!queue.isEmpty()){
            Node temp = queue.poll();

            if((temp.left != null && temp.right == null) || (temp.left != null && temp.right == null))
                count++;

            if(temp.left != null){
                queue.add(temp.left);
            }

            if(temp.right != null){
                queue.add(temp.right);
            }
        }
        return count;
    }

    public boolean checkIfTwoBTsStructureIdentical(Node tree1, Node tree2)
    {
        if(tree1 == null && tree2 == null)
            return true;

        if (tree1 != null && tree2 != null)
            return (tree1.key == tree2.key
                    && checkIfTwoBTsStructureIdentical(tree1.left, tree2.left)
                    && checkIfTwoBTsStructureIdentical(tree1.right, tree2.right));
        return false;
    }

    public int diameterOfBT(Node root){

        if(root == null)
            return 0;

        int leftHeight = findHeightOfTree(root.left);
        int rightHeight = findHeightOfTree(root.right);

        return (leftHeight + rightHeight + 1);
    }

    public int maxWidthOfBT(Node root){

        if(root == null)
            return 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int maxWidth = 0;

        while(!queue.isEmpty())
        {

            int count = queue.size();

            maxWidth = Math.max(maxWidth,count);

            while (count > 0){

                Node temp = queue.poll();

                if(temp.left != null)
                    queue.add(temp.left);

                if(temp.right != null)
                    queue.add(temp.right);

                count--;
            }
        }
        return maxWidth;
    }

    public int levelWithMaxSum(Node root){
        if(root == null)
            return 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int res = root.key;

        while(!queue.isEmpty())
        {

            int count = queue.size();
            int sum = 0;

            while (count > 0){

                Node temp = queue.poll();

                sum = sum + temp.key;

                if(temp.left != null)
                    queue.add(temp.left);

                if(temp.right != null)
                    queue.add(temp.right);

                count--;
            }

            res = Math.max(sum,res);
        }
        return res;
    }

    void printPathsRecur(Node node, int path[], int pathLen)
    {
        if (node == null)
            return;

        /* append this node to the path array */
        path[pathLen] = node.key;
        pathLen++;

        /* it's a leaf, so print the path that led to here  */
        if (node.left == null && node.right == null)
            printArray(path, pathLen);
        else
        {
            /* otherwise try both subtrees */
            printPathsRecur(node.left, path, pathLen);
            printPathsRecur(node.right, path, pathLen);
        }
    }

    void printArray(int ints[], int len)
    {
        int i;
        for (i = 0; i < len; i++)
        {
            System.out.print(ints[i] + " ");
        }
        System.out.println("");
    }

    public Node mirrorBT(Node root){
        Node temp;
        if(root != null){
            mirrorBT(root.left);
            mirrorBT(root.right);

            temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        return root;
    }

    public boolean areMirrors(Node tree1, Node tree2){
        if(tree1 == null && tree2 == null)
            return true;

        if(tree1 == null || tree2 == null)
            return false;

        if(tree1.key != tree2.key)
            return false;
        else return(areMirrors(tree1.left,tree2.right) && areMirrors(tree1.right,tree2.left));
    }

    public Node cloneTree(Node root) {
        if (root == null) return null;
        Node newNode = new Node(root.key);
        newNode.left = cloneTree(root.left);
        newNode.right = cloneTree(root.right);
        return newNode;
    }

    /* Imp */
    // Construct a tree from given pre order and in order traversal
    static int preIndex = 0;

    /* Recursive function to construct binary of size len from
       Inorder traversal in[] and Preorder traversal pre[].
       Initial values of inStart and inEnd should be 0 and len -1.
       The function doesn't do any error checking for cases where
       inorder and preorder do not form a tree */
    Node buildTree(int in[], int pre[], int inStrt, int inEnd)
    {
        if (inStrt > inEnd)
            return null;

        /* Pick current node from Preorder traversal using preIndex
           and increment preIndex */
        Node tNode = new Node(pre[preIndex++]);

        /* If this node has no children then return */
        if (inStrt == inEnd)
            return tNode;

        /* Else find the index of this node in Inorder traversal */
        int inIndex = search(in, inStrt, inEnd, tNode.key);

        /* Using index in Inorder traversal, construct left and
           right subtress */
        tNode.left = buildTree(in, pre, inStrt, inIndex - 1);
        tNode.right = buildTree(in, pre, inIndex + 1, inEnd);

        return tNode;
    }

    static class Index {
        int index;
    }

    Node buildBTFromPostAndIn(int in[], int post[], int inStrt,
                   int inEnd, Index pIndex)
    {
        // Base case
        if (inStrt > inEnd)
            return null;

        /* Pick current node from Postrder traversal using
           postIndex and decrement postIndex */
        Node node = new Node(post[pIndex.index]);
        (pIndex.index)--;

        /* If this node has no children then return */
        if (inStrt == inEnd)
            return node;

        /* Else find the index of this node in Inorder
           traversal */
        int iIndex = search(in, inStrt, inEnd, node.key);

        /* Using index in Inorder traversal, construct left and
           right subtress */
        node.right = buildBTFromPostAndIn(in, post, iIndex + 1, inEnd, pIndex);
        node.left = buildBTFromPostAndIn(in, post, inStrt, iIndex - 1, pIndex);

        return node;
    }

    int search(int arr[], int strt, int end, int value)
    {
        int i;
        for (i = strt; i <= end; i++) {
            if (arr[i] == value)
                break;
        }
        return i;
    }

    public boolean ifNodeExists( Node node, int key)
    {
        if (node == null)
            return false;

        if (node.key == key)
            return true;

        // then recur on left sutree /
        boolean res1 = ifNodeExists(node.left, key);
        if(res1) return true; // node found, no need to look further

        // node is not found in left, so recur on right subtree /
        boolean res2 = ifNodeExists(node.right, key);

        return res2;
    }

    public boolean printAllAncestors(Node node, int target){
        if(node == null)
            return false;

        if(node.key == target)
            return true;

        if(printAllAncestors(node.left,target) || printAllAncestors(node.right,target))
        {
            System.out.print(node.key + " ");
            return true;
        }

        return false;
    }

    public boolean checkIfTreeIsBalanced(BinaryTree tree)
    {
        int leftHeight = tree.findHeightOfTree(tree.root.left);
        int rightHeight = tree.findHeightOfTree(tree.root.right);

        if(Math.abs(rightHeight-leftHeight) <= 1)
            return true;
        else
            return false;
    }

    public void printVerticalOrder(){
        TreeMap<Integer,Vector<Integer>> map = new TreeMap<>();
        int hd =0;
        getVerticalOrder(root,hd,map);

        // Traverse the map and print nodes at every horigontal
        // distance (hd)
        System.out.print("Vertical Order Traversal :: ");
        for (Map.Entry<Integer, Vector<Integer>> entry : map.entrySet())
        {
            System.out.print(" " + entry.getValue());
        }
    }

    static void getVerticalOrder(Node root, int hd,
                                 TreeMap<Integer, Vector<Integer>> map)
    {
        // Base case
        if(root == null)
            return;

        //get the vector list at 'hd'
        Vector<Integer> get =  map.get(hd);

        // Store current node in map 'm'
        if(get == null)
        {
            get = new Vector<>();
            get.add(root.key);
        }
        else
            get.add(root.key);

        map.put(hd, get);

        // Store nodes in left subtree
        getVerticalOrder(root.left, hd-1, map);

        // Store nodes in right subtree
        getVerticalOrder(root.right, hd+1, map);
    }

    // Top view of Tree https://www.geeksforgeeks.org/print-nodes-top-view-binary-tree/
    static class pair
    {
        int first, second;

        pair(){}
        pair(int i, int j)
        {
            first = i;
            second = j;
        }
    }

    static TreeMap<Integer,pair> m= new TreeMap<>();
    static void fillMap(Node root, int d, int l)
    {
        if(root == null) return;

        if(m.get(d) == null)
        {
            m.put(d, new pair(root.key, l));
        }
        else if(m.get(d).second>l)
        {
            m.put(d, new pair(root.key, l));
        }

        fillMap(root.left, d - 1, l + 1);
        fillMap(root.right, d + 1, l + 1);
    }

    // function should print the topView of
    // the binary tree
    static void topView(Node root)
    {
        fillMap(root, 0, 0);

        for (Map.Entry<Integer,
                pair> entry : m.entrySet())
        {
            System.out.print(entry.getValue().first + " ");
        }
    }


    static int max_level = 0;

    // recursive function to print left view
    void leftViewUtil(Node node, int level)
    {
        // Base Case
        if (node == null)
            return;

        // If this is the first node of its level
        // https://www.geeksforgeeks.org/print-left-view-binary-tree/
        if (max_level < level) {
            System.out.print(" " + node.key);
            max_level = level;
        }

        // Recur for left and right subtrees
        leftViewUtil(node.left, level + 1);
        leftViewUtil(node.right, level + 1);
    }

    // A wrapper over leftViewUtil()
    void leftView()
    {
        leftViewUtil(root, 1);
    }

    // Right View of tree
    // https://www.geeksforgeeks.org/print-right-view-binary-tree-2/
    // class to access maximum level by reference
    class Max_level {
        int max_level;
    }

    Max_level max = new Max_level();

    // Recursive function to print right view of a binary tree.
    void rightViewUtil(Node node, int level, Max_level max_level) {

        // Base Case
        if (node == null)
            return;

        // If this is the last Node of its level
        if (max_level.max_level < level) {
            System.out.print(node.key + " ");
            max_level.max_level = level;
        }

        // Recur for right subtree first, then left subtree
        rightViewUtil(node.right, level + 1, max_level);
        rightViewUtil(node.left, level + 1, max_level);
    }

    void rightView()
    {
        rightView(root);
    }

    // A wrapper over rightViewUtil()
    void rightView(Node node) {

        rightViewUtil(node, 1, max);
    }

    /* Given a binary tree, print its nth nodes of inorder*/
    // https://www.geeksforgeeks.org/find-n-th-node-inorder-traversal/
    static int count = 0;

    static void NthInorder( Node node, int n)
    {
        if (node == null)
            return;

        if (count <= n) {
            /* first recur on left child */
            NthInorder(node.left, n);
            count++;

            // when count = n then print element
            if (count == n)
                System.out.printf("%d th Element in Tree is %d ",n ,node.key);

            /* now recur on right child */
            NthInorder(node.right, n);
        }
    }

    public static void main(String[] args) {

        /* Construct the following binary tree
                   10
                 /    \
               11      9
              / \     /  \
             7   19  15   8
        */

        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10);

        tree.root.left = new Node(11);
        tree.root.left.left = new Node(7);

        tree.root.right = new Node(9);
        tree.root.right.left = new Node(15);

        tree.root.right.right = new Node(8);

        System.out.print("In Order Traversal :: ");
        tree.inOrderTraversal(tree.root);
        System.out.println();

        tree.insert(tree.root, 19);

        System.out.print("Pre Order Traversal Recursive :: ");
        tree.preOrderTraversal(tree.root);
        System.out.println();

        System.out.print("In Order Traversal Recursive :: ");
        tree.inOrderTraversal(tree.root);
        System.out.println();

        System.out.print("Post Order Traversal Recursive :: ");
        tree.postOrderTraversal(tree.root);
        System.out.println();

        System.out.print("Pre Order Traversal :: ");
        ArrayList<Integer> list = tree.preOrder(tree.root);
        list.forEach(p -> System.out.print(" " + p));
        System.out.println();

        System.out.print("Inc Order Traversal :: ");
        list = tree.inOrder(tree.root);
        list.forEach(p -> System.out.print(" " + p));
        System.out.println();

        System.out.print("Post Order Traversal :: ");
        list = tree.postOrder(tree.root);
        list.forEach(p -> System.out.print(" " + p));
        System.out.println();

        BinaryTree tree1 = new BinaryTree();
        tree1.root = new Node(1);
        tree1.insert(tree1.root, 2);
        tree1.insert(tree1.root, 3);
        tree1.insert(tree1.root, 4);
        tree1.insert(tree1.root, 5);
        tree1.insert(tree1.root, 6);
        tree1.insert(tree1.root, 7);

        System.out.println("Height of a Binary Tree :: " + tree1.findHeightOfTree(tree1.root));

        System.out.print("Breath First Order :: ");
        tree1.breathFirstOrder(tree1.root);
        System.out.println();

        System.out.println("Find maximum Element in BST :: " + tree.findMaxElementInBT(tree.root));

        System.out.println("Check if data present in Tree :: " + tree.findIfDataExistInTree(tree.root, 15));

        tree1.root = tree1.insertRecursively(tree1.root, 8);
        System.out.print("In Order Traversal :: ");
        tree.inOrderTraversal(tree1.root);
        System.out.println();

        System.out.println("Size of Binary Tree :: " + tree1.findSizeOfBinaryTree(tree1.root));

        System.out.println("Size of Binary Tree using inorder :: " + tree1.findSize(tree1.root));

        System.out.print("reverse tree level order / breath first :: ");
        tree1.reverseLevelOrderBreathFirst(tree1.root);
        System.out.println();

        // tree1.deleteTree(tree1.root);

        System.out.print("Breath First Order :: ");
        tree1.breathFirstOrder(tree1.root);
        System.out.println();

        System.out.println("find depth of tree :: " + tree1.findDepthOfBT(tree1.root));

        System.out.println("find depth of tree Iterative :: " + tree1.findDepthOfBTIterative(tree1.root));

        System.out.println("Find min depth of a Binary tree :: " + tree1.minDepthOfBTUsingDFS(tree1.root));

        System.out.println("Deepest Node :: " + tree1.findDeepestNodeInBT(tree1.root, 0));

        System.out.println("Delete Node 3 from Tree :: ");
        tree1.deleteNodeInTree(tree1.root,3);

        System.out.print("Breath First Order After Delete :: ");
        tree1.breathFirstOrder(tree1.root);
        System.out.println();

        tree1.root = tree1.insertRecursively(tree1.root, 3);
        System.out.print("Breath First Order After adding 3 :: ");
        tree1.breathFirstOrder(tree1.root);
        System.out.println();

        System.out.println("No of Leaf Nodes in BT :: " + tree1.noOfLeavesBT(tree1.root));

        System.out.println("No of Full Nodes in BT :: " + tree1.noOfFullNodesBT(tree1.root));

        System.out.println("No of Nodes with only single child in BT :: " + tree1.noOfNodesWithOnlyOneChild(tree1.root));

        BinaryTree tree2 = new BinaryTree();
        tree2.root = tree2.cloneTree(tree1.root);
        System.out.println("Check if two trees are identical :: " + tree1.checkIfTwoBTsStructureIdentical(tree1.root,tree.root));
        System.out.println("Check if two trees are identical :: " + tree1.checkIfTwoBTsStructureIdentical(tree1.root,tree2.root));

        System.out.println("Diameter of BT :: " + tree1.diameterOfBT(tree1.root));

        System.out.println("Max Width of BT :: " + tree1.maxWidthOfBT(tree1.root) );

        System.out.println("max sum level of BT :: " + tree1.levelWithMaxSum(tree1.root));

        System.out.println("Print all root to leaf path :: ");
        tree1.printPathsRecur(tree1.root, new int[1000],0);

        System.out.print("Mirror Binary Tree :: ");
        BinaryTree tree3 = new BinaryTree();
        tree3.root = tree3.cloneTree(tree1.root);
        tree3.root = tree3.mirrorBT(tree3.root);
        tree3.breathFirstOrder(tree3.root);
        System.out.println();

        System.out.println("Check if 2 BTs are mirror :: " + tree1.areMirrors(tree1.root,tree3.root));

        System.out.print("Breath First Order :: ");
        tree1.breathFirstOrder(tree1.root);
        System.out.println();

        System.out.println("Check if Node exists :: " + tree1.ifNodeExists(tree1.root,6));

        System.out.print("Print all ancestors :: ");
        BinaryTree tree4 = new BinaryTree();

        /* Construct the following binary tree
                  1
                /   \
               2     3
              /  \
             4    5
            /
           7
        */
        tree4.root = new Node(1);
        tree4.root.left = new Node(2);
        tree4.root.right = new Node(3);
        tree4.root.left.left = new Node(4);
        tree4.root.left.right = new Node(5);
        tree4.root.left.left.left = new Node(7);

        tree4.printAllAncestors(tree4.root, 7);
        System.out.println();
        System.out.println("Check if BT is Balanced :: " + tree4.checkIfTreeIsBalanced(tree4));

        tree4.printVerticalOrder();
    }
}
