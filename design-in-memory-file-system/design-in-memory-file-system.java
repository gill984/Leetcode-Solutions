class FileSystem
{
    File root;
    
    public FileSystem()
    {
        root = new File(true, "", null);
    }
    
    // If path is a file path, returns a list that only contains this file's name.
    // If path is a directory path, returns the list of file and directory names in this directory.
    //     Sorted in lexicographic order
    public List<String> ls(String path)
    {
        String[] pathTokens = path.split("/");
        File curr = root;
        for (int i = 1; i < pathTokens.length; i++)
        {
            curr = curr.subFiles.get(pathTokens[i]);
        }
        
        return curr.fileList();
    }
    
    // Makes a new directory according to the given path. The given directory path does not exist.
    // If the middle directories in the path do not exist, you should create them as well.
    public void mkdir(String path)
    {
        String[] pathTokens = path.split("/");
        File curr = root;
        
        for (int i = 1; i < pathTokens.length; i++)
        {
            if (!curr.subFiles.containsKey(pathTokens[i]))
            {
                File f = new File(true, pathTokens[i], null);
                curr.subFiles.put(pathTokens[i], f);
                curr = f;
            }
            else
            {
                curr = curr.subFiles.get(pathTokens[i]);
            }
        }
    }
    
    // If filePath does not exist, creates that file containing given content.
    // If filePath already exists, appends the given content to original content.
    public void addContentToFile(String filePath, String content)
    {
        String[] pathTokens = filePath.split("/");
        File curr = root;
        
        for (int i = 1; i < pathTokens.length; i++)
        {
            if (i != pathTokens.length - 1)
            {
                if (!curr.subFiles.containsKey(pathTokens[i]))
                {
                    File f = new File(true, pathTokens[i], null);
                    curr.subFiles.put(pathTokens[i], f);
                    curr = f;
                }
                else
                {
                    curr = curr.subFiles.get(pathTokens[i]);
                }
            }
            else
            {
                if (curr.subFiles.containsKey(pathTokens[i]))
                {
                    curr.subFiles.get(pathTokens[i]).addContent(content);
                }
                else
                {
                    File f = new File(false, pathTokens[i], content);
                    curr.subFiles.put(pathTokens[i], f);
                }
            }
        }
    }
    
    // Returns the content in the file at filePath.
    // Can assume file exists
    public String readContentFromFile(String filePath)
    {
        String[] pathTokens = filePath.split("/");
        File curr = root;
        
        for (int i = 1; i < pathTokens.length; i++)
        {
            curr = curr.subFiles.get(pathTokens[i]);
        }
        
        return curr.content.toString();
    }
    
    class File
    {
        boolean isDirectory;
        String name;
        StringBuilder content;
        TreeMap<String, File> subFiles;
        
        public File(boolean isDir, String n, String c)
        {
            isDirectory = isDir;
            name = n;
            
            if (isDir)
            {
                subFiles = new TreeMap<String, File>();
            }
            else
            {
                content = new StringBuilder();
                addContent(c);
            }
        }
        
        public void addContent(String s)
        {
            content.append(s);
        }
        
        public List<String> fileList()
        {
            if (isDirectory)
            {
                List<String> res = new ArrayList<>();
                for (String k : subFiles.keySet())
                {
                    System.out.println(k);
                    res.add(k);
                }
                return res;
            }
            else
            {
                List<String> res = new ArrayList<>();
                res.add(name);
                return res;
            }
        }
        
        public String toString()
        {
            return name + " " + (isDirectory ? " directory" : " file");
        }
    }
}

