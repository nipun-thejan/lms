
class LocalStorageService {
    #TOKEN_KEY = 'token';
    #EMAIL_KEY = 'email';
    #ROLE_KEY = 'role';
    #NAME_KEY = 'name';
    // #IS_FIRST_TIME_AFTER_SIGNED = 'if_first_time_after_signed';

    setName(name) {
        localStorage.setItem(this.#NAME_KEY, name);
    }
    getName() { 
        return localStorage.getItem(this.#NAME_KEY) || null;
    }

    setToken(token) {
        localStorage.setItem(this.#TOKEN_KEY, token);
    }
    getToken() {
        return localStorage.getItem(this.#TOKEN_KEY) || null;
    }
    clearAll() {
        localStorage.removeItem(this.#TOKEN_KEY);
        localStorage.removeItem(this.#EMAIL_KEY);
        localStorage.removeItem(this.#ROLE_KEY);
        localStorage.removeItem(this.#NAME_KEY)
    }

    isSigned() {
        return this.getToken() != null;
    }

    setEmail(email) {
        localStorage.setItem(this.#EMAIL_KEY, email);
    }
    getEmail() {
        return localStorage.getItem(this.#EMAIL_KEY) || null;
    }

    setRole(role) {
        localStorage.setItem(this.#ROLE_KEY, role);
    }
    getRole() {
        return localStorage.getItem(this.#ROLE_KEY) || null;
    }

    // setIsFirstTime(isFirstValue) {
    //     localStorage.setItem(this.#IS_FIRST_TIME_AFTER_SIGNED, isFirstValue);
    // }
    // getIsFirstTime() {
    //     return localStorage.getItem(this.#IS_FIRST_TIME_AFTER_SIGNED) === "true" ? true : false;
    // }
}

let localStorageService = new LocalStorageService();
export default localStorageService;