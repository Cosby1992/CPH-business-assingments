# Tower of Hanoi with console GUI
This program can solve a tower of hanoi game and print it to the console. 

# To run
Have python intalled
Clone this repository
run tower_of_hanoi.py 

OBS: If you don't want to clone this entire repository you can get the project as zip folder by pressing here [download downgit link](https://www.google.com "download")

# Features
You can input any number of disc you want and it will print it to the console. <br>
You can change the value in ```tower_of_hanoi.py``` at the bottom line ```init_game(4)```

Just change the value of 4 to whatever you please, but beware: <br>
The number of moves raises with (2^n) - 1
- 10 discs =      1023 moves
- 20 discs ~ 1.048.500 moves

# Output 
With default number of discs (4).
```
Output: 


   █       ║       ║   
  ███      ║       ║
 █████     ║       ║   
███████    ║       ║
━━━━━━━━━━━━━━━━━━━━━━━━
   A       B       C

   ║       ║       ║
  ███      ║       ║
 █████     ║       ║
███████    ║       █
━━━━━━━━━━━━━━━━━━━━━━━━
   A       B       C

   ║       ║       ║
   ║       ║       ║
 █████     ║       ║
███████   ███      █
━━━━━━━━━━━━━━━━━━━━━━━━
   A       B       C

   ║       ║       ║
   ║       ║       ║
 █████     █       ║
███████   ███      ║
━━━━━━━━━━━━━━━━━━━━━━━━
   A       B       C

   ║       ║       ║
   ║       ║       ║
   ║       █       ║
███████   ███    █████
━━━━━━━━━━━━━━━━━━━━━━━━
   A       B       C

   ║       ║       ║
   ║       ║       ║
   █       ║       ║
███████   ███    █████
━━━━━━━━━━━━━━━━━━━━━━━━
   A       B       C

   ║       ║       ║
   ║       ║       ║
   █       ║      ███
███████    ║     █████
━━━━━━━━━━━━━━━━━━━━━━━━
   A       B       C

   ║       ║       ║
   ║       ║       █
   ║       ║      ███
███████    ║     █████
━━━━━━━━━━━━━━━━━━━━━━━━
   A       B       C

   ║       ║       ║
   ║       ║       █
   ║       ║      ███
   ║    ███████  █████
━━━━━━━━━━━━━━━━━━━━━━━━
   A       B       C

   ║       ║       ║
   ║       ║       ║
   ║       █      ███
   ║    ███████  █████
━━━━━━━━━━━━━━━━━━━━━━━━
   A       B       C

   ║       ║       ║
   ║       ║       ║
   ║       █       ║
  ███   ███████  █████
━━━━━━━━━━━━━━━━━━━━━━━━
   A       B       C

   ║       ║       ║
   ║       ║       ║
   █       ║       ║
  ███   ███████  █████
━━━━━━━━━━━━━━━━━━━━━━━━
   A       B       C

   ║       ║       ║
   ║       ║       ║
   █     █████     ║
  ███   ███████    ║
━━━━━━━━━━━━━━━━━━━━━━━━
   A       B       C

   ║       ║       ║
   ║       ║       ║
   ║     █████     ║
  ███   ███████    █
━━━━━━━━━━━━━━━━━━━━━━━━
   A       B       C

   ║       ║       ║
   ║      ███      ║
   ║     █████     ║
   ║    ███████    █
━━━━━━━━━━━━━━━━━━━━━━━━
   A       B       C

   ║       █       ║
   ║      ███      ║
   ║     █████     ║
   ║    ███████    ║
━━━━━━━━━━━━━━━━━━━━━━━━
   A       B       C
```