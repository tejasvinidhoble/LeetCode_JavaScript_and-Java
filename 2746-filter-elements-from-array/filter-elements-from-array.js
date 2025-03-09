/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function(arr, fn) {
     let result = [];
    for (let i = 0; i < arr.length; i++) {
        if (fn(arr[i], i)) { // Apply function and check if the result is truthy
            result.push(arr[i]); // Add element if condition is met
        }
    }
    return result;
};