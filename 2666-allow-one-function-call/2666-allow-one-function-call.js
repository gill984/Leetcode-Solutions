var once = function(fn) {
    let first = true;
    return function(...args){
        if (!first)
            return undefined;
        first = false;
        return fn(...args);
    }
};
