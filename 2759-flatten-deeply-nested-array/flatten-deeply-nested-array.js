/**
 * @param {Array} arr
 * @param {number} depth
 * @return {Array}
 */
var flat = function (arr, n) {
    const result = [];

    function flattenHelper(arr, depth) {
        for (let el of arr) {
            if (Array.isArray(el) && depth < n) {
                flattenHelper(el, depth + 1);
            } else {
                result.push(el);
            }
        }
    }

    flattenHelper(arr, 0);
    return result;
};