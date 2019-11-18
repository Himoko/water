/**
 * 封装axios方法
 * @autor 周学新
 * @date 2018.1.22
 */
import axios from 'axios'
axios.defaults.withCredentials=true;
import { Message } from 'iview'
axios.interceptors.request.use(
    config => {
        // 发送请求之前做一些处理
        config.headers = {
          'Content-Type': 'application/json',
        };
        config.headers.Accept = 'application/json';    //设置请求头Accept
        config.timeout = 50000;
        return config
    },
    error => {
        // 当请求异常时做一些处理
        console.log('请求出错')
        return Promise.reject(error)
    }
)

// 响应时拦截
axios.interceptors.response.use(
    function(response) {
        // 返回响应时做一些处理
        return response
    },
    function(error) {
        // 当响应异常时做一些处理
        return Promise.reject(error)
    }
)

export default function({ api, method = 'get', para = {} }) {
    return new Promise((resolve, reject) => {
        axios({
                method: method,
                url: api,
                data: para,
            })
            .then(res => {
                if (res.status === 200) {
                    resolve(res.data)
                }
            })
            .catch(err => {
                reject(err)
            })
    })
}
