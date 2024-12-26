import React from 'react'
import { NavLink } from 'react-router-dom'
import { useNavigate } from 'react-router-dom'


const HeaderComponent = () => {

  return (
    <div>
        <header>
            <nav className='navbar navbar-expand-md navbar-dark bg-dark'>
                <ul className='navbar-nav'>
                    <Nav className="me-auto">
                        {isAuthenticated ? (
                                <Nav.Link as={Link} to="/">Главная</Nav.Link>
                                ) : (
                            <>
                                <Nav.Link as={Link} to="/account">Аккаунт</Nav.Link>
                                <Nav.Link as={Link} to="/create-function">Создать функцию</Nav.Link>
                                <Nav.Link as={Link} to="/create-custom-function">Создать свою функцию</Nav.Link>
                                <Nav.Link as={Link} to="/functions-paged">К списку функций</Nav.Link>
                            </>
                        )}
                    </Nav>
                    <Nav>
                        {isAuthenticated ? (
                            <Nav.Link onClick={handleLogout}>Выйти</Nav.Link>
                        ) : (
                            <>
                                <Nav.Link as={Link} to="/login">Войти</Nav.Link>
                                <Nav.Link as={Link} to="/register">Зарегистрироваться</Nav.Link>
                            </>
                        )}
                    </Nav>
                </ul>
            </nav>
        </header>

    </div>
  )
}

export default HeaderComponent