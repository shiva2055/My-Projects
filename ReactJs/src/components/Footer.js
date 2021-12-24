import React from 'react'
import {BottomNavigation, BottomNavigationAction} from '@material-ui/core'
import FacebookIcon from '@material-ui/icons/Facebook';
import TwitterIcon from '@material-ui/icons/Twitter';
import InstagramIcon from '@material-ui/icons/Instagram';
import YouTubeIcon from '@material-ui/icons/YouTube';
import { makeStyles } from '@material-ui/styles';

const styles = makeStyles({
   wrapper: {
      display: 'flex'
   },
})
function Footer() {
      const classes = styles();
    return (
        <BottomNavigation  className= {classes.wrapper}>
          <BottomNavigationAction 
            onClick = { () =>{ 
                    window.open("https://facebook.com/");
                 }
                 }color="red" label="Facebook" value="recents" icon={<FacebookIcon  style={{fill: "#3b5998"}}/>} />
          <BottomNavigationAction  onClick = { () =>{ 
                    window.open("https://www.twitter.com/");
                 }
                 }label="Twitter" value="favorites" icon={<TwitterIcon  style={{fill: "#1DA1F2"}}/>} />
          <BottomNavigationAction  onClick = { () =>{ 
                    window.open("https://www.instagram.com/");
                 }
                 }label="Instagram" value="nearby" icon={<InstagramIcon  style={{fill: " #C13584"}}/>} />
          <BottomNavigationAction  onClick = { () =>{ 
                    window.open("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
                 }
                 }label="YouTube" value="folder" icon={<YouTubeIcon  style={{fill: "#c4302b"}}/>} />
        </BottomNavigation>
)
}

export default Footer