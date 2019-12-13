package personas.test;
import Frame.IOBase;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFrame;
import personas.dto.PersonaDTO;
import personas.jdbc.PersonaDao;
import personas.jdbc.PersonaDaoJDBC;

public class TestPersonas {
    /**
 * @author Figueras, Galarza, Gutierrez
 * Clase main (principal). Se utiliza para poder llamar . Se realiza un while para
 * poder manejar todas las opciones posibles en este CRUD. AL final al seleccionar
 * la opcion de terminar el ciclo se realiza un break para romper la ejecucion
 * 
 * 
 * @throws SQLException
 * 
 * @version 1.0.1
 */

    public static void main(String[] args) throws SQLException, Exception {
        IOBase iob = new IOBase();
        iob.setVisible(true);
        iob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

