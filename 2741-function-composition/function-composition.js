/**
 * @param {Function[]} functions
 * @return {Function}
 */
var compose = function(functions) {
    
    return function(x) {
        return functions.reduceRight((acc, fn) => fn(acc), x);
    }
};
console.log(compose([x => x + 1, x => x * x, x => 2 * x])(4)); // Output: 65
console.log(compose([x => 10 * x, x => 10 * x, x => 10 * x])(1)); // Output: 1000
console.log(compose([])(42)); // Output: 42

/**
 * const fn = compose([x => x + 1, x => 2 * x])
 * fn(4) // 9
 */