import React from 'react'
import { NavLink } from 'react-router-dom'
import { useNavigate } from 'react-router-dom'


const HeaderComponent = () => {

  return (
    <div>
        <header>
            <nav className='navbar navbar-expand-md navbar-dark bg-dark'>
                <ul className='navbar-nav'>
                        <li className='nav-item'>
                        <NavLink to="/testF" className="nav-link">Тест</NavLink>
                     </li>
                        <li className='nav-item'>
                        <NavLink to="/test2" className="nav-link">Тест2</NavLink>
                     </li>
                        <li className='nav-item'>
                        <NavLink to="/" className="nav-link">Главная</NavLink>
                     </li>
                        <li className='nav-item'>
                        <NavLink to="/register" className="nav-link">Регистрация</NavLink>
                    </li>
                        <li className='nav-item'>
                        <NavLink to="/login" className="nav-link">Войти</NavLink>
                    </li>
                </ul>
            </nav>
        </header>

    </div>
  )
}

export default HeaderComponent