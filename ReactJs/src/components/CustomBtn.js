import React from 'react'
import { Button } from '@material-ui/core'
import { withStyles } from '@material-ui/core/styles'
import { Link } from 'react-router-dom';
import Ticket from './pages/Ticket'
import { useNavigate } from 'react-router-dom';

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
    fontFamily: 'Roboto',
    cursor: "pointer",
    flexGrow: 1,
    "&:hover": {
      color: "#4f25c8"
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
      backgroundColor: "#4f25f7"
    },
  },
  label: {
    textTransform: 'capitalize',
  },
})(Button);


function CustomBtn(props) {
  const history = useNavigate();
  // const handleRoute;
  // const handleRoute = () =>{ 
  //   history("/ticket");
  // }

  function clickHandler() {

  }
  return (
    <StyledButton variant="contained">{props.txt}</StyledButton>
  )
}

export default CustomBtn