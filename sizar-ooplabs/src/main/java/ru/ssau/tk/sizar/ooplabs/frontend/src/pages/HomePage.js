import React from 'react';
import { Container, Row, Col, Card, Button } from 'react-bootstrap';
import { Link } from 'react-router-dom';

const Home = () => {
    return (
        <Container className="mt-5">
            {/* Hero Section */}
            <Row className="mb-5">
                <Col>
                    <div className="p-5 bg-light rounded-3">
                        <h1 className="display-4">Это приложение для работы с функциями.
                        Здесь вы можете создавать функции и просматривать их графики.</h1>
                        <hr className="my-4" />
                        <p>Чтобы начать пользоваться — войдите в аккаунт</p>
                        <Button as={Link} to="/login" variant="primary" size="lg">
                            Войти
                        </Button>
                    </div>
                </Col>
            </Row>
        </Container>
    );
};

export default Home;