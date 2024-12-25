 import './App.css';
import {BrowserRouter, Routes, Route } from 'react-router-dom';
import HeaderComponent from './components/HeaderComponent';
import RegisterComponent from './components/RegisterComponent';
import LoginComponent from './components/LoginComponent';
import Home from './pages/home';
import PersonalAccount from './pages/PersonalAccount';

function App() {
  return (
    <div>
      <BrowserRouter>
        <HeaderComponent />
        <div className= "container">
          <Routes>
              <Route path = "/" element = { <Home/> }></Route>
              <Route path = "/account" element = { <PersonalAccount/> }></Route>
              <Route path='/login' element = { <LoginComponent /> }></Route>
              <Route path = "/register" element = { <RegisterComponent /> }></Route>
            </Routes>
        </div>
        </BrowserRouter>
    </div>
  );
}
export default App;
