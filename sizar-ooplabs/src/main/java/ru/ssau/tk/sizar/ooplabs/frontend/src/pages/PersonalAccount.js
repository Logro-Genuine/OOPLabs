import React, { useState} from 'react';
import { Container, Row, Col, Card, Button, Modal } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import api from 'C:/Users/bogom/demo/demo/frontend/src/api';

const PersonalAccount = () => {

  return (
        <Container className="mt-5">
            {/* Hero Section */}
            <Row className="mb-5">
                <Col>
                    <div className="p-5 bg-light rounded-3">
                        <p className="lead">
                            Здесь вы можете создавать функции, просматривать их графики,
                            выполнять операции над ними и многое другое.
                        </p>
                    </div>
                </Col>
            </Row>

            {/* Cards Section */}
            <Row>
                <Col md={4}>
                    <Card className="mb-4 shadow-sm">
                        <Card.Body>
                            <Card.Title>Создание функций</Card.Title>
                            <Card.Text>
                                В этом разделе вы можете создать функцию и сохраните её в базе данных.
                                Затем вы сможете просмотреть её график.
                            </Card.Text>
                            <Button as={Link} to="/create-function" variant="success">
                                Создать функцию
                            </Button>
                        </Card.Body>
                    </Card>
                </Col>
                <Row>
                                <Col md={4}>
                                    <Card className="mb-4 shadow-sm">
                                        <Card.Body>
                                            <Card.Title>Просмотр функций</Card.Title>
                                            <Card.Text>
                                                Здесь вы можете просмотреть функции, созданные в этом приложении.
                                            </Card.Text>
                                            <Button as={Link} to="/functions" variant="success">
                                                К списку функций
                                            </Button>
                                        </Card.Body>
                                    </Card>
                                </Col>
                <Col md={4}>
                    <Card className="mb-4 shadow-sm">
                        <Card.Body>
                            <Card.Title>Список функций</Card.Title>
                            <Card.Text>
                                Просматривайте уже созданные функции
                                и открывайте для просмотра графиков.
                            </Card.Text>
                            <Button as={Link} to="/functions" variant="primary">
                                Посмотреть список
                            </Button>
                        </Card.Body>
                    </Card>
                </Col>
                <Col md={4}>
                    <Card className="mb-4 shadow-sm">
                        <Card.Body>
                            <Card.Title>Операции над функциями</Card.Title>
                            <Card.Text>
                                Выполняйте арифметические операции (сложение, вычитание, умножение, деление)
                                над двумя существующими функциями и сохраняйте результат.
                            </Card.Text>
                            <Button as={Link} to="/operate-functions" variant="warning">
                                Перейти к операциям
                            </Button>
                        </Card.Body>
                    </Card>
                </Col>
            </Row>
        </Container>
    );
};

export default PersonalAccount;