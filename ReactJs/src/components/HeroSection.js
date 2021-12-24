import React from 'react'
import { Button } from '@material-ui/core';
import './css/HeroSection.css'
import './css/App.css';
import Grid from './Grid';
import GetStartedBtn from './GetStartedBtn';

function HeroSection() {
    return (
        <div className='hero-container'>
            <video src='./grid.mp4' autoPlay loop muted />
            <h1>AARONTECH</h1>
            <p>Computer upgrades and repair. Right at your doorstep.</p>
            {/* <div className="hero-btns">
                <Button className='btns' buttonStyle='btn--outline' buttonSize='btn--large'>
                    Get Started
                </Button>
            </div> */}
            <br/><br/><br/><br/><br/><br/>
            <GetStartedBtn/>
        </div>
    )
}

export default HeroSection
