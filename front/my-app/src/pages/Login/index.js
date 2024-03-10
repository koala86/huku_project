import React from 'react';
import { Card, Form, Input, Button } from 'antd';
import './index.css';
import { useDispatch } from 'react-redux';
import { fetchLogin } from '../../store/modules/user';

const Login = () => {
    const dispatch = useDispatch();
    const onFinish = (values) => {
        console.log(values)
        // 触发异步action fetchLogin
        dispatch(fetchLogin(values))
    }
    return (
        <div className='login'>
            <Card className='login-container'>
                <Form onFinish={onFinish}>
                    <Form.Item name='username'>
                        <Input size='large' placeholder='IDを入力してください' />
                    </Form.Item>
                    <Form.Item name='password'>
                        <Input size='large' placeholder='パスワードを入力してください' />
                    </Form.Item>
                    <Form.Item>
                        <Button type='primary' htmlType='submit' size='large' block>
                            ログイン
                        </Button>
                    </Form.Item>
                </Form>
            </Card>
        </div>
    )
}

export default Login;