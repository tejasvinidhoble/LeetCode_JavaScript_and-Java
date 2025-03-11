class TimeLimitedCache {
    constructor() {
        this.cache = new Map(); // Stores key-value pairs with expiration time
    }

    /**
     * @param {number} key
     * @param {number} value
     * @param {number} duration
     * @return {boolean}
     */
    set(key, value, duration) {
        const now = Date.now();
        const alreadyExists = this.cache.has(key) && this.cache.get(key).expiry > now;

        // Store the value with an expiration timestamp
        this.cache.set(key, { value, expiry: now + duration });

        // Set a timeout to remove the key once it expires
        setTimeout(() => {
            if (this.cache.get(key)?.expiry <= Date.now()) {
                this.cache.delete(key);
            }
        }, duration);

        return alreadyExists;
    }

    /**
     * @param {number} key
     * @return {number}
     */
    get(key) {
        const entry = this.cache.get(key);
        if (!entry || entry.expiry <= Date.now()) {
            return -1; // Key has expired or doesn't exist
        }
        return entry.value;
    }

    /**
     * @return {number}
     */
    count() {
        const now = Date.now();
        let count = 0;
        for (const [key, entry] of this.cache.entries()) {
            if (entry.expiry > now) count++;
            else this.cache.delete(key); // Cleanup expired entries
        }
        return count;
    }
}

// Example Usage
const cache = new TimeLimitedCache();

console.log(cache.set(1, 42, 100)); // false (key does not exist yet)
setTimeout(() => console.log(cache.get(1)), 50); // 42 (key is still valid)
setTimeout(() => console.log(cache.count()), 50); // 1 (one active key)
setTimeout(() => console.log(cache.get(1)), 150); // -1 (key has expired)
