import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

class Solution
{
    List<List<String>> result;
    HashMap<String, ArrayList<String>> prefixMap;
    char[][] wordPool;
    String[] globalWords;

    public List<List<String>> wordSquares(String[] words)
    {
        result = new ArrayList<List<String>>();

        // Build prefix Map
        prefixMap = new HashMap<String, ArrayList<String>>();
        for (String w : words)
        {
            for (int i = 0; i < w.length(); i++)
            {
                String subKey = w.substring(0, i);
                if (prefixMap.containsKey(subKey))
                {
                    prefixMap.get(subKey).add(w);
                } else
                {
                    ArrayList<String> list = new ArrayList<String>();
                    list.add(w);
                    prefixMap.put(subKey, list);
                }
            }
        }
        // Prefix Map built

        // For each word in the list, attempt to build a word square with this
        // word as a starting word. In order to have a valid square, the next
        // prefix needs to have a nonempty list. Use the DFS function to build each word
        // square and add the result to the overall return value.
        for (String w : words)
        {
            DFS(w, new ArrayList<String>());
        }

        return result;
    }

    public void DFS(String word, List<String> list)
    {
        int nextIndex = list.size();
        list.add(word);

        if (nextIndex == word.length() - 1)
        {
            result.add(new ArrayList<String>(list));
        } else
        {

            StringBuilder nextPrefix = new StringBuilder();
            for(int i = 0; i < list.size(); i++)
                nextPrefix.append(list.get(i).charAt(list.size()));

            if (prefixMap.containsKey(nextPrefix.toString()))
            {
                for (String s : prefixMap.get(nextPrefix.toString()))
                {
                    DFS(s, list);
                }
                
            }
        }
        list.remove(list.size() - 1);
    }
}