class Calculator {
    /**
     * @param {number} value
     */
    constructor(value) {
        this.result = value; // Initialize with the given value
    }

    /**
     * @param {number} value
     * @return {Calculator}
     */
    add(value) {
        this.result += value;
        return this; // Enable method chaining
    }

    /**
     * @param {number} value
     * @return {Calculator}
     */
    subtract(value) {
        this.result -= value;
        return this;
    }

    /**
     * @param {number} value
     * @return {Calculator}
     */
    multiply(value) {
        this.result *= value;
        return this;
    }

    /**
     * @param {number} value
     * @return {Calculator}
     */
    divide(value) {
        if (value === 0) {
            throw new Error("Division by zero is not allowed");
        }
        this.result /= value;
        return this;
    }

    /**
     * @param {number} value
     * @return {Calculator}
     */
    power(value) {
        this.result = Math.pow(this.result, value);
        return this;
    }

    /**
     * @return {number}
     */
    getResult() {
        return this.result;
    }
}

/**
 * Example Usage:
 * new Calculator(10).add(5).subtract(7).getResult(); // 8
 * new Calculator(2).multiply(5).power(2).getResult(); // 100
 * new Calculator(20).divide(0).getResult(); // Throws "Division by zero is not allowed"
 */
