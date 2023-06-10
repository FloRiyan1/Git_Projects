package tikTakTo.View;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class BasisView {

	public static BasisView instance;
	
	public static BasisView getInstance()
	{
		if(instance == null)
		{
			instance = new BasisView();
		}
		return instance;
	}
	
	public JFrame frmBasis;
	public JPanel pnlBasis;
	public JButton btnUpperRight, btnUpper, btnUpperLeft, btnMiddelRight, btnMiddel, btnMiddelLeft, btnBottomRight, btnBottom, btnBottomLeft;
	public JLabel lblTitel;
	public Border emptyBorder;
	
	private BasisView()
	{
		frmBasis = new JFrame("Tik-Tak-To");
		pnlBasis = new JPanel();
		btnUpperRight = new JButton("Oben Rechts");
		btnUpperRight.setName("Oben Rechts");
		btnUpper = new JButton("Oben");
		btnUpper.setName("Oben");
		btnUpperLeft = new JButton("Oben Links");
		btnUpperLeft.setName("Oben Links");
		btnMiddelRight = new JButton("Mitte Rechts");
		btnMiddelRight.setName("Mitte Rechts");
		btnMiddel = new JButton("Mitte");
		btnMiddel.setName("Mitte");
		btnMiddelLeft = new JButton("Mitte Links");
		btnMiddelLeft.setName("Mitte Links");
		btnBottomRight = new JButton("Unten Rechts");
		btnBottomRight.setName("Unten Rechts");
		btnBottom = new JButton("Unten");
		btnBottom.setName("Unten");
		btnBottomLeft = new JButton("Unten Links");
		btnBottomLeft.setName("Unten Links");
		emptyBorder = BorderFactory.createEmptyBorder(50, 50, 50, 50);
		lblTitel = new JLabel("titiel");
	}
	
	public void initGUI()
	{
		frmBasis.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Dimension dimButton = new Dimension(160,140);
		pnlBasis.setLayout(new GridBagLayout());
		GridBagConstraints gb = new GridBagConstraints();		
		
		//lblTitiel
		gb.gridx = 0;
		gb.gridy = 0;
		gb.weightx = 1.0;
		gb.weighty = 1.0;
		gb.gridwidth = 3;
		pnlBasis.add(lblTitel, gb);
		
		
		//btnUpperRight
		btnUpperRight.setBorder(emptyBorder);
		btnUpperRight.setPreferredSize(dimButton);
		gb.gridx = 2;
		gb.gridy = 1;
		gb.weightx = 1.0;
		gb.weighty = 1.0;
		gb.gridwidth = 1;
		pnlBasis.add(btnUpperRight, gb);

		//btnUpper
		btnUpper.setBorder(emptyBorder);
		btnUpper.setPreferredSize(dimButton);
		gb.gridx = 1;
		gb.gridy = 1;
		gb.weightx = 1.0;
		gb.weighty = 1.0;
		pnlBasis.add(btnUpper, gb);
		
		//btnUpperLeft
		btnUpperLeft.setBorder(emptyBorder);
		btnUpperLeft.setPreferredSize(dimButton);
		gb.gridx = 0;
		gb.gridy = 1;
		gb.weightx = 1.0;
		gb.weighty = 1.0;
		pnlBasis.add(btnUpperLeft, gb);

		//btnMiddelRight
		btnMiddelRight.setBorder(emptyBorder);
		btnMiddelRight.setPreferredSize(dimButton);
		gb.gridx = 2;
		gb.gridy = 2;
		gb.weightx = 1.0;
		gb.weighty = 1.0;
		pnlBasis.add(btnMiddelRight, gb);

		//btnMiddel
		btnMiddel.setBorder(emptyBorder);
		btnMiddel.setPreferredSize(dimButton);
		gb.gridx = 1;
		gb.gridy = 2;
		gb.weightx = 1.0;
		gb.weighty = 1.0;
		pnlBasis.add(btnMiddel, gb);

		//btnMiddelLeft
		btnMiddelLeft.setBorder(emptyBorder);
		btnMiddelLeft.setPreferredSize(dimButton);
		gb.gridx = 0;
		gb.gridy = 2;
		gb.weightx = 1.0;
		gb.weighty = 1.0;
		pnlBasis.add(btnMiddelLeft, gb);
		
		//btnBottomRigth
		btnBottomRight.setBorder(emptyBorder);
		btnBottomRight.setPreferredSize(dimButton);
		gb.gridx = 2;
		gb.gridy = 3;
		gb.weightx = 1.0;
		gb.weighty = 1.0;
		pnlBasis.add(btnBottomRight, gb);
		
		//btnBottom
		btnBottom.setBorder(emptyBorder);
		btnBottom.setPreferredSize(dimButton);
		gb.gridx = 1;
		gb.gridy = 3;
		gb.weightx = 1.0;
		gb.weighty = 1.0;
		pnlBasis.add(btnBottom, gb);

		//btnBottomLeft
		btnBottomLeft.setBorder(emptyBorder);
		btnBottomLeft.setPreferredSize(dimButton);
		gb.gridx = 0;
		gb.gridy = 3;
		gb.weightx = 1.0;
		gb.weighty = 1.0;
		pnlBasis.add(btnBottomLeft, gb);
		
		frmBasis.add(pnlBasis);
		frmBasis.setBounds(600, 600, 600, 600);
		frmBasis.setVisible(true);
	}
	
}
