class Solution
{
    public String simplifyPath(String path)
    {
        ArrayDeque<String> queue = new ArrayDeque<String>();
        String [] paths = path.split("/");
        
        for(String s : paths)
        {
            if(s.equals(".."))
            {
                if(!queue.isEmpty())
                    queue.removeLast();
            }
            else if(s.equals(".") || s.equals(""))
                continue;
            else
                queue.addLast(s);
        }
        
        StringBuilder result = new StringBuilder();
        
        result.append("/");
        while(!queue.isEmpty())
        {
            result.append(queue.removeFirst());
            if(!queue.isEmpty())
                result.append("/");
        }
        
        return result.toString();
    }
}