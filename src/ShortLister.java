/**
 * This main class is used to read a file and print out all the short words in the file.
 * Implements the ShortWordFilter class to filter out the short words.
 */

import javax.swing.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;


public class ShortLister
{
    public static void main(String[] args)
    {
        /**
         * The ShortWordFilter object is created to filter out the short words.
         * The JFileChooser object is created to allow the user to select a file.
         * The selectedFile object is created to hold the selected file.
         * The record object is created to hold the record from the file.
         */
        ShortWordFilter filter = new ShortWordFilter();
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String record;

        /**
         * Try catches are made in case the file is not found, cannot be read, or some other error occurs
         */
        try
        {
            /**
             * Set the current directory to the working directory
             */
            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);
            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                /**
                 * Get the selected file to read for the for loop
                 */
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();
                System.out.println("Selected file: " + file.getFileName().toString());
                InputStream in = new BufferedInputStream(Files.newInputStream(file));
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                /**
                 * Display the short words from the file
                 */
                System.out.println("All of the short words from " +  file.getFileName().toString() + " are: ");
                while((record = reader.readLine()) != null)
                {
                    for (String word : record.split("\\s+"))
                    {
                        if (filter.accept(word))
                        {
                            System.out.println(word);
                        }
                    }
                }
            }
            /**
             * If no file is selected, display an error message
             */
            else
            {
                System.out.println("No file selected");
            }
        }
        /**
         * If the file is not found, display an error message
         */
        catch (FileNotFoundException e)
        {
            System.out.println("The selected file was not found");
        }
        /**
         * If an error occurs, display an error message
         */
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
