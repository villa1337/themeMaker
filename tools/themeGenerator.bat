::change this for the place where you have the App.java
cd C:\Documents\Personal\untitled\src
javac App.java
java App
::change this to the folder you unzipped the themes from the jar in plugins
wzzip -rp test.zip C:\Users\villafra\Documents\Personal\Scripts\Dark-Themes-1.0.8
rename test.zip Dark-Themes-1.0.8.jar
::change here too to the location of your intellij
move Dark-Themes-1.0.8.jar C:\Users\villafra\AppData\Roaming\JetBrains\IntelliJIdea2022.2\plugins\
echo "All Done!"
::change with the location of your intellij
start D:\"IntelliJ IDEA 2022.2.3"\bin\idea64.exe