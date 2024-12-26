import React, { useEffect, useState } from 'react';
import api from '../api';
import { Line } from 'react-chartjs-2';
import { Card, Button, Modal, Form } from 'react-bootstrap';
import {
  Chart as ChartJS,
  CategoryScale,
  LinearScale,
  PointElement,
  LineElement,
  Title, Tooltip, Legend
} from 'chart.js';
import { useParams, useNavigate } from 'react-router-dom';

ChartJS.register(CategoryScale, LinearScale, PointElement, LineElement, Title, Tooltip, Legend);

const ViewFunction = () => {
    const { id } = useParams();
    const navigate = useNavigate(); // Используем useNavigate вместо useHistory
    const [functionData, setFunctionData] = useState(null);
    const [points, setPoints] = useState([]);
    const [showModal, setShowModal] = useState(false);
    const [newFuncName, setNewFuncName] = useState('');

    useEffect(() => {
        const fetchFunction = async () => {
            const response = await api.get(`/functions/${id}`);
            setFunctionData(response.data);
        };

        const fetchPoints = async () => {
            const resp = await api.get(`/points/function/${id}`);
            const sortedPoints = resp.data.sort((a, b) => a.xvalue - b.xvalue);
            setPoints(sortedPoints);
        };

        fetchFunction();
        fetchPoints();
    }, [id]);

    const handleDelete = async () => {
        await api.delete(`/functions/${id}`);
        navigate('/functions'); // Перенаправляем после удаления
    };

    const handleUpdate = async () => {
        await api.put(`/functions/${id}`, { funcName: newFuncName });
        setShowModal(false);
        // Опционально, можно заново получить данные функции
        const response = await api.get(`/functions/${id}`);
        setFunctionData(response.data);
    };

    const data = {
        labels: points.map(p => p.xvalue),
        datasets: [
            {
                label: functionData ? functionData.funcName : '',
                data: points.map(p => p.yvalue),
                fill: false,
                borderColor: 'rgba(75,192,192,1)'
            }
        ]
    };

    return (
        <Card className="mt-3">
            <Card.Body>
                <h2>{functionData?.funcName}</h2>
                <Line
                    data={data}
                    options={{
                        scales: {
                            x: {
                                beginAtZero: true,
                                grid: {
                                    color: 'rgba(0, 0, 0, 0.1)',
                                },
                                title: {
                                    display: true,
                                    text: 'X Axis'
                                }
                            },
                            y: {
                                beginAtZero: true,
                                grid: {
                                    color: 'rgba(0, 0, 0, 0.1)',
                                },
                                title: {
                                    display: true,
                                    text: 'Y Axis'
                                }
                            }
                        },
                        plugins: {
                            legend: {
                                display: true,
                            },
                            tooltip: {
                                enabled: true,
                            }
                        }
                    }}
                />
                <div className="mt-3">
                    <Button variant="primary" onClick={() => setShowModal(true)}>Edit Function</Button>
                    <Button variant="danger" onClick={handleDelete} className="ml-2">Delete Function</Button>
                </div>
            </Card.Body>

            {/* Modal for editing function */}
            <Modal show={showModal} onHide={() => setShowModal(false)}>
                <Modal.Header closeButton>
                    <Modal.Title>Edit Function</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <Form>
                        <Form.Group controlId="formFuncName">
                            <Form.Label>Function Name</Form.Label>
                            <Form.Control
                                type="text"
                                placeholder="Enter new function name"
                                value={newFuncName}
                                onChange={(e) => setNewFuncName(e.target.value)}
                            />
                        </Form.Group>
                    </Form>
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={() => setShowModal(false)}>
                        Close
                    </Button>
                    <Button variant="primary" onClick={handleUpdate}>
                        Save Changes
                    </Button>
                </Modal.Footer>
            </Modal>
        </Card>
    );
};

export default ViewFunction; // Экспорт компонента
