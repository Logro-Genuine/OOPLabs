import React, { useState } from 'react';
import { registerAPICall } from '../AuthService'; // Убедитесь, что путь правильный

const RegisterComponent = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [confirmPassword, setConfirmPassword] = useState('');
    const [error, setError] = useState('');
    const [loading, setLoading] = useState(false);

    const handleRegistrationForm = (e) => {
        e.preventDefault();
        setLoading(true);
        setError('');

        if (password !== confirmPassword) {
            setError('Пароли не совпадают');
            setLoading(false);
            return;
        }

        const role = "USER"; // Установите роль, которую вы хотите отправить
        registerAPICall(username, password, role)
            .then((response) => {
                console.log(response.data);
                // Логика для перенаправления пользователя после успешной регистрации
            })
            .catch((error) => {
                console.error('Ошибка регистрации:', error.response ? error.response.data : error.message);
                setError(error.response ? error.response.data.message : 'Ошибка регистрации. Пожалуйста, попробуйте еще раз.');
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
                            <h2 className='text-center'>Register Form</h2>
                        </div>

                        <div className='card-body'>
                            <form onSubmit={handleRegistrationForm}>
                                <div className='row mb-3'>
                                    <label className='col-md-3 control-label'>Username</label>
                                    <div className='col-md-9'>
                                        <input
                                            type='text'
                                            name='username'
                                            className='form-control'
                                            placeholder='Enter username'
                                            value={username}
                                            onChange={(e) => setUsername(e.target.value)}
                                        />
                                    </div>
                                </div>

                                <div className='row mb-3'>
                                    <label className='col-md-3 control-label'>Password</label>
                                    <div className='col-md-9'>
                                        <input
                                            type='password'
                                            name='password'
                                            className='form-control'
                                            placeholder='Enter password'
                                            value={password}
                                            onChange={(e) => setPassword(e.target.value)}
                                        />
                                    </div>
                                </div>

                                <div className='row mb-3'>
                                    <label className='col-md-3 control-label'>Confirm Password</label>
                                    <div className='col-md-9'>
                                        <input
                                            type='password'
                                            name='confirmPassword'
                                            className='form-control'
                                            placeholder='Confirm password'
                                            value={confirmPassword}
                                            onChange={(e) => setConfirmPassword(e.target.value)}
                                        />
                                    </div>
                                </div>

                                {error && <div className='alert alert-danger'>{error}</div>}

                                <div className='form-group mb-3'>
                                    <button className='btn btn-primary' type='submit' disabled={loading}>
                                        {loading ? 'Loading...' : 'Register'}
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default RegisterComponent;
