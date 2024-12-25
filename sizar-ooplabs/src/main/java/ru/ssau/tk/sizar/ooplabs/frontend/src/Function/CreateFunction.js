import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { Button } from 'react-bootstrap';
import FunctionForm from './FunctionForm';
import FunctionTable from './FunctionTable';
import api from '../api';
import CustomModal from '../Common/CustomModal';

const CreateFunction = () => {
    const [numPoints, setNumPoints] = useState(0);
    const [points, setPoints] = useState([]);
    const [functionName, setFunctionName] = useState('');
    const [showTable, setShowTable] = useState(false);
    const [error, setError] = useState(null);

    const [showErrorModal, setShowErrorModal] = useState(false);
    const [successMessage, setSuccessMessage] = useState('');
    const [showSuccessModal, setShowSuccessModal] = useState(false);

    const handleSetFunctionData = ({ functionName, number }) => {
        setFunctionName(functionName);
        setNumPoints(number);
        setPoints(Array.from({ length: number }, () => ({ x: '', y: '' })));
        setShowTable(true);
    };

    const handleChange = (index, field, value) => {
        const updatedPoints = [...points];
        updatedPoints[index][field] = value;
        setPoints(updatedPoints);
    };

    const handleSubmit = async () => {
        try {
            const xValues = points.map(p => parseFloat(p.x));
            const yValues = points.map(p => parseFloat(p.y));

            const xSet = new Set(xValues);
            if (xSet.size < xValues.length) {
                throw new Error("В списке есть дублирующиеся X! Убедитесь, что все X уникальны.");
            }
            if (!functionName.trim()) {
                throw new Error("Название функции не может быть пустым.");
            }
            if (numPoints <= 0) {
                throw new Error("Количество точек должно быть > 0.");
            }
            if (xValues.some(isNaN) || yValues.some(isNaN)) {
                throw new Error("Все значения x и y должны быть числами.");
            }

            const x_from = Math.min(...xValues);
            const x_to = Math.max(...xValues);

            if (x_to <= x_from) {
                throw new Error("Диапазон X некорректен (x_to не может быть меньше или равен x_from).");
            }

            const mathFunctionData = {
                funcName: functionName,
                pointsCount: numPoints,
                xfrom: parseFloat(x_from),
                xto: parseFloat(x_to),
            };

            const response = await api.post('/functions', mathFunctionData);
            const functionId = response.data.id;

            for (let i = 0; i < points.length; i++) {
                const pointData = {
                    xvalue: parseFloat(points[i].x),
                    yvalue: parseFloat(points[i].y),
                    func: functionId
                };
                await api.post('/points', pointData);
            }

            setSuccessMessage('Табулированная функция успешно создана!');
            setShowSuccessModal(true);

            setShowTable(false);
            setNumPoints(0);
            setPoints([]);
            setFunctionName('');
        } catch (err) {
            setError(err.response?.data || err.message);
            setShowErrorModal(true);
        }
    };
    const navigate = useNavigate();
    const handleSuccessModalClose = () => {
            setShowSuccessModal(false);
            navigate('/account'); // Переход на страницу /account
        };
    return (
        <>
            <FunctionForm onSubmit={handleSetFunctionData} />
            {showTable && (
                <>
                    <FunctionTable points={points} onChange={handleChange} />
                    <Button variant="primary" onClick={handleSubmit} className="mt-3">
                        Создать
                    </Button>
                </>
            )}

            <CustomModal
                show={showErrorModal}
                onHide={() => setShowErrorModal(false)}
                title="Ошибка"
                body={error}
                confirmText="Закрыть"
                variant="danger"
            />

            <CustomModal
                show={showSuccessModal}
                onHide={() => setShowSuccessModal(false)}
                title="Успех"
                body={successMessage}
                confirmText="ОК"
                confirmAction={() => setShowSuccessModal(false)} // Закрытие модального окна
                secondButtonText="Перейти в аккаунт" // Вторая кнопка
                secondButtonAction={() => navigate('/account')} // Переход на страницу /account
                variant="success"
            />
        </>
    );
};

export default CreateFunction;