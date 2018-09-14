/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
private:
    vector<vector<int>> total_vector;
public:
    vector<vector<int>> pathSum(TreeNode* root, int sum) {
        vector<int> v;
        
        path(root, sum, v);
        
        return total_vector;
    }
    
    void path(TreeNode* node, int num, vector<int> v) {
        if (node != NULL) {
            num -= node->val;
            
            v.push_back(node->val);
            
            if (num == 0 && node->left == NULL && node->right == NULL) {
                total_vector.push_back(v);
            }
            
            path(node->left, num, v);
            path(node->right, num, v);
        }
        else {
            return;
        }
    }
};