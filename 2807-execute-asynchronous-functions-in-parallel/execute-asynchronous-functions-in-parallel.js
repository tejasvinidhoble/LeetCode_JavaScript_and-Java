/**
 * @param {Array<Function>} functions
 * @return {Promise}
 */
function promiseAll(functions) {
    return new Promise((resolve, reject) => {
        let results = new Array(functions.length);
        let completed = 0;
        let hasRejected = false;

        functions.forEach((fn, index) => {
            fn().then(value => {
                if (hasRejected) return;
                results[index] = value;
                completed++;

                if (completed === functions.length) {
                    resolve(results);
                }
            }).catch(error => {
                if (!hasRejected) {
                    hasRejected = true;
                    reject(error);
                }
            });
        });
    });
}


const functions = [
  () => new Promise(resolve => setTimeout(() => resolve(4), 50)), 
  () => new Promise(resolve => setTimeout(() => resolve(10), 150)), 
  () => new Promise(resolve => setTimeout(() => resolve(16), 100))
];

let start = Date.now();
promiseAll(functions)
  .then(res => console.log({ t: Date.now() - start, resolved: res }))
  .catch(err => console.log({ t: Date.now() - start, rejected: err }));
