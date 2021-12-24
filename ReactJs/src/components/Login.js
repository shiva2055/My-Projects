import NavBar from "./NavBar";
import { withStyles, makeStyles } from "@material-ui/core";
import Grid from './Grid'
import Footer from "./Footer";
import {Button} from '@material-ui/core'
import login_icon from '../photos/icon.png'
import signup from "./Signup";
import { useNavigate } from "react-router";

const StyledButton = withStyles({
    root: { 
        display: 'block',
        marginLeft: 'auto',
        marginRight: 'auto',
        alignItems: "center",
        justifyContent: "center",
        padding: '20px',
        fontSize: '20px',
        borderRadius:'20px',
        width: '250px',
        variant: 'h6',
      
        boxSizing: "border-box",
        fontFamily:'Roboto',
        cursor: "pointer", 
        flexGrow: 1,
        "&:hover": {
            color:  "#4f25c8"
        },
       //  ['@media (max-width:780px)']: { 
        // paddingBottom: "1rem"    }, 
        background: "#232e3a", //"#4f25f7",
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

const style = makeStyles({
    image:{
        display: 'block',
        marginLeft: 'auto',
        marginRight: 'auto',
        width: "10%",
        paddingTop: '1rem'
    },
    wrapper: {
        width: "65%",
        margin: "auto",
        textAlign: "center"
      },
      textfield:{
        display: 'block',
        marginLeft: 'auto',
        marginRight: 'auto',
        width:'300px',
        padding:'20px',
        borderRadius:'20px',
        boxShadow:"0 0 15px 4px rgba(0,0,0,0.06)"
       
    }

})

function Login() {
    const classes = style();
    const history = useNavigate();
    function handleSumbmit() {
        const NAME = document.getElementById('name').value;
       // alert(name);
        sessionStorage.setItem("NAME",NAME);
       // console.log(sessionStorage.getItem("NAME"));
        history("/account");
        
      }
    return ( 

        <div className="App">
            <NavBar/>
            <br/> <br/>
           <h1 className = {classes.wrapper}> Login</h1>
           <img className = {classes.image} src = {login_icon} alt = "Login Image" ></img>
           <br/>
            <input className = {classes.textfield} type="text" id="name" placeholder = 'User Name'></input>
            <br/>
            <input className = {classes.textfield} type="password" id="pass" placeholder = 'Password'></input>
            <br/>
            <StyledButton onClick = { handleSumbmit }

            > Submit </StyledButton> 
           <br/><br/>
           <h3 className = {classes.wrapper}> OR </h3>
           <br/>
            <StyledButton onClick = { () =>{ 
                    history("/signup");
                 }
            } > Create An Account </StyledButton> 
            <br/><br/>
            <Footer/>
        </div>
     );
}
 
export default Login;