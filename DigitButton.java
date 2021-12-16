package guiSudoku;

import java.awt.event.*;
import javax.swing.*;

public class DigitButton extends JButton implements ActionListener{
	
	private Sudoku board;
	private SudokuFrame frame;
	
	public DigitButton(Sudoku b, SudokuFrame f) {
		board = b;
		frame = f;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(board.check(Integer.parseInt(getText()))) {
			frame.update();
		}
		if(board.delete_num(Integer.parseInt(getText()))==true)
			setEnabled(false);
}
}