class FileSystem {
    Dir root;
    
    
    class Dir
    {
        String name;
        int value;
        Map<String, Dir> subdirs;
        
        public Dir (String name, int value)
        {
            this.name = name;
            this.value = value;
            subdirs = new HashMap<>();
        }
        
        public boolean add (Dir d)
        {
            if (subdirs.containsKey(d.name))
                return false;
            subdirs.put(d.name, d);
            return true;
        }
    }

    public FileSystem() {
        root = new Dir("", 0);
    }
    
    public boolean createPath(String path, int value) {
        String [] tokens = path.split("/");
        Dir curr = root;
        for (int i = 1; i < tokens.length - 1; i++)
        {
            String t = tokens[i];
            if (curr.subdirs.containsKey(t))
                curr = curr.subdirs.get(t);
            else
                return false;
        }
        return curr.add(new Dir(tokens[tokens.length - 1], value));
    }
    
    public int get(String path) {
        String [] tokens = path.split("/");
        Dir curr = root;
        for (int i = 1; i < tokens.length; i++)
        {
            String t = tokens[i];
            if (curr.subdirs.containsKey(t))
                curr = curr.subdirs.get(t);
            else
                return -1;
        }
        
        return curr.value;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */