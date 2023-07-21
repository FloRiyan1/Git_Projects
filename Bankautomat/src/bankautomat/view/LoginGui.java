package bankautomat.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

public class LoginGui
{
	public JTextField tfUserLogin;
	public JTextField tfUserPassword;
	public JButton btnBestaetigen;

	public LoginGui()
	{
		
	}
	
	public void initGui()
	{
		JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tfUserLogin = new JTextField(20);
        tfUserPassword = new JTextField(20);
        btnBestaetigen = new JButton("Submit");

        // Set the layout manager to GridBagLayout
        frame.setLayout(new GridBagLayout());

        // Create a GridBagConstraints object
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Add some padding

        // Add textField1
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(tfUserLogin, gbc);

        // Add textField2
        gbc.gridy = 1;
        frame.add(tfUserPassword, gbc);

        // Add button
        gbc.gridy = 2;
        frame.add(btnBestaetigen, gbc);

        // Set the size of the frame
        frame.setSize(400, 400);
        frame.setVisible(true);
	}
}
