import React from 'react';
import TicketTable from '../TicketTable';
import { Button } from "@material-ui/core";
import { Link, useNavigate } from 'react-router-dom';
import { withStyles } from '@material-ui/core/styles';


const StyledButton = withStyles({
  root: {
    display: 'block',
    margin: "auto",
    alignItems: "center",
    textAlign: "auto",
    justifyContent: "center",
    borderRadius: '20px',
    width: 'auto',
    variant: 'h6',
    fontSize: '40px',
    boxSizing: "border-box",
    fontFamily: 'Roboto',
    "&:hover": {
      background: "#fff",
      color: "#242424",
      border: "2px solid #232e3a"
    },
    background: "#232e3a",
    color: "#fff",
    transform: "none",
    transition: "background .3s,border-color .3s,color .3s",
  },
  label: {
    textTransform: 'capitalize',
  },
})(Button);


var ex = sessionStorage.getItem('NAME');
function Account() {
  return (
    <div className="App">
      <TicketTable />
    </div>
  );
}

export default Account;