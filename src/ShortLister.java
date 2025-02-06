import javax.swing.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;


public class ShortLister
{
    public static void main(String[] args)
    {
        ShortWordFilter filter = new ShortWordFilter();
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String record;

        try
        {
            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);
            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();
                System.out.println("Selected file: " + file.getFileName().toString());
                InputStream in = new BufferedInputStream(Files.newInputStream(file));
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

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
            else
            {
                System.out.println("No file selected");
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("The selected file was not found");
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
