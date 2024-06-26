package hus.oop.lab11.abstractfactorypattern.pseudocode;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
public class ApplicationConfigurator {
    public static void main(String[] args) {
        Properties prop = new Properties();
        String fileName = "app.config";
        try (FileInputStream fis = new FileInputStream(fileName)) {
            prop.load(fis);
        } catch (FileNotFoundException ex) {
     // FileNotFoundException catch is optional and can be collapsed
        } catch (IOException ex) {

        }
        System.out.println(prop.getProperty("app.name"));
        System.out.println(prop.getProperty("app.version"));

    }
}
