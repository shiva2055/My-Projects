import React from 'react'
import {Button} from '@material-ui/core'
import {withStyles} from '@material-ui/core/styles'
import { useNavigate } from 'react-router';
const StyledButton = withStyles({
    root: {
        display: "flex",
        alignItems: "center",
        justifyContent: "center",
        width: "500px",
        height: "100px",
        fontSize: '40px',
        padding: "0 25px",
        boxSizing: "border-box",
        borderRadius: 0, 
        background: "#232e3a", //"#4f25f7",
        color: "#fff",
        transform: "none",
        transition: "background .3s,border-color .3s,color .3s",
        "&:hover": {
            backgroundColor:  "#4f25f7"
          },
    },
    label: {
      textTransform: 'capitalize',
    },
  })(Button);

function GetStartedBtn() {
  const history = useNavigate();
    return (
        <StyledButton onClick = { () =>{ 
          history("/ticket");
       }
  } variant="contained">Get Started Today</StyledButton>
    )
}

export default GetStartedBtn