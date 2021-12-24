import React from 'react'

function CardItems(props) {
    return (
        <>
            <li className="cards__item">
                <div className='cards__item__link'>
                    <div className="cards__item__pic-wrap">
                        <img src={props.src} alt="" className="cards__item__img" />
                    </div>
                    <div className="cards__item__info">
                        <h6 className="cards__item__title">
                            {props.title}
                        </h6>
                        <p className="cards__item__text">
                            {props.text}
                        </p>
                    </div>
                </div>
            </li>
        </>
    )
}

export default CardItems
