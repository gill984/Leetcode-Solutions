class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        // Get the whole skyline from all the input buildings.
        return divideAndConquer(buildings, 0, buildings.length - 1);
    }
    
    public List<List<Integer>> divideAndConquer(int[][] buildings, int left, int right) {
        // If the given array of building contains only 1 building, we can
        // directly return the corresponding skyline.
        if (left == right) {
            List<List<Integer>> answer = new ArrayList<>();
            answer.add(Arrays.asList(buildings[left][0], buildings[left][2]));
            answer.add(Arrays.asList(buildings[left][1], 0));
            return answer;
        }
        
        // Otherwise, we shall recursively divide the buildings and 
        // merge the skylines. Cut the given skyline into two halves, 
        // get skyline from each half and merge them into a single skyline.
        int mid = (right - left)/2 + left;
        List<List<Integer>> leftSkyline = divideAndConquer(buildings, left, mid);
        List<List<Integer>> rightSkyline = divideAndConquer(buildings, mid+1, right);
        
        return mergeSkylines(leftSkyline, rightSkyline);
    }
    
    // Given two skylines: leftSky and rightSky, merge them into one skyline.
    public List<List<Integer>> mergeSkylines(List<List<Integer>> leftSkyline, List<List<Integer>> rightSkyline) {
        // Initalize leftPos=0, rightPos=0 as the pointer of lft_sky and rgt_sky.
        // Since we start from the left ground, thus our current height curY = 0,
        // the previous height from lft_sky and rgt_sky are also 0.
        List<List<Integer>> answer = new ArrayList<>();
        int leftPos = 0, rightPos = 0;
        int leftPrevHeight = 0, rightPrevHeight = 0;
        int curX, curY;

        // Now we start to iterate over both skylines.
        while (leftPos < leftSkyline.size() && rightPos < rightSkyline.size()) {
            int nextLeftX = leftSkyline.get(leftPos).get(0);
            int nextRightX = rightSkyline.get(rightPos).get(0);

            // If we meet lft_sky key point first, our current height 
            // changes to the larger one between height on left skyline 
            // and the previous height on right skyline. Update the 
            // previous height from lft_sky and increment leftPos by 1.
            if (nextLeftX < nextRightX) {
                leftPrevHeight = leftSkyline.get(leftPos).get(1);
                curX = nextLeftX;
                curY = Math.max(leftPrevHeight, rightPrevHeight);
                leftPos++;
            } 
            
            // If we meet rgt_sky key point first, our current height 
            // changes to the larger one between height on right skyline 
            // and the previous height on left skyline. Update the 
            // previous height from rgt_sky and increment rightPos by 1.
            else if (nextLeftX > nextRightX) {
                rightPrevHeight = rightSkyline.get(rightPos).get(1);
                curX = nextRightX;
                curY = Math.max(leftPrevHeight, rightPrevHeight);
                rightPos++;
            } 
            
            // If both skyline key points has same x:
            // Our current height is the larger one, update the 
            // previous height from lft_sky and rgt_sky. 
            // Increment both leftPos and rightPos by 1.
            else {    
                leftPrevHeight = leftSkyline.get(leftPos).get(1);
                rightPrevHeight = rightSkyline.get(rightPos).get(1);
                curX = nextLeftX;
                curY = Math.max(leftPrevHeight, rightPrevHeight);
                leftPos++;
                rightPos++;
            }

            // Discard those key points that has the same height 
            // as the previous one.
            if (answer.isEmpty() || answer.get(answer.size()-1).get(1) != curY){
                answer.add(Arrays.asList(curX, curY));
            }
        }
        
        // If we finish iterating over any skyline, 
        // just append the rest of the other skyline to the merged skyline.
        while(leftPos < leftSkyline.size()) {
            answer.add(leftSkyline.get(leftPos));
            leftPos++;
        }
        
        while(rightPos < rightSkyline.size()) {
            answer.add(rightSkyline.get(rightPos));
            rightPos++;
        }
        return answer;
    }
}