/**
 * @param {string} val
 * @return {Object}
 */
var expect = function(val) {
    return {
        toBe: function(expected) {
            if (val === expected) return true;
            throw new Error("Not Equal");
        },
        notToBe: function(expected) {
            if (val !== expected) return true;
            throw new Error("Equal");
        }
    };
};
console.log(expect(5).toBe(5)); // true

try {
    console.log(expect(5).notToBe(5)); // Throws "Equal"
} catch (error) {
    console.log(error.message); // "Equal"
}

/**
 * expect(5).toBe(5); // true
 * expect(5).notToBe(5); // throws "Equal"
 */