import { Link } from "react-router-dom"
import { withStyles, makeStyles } from "@material-ui/core";

const styles = makeStyles({
    emails:{
        fontFamily:'Roboto',
        fontSize: '20px',
        margin: "auto",
        float: 'right'
    }

})
function Top() {
    const classes = styles();
    return (  
        <div>
            <a className= {classes.emails} href="mailto:shivashrestha2015@gmail.com">Email me</a> 
            <a href="tel:+1123-456-7890">123-456-7890</a>
        </div>
        
    );
}

export default Top;