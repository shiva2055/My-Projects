import React from 'react'
import './css/Cards.css';
import CardItems from './CardItems'
import malware from '../photos/malware.jpg'
import backup from '../photos/backup.jpg'
import hardware from '../photos/hardware.jpg'

function Cards() {
    return (
        <div className='cards'>
            <h1>Services we offer</h1>
            <div className="cards__container">
                <div className="cards__wrapper">
                    <ul className="cards__items">
                        <CardItems
                            src={malware}
                            title='Malware Removal and Tune-Ups'
                            text="Malware concerns? Slow performance? Leave it to us! We offer tune-ups and malware removal with industry-standard tools to get your computer running like new again." />
                        <CardItems
                            src={backup}
                            title='Backups and Recovery'
                            text="Your data is important to you. We offer backup and recovery solutions for your home and small business to ensure it stays in one piece." />
                        <CardItems
                            src={hardware}
                            title='Harware installations'
                            text="If you need new hardware, or are planning on upgrading existing hardware, you've come to the right place. Whether it's a new printer, a part, or a custom PC, AaronTech is at your service." />
                    </ul>
                </div>
            </div>
        </div>
    )
}

export default Cards
