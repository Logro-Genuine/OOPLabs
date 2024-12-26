import React from 'react';
import { NavLink, Link } from 'react-router-dom';
import { Nav } from 'react-bootstrap'; // Импорт Nav из react-bootstrap
import { useNavigate } from 'react-router-dom';

const HeaderComponent = ({ isAuthenticated, handleLogout }) => {
  return (
    <div>
      <header>
        <nav className='navbar navbar-expand-md navbar-dark bg-dark'>
          <ul className='navbar-nav'>
            <Nav className="me-auto">
              {isAuthenticated ? (
                <>
                  <Nav.Link as={Link} to="/">Главная</Nav.Link>
                  <Nav.Link as={Link} to="/login">Войти</Nav.Link>
                  <Nav.Link as={Link} to="/register">Зарегистрироваться</Nav.Link>
                </>
              ) : (
                <>
                  <Nav.Link as={Link} to="/account">Аккаунт</Nav.Link>
                  <Nav.Link as={Link} to="/create-function">Создать функцию</Nav.Link>
                  <Nav.Link as={Link} to="/create-custom-function">Создать свою функцию</Nav.Link>
                  <Nav.Link as={Link} to="/functions">К списку функций</Nav.Link>
                  <Nav.Link onClick={handleLogout}>Выйти</Nav.Link>
                </>
              )}
            </Nav>
          </ul>
        </nav>
      </header>
    </div>
  );
};

export default HeaderComponent;
