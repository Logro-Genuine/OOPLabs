import axios from "axios";

const AUTH_REST_API_BASE_URL = "http://localhost:8080/api/auth";

// Функция для регистрации
export const registerAPICall = (username, password, role) => {
    const registerObj = {
        username: username,  // Ключ "username"
        password: password,  // Ключ "password"
        role: role           // Ключ "role"
    };

    return axios.post(`${AUTH_REST_API_BASE_URL}/signup`, registerObj, {
        headers: {
            'Content-Type': 'application/json' // Указываем, что отправляем JSON
        }
    });
};

// Функция для входа в систему
export const loginAPICall = (username, password) => {
    const loginObj = {
        username: username,  // Ключ "username"
        password: password   // Ключ "password"
    };

    return axios.post(`${AUTH_REST_API_BASE_URL}/signin`, loginObj, {
        headers: {
            'Content-Type': 'application/json' // Указываем, что отправляем JSON
        }
    });
};
