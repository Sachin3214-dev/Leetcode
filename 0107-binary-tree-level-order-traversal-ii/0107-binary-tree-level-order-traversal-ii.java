/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> mainlist = new ArrayList<>();
        if (root == null) {
            return mainlist; // Return empty list if tree is empty
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        List<Integer> sublist = new ArrayList<>(); // Initialize sublist
        while(!q.isEmpty())
        {
            TreeNode curr=q.remove();
            if(curr==null)
            {
                mainlist.add(sublist);
                sublist=new ArrayList<>();
                if(q.isEmpty())
                {
                    break;
                }else{
                    q.add(null);
                }
            }else{
                sublist.add(curr.val);
                if(curr.left!=null)
                {
                    q.add(curr.left);
                }
                if(curr.right!=null)
                {
                    q.add(curr.right);
                }
            }
        }
        //till here the list is in top to bottom fashion Okay ...
        //if its possible to swap the list of list like array elements then we get the answer? ---------yes---------
        for(int i=0;i<mainlist.size()/2;i++)
        {
            List<Integer> temp=mainlist.get(i);//saved
            mainlist.set(i,mainlist.get(mainlist.size()-i-1));
            mainlist.set(mainlist.size()-i-1,temp);
        }
        return mainlist;
    }
}