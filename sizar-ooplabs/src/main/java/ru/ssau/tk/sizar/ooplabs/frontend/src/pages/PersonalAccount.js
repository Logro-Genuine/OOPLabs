 import React from 'react';
import { Container, Row, Col, Card, Button } from 'react-bootstrap';
import { Link } from 'react-router-dom';

const PersonalAccount = () => {
    return (
        <Container className="mt-5">
            {/* Hero Section */}
            <Row className="mb-5">
                <Col>
                    <div className="p-5 bg-light rounded-3">
                        <h1 className="display-4">Добро пожаловать!</h1>
                        <p className="lead">
                            Теперь вы можете воспользоваться всеми функциями нашего приложения.
                            Здесь вы можете создавать функции и просматривать их графики.
                        </p>
                        <hr className="my-4" />
                        <p>Воспользуйтесь возможностями приложения уже сейчас!</p>
                        <Button as={Link} to="/functions" variant="primary" size="lg">
                            Перейти к списку функций
                        </Button>
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
                                Введите данные точек вашей функции и сохраните её в базе данных.
                                Затем вы сможете просмотреть её график.
                            </Card.Text>
                            <Button as={Link} to="/create-function" variant="success">
                                Создать функцию
                            </Button>
                        </Card.Body>
                    </Card>
                </Col>
                <Col md={4}>
                    <Card className="mb-4 shadow-sm">
                        <Card.Body>
                            <Card.Title>Список функций</Card.Title>
                            <Card.Text>
                                Просматривайте уже созданные функции, удаляйте ненужные
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
                            <Card.Title>Удалить аккаунт</Card.Title>
                            <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">
                              Удалить
                            </button>
                        </Card.Body>
                    </Card>
                </Col>
            </Row>
        </Container>
    );
};

export default PersonalAccount;
