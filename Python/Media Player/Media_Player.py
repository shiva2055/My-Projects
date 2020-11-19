# -*- coding: utf-8 -*-
"""
Created on Mon Nov  2 09:54:03 2020
@author: shiva shrestha
#Date: 10/17/2020
#file: FinalProject, Media_Player.py
"""
import tkinter
from tkinter import *
from PIL import ImageTk
from PIL import Image
import pygame
from tkinter import filedialog
import time
from mutagen.mp3 import MP3
import tkinter.ttk as ttk


root = Tk()
#Giving title
root.title("Shiva's Media Player")
#putting icon in my media player
root.iconbitmap("tr.ico")
#setting geometry of my screen of media player
root.geometry("600x500")

#setting a background color of my screen
background_label = tkinter.Label(root, bg ='#092330') #image = image1
#placing background in screen
background_label.place(x=0,y=0,relwidth=1, relheight=1)

#making screen non resizable from its default geometry  
root.resizable(False,False)

#initialize pygame mixer
pygame.mixer.init()


# get song length time informantion for music slider
def play_time():
    #checking if stopped
    if stopped:
        return
    #grab current songe elapsed time
    currentTime = pygame.mixer.music.get_pos()/1000
    
    converted_currrent_time = time.strftime('%M:%S', time.gmtime(currentTime))

    #TEMP LEVEL OT GET DATA
   # sliderLabel.config(text = f'Slider: {int(mySlider.get())} and Song Pos:{int(currentTime )}')
    #current song

    #current_song = song_box.curselection()

    song = song_box.get(ACTIVE)
    
    song = song[len(song)-1]
    
    global songLength
    #load song with mutagen
    song_mut = MP3(song)
    
    songLength = song_mut.info.length
    #convert to proper time format
    converted_songLength = time.strftime('%M:%S',time.gmtime(songLength))

    #increase currentTime by 1    
    currentTime += 1
    if int(mySlider.get()) == int(songLength):
       status_bar.config(text =f'Time Elapsed: {converted_songLength} of  {converted_songLength}')
       
    elif paused:
        pass
    elif(int(mySlider.get())) == int(currentTime):
        #SLIDEER HAS NOT BEEN MOVED
         #update slider to position
         slider_position = int(songLength)
         mySlider.config(to = slider_position, value = int(currentTime))
    
    else:
        #slider has moved
         #update slider to position
         slider_position = int(songLength)
         mySlider.config(to = slider_position, value = int(mySlider.get()))
        
         converted_currrent_time = time.strftime('%M:%S', time.gmtime(mySlider.get()))
 
         status_bar.config(text =f'Time Elapsed: {converted_currrent_time} of  {converted_songLength}')
         
         #Move bar by 1 sec
         next_time = int(mySlider.get())+1
         mySlider.config(value = next_time)
         
   # status_bar.config(text =f'Time Elapsed: {converted_currrent_time} of  {converted_songLength}')
    #update slide value to current song
    #mySlider.config(value = int(currentTime))
    
    
    
    #update time
    status_bar.after(1000, play_time)
#add song function: adds a song from a file and displays in a listbox in screen 
def add_song():
    song = filedialog.askopenfilename(initialdir = 'C:\\Users\\shiva\\Downloads\\songs', title= 'Choose a song' , filetypes= (("mp3 Files", "*.mp3"),))
  #  print(song)
    list = song.split('/')
   # print(list)
    song_title = list[len(list)-1]
    #print('\u2022', "song title: " ,song_title)
    song_display = ['\u2022', ' ',song_title,'------', song]
    song_box.insert(END,song_display)

# add many songs: adds many songs from the file and displays in a listbox in screen
def add_many_song():
     songs = filedialog.askopenfilenames(initialdir = 'C:\\Users\\shiva\\Downloads\\songs', title= 'Choose a song' , filetypes= (("mp3 Files", "*.mp3"),))
     #loop to get directory of list of songs
     for song in songs:
         list = song.split('/')
         # print(list)
         song_title = list[len(list)-1]
         #print('\u2022', "song title: " ,song_title)
         song_display = ['\u2022', ' ',song_title,'------', song]
         song_box.insert(END,song_display)
         
#play function: It plays the music usng mixer from pygame         
def play():
    #setting stop as false when played
    global stopped
    stopped = False
    song = song_box.get(ACTIVE)
   
    song = song[len(song)-1]
  
    pygame.mixer.music.load(song)
    pygame.mixer.music.play(loops=0)
    
    #call play_time to get song length
    play_time() 
    
    #update slider to position
   # slider_position = int(songLength)
   #mySlider.config(to = slider_position, value = 0)
    
global stopped
stopped = False
#stop function: stops the song if playing using mixer from pygame
def stop():
    #Reset slider and status bar
    status_bar.config(text = '')
    mySlider.config(value =0)
    
    #stop the song
    pygame.mixer.music.stop()
    song_box.selection_clear(ACTIVE)
    
    #clear the status bar
    status_bar.config(text = '')
    
    #set stop variable
    global stopped
    stopped = TRUE
    
#play next song function: it plays next song in the playlist in the listbox   
def next_song():
    #Reset slider and status bar
    status_bar.config(text = '')
    mySlider.config(value =0)
    
    #get current song number
    next_one = song_box.curselection()
    #add one to current song number
    next_one = next_one[0]+1
    
    song = song_box.get(next_one)
    
    song = song[len(song)-1]
    pygame.mixer.music.load(song)
    pygame.mixer.music.play(loops=0)
    
    #clear active bar in playlist
    song_box.selection_clear(0, END)
    
    #new song bar
    song_box.activate(next_one)
    song_box.select_set(next_one, last =None)
    
