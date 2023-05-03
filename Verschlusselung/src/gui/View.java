package gui;

import javax.swing.*;
import java.awt.*;
import javax.swing.BorderFactory;

public class View 
{
  public View() {
    	
    }
    
    public void updateGui()
    {
        // Set the title of the window
        setTitle("Verschlüsselungs Programm");

        // Create a new JPanel with a titled border
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));

        // Set the layout of the content pane to a GridBagLayout
        panel.setLayout(new GridBagLayout());

        // Define GridBagConstraints to control the layout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(30, 30, 30, 30); // Add a 30 pixel margin around the window
       
        // Add the upper left label and text area
        JLabel lblEingabe = new JLabel("Label 1");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.5;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5, 5, 0, 5); // Add a 5 pixel margin between label and text area
        panel.add(lblEingabe, gbc);

        JTextArea txtEingabe = new JTextArea(5, 20);
        JScrollPane spEingabe = new JScrollPane(txtEingabe);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.5;
        gbc.weighty = 0.8;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 5, 5, 5); // Add a 5 pixel margin between text areas
        panel.add(spEingabe, gbc);

        // Add the upper right label and text area
        JLabel lblVerschluesseld = new JLabel("Label 2");
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.5;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5, 5, 0, 5); // Add a 5 pixel margin between label and text area
        panel.add(lblVerschluesseld, gbc);

        JTextArea txtVerschluesselt = new JTextArea(5, 20);
        JScrollPane spVerschluesselt = new JScrollPane(txtVerschluesselt);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.5;
        gbc.weighty = 0.8;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 5, 5, 5); // Add a 5 pixel margin between text areas
        panel.add(spVerschluesselt, gbc);

     // Add the lower left text area with label
        JLabel lblPrivateKey = new JLabel("Label 3");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.5;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5, 5, 0, 5); // Add a 5 pixel margin between text areas and labels
        panel.add(lblPrivateKey, gbc);

        JTextArea txtPrivateKey = new JTextArea(5, 20);
        JScrollPane spPrivateKey = new JScrollPane(txtPrivateKey);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.5;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 5, 5, 5); // Add a 5 pixel margin between text areas and labels
        panel.add(spPrivateKey, gbc);

        JLabel lblPublicKey = new JLabel("Label 4");
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.5;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 0, 5); // Add a 5 pixel margin between label and text area
        panel.add(lblPublicKey, gbc);

        // Add the lower right text area
        JTextArea txtPublicKey = new JTextArea(5, 20);
        JScrollPane spPublicKey = new JScrollPane(txtPublicKey);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.5;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 5, 5, 5); // Add a 5 pixel margin between text areas
        panel.add(spPublicKey, gbc);

        // Set the panel as the content pane of the frame
        setContentPane(panel);
        
        // Set the size of the window
        setSize(600, 400);

        // Set the window to be visible
        setVisible(true);

}
