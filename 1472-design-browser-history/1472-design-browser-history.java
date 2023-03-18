class BrowserHistory {
    int idx;
    int max;
    List<String> history;
    
    
    public BrowserHistory(String homepage) {
        history = new ArrayList<>();
        history.add(homepage);
        idx = 0;
    }
    
    public void visit(String url) {
        idx++;
        if (idx >= history.size())
            history.add(url);
        else
            history.set(idx, url);
        max = idx;
    }
    
    public String back(int steps) {
        max = Math.max(idx, max);
        idx = Math.max(idx - steps, 0);
        return history.get(idx);
    }
    
    public String forward(int steps) {
        idx = Math.min(idx + steps, max);
        return history.get(idx);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */