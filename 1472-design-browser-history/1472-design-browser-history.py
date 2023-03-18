class BrowserHistory:

    def __init__(self, homepage: str):
        self.history = [homepage]
        self.current_idx = 0

    def visit(self, url: str) -> None:
        # Clear the forward history
        self.history = self.history[:self.current_idx+1]
        # Add the new url to the history
        self.history.append(url)
        # Update the current index
        self.current_idx = len(self.history) - 1

    def back(self, steps: int) -> str:
        # Move back in history
        self.current_idx = max(0, self.current_idx - steps)
        return self.history[self.current_idx]

    def forward(self, steps: int) -> str:
        # Move forward in history
        self.current_idx = min(len(self.history) - 1, self.current_idx + steps)
        return self.history[self.current_idx]
        


# Your BrowserHistory object will be instantiated and called as such:
# obj = BrowserHistory(homepage)
# obj.visit(url)
# param_2 = obj.back(steps)
# param_3 = obj.forward(steps)