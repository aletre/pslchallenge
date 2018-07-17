package co.com.psl.challenge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


/**
 * Clase principal para ejecutar el reto de números ordenados.
 * 
 * @author dtrejos
 */
public class PSLChallenge {

  /**
   * Main.
   * 
   * Recibe como argumento el archivo a procesar, en caso que no se envíe abrirá una ventana de dialogo para que el usuario lo obtenga.
   * 
   * @param args (Opcional) [0] Ruta completa del archivo que se desea procesar.
   */
  public static void main(String[] args) {
    File fileToReview = null;
    if (args != null && args.length == 1) {
      fileToReview = new File(args[0]);
      if (!fileToReview.exists()) {
        System.err.println("El archivo ingresado no existe.");
        return;
      }
    } else {
      JFileChooser fileChooser = new JFileChooser();
      int result = fileChooser.showOpenDialog(null);
      if (result == JFileChooser.APPROVE_OPTION) {
        fileToReview = fileChooser.getSelectedFile();
      }
    }

    try {
      File resultFile = new File(fileToReview.getParent() + File.separator + "salida.txt");
      LastOrderedNumber loNumber = new LastOrderedNumber();
      try (BufferedReader br = new BufferedReader(new FileReader(fileToReview)); 
          BufferedWriter writer = new BufferedWriter(new FileWriter(resultFile))) {
        String line = br.readLine();
        int numberOfLines = Integer.valueOf(line);
        int numberCase = 1;
        while ((line = br.readLine()) != null && numberOfLines-- != 0) {
          String lastOrderedNumber = loNumber.getLastOrderedNumberOf(line);
          writer.write(String.format("Case %s: N=%s, R=<%s>\n", numberCase, line, lastOrderedNumber));
          numberCase++;
        }
      }
      JOptionPane.showMessageDialog(null, "Archivo de salida genedado, lo puede encontrar en: \n" + resultFile.getAbsolutePath());
    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(null, "No fue posible obtener el número de casos a revisar.");
      throw new RuntimeException(e);
    } catch (IOException e) {
      JOptionPane.showMessageDialog(null, "Ocurrió un error en la manipulación de los archivos durante el proceso.");
      throw new RuntimeException(e);
    }
  }
}
