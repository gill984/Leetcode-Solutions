import java.util.Arrays;
import java.util.HashMap;

class Solution
{
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries)
    {
        HashMap<String, Integer> stringToIndex = new HashMap<String, Integer>();
        HashMap<Integer, String> indexToString = new HashMap<Integer, String>();

        int numNodes = 0;
        for (List<String> vars : equations)
        {
            for (String var : vars)
            {
                if (!stringToIndex.containsKey(var))
                {
                    stringToIndex.put(var, numNodes);
                    indexToString.put(numNodes, var);
                    numNodes += 1;
                }
            }
        }

        // Build adjacency matrix
        double[][][] D = new double[numNodes + 1][numNodes][numNodes];

        // Put 0 in each self edge and infinity in the rest
        for (int k = 0; k < numNodes + 1; k++)
        {
            for (int i = 0; i < numNodes; i++)
            {
                for (int j = 0; j < numNodes; j++)
                {
                    D[k][i][j] = Double.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < equations.size(); i++)
        {
            String num = equations.get(i).get(0);
            String den = equations.get(i).get(1);
            double val = values[i];

            D[0][stringToIndex.get(num)][stringToIndex.get(den)] = val;
            D[0][stringToIndex.get(den)][stringToIndex.get(num)] = 1.0 / val;
        }

        // Matrix is now in beginning state of Floyd Warshall
        for (int k = 0; k < numNodes; k++)
            for (int i = 0; i < numNodes; i++)
                for (int j = 0; j < numNodes; j++)
                    if (i == j)
                        continue;
                    else
                        D[k + 1][i][j] = Math.min(D[k][i][j], D[k][i][k] * D[k][k][j]);

        double[] result = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++)
        {
            if (!stringToIndex.containsKey(queries.get(i).get(0)) || !stringToIndex.containsKey(queries.get(i).get(1)))
            {
                result[i] = -1;
            }
            else
            {

                int from = stringToIndex.get(queries.get(i).get(0));
                int to = stringToIndex.get(queries.get(i).get(1));
                if (from == to)
                {
                    result[i] = 1.0;
                } 
                else if (D[numNodes][from][to] > 1E100)
                {
                    result[i] = -1;
                } 
                else
                {
                    result[i] = D[numNodes][from][to];
                }
            }
        }

        return result;
    }
}