import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.Box;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CYKGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CYKGUI window = new CYKGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CYKGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.controlHighlight);
		frame.getContentPane().setLayout(null);
		
		JLabel title = new JLabel("CYK Algorithm");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 30));
		title.setBounds(219, 11, 208, 64);
		frame.getContentPane().add(title);
		
		JLabel promptOne = new JLabel("Enter your grammar, then check");
		promptOne.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 11));
		promptOne.setHorizontalAlignment(SwingConstants.CENTER);
		promptOne.setBounds(229, 67, 176, 22);
		frame.getContentPane().add(promptOne);
		
		JLabel promptTwo = new JLabel("if your output can be generated");
		promptTwo.setHorizontalAlignment(SwingConstants.CENTER);
		promptTwo.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 11));
		promptTwo.setBounds(229, 86, 180, 22);
		frame.getContentPane().add(promptTwo);
		
		JLabel label = new JLabel("<Example Input>");
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setToolTipText("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 13));
		label.setBounds(251, 132, 139, 22);
		frame.getContentPane().add(label);
		
		JLabel lblSabac = new JLabel("S->A,b");
		lblSabac.setVerticalAlignment(SwingConstants.TOP);
		lblSabac.setToolTipText("");
		lblSabac.setHorizontalAlignment(SwingConstants.CENTER);
		lblSabac.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 11));
		lblSabac.setBounds(261, 154, 112, 22);
		frame.getContentPane().add(lblSabac);
		
		JLabel grammarLabel = new JLabel("Grammar");
		grammarLabel.setVerticalAlignment(SwingConstants.TOP);
		grammarLabel.setToolTipText("");
		grammarLabel.setHorizontalAlignment(SwingConstants.CENTER);
		grammarLabel.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 17));
		grammarLabel.setBounds(51, 210, 198, 22);
		frame.getContentPane().add(grammarLabel);
		
		JTextPane grammarField = new JTextPane();
		grammarField.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 11));
		grammarField.setBounds(98, 241, 105, 143);
		frame.getContentPane().add(grammarField);
		
		JLabel lblAac = new JLabel("A->a,c");
		lblAac.setVerticalAlignment(SwingConstants.TOP);
		lblAac.setToolTipText("");
		lblAac.setHorizontalAlignment(SwingConstants.CENTER);
		lblAac.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 11));
		lblAac.setBounds(261, 177, 112, 22);
		frame.getContentPane().add(lblAac);
		
		JLabel outputLabel = new JLabel("Output");
		outputLabel.setVerticalAlignment(SwingConstants.TOP);
		outputLabel.setToolTipText("");
		outputLabel.setHorizontalAlignment(SwingConstants.CENTER);
		outputLabel.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 17));
		outputLabel.setBounds(387, 210, 198, 22);
		frame.getContentPane().add(outputLabel);
		
		JTextPane outputField = new JTextPane();
		outputField.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 11));
		outputField.setBounds(434, 241, 105, 143);
		frame.getContentPane().add(outputField);
		frame.setBounds(100, 100, 640, 459);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton checkOutputButton = new JButton("Check Output");
		checkOutputButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				HashTable table = new HashTable();
				String grammar = grammarField.getText();
				String output = outputField.getText();
				String grammarArray[] = grammar.split("\n");
				String arrow = "->";
				
				//Process through each line of the user's input to build the grammar
				for (int i = 0; i < grammarArray.length; i++)
				{
					String grammarLine = grammarArray[i];
					String leftSideVariable = grammarLine.substring(0, grammarLine.indexOf(arrow));
					String rightSide = grammarLine.substring(leftSideVariable.length()+arrow.length());
					String rightSideArray[] = rightSide.split(",");
					
					//Insert each variable on the right side into the table at the leftSideVariable's
					//index in the HashTable
					for (int x = 0; x < rightSideArray.length; x++)
					{
						String rightSideElement = rightSideArray[x];
						table.insert(rightSideElement,leftSideVariable);
					}//inner
				}//outer
				
				//Now that the table has been completely filled out, send the table to the 
				//other program to check if the output can be generated by the grammar
				
				//boolean canBeGenerated = Run.checkInput(table, output);
			}
			
		});
		checkOutputButton.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 15));
		checkOutputButton.setBackground(new Color(154, 205, 50));
		checkOutputButton.setBounds(251, 349, 139, 35);
		frame.getContentPane().add(checkOutputButton);
	}
}
