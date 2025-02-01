import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

	public class Tic_Tac_Toe_Game extends JFrame implements ActionListener {
		private JButton[] gridButtons = new JButton[9];
	    private boolean isXTurn = true;

	    public Tic_Tac_Toe_Game() {
	        setTitle("Simple Tic Tac Toe");
	        setSize(500, 500);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLayout(new GridLayout(3, 3));
	        
	        initializeGrid();
	        setVisible(true);
	    }

	    private void initializeGrid() {
	        for (int i = 0; i < 9; i++) {
	            gridButtons[i] = new JButton("");
	            gridButtons[i].setFont(new Font("Arial", Font.PLAIN, 60));
	            gridButtons[i].setFocusPainted(false);
	            gridButtons[i].addActionListener(this);
	            add(gridButtons[i]);
	        }
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        JButton clickedButton = (JButton) e.getSource();
	        if (clickedButton.getText().equals("")) {
	            clickedButton.setText(isXTurn ? "X" : "O");
	            isXTurn = !isXTurn;
	            checkWinner();
	        }
	    }

	    private void checkWinner() {
	        int[][] winningPositions = {
	            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, 
	            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, 
	            {0, 4, 8}, {2, 4, 6}             
	        };

	        for (int[] position : winningPositions) {
	            if (gridButtons[position[0]].getText().equals(gridButtons[position[1]].getText()) &&
	                gridButtons[position[1]].getText().equals(gridButtons[position[2]].getText()) &&
	                !gridButtons[position[0]].getText().equals("")) {
	                showWinningMessage(gridButtons[position[0]].getText());
	                resetGrid();
	                return;
	            }
	        }

	        boolean isDraw = true;
	        for (JButton button : gridButtons) {
	            if (button.getText().equals("")) {
	                isDraw = false;
	                break;
	            }
	        }
	        if (isDraw) {
	            showWinningMessage("No one");
	            resetGrid();
	        }
	    }

	    private void showWinningMessage(String winner) {
	        JOptionPane.showMessageDialog(null, winner + " wins!");
	    }

	    private void resetGrid() {
	        for (JButton button : gridButtons) {
	            button.setText("");
	        }
	        isXTurn = true;
	    }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new Tic_Tac_Toe_Game();

		

	}

}
