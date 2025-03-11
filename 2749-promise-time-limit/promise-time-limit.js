/**
 * @param {Function} fn
 * @param {number} t
 * @return {Function}
 */
var timeLimit = function(fn, t) {
    return async function(...args) {
        return new Promise(async (resolve, reject) => {
            // Start the execution of the function
            const fnPromise = fn(...args);

            // Create a timeout promise that rejects after `t` milliseconds
            const timeout = new Promise((_, reject) => 
                setTimeout(() => reject("Time Limit Exceeded"), t)
            );

            // Race the function execution against the timeout
            try {
                resolve(await Promise.race([fnPromise, timeout]));
            } catch (error) {
                reject(error);
            }
        });
    };
};

// Example usage:
(async () => {
    const fn = async (n) => { 
        await new Promise(res => setTimeout(res, 100)); 
        return n * n; 
    };
    
    const inputs = [5], t = 50;
    
    const limited = timeLimit(fn, t);
    const start = performance.now();
    
    let result;
    try {
        const res = await limited(...inputs);
        result = { "resolved": res, "time": Math.floor(performance.now() - start) };
    } catch (err) {
        result = { "rejected": err, "time": Math.floor(performance.now() - start) };
    }
    
    console.log(result);
})();