#play previous song function: it plays previous song in the listbox  
def prev_song():  
    
    #Reset slider and status bar
    status_bar.config(text = '')
    mySlider.config(value =0)
    
    #get current song number
    next_one = song_box.curselection()
    #add one to current song number
    next_one = next_one[0]-1
    
    song = song_box.get(next_one)
    
    song = song[len(song)-1]
    pygame.mixer.music.load(song)
    pygame.mixer.music.play(loops=0)
    
    #clear active bar in playlist
    song_box.selection_clear(0, END)
    
    #new song bar
    song_box.activate(next_one)
    song_box.select_set(next_one, last =None)
    
#delete a song function: it deletes a song from a selected song in the listbox
def delete_song():
    stop()
    song_box.delete(ANCHOR)
    #stop music if playing
    pygame.mixer.music.stop()
    
#delete many song function: it deletes many songs from a listbox
def delete_all_songs():
    stop()
    song_box.delete(0, END)
    #stop music if playing
    pygame.mixer.music.stop()

#slide function: creates slider of music playing
def slide(x):
   # sliderLabel.config(text = f'{ int(mySlider.get())}  of  {int(songLength)}')
    song = song_box.get(ACTIVE)
   
    song = song[len(song)-1]
  
    pygame.mixer.music.load(song)
    pygame.mixer.music.play(loops=0, start= int(mySlider.get()))
    
# global pause variable
global paused
paused = False   

#pause function: it pauses the song if song is playing
def pause(is_paused):
    
    global paused
    paused = is_paused
    
    if paused:     
        #unpause
        pygame.mixer.music.unpause()
        paused = False
    else:
        #pause
        pygame.mixer.music.pause()
        paused = True

muted = False

#mute function: it mutes song if it is unmutted and vice versa 
def mute():
    global muted
    if muted:  # Unmute the music
        pygame.mixer.music.set_volume(0.7)
       # volumeBtn.configure(image=volumePhoto)
      #  scale.set(70)
        muted = FALSE
    else:  # mute the music
        pygame.mixer.music.set_volume(0)
       # volumeBtn.configure(image=mutePhoto)
       # scale.set(0)
        muted = TRUE


#create playlist Box
song_box = Listbox(root,bg ='#092330', borderwidth =0,highlightthickness =0, fg = 'white',height = 10, width = 90,selectbackground= "gray", selectforeground = 'black')
song_box_title = tkinter.Label(root, text = "Songs in playlist: ", foreground = 'white', bg = "#092330" )
song_box_title.place(x=0,y=0)
song_box_title.config(font= ("Courier",20))

song_box.place(x=50,y=50)
song_box.pack(fill=X, pady=50)
song_box.config(font= ("Courier",8))


#creating player control buttons
back_btn_img = PhotoImage(file = "backward_button.png") 
forward_btn_img = PhotoImage(file = 'forward_button.png')
play_btn_img = PhotoImage(file = 'play_button.png')
pause_btn_img =PhotoImage(file = 'pause_button.png')
stop_btn_img =PhotoImage(file = 'stop_button.png')
mute_btn_img = PhotoImage(file = 'mute_button.png')


#creating frames put the buttons into the frame
control_frame = Frame(root)
control_frame.pack(fill=X, pady=30)


#creating player control Buttons and giving them specific commands
back_button= Button(control_frame, image = back_btn_img , borderwidth=0, command = prev_song)
forward_button = Button(control_frame, image=forward_btn_img , borderwidth=0, command = next_song)
play_button = Button(control_frame, image=play_btn_img , borderwidth=0, command = play)
pause_button = Button(control_frame, image=pause_btn_img , borderwidth=0,command =lambda: pause(paused))
stop_button = Button(control_frame, image=stop_btn_img    , borderwidth=0,command = stop)
mute_button = Button(control_frame, image=mute_btn_img    , borderwidth=0,command = mute)

#putting the buttons in the control frame grid
back_button.grid(row=0, column=0, padx= 20)
#back_button.lift()
forward_button.grid(row=0, column=1, padx= 20)
play_button.grid(row=0, column=2, padx= 20)
pause_button.grid(row=0, column=3, padx= 20)
stop_button.grid(row=0, column=4, padx= 20)
mute_button.grid(row =0, column =5, padx =20)

#create menu
my_menu = Menu(root)    
root.config(menu = my_menu)

#adding add song menu
add_song_menu = Menu(my_menu)
my_menu.add_cascade(label = "Add Songs", menu = add_song_menu)
add_song_menu.add_command(label = "Add a song to playlist", command = add_song)

#adding many songs in playlist
add_song_menu.add_command(label = "Add Many songs to playlist", command = add_many_song)

#delete song menu
remove_song_menu = Menu(my_menu)
my_menu.add_cascade(label="Remove Songs from playlist", menu= remove_song_menu)
remove_song_menu.add_command(label= "Delete A song from playlist", command = delete_song )
remove_song_menu.add_command(label= "Delete all songs from playlist", command = delete_all_songs )

#status baar
status_bar = Label(root, text='', bd = 1, relief = GROOVE, anchor = E)
status_bar.pack(fill =X, side = BOTTOM, ipady =2)


mySlider = ttk.Scale(root,from_= 0, to=100, orient = HORIZONTAL, value =0, command= slide,  length  = 360)
#mySlider.config(background ='#092330')
mySlider.pack(pady =20)

#create temp slider label
#sliderLabel = Label(root, text ="0")
#sliderLabel.pack(pady =10)

root.mainloop()