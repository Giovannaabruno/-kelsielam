package swing;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class ImagePane extends JPanel {

  private BufferedImage image;
  
  public ImagePane(BufferedImage image) {
    super();
    this.image = image;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    System.out.println("Calling paint");
    g.drawImage(this.image, 0, 0, this); /// draw image
  }
}
