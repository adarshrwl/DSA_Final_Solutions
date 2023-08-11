public class SiblingNodeFinder {

    // Variables to store the depths and parent nodes for the given values nodeA and
    // nodeB
    private int depthA, depthB;
    private TreeNode parentA, parentB;

    // Function to check if two nodes in a binary tree are siblings
    public boolean areNodesSiblings(TreeNode root, int nodeAValue, int nodeBValue) {
        // Perform a depth-first traversal to find the depths and parents of nodeA and
        // nodeB
        exploreTree(root, null, nodeAValue, nodeBValue, 0);
        // Return true if both nodes are at the same depth and have different parents
        return depthA == depthB && parentA != parentB;
    }

    // Depth-first traversal function to explore the tree and find depths and
    // parents
    private void exploreTree(TreeNode node, TreeNode parent, int nodeAValue, int nodeBValue, int depth) {
        if (node == null) {
            return;
        }

        // If the current node matches the value of nodeA
        if (node.val == nodeAValue) {
            depthA = depth; // Set the depth of nodeA
            parentA = parent; // Set the parent of nodeA
        }
        // If the current node matches the value of nodeB
        else if (node.val == nodeBValue) {
            depthB = depth; // Set the depth of nodeB
            parentB = parent; // Set the parent of nodeB
        }

        // Recur to the left and right subtrees
        exploreTree(node.left, node, nodeAValue, nodeBValue, depth + 1);
        exploreTree(node.right, node, nodeAValue, nodeBValue, depth + 1);
    }

    public static void main(String[] args) {
        // Create the binary tree
        /*
         * 1
         * / \
         * 2 3
         * /
         * 4
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        int nodeAValue = 4, nodeBValue = 3;

        SiblingNodeFinder snf = new SiblingNodeFinder();
        // Check if nodes with values nodeAValue and nodeBValue are siblings
        boolean result = snf.areNodesSiblings(root, nodeAValue, nodeBValue);
        System.out.println(result); // Print the result
    }
}

// Definition of TreeNode class
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}
