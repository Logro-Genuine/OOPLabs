import './App.css';
import React, { useState, useEffect } from 'react';
import {BrowserRouter, Routes, Route } from 'react-router-dom';
import HeaderComponent from './components/HeaderComponent';
import RegisterComponent from './components/RegisterComponent';
import LoginComponent from './components/LoginComponent';
import Home from './pages/HomePage';
import PersonalAccount from './pages/PersonalAccount';
import CreateCustomFunction from './Function/CreateCustomFunction'
import CreateFunction from './Function/CreateFunction'
import FunctionForm from './Function/FunctionForm'
import FunctionTable from './Function/FunctionTable'
import ViewFunction from './Function/ViewFunction'
import FunctionList from './Function/FunctionList';


function App() {
    const [isAuthenticated, setIsAuthenticated] = useState(false);

        useEffect(() => {
            const token = localStorage.getItem('token');
            if (token) {
                setIsAuthenticated(true);
            }
        }, []);

        const handleLogin = (token) => {
            setIsAuthenticated(true);
        };

        const handleLogout = () => {
            localStorage.removeItem('token');
            setIsAuthenticated(false);
        };
  return (
    <div>
      <BrowserRouter>
        <HeaderComponent />
        <div className= "container">
          <Routes>
              <Route path = "/" element = { <Home/> }></Route>
              <Route path = "/account" element = {isAuthenticated ? <PersonalAccount/> : <LoginComponent onLogin={handleLogin} />
              } />
              <Route path='/login' element = { <LoginComponent onLogin={handleLogin} /> }></Route>
              <Route path = "/register" element = { <RegisterComponent /> }></Route>
              <Route path="/create-function" element={
                  isAuthenticated ? <CreateFunction /> : <LoginComponent onLogin={handleLogin} />
              } />
              <Route path="/view-function/:id" element={
                  isAuthenticated ? <ViewFunction /> : <LoginComponent onLogin={handleLogin} />
              } />
              <Route path="/create-custom-function" element={
                  isAuthenticated ? <CreateCustomFunction /> : <LoginComponent onLogin={handleLogin} />
              } />
              <Route path="/functions" element={
                                isAuthenticated ? <FunctionList /> : <LoginComponent onLogin={handleLogin} />
                            } />
            </Routes>
        </div>
        </BrowserRouter>
    </div>
  );
}
export default App;