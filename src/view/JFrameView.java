package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import controller.ImageController;
import model.Layer;
import model.Project;

/**
 * Implements the CollagingView interface. Constructs a GUI using the Swing framework.
 */
public class JFrameView extends JFrame implements CollagingView {
  private final JButton loadButton;
  private final JButton saveButton;

  private JList layerList;
  private DefaultListModel<String> listModel;

  private JLabel projectNameLabel;
  private JButton newProjectButton;

  private Project currentProject;

  /**
   * Constructor for the JFrameView class.
   */
  public JFrameView() {
    super("Collaging Images");

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    ImageController ic = new ImageController();
    JPanel topPanel = new JPanel();
    topPanel.setLayout(new FlowLayout());

    this.newProjectButton = new JButton("New Project");
    topPanel.add(newProjectButton);

    this.projectNameLabel = new JLabel("No Project");
    topPanel.add(this.projectNameLabel);
    currentProject = ic.newProject(800,600);

    this.newProjectButton.addActionListener(new ActionListener() {
      ///part5
      @Override
      public void actionPerformed(ActionEvent e) {
       String projectName = (String) JOptionPane.showInputDialog(
           topPanel,
           "Enter project name.",
               "New Project Dialog",
               JOptionPane.PLAIN_MESSAGE,
               null,
               null,
               ""
       );
       projectNameLabel.setText("Project Name: " + projectName);
       currentProject = ic.newProject(800,600);
      }
    });

    this.loadButton = new JButton("Load");
    topPanel.add(this.loadButton);

    this.loadButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

      }
    });


    this.saveButton = new JButton("Save");


    this.saveButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

      }
    });

    topPanel.add(this.saveButton);

    if(currentProject != null) {
      currentProject.addLayer(new Layer(600, 800, "newLayer"));

      this.listModel = new DefaultListModel<>();
      for (int l = 0; l < currentProject.getNumberLayers(); l++) {
        listModel.addElement(currentProject.getLayer(l).getName());
      }

      this.layerList = new JList<>(listModel);
      layerList.setSelectedIndex(1);
      layerList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
      layerList.setLayoutOrientation(JList.VERTICAL_WRAP);
      layerList.setVisibleRowCount(-1); // max number of possible rows

      JScrollPane listScroller = new JScrollPane(layerList);
      listScroller.setPreferredSize(new Dimension(250, 80));
      topPanel.add(listScroller);
    }

    this.add(topPanel);
    this.setSize(800,600);
    this.setVisible(true);
  }

  /**
   * Renders a given message to the GUI Application.
   *
   * @param message the message to be printed
   * @throws IOException if the transmission of the message to the data output fails
   */
  @Override
  public void renderMessage(String message) throws IOException {

  }

}
