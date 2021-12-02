class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        // Build a tree structure
        // com --- leetcode --- discuss
        //                 \--- problems
        // Each node has a separate count
        // At the end traverse the tree to get all values
        // Create list and reverse for the full domain, count is the value at the node
        PrefixNode root = new PrefixNode("");
        
        for (String site : cpdomains)
        {
            String [] numDomain = site.split(" ");
            int count = Integer.parseInt(numDomain[0]);
            String [] domains = numDomain[1].split("\\.");
            PrefixNode curr = root;
            
            for (int i = domains.length - 1; i >= 0; i--)
            {
                String s = domains[i];
                if (!curr.children.containsKey(s))
                {
                    curr.children.put(s, new PrefixNode(s));
                }
                curr = curr.children.get(s);
                curr.count += count;
                System.out.println(curr);
            }
        }
        
        List<String> res = new ArrayList<String>();
        
        // Traverse tree and create res
        dfs(root, new ArrayDeque<String>(), res);        
        return res;
    }
    
    public void dfs(PrefixNode curr, Deque<String> path, List<String> res)
    {
        if (curr == null)
            return;
        
        for (String name : curr.children.keySet())
        {
            PrefixNode p = curr.children.get(name);
            path.addFirst(p.name);
            
            StringBuilder buffer = new StringBuilder();
            buffer.append(p.count + " ");
            boolean first = true;
            for (String s : path)
            {
                if (first)
                    first = false;
                else
                    buffer.append(".");
                buffer.append(s);
            }
            
            res.add(buffer.toString());
            dfs(p, path, res);
            path.removeFirst();
        }
    }
    
    class PrefixNode
    {
        String name;
        int count;
        Map<String, PrefixNode> children;
        
        public PrefixNode(String name)
        {
            this.name = name;
            children = new HashMap<String, PrefixNode>();
        }
        
        public String toString()
        {
            return name + " " + count;
        }
    }
}