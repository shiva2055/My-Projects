import React from 'react';
import Navbar from './components/NavBar';
import './components/css/App.css';
import Footer from './components/Footer';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Home from './components/pages/Home'
import Login from './components/pages/Login';
import Contact from './components/pages/Contact';
import Signup from './components/pages/Signup';
import Account from './components/pages/Account';
import About from './components/pages/About'
import Ticket from './components/pages/Ticket'
//import Signup from './components/Signup';

function App() {
  return (
    <>
      <Router>
        <Navbar />
        <Routes>
          <Route path='/' element={<Home />} />
          <Route path='/about' element={<About />} />
          <Route path='/ticket' element={<Ticket />} />
          <Route path='/login' element={<Login />} />
          <Route path='/contact' element={<Contact />} />
          <Route path='/signup' element={<Signup />} />
          <Route path='/account' element={<Account />} />
        </Routes>
      </Router>
      <Footer />
    </>
  );
}

export default App;