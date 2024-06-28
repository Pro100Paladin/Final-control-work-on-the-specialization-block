
import management.AnimalRegister;
import management.MyException;
import management.Writer;
import menu.Menu;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, MyException {
//        Writer.read();
        Menu.menu();
        Writer.save();
//        Writer.read();
    }

}