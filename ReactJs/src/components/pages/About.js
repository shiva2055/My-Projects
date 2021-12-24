import React from 'react'
import '../css/Cards.css';
import CardItems from '../CardItems'
import shiva from '../../photos/shiva.jpg'
import jacob from '../../photos/jacob.jpg'
import matt from '../../photos/matt.jpg'

function Cards() {
  return (
    <div className='cards'>
      <h1>Our Team</h1>
      <div className="cards__container">
        <div className="cards__wrapper">
          <ul className="cards__items">
            <CardItems
              src={shiva}
              title="Web Dev"
              text="Born in Nepal. Stack Overflow consultant." />
            <CardItems
              src={jacob}
              title="Web Dev"
              text="certified hackerman" />
            <CardItems
              src={matt}
              title="Web Dev"
              text="Works on websites until 4AM. Likes gardening." />
          </ul>
        </div>
      </div>
    </div>
  )
}

export default Cards
