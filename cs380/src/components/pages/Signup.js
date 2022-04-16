import { withStyles, makeStyles } from "@material-ui/core";
import { Button } from "@material-ui/core";
import { useNavigate } from "react-router";

function Signup() {
  const history = useNavigate();

  return (
    <div className="App">
      <h1>Sign Up</h1>
    </div>
  );
}

export default Signup;
