package org.example;
import org.example.Model.DatosModel;
import org.example.Robot.Robot;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/*
    Daniel Arango Villegas
* */

public class Main {
    public static void main(String[] args) {
        Robot robot = new Robot();
        Properties properties = new Properties();
        DatosModel datosModel = new DatosModel();
        String ruta = datosModel.getRuta();

        try (FileInputStream fis = new FileInputStream(ruta)) {
            properties.load(fis);

            //tiempo
            int hora = Integer.parseInt(properties.getProperty("hora"));
            int minuto = Integer.parseInt(properties.getProperty("minuto"));
            int dia = Integer.parseInt(properties.getProperty("dia"));

            //ejecutar logica 1
            robot.ejecutarFechaRobot(hora,minuto,dia);

        } catch (IOException e) {
            System.err.println("Error al leer el archivo de propiedades: " + e.getMessage());
        }
    }
}