Requirements:
YOu will need wzip command line add on:
https://www.winzip.com/en/download/command-line/
You will need to have Dark themes installed:
https://github.com/Shubham076/Dark-Themes
Once both are installed, select Aura theme on Intellij by going to File - Settings - Appearance  since the theme generator uses it to work
After having dark themes plugin installed, exploit the themes folder usually located in ~\AppData\Roaming\JetBrains\IntelliJIdea2022.2\plugins into C: drive or whatever location. Just make sure you modify it in the App.java as well as in the themeGenerator.bat located in the tools folder

This is a 2 piece script in both java and batch. You will need to change the URLs where you see them to reflect the actual paths in your system 

After all this. Just close IntelliJ, run themeGenerator.bat and wait for it to open

You'll have a uniquely generated theme!

