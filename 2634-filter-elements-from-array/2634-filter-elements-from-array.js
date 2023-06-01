/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function(arr, fn) {
    s = 0;
    shifts = Array(arr.length).fill(0);
    length = 0;
    
    for (let i = 0; i < arr.length; i++) {
        if (!fn(arr[i], i)) {
            s++;
            shifts[i] = -1;
        } else {
            length++;
            shifts[i] = s;
        }
    }
    
    res = Array(length);
    for (let i = 0; i < shifts.length; i++) {
        if (shifts[i] == -1) {
            continue;
        }
        
        res[i - shifts[i]] = arr[i];
    }
    return res;
};