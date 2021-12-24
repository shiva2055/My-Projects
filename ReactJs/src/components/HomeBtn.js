import React from 'react'
import {Button} from '@material-ui/core'
import {withStyles} from '@material-ui/core/styles'
import Aaron from '../aarontech.jpg'
import { Link } from 'react-router-dom';
import Home from './Home';
import {useNavigate} from 'react-router-dom';

const StyledButton = withStyles({
    root: { 
        display: "flex",
        alignItems: "center",
        justifyContent: "center",
        height: "44px",
        width: '200px',
        variant: 'h6',
       // padding: "0 25px",
        boxSizing: "border-box",
        fontFamily:'Roboto',
        cursor: "pointer", 
        flexGrow: 1,
        "&:hover": {
            color:  "#4f25c8"
        },
       //  ['@media (max-width:780px)']: { 
        // paddingBottom: "1rem"    },
        borderRadius: 0, 
        background: "#D68910", //"#4f25f7",
        color: "#fff",
        transform: "none",
        boxShadow: "6px 6px 0 0 #c7d8ed",
        transition: "background .3s,border-color .3s,color .3s",
        "&:hover": {
            backgroundColor:  "#4f25f7"
          },
    },
    label: {
      textTransform: 'capitalize',
    },
  })(Button);


function HomeBtn(props) {
   const history = useNavigate();
  
   const handleRoute = () =>{ 
    history("/home");
   }
 
   function clickHandler(){
    window.open = "https://google.com";
   }
    return (
        <StyledButton onClick = {handleRoute} variant="contained">{props.txt}</StyledButton>
    )
}

export default HomeBtn