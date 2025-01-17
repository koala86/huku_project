import { createSlice } from '@reduxjs/toolkit'
import { request } from '../../utils'

const userStore = createSlice({
    name: 'user',
    initialState: {
        token: ''
    },
    reducers: {
        setToken(state, action) {
            state.token = action.payload
        }
    }
})

// 解构出actionCreater函数
const { setToken } = userStore.actions

// 获取reducer函数
const userReducer = userStore.reducer

// 异步方法 完成登录获取token
const fetchLogin = (loginForm) => {
    return async (dispatch) => {
        // 1.发送异步请求
        const res = await request.post('/test', loginForm)
        // 2.提交同步action进行token的存入
        // dispatch(setToken(res.data.token))
    }
}

export { fetchLogin, setToken }

export default userReducer