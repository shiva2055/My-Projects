import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import { Button } from './Button';
import './css/NavBar.css';
import { useNavigate } from 'react-router';

function Navbar() {
    const [click, setClick] = useState(false);
    const [button, setButton] = useState(true);
    const history = useNavigate();
    function handleSumbmit() {
       
        history("/signup");}
   // const handleMenuClick = () => setClick(!click);
    const closeMobileMenu = () => setClick(false);


    //If windows size is less than or equal to 960px, 
    const showButton = () => {
        if (window.innerWidth <= 960) {
            setButton(false)
        } else {
            setButton(true)
        }
    };

    {/*keeps login button hidden on refresh*/ }
    useEffect(() => {
        showButton()
    }, []);

    window.addEventListener('resize', showButton);


    return (
        <>
            <nav className="navbar">
                <div className="navbar-container">

                    <Link to='/'
                        className='navbar-logo'
                        onClick={closeMobileMenu}>
                        AaronTech
                    </Link>

                    <ul className={click ? 'nav-menu active' : 'nav-menu'}>
                        <li className='nav-item'>
                            <Link to='/'
                                className='nav-links'
                                onClick={closeMobileMenu}>
                                Home
                            </Link>
                        </li>

                        <li className='nav-item'>
                            <Link to='/about'
                                className='nav-links'
                                onClick={closeMobileMenu}>
                                About Us
                            </Link>
                        </li>

                        <li className='nav-item'>
                            <Link to='/contact'
                                className='nav-links'
                                onClick={closeMobileMenu}>
                                Contact
                            </Link>
                        </li>

                        <li>
                            <Link
                                to='/signup'
                                className='nav-links-mobile'
                                onClick={closeMobileMenu}>
                                Sign Up
                            </Link>
                        </li>
                    </ul>

                    {button && <Button buttonStyle='btn--outline'>SIGN UP</Button>}

                    <div className='menu-icon' onClick={ handleSumbmit}>
                        <i className={click ? 'fas fa-times' : 'fas fa-bars'} />
                    </div>

                </div>
            </nav>
        </>
    )
}

export default Navbar
