
import java.awt.image.BufferedImage;


/**
 * Class to handle decoding of messages in images.
 * 
 * @author Cosby1992, Stabz
 */
public class ImageSteganography {

    /**
     * Method that takes an image as buffered image and try to make a message 
     * from bits in a specific position in the 32 bit color representation.
     * 
     * @param img Buffered image to iterate over
     * @param position bit posistion to create a message from (interval: 0-31) 
     * 32 would be the same as 0 since it is shifted with the posistion.
     * ARGB = pos 24-31 alpha bits, pos 16-23 red bits, pos 8-15 green bits, pos 0-7 blue bits
     * pos  = 24 for alpha LSB,     16 for red LSB,     8 for green LSB,     0 for blue LSB
     * LSB = Least Significant Bit
     */
    String decodeWithLittleEndianFromImageByBitPosition(BufferedImage img, int position) {

        // get image width and height
        int imageWidth = img.getWidth();
        int imageHeight = img.getHeight();

        StringBuilder message = new StringBuilder();

        // Initializing String builder to append bits as strings
        StringBuilder builder = new StringBuilder();

        // Used to break out of 2 dimentional loop
        boolean nullByteReached = false;

        // Looping through pixels in image
        for (int y = 0; y < imageHeight; y++) {
            for (int x = 0; x < imageWidth; x++) {

                // Getting pixel value from current posistion
                int p = img.getRGB(x, y); 

                // Append the bit found on bit posistion (0-31)
                builder.append(String.valueOf((p >> position) & 0x01));

                // If a whole byte is collected
                if(builder.length() == 8) {

                    // break if null byte is found
                    if(builder.toString().equals("00000000")){
                        System.out.println();
                        System.out.println("Message found. Exiting."); 
                        nullByteReached = true;
                        break;
                    } 

                    // Print binary value from string to int to char - reversed (Little Endian)
                    message.append((char)Integer.parseInt(builder.reverse().toString(), 2));
                    builder = new StringBuilder(); // clear string builder
                }

                if(nullByteReached) break; // break if null byte is reached

            }
        }

        return message.toString();

    }

}
