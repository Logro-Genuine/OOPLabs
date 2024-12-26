import React, { useState } from 'react';
import { loginAPICall } from '../AuthService'; // Убедитесь, что путь правильный
import 'bootstrap/dist/css/bootstrap.min.css'; // Импортируйте CSS Bootstrap

const LoginComponent = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState('');

    const handleLoginForm = (e) => {
        e.preventDefault();
        setLoading(true);
        setError('');
    loginAPICall(username, password)
            .then((response) => {
                console.log(response.data);
                localStorage.setItem('token', response.data);
                window.location.href = 'http://localhost:3000/account';
            })
            .catch((error) => {
                console.error('Ошибка входа:', error);
                setError('Ошибка входа. Пожалуйста, проверьте свои учетные данные.');
            })
            .finally(() => {
                setLoading(false);
            });
    };

    return (
        <div className='container'>
            <br /> <br />
            <div className='row'>
                <div className='col-md-6 offset-md-3'>
                    <div className='card'>
                        <div className='card-header'>
                            <h2 className='text-center'>Форма Входа</h2>
                        </div>

                        <div className='card-body'>
                            <form onSubmit={handleLoginForm}>
                                <div className='row mb-3'>
                                    <label className='col-md-3 control-label'>Имя пользователя</label>
                                    <div className='col-md-9'>
                                        <input
                                            type='text'
                                            name='username'
                                            className='form-control'
                                            placeholder='Введите имя пользователя'
                                            value={username}
                                            onChange={(e) => setUsername(e.target.value)}
                                        />
                                    </div>
                                </div>

                                <div className='row mb-3'>
                                    <label className='col-md-3 control-label'>Пароль</label>
                                    <div className='col-md-9'>
                                        <input
                                            type='password'
                                            name='password'
                                            className='form-control'
                                            placeholder='Введите пароль'
                                            value={password}
                                            onChange={(e) => setPassword(e.target.value)}
                                        />
                                    </div>
                                </div>

                                {error && <div className='alert alert-danger'>{error}</div>}

                                <div className='form-group mb-3'>
                                    <button className='btn btn-primary' type='submit' disabled={loading}>
                                        {loading ? 'Загрузка...' : 'Отправить'}
                                    </button>
                                </div>
                            </form>
                        </div>
                        <div class="text-center text-lg-start mt-2 pt-2">
                             <p class="small fw-bold mt-1 pt-1 mb-0">Нет аккаунта? <a href="/register"
                             class="link-primary">Зарегистрироваться</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default LoginComponent;
