/**
 * @param {number} n
 * @return {Function} counter
 */
var createCounter = function(n) {
    
    return function() {
          return n++;
    };
};
const counter1 = createCounter(10);
console.log(counter1()); // 10
console.log(counter1()); // 11
console.log(counter1()); // 12

const counter2 = createCounter(-2);
console.log(counter2()); // -2
console.log(counter2()); // -1
console.log(counter2()); // 0
console.log(counter2()); // 1
console.log(counter2()); // 2

/** 
 * const counter = createCounter(10)
 * counter() // 10
 * counter() // 11
 * counter() // 12
 */