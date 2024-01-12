import axios from 'axios';
const webClient = axios.create({
    baseURL: 'http://localhost:3090',
    timeout: 1000
});

export {webClient};