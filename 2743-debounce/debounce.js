/**
 * @param {Function} fn
 * @param {number} t
 * @return {Function}
 */
function debounce(fn, t) {
    let timer = null; // To track the timeout ID

    return function(...args) {
        clearTimeout(timer); // Cancel previous timer if a new call is made
        timer = setTimeout(() => fn(...args), t); // Set new timer
    };
}


let start = Date.now();
function log(...inputs) { 
  console.log([Date.now() - start, inputs])
}

const dlog = debounce(log, 50);
setTimeout(() => dlog(1), 50);  // Cancelled
setTimeout(() => dlog(2), 75);  // Runs at 125ms
