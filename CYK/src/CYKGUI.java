import java.awt.EventQueue;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
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
import javax.swing.UIManager;

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
		
		JLabel exampleOneLabel = new JLabel("S->A,b");
		exampleOneLabel.setVerticalAlignment(SwingConstants.TOP);
		exampleOneLabel.setToolTipText("");
		exampleOneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		exampleOneLabel.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 11));
		exampleOneLabel.setBounds(261, 154, 112, 22);
		frame.getContentPane().add(exampleOneLabel);
		
		JLabel grammarLabel = new JLabel("Grammar");
		grammarLabel.setVerticalAlignment(SwingConstants.TOP);
		grammarLabel.setToolTipText("");
		grammarLabel.setHorizontalAlignment(SwingConstants.CENTER);
		grammarLabel.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 17));
		grammarLabel.setBounds(-12, 210, 198, 22);
		frame.getContentPane().add(grammarLabel);
		
		JTextPane grammarPane = new JTextPane();
		grammarPane.setBackground(new Color(248, 248, 255));
		grammarPane.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 13));
		grammarPane.setBounds(39, 241, 105, 143);
		frame.getContentPane().add(grammarPane);
		StyledDocument grammarPaneDoc = grammarPane.getStyledDocument();
		SimpleAttributeSet grammarPaneCenter = new SimpleAttributeSet();
		StyleConstants.setAlignment(grammarPaneCenter, StyleConstants.ALIGN_CENTER);
		grammarPaneDoc.setParagraphAttributes(0, grammarPaneDoc.getLength(), grammarPaneCenter, false);
		
		JLabel exampleTwoLabel = new JLabel("A->a,c");
		exampleTwoLabel.setVerticalAlignment(SwingConstants.TOP);
		exampleTwoLabel.setToolTipText("");
		exampleTwoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		exampleTwoLabel.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 11));
		exampleTwoLabel.setBounds(261, 177, 112, 22);
		frame.getContentPane().add(exampleTwoLabel);
		
		JLabel outputLabel = new JLabel("Output");
		outputLabel.setVerticalAlignment(SwingConstants.TOP);
		outputLabel.setToolTipText("");
		outputLabel.setHorizontalAlignment(SwingConstants.CENTER);
		outputLabel.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 17));
		outputLabel.setBounds(129, 210, 198, 22);
		frame.getContentPane().add(outputLabel);
		
		JTextPane outputPane = new JTextPane();
		outputPane.setBackground(new Color(248, 248, 255));
		outputPane.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 13));
		outputPane.setBounds(178, 241, 105, 45);
		frame.getContentPane().add(outputPane);
		frame.setBounds(100, 100, 640, 459);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		StyledDocument outputPaneDoc = outputPane.getStyledDocument();
		SimpleAttributeSet outputPaneCenter = new SimpleAttributeSet();
		StyleConstants.setAlignment(outputPaneCenter, StyleConstants.ALIGN_CENTER);
		outputPaneDoc.setParagraphAttributes(0, outputPaneDoc.getLength(), outputPaneCenter, false);
		
		JLabel startVariableLabel = new JLabel("Start Variable");
		startVariableLabel.setVerticalAlignment(SwingConstants.TOP);
		startVariableLabel.setToolTipText("");
		startVariableLabel.setHorizontalAlignment(SwingConstants.CENTER);
		startVariableLabel.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 17));
		startVariableLabel.setBounds(129, 307, 198, 22);
		frame.getContentPane().add(startVariableLabel);
		
		JTextPane startVariablePane = new JTextPane();
		startVariablePane.setBackground(new Color(248, 248, 255));
		startVariablePane.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 13));
		startVariablePane.setBounds(178, 340, 105, 45);
		frame.getContentPane().add(startVariablePane);
		StyledDocument starVariablePaneDoc = startVariablePane.getStyledDocument();
		SimpleAttributeSet startVariablePaneCenter = new SimpleAttributeSet();
		StyleConstants.setAlignment(startVariablePaneCenter, StyleConstants.ALIGN_CENTER);
		starVariablePaneDoc.setParagraphAttributes(0, starVariablePaneDoc.getLength(), startVariablePaneCenter, false);
		
		JLabel resultLabel = new JLabel("Result");
		resultLabel.setVerticalAlignment(SwingConstants.TOP);
		resultLabel.setToolTipText("");
		resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
		resultLabel.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 17));
		resultLabel.setBounds(416, 307, 198, 22);
		frame.getContentPane().add(resultLabel);
		
		
		JTextPane resultPane = new JTextPane();
		resultPane.setBackground(new Color(248, 248, 255));
		resultPane.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 13));
		resultPane.setBounds(461, 340, 105, 45);
		frame.getContentPane().add(resultPane);
		StyledDocument resultPaneDoc = resultPane.getStyledDocument();
		SimpleAttributeSet resultPaneCenter = new SimpleAttributeSet();
		StyleConstants.setAlignment(resultPaneCenter, StyleConstants.ALIGN_CENTER);
		resultPaneDoc.setParagraphAttributes(0, resultPaneDoc.getLength(), resultPaneCenter, false);
		
		JButton checkOutputButton = new JButton("Check Output");
		checkOutputButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				HashTable table = new HashTable();
				String grammar = grammarPane.getText();
				String output = outputPane.getText();
				String startVariable = startVariablePane.getText();
				String grammarArray[] = grammar.split("\\r?\\n");
				String arrow = "->";
				for (int a = 0; a < grammarArray.length; a++)
					System.out.print(grammarArray[a]);
				
				System.out.println();
				
				for (int i = 0; i < grammarArray.length; i++)
				{
					String grammarLine = grammarArray[i];
					String leftSideElement = grammarLine.substring(0,grammarLine.indexOf(arrow));
					String rightSideElements = grammarLine.substring(leftSideElement.length()+arrow.length());
					System.out.println(leftSideElement);
					System.out.println(rightSideElements);
					String rightSideArray[] = rightSideElements.split(",");
					
					for (int x = 0; x < rightSideArray.length; x++)
					{
						String currElement = rightSideArray[x];
						table.insert(currElement,leftSideElement);
					}

				}
				
				//Now that the table has been completely filled out, send the table to the 
				//other program to check if the output can be generated by the grammar
				
				boolean canBeGenerated = Run.checkInput(table, output, startVariable);
				
				if (canBeGenerated)
				{
					resultPane.setText("Yes");
				}
				else
				{
					resultPane.setText("No");
				}
			}
			
		});
		checkOutputButton.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 15));
		checkOutputButton.setBackground(new Color(154, 205, 50));
		checkOutputButton.setBounds(440, 241, 139, 35);
		frame.getContentPane().add(checkOutputButton);
		

	}
}
