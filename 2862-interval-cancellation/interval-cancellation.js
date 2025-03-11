/**
 * @param {Function} fn
 * @param {Array} args
 * @param {number} t
 * @return {Function}
 */
var cancellable = function(fn, args, t) {
    // Store the start time for accurate logging
    const start = performance.now();

    // Immediately execute the function and log the first result
    fn(...args);

    // Set up an interval to call fn repeatedly every t milliseconds
    const interval = setInterval(() => {
        fn(...args);
    }, t);

    // Return a function to cancel the interval when invoked
    return () => clearInterval(interval);
};

// Example usage:
const result = [];

const fn = (x) => x * 2;
const args = [4], t = 35, cancelTimeMs = 190;

const start = performance.now();

const log = (...argsArr) => {
    const diff = Math.floor(performance.now() - start);
    result.push({ "time": diff, "returned": fn(...argsArr) });
}

const cancel = cancellable(log, args, t);

setTimeout(cancel, cancelTimeMs);

setTimeout(() => {
    console.log(result);
}, cancelTimeMs + 15);
