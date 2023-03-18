class BrowserHistory:
    def __init__(self, homepage: str):
        self.history = [homepage]
        self.current_idx = 0
        self.max_forward_idx = 0

    def visit(self, url: str) -> None:
        # If current_idx is already at the end of the history list, append the new url
        if self.current_idx == len(self.history) - 1:
            self.history.append(url)
        # If current_idx is not at the end of the history list, overwrite the value and add 1 to current_idx
        else:
            self.history[self.current_idx+1] = url
            
        self.current_idx += 1
        self.max_forward_idx = self.current_idx

    def back(self, steps: int) -> str:
        # Calculate the new index after moving back
        new_idx = max(0, self.current_idx - steps)
        # Update the current and max forward indices
        self.max_forward_idx = max(self.max_forward_idx, self.current_idx)
        self.current_idx = new_idx
        # Return the current url
        return self.history[self.current_idx]

    def forward(self, steps: int) -> str:
        # Calculate the new index after moving forward
        new_idx = min(self.max_forward_idx, self.current_idx + steps)
        # Update the current index
        self.current_idx = new_idx
        # Return the current url
        return self.history[self.current_idx]
