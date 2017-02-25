LZW Compression Algorithm -  Program by Kaushal Kanakamedala - 800936486



---------------------------------------------------------------------------------------------------------------------------


Configuration :
1) The program was written exclusively in eclipse.(So I couldn't take the name of the file dynamically).
2) The programs runs in output console for ease and convinence.
3) The number bit is dynamic and is to be given at the beginning.
4) The program is made on Eclipse version - Mars.2 Release (4.5.2) and java version 1.8.0_73-b02.

---------------------------------------------------------------------------------------------------------------------------

Design Pattern and data structures :

-> The prgram has the encoding and decoding in the same class for ease of use.

Data Structures used are Arraylist(For taking Hexadecimal Integers), HashMap(For coded information) and used for each loop,
if loop.


---------------------------------------------------------------------------------------------------------------------------


Instruction Of Use :
1) Open the program in eclipse for better compatablity(As mentioned, written exclusiverly in eclipseIDE).
2) Running the program prompts user for bits but not the name of the file.
3) Please give the name of the file in the program.
4) Setting this would be easy I have written two commands for getting the address of the file.
5) If the file is the same user directory use file encoding 1 and change name.
    else if file is some other directory use encoding 2.
6) The output file is also hardcoded as of now.
7) I have still written 2 output file to get output in .txt and .lzw files. Use them accordingly.

---------------------------------------------------------------------------------------------------------------------------
Copyright and licencing :
This code is not free for use and is not restricted for anyone.
(There is still a lot of room for improvement).

---------------------------------------------------------------------------------------------------------------------------

Known bugs :
1) The name of the files are hardcoded(I tried hard but, incorporation name from user command is work in motion and future 
	version will support them)
2) I tried my best to clear bugs and tried various algorithms to reduce timimgs.
3) The reading of string is made to read 16 bit all at once to reduce time(It has worked so far).
4) The code looks a little messy(trieed my best to organise and comment each step).

---------------------------------------------------------------------------------------------------------------------------

Troubleshooting :
->Large file are known to take a long time to run, so please be patient as the program runs.
->If the program stops, re-run. No other way to go round.


---------------------------------------------------------------------------------------------------------------------------

Comments and other credits :

The only problem is the names are hard coded and I working to improve those in the next versions.



---------------------------------------------------------------------------------------------------------------------------

Credits and Acknowledgement :

-> The encoding and decoding were available in the package.lzw class. 