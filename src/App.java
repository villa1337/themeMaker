import java.awt.*;
import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {

    public static final String path = "C:/Users/villafra/Documents/Personal/Scripts/Dark-Themes-1.0.8/themes/Aura.xml";

    public static void main(String[] args) {
        try {
            File file = new File(path);
            Scanner myReader = new Scanner(file);
            String data = "";

            Set<String> differentColors = new HashSet<>();
            Pattern pattern = Pattern.compile("(?<=value=\\\").{6,}(?=\\\")");

            while (myReader.hasNextLine()) {
                String newLine = myReader.nextLine();
//                System.out.println(newLine);
                data+=newLine+"\n";
                Matcher matcher = pattern.matcher(newLine);
                if (matcher.find()) {
                    differentColors.add(matcher.group());
                }
            }
            myReader.close();

            // This is a good approach for a more granular control over each element, but if what we need is to re-use
            // the existing themes's "cohesion" we need to make adjustments between the present hues
//            JAXBContext jaxbContext = JAXBContext.newInstance(Scheme.class);
//            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//            StringReader reader = new StringReader(data);
//            StringWriter stringWriter = new StringWriter();
//            Scheme scheme = (Scheme) jaxbUnmarshaller.unmarshal(reader);
//            Marshaller marshaller = jaxbContext.createMarshaller();
//            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
//            marshaller.marshal(scheme,new FileOutputStream("Aura.xml"));

            for(String colorString : differentColors){
                int r = Integer.valueOf(colorString.substring(0,2), 16);
                int g = Integer.valueOf(colorString.substring(2,4), 16);
                int b = Integer.valueOf(colorString.substring(4,6), 16);
                float[] hsbColors = Color.RGBtoHSB(r,g,b,null);
                data = data.replaceAll(colorString, getRandomHueHexColor(hsbColors));
            }

            FileWriter writer = new FileWriter(new File(path));
            writer.write(data);
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
//        } catch (JAXBException e) {
//            throw new RuntimeException(e);
//        }
        }
    }

    private static String getRandomHueHexColor(float[] hsbColors) {
        float randomHue = (float)Math.random()*.6f+.6f;
        Color newColor = new Color(Color.HSBtoRGB(randomHue,hsbColors[1],hsbColors[2]));
        String result = "";
        result += Integer.toString(newColor.getRed(), 16) + Integer.toString(newColor.getGreen(), 16) + Integer.toString(newColor.getBlue(), 16);
        return result;
    }

    private static String getRandomHexColor() {
        String color = "";
        for(int i=0; i<6; i++){
            color+=Integer.toString((int)(Math.random()*16),16);
        }
        return color;
    }

    private static String getRandomRGBHexColor() {
        String color = "";
        for(int i=0; i<3; i++){
            color+=Integer.toString((int)(Math.random()*255),16);
        }
        return color;
    }
}
