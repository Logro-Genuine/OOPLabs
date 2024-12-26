import React, { useEffect, useState } from 'react';
import api from '../api';
import { Link } from 'react-router-dom'; // Импортируем Link из react-router-dom
import { Card } from 'react-bootstrap';

const FunctionList = () => {
    const [functions, setFunctions] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchFunctions = async () => {
            try {
                const response = await api.get('/functions?name=');
                setFunctions(response.data);
            } catch (err) {
                setError('Ошибка при загрузке функций');
            } finally {
                setLoading(false);
            }
        };

        fetchFunctions();
    }, []);

    if (loading) {
        return <div>Загрузка...</div>;
    }

    if (error) {
        return <div>Ошибка: {error}</div>;
    }

    return (
        <div className="container mt-5">
            <h2>Список функций</h2>
            <table className="table table-bordered">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Название функции</th>
                        <th>Количество точек</th>
                        <th>X от</th>
                        <th>X до</th>
                    </tr>
                </thead>
                <tbody>
                    {functions.map((func) => (
                        <tr key={func.id}>
                            <td>{func.id}</td>
                            <td>
                                <Link to={`/view-function/${func.id}`}>{func.funcName}</Link> {/* Ссылка на функцию */}
                            </td>
                            <td>{func.pointsCount}</td>
                            <td>{func.xfrom}</td>
                            <td>{func.xto}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default FunctionList;
