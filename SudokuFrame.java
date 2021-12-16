package guiSudoku;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SudokuFrame extends JFrame{
	
	private Sudoku board;
	private SudokuButton[][] button_board;
	private DigitButton[] digit_buttons;
	
	public SudokuFrame(Sudoku b) {
		board = b;
		button_board = new SudokuButton[9][9];
		digit_buttons = new DigitButton[9];
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		JPanel p1 = new JPanel(new GridLayout(9,9));
		for(int row = 0; row<9; row++) {
			for(int col = 0; col < 9; col++) {
				button_board[row][col] = new SudokuButton(b, row, col);
				String d = Integer.toString(board.getNumber(row,col));
				button_board[row][col].setText(d);
				p1.add(button_board[row][col]);
			}
		}
		
		JPanel p2 = new JPanel(new GridLayout(1,9));
		for(int i = 0; i <9; i++) {
			digit_buttons[i] = new DigitButton(board, this);
			digit_buttons[i].setText(Integer.toString(i+1));
			p2.add(digit_buttons[i]);
		}
		
		
		
		JLabel label = new JLabel();
		if(board.countHoles() == 36) {
			label.setText("Easy Mode");
		}
		else if(board.countHoles() == 45) {
			label.setText("Normal Mode");
		}
		else {
			label.setText("Hard Mode");
		}
		label.setFont(label.getFont().deriveFont(55.0f));
		label.setHorizontalAlignment(JLabel.CENTER);
		
		while(board.countHoles() == 0) {
			delete();
			
		}
		
		cp.add(p1, BorderLayout.NORTH);
		cp.add(p2, BorderLayout.SOUTH);
		cp.add(label);
		update();
		setTitle("Sudoku");
		setSize(400,400);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
	
	}
	
	public void update() {
		for(int row = 0; row<9; row++) {
			for(int col = 0; col < 9; col++) {
				int d = board.getNumber(row, col);
				if(d == 0)
					button_board[row][col].setText("");
				else
					button_board[row][col].setText(Integer.toString(d));
				}
			}
	}
	
	public void delete() {
		for(int i=0; i<9; i++) 
			for(int j = 0; j<9; j++) {
			int d = board.getNumber(i, i);
			if(board.counting(d)==9) {
				digit_buttons[d].setText("");
				digit_buttons[d].setRolloverEnabled(false);
				update();
			}
		}
	}

}
