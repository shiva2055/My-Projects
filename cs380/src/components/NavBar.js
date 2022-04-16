import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import { Button } from "./Button";
import "./css/NavBar.css";
import { useNavigate } from "react-router";

function Navbar() {
  const [click, setClick] = useState(false);
  const closeMobileMenu = () => setClick(false);

  return (
    <>
      <nav className="navbar">
        <div className="navbar-container">
          <Link to="/" className="navbar-logo" onClick={closeMobileMenu}>
            ReserveIt
          </Link>

          <ul className={click ? "nav-menu active" : "nav-menu"}>
            <li className="nav-item">
              <Link to="/" className="nav-links" onClick={closeMobileMenu}>
                Home
              </Link>
            </li>

            <li className="nav-item">
              <Link to="/about" className="nav-links" onClick={closeMobileMenu}>
                About Us
              </Link>
            </li>

            <li className="nav-item">
              <Link
                to="/contact"
                className="nav-links"
                onClick={closeMobileMenu}
              >
                Contact
              </Link>
            </li>
            <li className="nav-item">
              <Link
                to="/account"
                className="nav-links"
                onClick={closeMobileMenu}
              >
                Account
              </Link>
            </li>
          </ul>

          <Button buttonStyle="btn--outline">SIGN UP</Button>

          {/* <div className="menu-icon" onClick={handleSumbmit}>
            <i className={click ? "fas fa-times" : "fas fa-bars"} />
          </div> */}
        </div>
      </nav>
    </>
  );
}

export default Navbar;
