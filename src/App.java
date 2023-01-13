import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {

    public static final String originalXmlPath = "C:/Users/villafra/Documents/Personal/Scripts/Dark-Themes-1.0.8/themes/Aura.xml";
    public static final String originalJsonPath = "C:/Users/villafra/Documents/Personal/Scripts/Dark-Themes-1.0.8/themes/aura.theme.json";

    public static void generateNewFile(String path, String regex){
        try {
            File file = new File(path);
            Scanner myReader = new Scanner(file);
            StringBuilder data = new StringBuilder();

            Set<String> differentColors = new HashSet<>();
            Pattern pattern = Pattern.compile(regex);

            while (myReader.hasNextLine()) {
                String newLine = myReader.nextLine();
                data.append(newLine).append("\n");
                Matcher matcher = pattern.matcher(newLine);
                if (matcher.find()) {
                    differentColors.add(matcher.group());
                }
            }
            myReader.close();

            for(String colorString : differentColors){
                int r = Integer.valueOf(colorString.substring(0,2), 16);
                int g = Integer.valueOf(colorString.substring(2,4), 16);
                int b = Integer.valueOf(colorString.substring(4,6), 16);

                float[] hsbColors = Color.RGBtoHSB(r,g,b,null);

                if(colorString.length()>6){
                    try{
                        String transparency = colorString.substring(6,8);
                        data = new StringBuilder(data.toString().replaceAll(colorString, getRandomHueHexColor(hsbColors) + transparency));
                    } catch(Exception e){
                        System.out.println(colorString);
                        System.out.println(e.getMessage());
                    }
                }else{
                    data = new StringBuilder(data.toString().replaceAll(colorString, getRandomHueHexColor(hsbColors)));
                }
            }
            FileWriter writer = new FileWriter(path);
            writer.write(data.toString());
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getRandomHueHexColor(float[] hsbColors) {
        float randomBaseline = (float)Math.random()*.2f+.2f;
        float randomHue = randomBaseline*randomBaseline+randomBaseline;
        Color newColor = new Color(Color.HSBtoRGB(randomHue,hsbColors[1],hsbColors[2]));
        String result = "";
        String red = twoDigitize(Integer.toString(newColor.getRed(), 16));
        String green = twoDigitize(Integer.toString(newColor.getGreen(), 16));
        String blue = twoDigitize(Integer.toString(newColor.getBlue(), 16));
        result += red + green + blue;
        return result;
    }

    private static String twoDigitize(String color) {
        return color.length()<2 ? "0"+color : color;
    }

    public static void main(String[] args) {
        generateNewFile(originalJsonPath, "(?<=: \\\"#).{6,}(?=\\\")");
        generateNewFile(originalXmlPath, "(?<=value=\\\").{6,}(?=\\\")");
    }

}
