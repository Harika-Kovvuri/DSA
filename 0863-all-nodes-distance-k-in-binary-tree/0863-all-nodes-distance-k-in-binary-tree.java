/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        // Store parent of each node
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node.left != null) {
                parent.put(node.left, node);
                q.offer(node.left);
            }

            if (node.right != null) {
                parent.put(node.right, node);
                q.offer(node.right);
            }
        }

        // BFS from target node
        HashSet<TreeNode> visited = new HashSet<>();

        q.offer(target);
        visited.add(target);

        int dist = 0;

        while (!q.isEmpty()) {

            if (dist == k)
                break;

            int size = q.size();
            dist++;

            for (int i = 0; i < size; i++) {

                TreeNode node = q.poll();

                // Left child
                if (node.left != null && !visited.contains(node.left)) {
                    visited.add(node.left);
                    q.offer(node.left);
                }

                // Right child
                if (node.right != null && !visited.contains(node.right)) {
                    visited.add(node.right);
                    q.offer(node.right);
                }

                // Parent
                if (parent.containsKey(node) &&
                        !visited.contains(parent.get(node))) {

                    visited.add(parent.get(node));
                    q.offer(parent.get(node));
                }
            }
        }

        List<Integer> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            ans.add(q.poll().val);
        }

        return ans;
    }
}