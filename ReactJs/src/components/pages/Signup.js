import { withStyles, makeStyles } from "@material-ui/core";
import { Button } from '@material-ui/core'
import { useNavigate } from "react-router";
import account from '../../photos/account.png';

const StyledButton = withStyles({
  root: {
    display: 'block',
    marginLeft: 'auto',
    marginRight: 'auto',
    alignItems: "center",
    justifyContent: "center",
    padding: '20px',
    borderRadius: '20px',
    width: '250px',
    variant: 'h6',
    fontSize: '20px',
    boxSizing: "border-box",
    fontFamily: 'Roboto',
    cursor: "pointer",
    flexGrow: 1,
    "&:hover": {
      color: "#4f25c8"
    },
    background: "#232e3a",
    color: "#fff",
    transform: "none",
    boxShadow: "6px 6px 0 0 #c7d8ed",
    transition: "background .3s,border-color .3s,color .3s",
  },
  label: {
    textTransform: 'capitalize',
  },
})(Button);

const style = makeStyles({
  image: {
    display: 'block',
    marginLeft: 'auto',
    marginRight: 'auto',
    width: "8%",
    paddingTop: '1rem',
    //  border: "10px solid #000",
    // borderRadius: '50%',
    // backgroundSize: 'cover'
  },
  wrapper: {
    width: "65%",
    margin: "auto",
    textAlign: "center"
  },
  textfield: {
    display: 'block',
    marginLeft: 'auto',
    marginRight: 'auto',
    width: '300px',
    padding: '20px',
    borderRadius: '20px',
    boxShadow: "0 0 15px 4px rgba(0,0,0,0.06)"

  }

})
function Signup() {
  const classes = style();
  const history = useNavigate();

  return (

    <div className="App">
      <h1 className={classes.wrapper}>Create An Account </h1>
      <img className={classes.image} src={account} alt='lado' />
      <br />
      <input className={classes.textfield} type="text" id="myText" placeholder='User Name'></input>
      <br />
      <input className={classes.textfield} type="text" id="myText" placeholder='Email'></input>
      <br />
      <input className={classes.textfield} type="password" id="pass" placeholder='Password'></input>
      <br />
      <input className={classes.textfield} type="password" id="pass" placeholder='Confirm Password'></input>
      <br />
      <StyledButton onClick={() => {
        history("/ticket");
      }
      } >Submit </StyledButton>
      <br />
    </div>

  );
}

export default Signup;