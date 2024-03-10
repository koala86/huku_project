// axios 
import axios from 'axios'
const request = axios.create({
    baseURL: 'http://127.0.0.1:8080',
    timeout: 5000
})

// 请求拦截器
request.interceptors.request.use((config) => {
    return config
},(error) => {
    return Promise.reject(error)
})

// 响应拦截器
request.interceptors.response.use((response) => {
    return response.data
}, (error) => {
    return Promise.reject(error)
})

export { request }

