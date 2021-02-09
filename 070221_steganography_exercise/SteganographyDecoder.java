import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Color;

public class SteganographyDecoder {

    File image;

    // no-arg contructor
    SteganographyDecoder() {

    }

    /**
     * Constructor
     * 
     * @param image - image to decode
     */
    SteganographyDecoder(File image) {
        this.image = image;
    }

    String decode() {

        // System.out.println("Decode initiating...");

        // message to return
        String decodedMessage = "";

        try {
            // read image file bytes
            BufferedImage image = ImageIO.read(this.image);

            // TEST LOOP
            // System.out.println("Filling byte array");
            for (int i = 0; i < 10; i++) {

                for (int j = 0; j < image.getWidth(); j++) {

                    int clr = image.getRGB(j, i);
                    Color color = new Color(clr, true);

                    // System.out.print(color.getRed() + " " + color.getGreen() + " " + color.getBlue() + " ");
                    // getLastBitFromIntColor(clr);
                    // System.out.println();
                    

                }

            }

            ArrayList<String> bytes = new ArrayList<>();

            // System.out.println("Filling byte array");
            for (int i = 0; i < image.getHeight(); i++) {

                for (int j = 0; j < image.getWidth(); j++) {

                    int clr = image.getRGB(j, i);

                    bytes.add(getLastBitFromIntColor(clr));
                }

            }

            // System.out.println("Byte array length: " + bytes.size());
            // System.out.println("Image size: " + image.getHeight() * image.getWidth());

            int temp = 0;
            String nextChar = "";
            ArrayList<String> message = new ArrayList<>();

            for (int i = 0; i < bytes.size(); i++) {
                
                // System.out.print(bytes.get(i));
                // nextChar += String.valueOf(bytes.get(i));
                nextChar += bytes.get(i);

                if (temp == 7) {

                    System.out.print(nextChar + " ");

                    if (nextChar.equals("00000000")) {
                        System.out.println("BREAKING: EMPTY BYTE");
                        break;
                    }

                    // System.out.println(Integer.parseInt(nextChar, 2));

                    message.add(nextChar);
                    // System.out.println("Temp == 7: " + nextChar);
                    temp = 0;
                    nextChar = "";

                    continue;
                }

                temp++;

            }

            System.out.println();

            for (String stringByte : message) {
                // System.out.print((char) character);

                System.out.println(stringByte);
                System.out.print((char) Integer.parseInt(stringByte));

            }

            System.out.println();

        } catch (Exception e) {
            System.out.println("Problem reading image: " + e.getMessage());
            return e.getMessage();
        }

        return decodedMessage;
    }

    private String bitStringToFullByteString(String bitString){

        String toAddInFrontOfBitString = "";

        for (int i = 0; i < 8-bitString.length(); i++) {
            toAddInFrontOfBitString += "0";
        }

        StringBuilder builder = new StringBuilder(bitString);

        builder.insert(0, toAddInFrontOfBitString);

        return builder.toString();

    }

    private String getLastBitFromIntColor(int clr) {

        Color color = new Color(clr, true);

        String blueBitString = Integer.toBinaryString(color.getBlue());
        
        boolean manipulated = false;

        if(blueBitString.length() != 8){
            manipulated = true;
            blueBitString = bitStringToFullByteString(blueBitString);
        }

        if(manipulated){
            System.out.println("bluebitstring: " + blueBitString + " " + blueBitString.charAt(7) + " manipulated");
        } else {
            System.out.println("bluebitstring: " + blueBitString + " " + blueBitString.charAt(7));
        }
        

        return String.valueOf(blueBitString.charAt(7));

    }

    // Getters and Setters
    void setImage(File image) {
        this.image = image;
    }

}
