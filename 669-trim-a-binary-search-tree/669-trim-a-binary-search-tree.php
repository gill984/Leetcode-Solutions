/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     public $val = null;
 *     public $left = null;
 *     public $right = null;
 *     function __construct($val = 0, $left = null, $right = null) {
 *         $this->val = $val;
 *         $this->left = $left;
 *         $this->right = $right;
 *     }
 * }
 */
class Solution {

    /**
     * @param TreeNode $root
     * @param Integer $low
     * @param Integer $high
     * @return TreeNode
     */
    function trimBST($root, $low, $high) {
        if ($root == null)
            return null;
        
        if ($root->val < $low)
        {
            return $this->trimBST($root->right, $low, $high);
        }
        else if ($root->val > $high)
        {
            return $this->trimBST($root->left, $low, $high);
        }
        
        $root->left = $this->trimBST($root->left, $low, $high);
        $root->right = $this->trimBST($root->right, $low, $high);
        return $root;
    }
}