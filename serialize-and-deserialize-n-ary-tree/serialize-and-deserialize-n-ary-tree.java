/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Codec {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        StringBuilder s = new StringBuilder();
        preOrderSerialize(root, s);
        // System.out.println(s.toString());
        return s.toString();
    }
    
    public void preOrderSerialize(Node cur, StringBuilder s)
    {
        if (cur == null)
            return;
        
        s.append(cur.val + " ");
        if (cur.children != null && cur.children.size() > 0)
        {
            s.append("[ ");
            for (Node n : cur.children)
                preOrderSerialize(n, s);
            s.append("] ");
        }
    }
	
    // Decodes your encoded data to tree.
    public Node deserialize(String dataString) {
        char [] data = dataString.toCharArray();
        Node root = null;
        Node prev = null;
        Stack<Node> parentStack = new Stack<>();
        
        for (int i = 0; i < data.length; i++)
        {
            if (data[i] == ' ')
                continue;
            
            if (data[i] == '[')
            {
                parentStack.push(prev);
            }
            else if (data[i] == ']')
            {
                parentStack.pop();
            }
            else if (Character.isDigit(data[i]))
            {
                int val = 0;
                while (i < data.length && Character.isDigit(data[i]))
                {
                    val = val * 10 + (data[i] - '0');
                    i++;
                }
                
                Node nextNode = new Node(val, new ArrayList<Node>());
                // System.out.println("Created " + nextNode.val);
                
                // This node is either the child of the top node
                // on the parentStack or it's the root
                if (parentStack.isEmpty())
                {
                    root = nextNode;
                    // System.out.println("Set root to: " + nextNode.val);
                }
                else
                {                    
                    // System.out.println("Adding " + nextNode.val + " as child of " + parentStack.peek().val);
                    parentStack.peek().children.add(nextNode);
                }
                
                prev = nextNode;
                i--;
            }
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));