import javax.swing.*;
import java.awt.*;

public class Spiralen extends JPanel {

  private void drawSpiral(Graphics graphics, String[] args) throws Exception{

    if (args.length != 3) {
      throw new Exception("Fehler, geben sie genau 3 Kommandozeilenargumente an!");
    }
    else if(args.length >= 3 && Double.parseDouble(args[1]) < 0) {
      throw new Exception("Fehler, wählen sie Winkel größer 0!");
    }
    // — Anzahl der Wiederholungen
    int iterations = Integer.parseInt(args[0]);
    //— Drehwinkel in Grad (mehr unten) 
    double angle = Double.parseDouble(args[1]);
    // — Verkürzungsfaktor zwischen 0 und 1 (mehr unten)
    double shrink = Double.parseDouble(args[2]);
    // Coordinates and vector
    double currentX = 20;
    double currentY = 20;
    double currentDX = 400;
    double currentDY = 0;
    

    // Do drawing iterations
    for(int i = 0; i < iterations; i++) {
      // Zeichne eine Linie von (x,y) nach (x+dx, y+dy)
      double newX = currentX + currentDX;
      double newY = currentY + currentDY;
      graphics.drawLine((int)currentX, (int)currentY, (int)newX, (int)newY);
      // Verschiebe (x,y) nach (x+dx,y+dy)
      currentX = newX;
      currentY = newY;
      // Drehe den Vektor (dx,dy) um den Winkel angle mit der Formel:
      double newDX = currentDX * Math.cos(Math.toRadians(angle))- currentDY * Math.sin(Math.toRadians(angle));
      double newDY = currentDX * Math.sin(Math.toRadians(angle))+ currentDY * Math.cos(Math.toRadians(angle));
      // Multipliziere dx und dy jeweils mit shrink
      newDX *= shrink;
      newDY *= shrink;
      currentDX = newDX;
      currentDY = newDY;
    }

  }

  // DONT'T CHANGE ANYTHING BELOW HERE

  private String[] args;

  private final int WIDTH = 600;
  private final int HEIGHT = 600;

  private Spiralen(String[] args){
    super();
    this.args = args;
    JFrame frame = new JFrame("Spiralen");
    frame.setSize(WIDTH, HEIGHT);
    this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    frame.add(this);
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setVisible(true);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g.setColor(java.awt.Color.WHITE);
    g.fillRect(0, 0, WIDTH, HEIGHT);
    g.setColor(new java.awt.Color(0.6f, 0, 0));
    try {
      drawSpiral(g, args);
    }catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public static void main(String[] args) {
    Spiralen spiralen = new Spiralen(args);
    
  }
    
}
