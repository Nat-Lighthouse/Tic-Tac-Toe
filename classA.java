import javax.swing.*;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.*;
import java.awt.event.*;

public class classA extends JPanel implements ActionListener
{
   final String LEGEND = "Legend";
   private String[] buttonNames = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
   private JButton[] button = new JButton[9];
   
   private Font Classy = new Font("Arial", Font.BOLD, 30);
   private Font small = new Font("Arial", Font.BOLD, 25);
   private Font player = new Font("Arial", Font.BOLD, 10);
   private Font legend = new Font("Arial", Font.BOLD, 15);
   private Font other = new Font("Arial", Font.BOLD, 13);
   
   private JPanel board = new JPanel();
   private JPanel p1 = new JPanel();
   private JPanel p2 = new JPanel();
   int count = 0, score1 = 0, score2 = 0;
   
   //player names
   private String player1 = "Player 1";
   private String player2 = "Player 2";
   
   //PLAYER 1
   //connections
   int frt = 0, snd = 0, trd = 0;   //horizontal
   int vertA = 0, vertB = 0, vertC = 0;   //vertical
   int diagA = 0, diagB = 0;  //diagonal
   
   //limiter
   int countA = 0, countB = 0, countC = 0;   //horizontal
   int countD = 0, countE = 0, countF = 0;   //vertical
   int countG = 0, countH = 0;   //diagonal
  
  /*_________________________________________________________________*/
   
   //PLAYER 2
   //connections
   int frt2 = 0, snd2 = 0, trd2 = 0;   //horizontal
   int vertA2 = 0, vertB2 = 0, vertC2 = 0;   //vertical
   int diagA2 = 0, diagB2 = 0;  //diagonal
   
   //limiter
   int countA2 = 0, countB2 = 0, countC2 = 0;   //horizontal
   int countD2 = 0, countE2 = 0, countF2 = 0;   //vertical
   int countG2 = 0, countH2 = 0;   //diagonal
   
   public classA()
   {
      setLayout(null);
      buttons();
      add(p1);
      add(p2);
      add(board);
      p1.setBounds(265, 7, 10, 10);
      p2.setBounds(265, 22, 10, 10);
      board.setBounds(25, 105, 230, 175);
      board.setBackground(Color.WHITE);
      p1.setBackground(Color.GREEN);
      p2.setBackground(Color.RED);
      p1.setVisible(true);
      p2.setVisible(false);
   }
   
   public void buttons()
   {
      for(int i = 0; i<button.length; i++)
      {
         button[i] = new JButton(buttonNames[i]);
         add(button[i]);
         button[i].addActionListener(this);
      }
      //1st row
      button[0].setBounds(40, 120, 60, 40);
      button[1].setBounds(110, 120, 60, 40);
      button[2].setBounds(180, 120, 60, 40);
      //2nd row
      button[3].setBounds(40, 170, 60, 40);
      button[4].setBounds(110, 170, 60, 40);
      button[5].setBounds(180, 170, 60, 40);
      //3rd row
      button[6].setBounds(40, 220, 60, 40);
      button[7].setBounds(110, 220, 60, 40);
      button[8].setBounds(180, 220, 60, 40);
   }
   
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      g.setFont(Classy);
      g.setColor(Color.BLACK);
      g.drawString("Tic Tac Toe", 60, 60);
      g.setFont(small);
      g.setColor(Color.BLACK);
      g.drawString("Choose one button", 30, 100);   
      g.setFont(player);
      g.drawString(player1, 220, 15);
      g.drawString(player2, 220, 31);
      g.setFont(legend);
      g.drawString(LEGEND + ":", 40, 300);
      g.setFont(other);
      g.drawString(player1 + " =", 120, 320);
      g.drawString(player2 + " =", 120, 340);
      g.setColor(Color.GREEN);
      g.drawString("X", 190, 320);
      g.setColor(Color.RED);
      g.drawString("O", 190, 340);
      g.setColor(Color.BLACK);
      g.drawRect(110, 300, 100, 50);
   }
   
   public void actionPerformed(ActionEvent e)
   {
      Object source = e.getSource();
      
      for(int i = 0; i<button.length; i++)
      {
         if(source == button[i])
         {
            button[i].setEnabled(false);
         }
      }
      count++;
      
      if(count % 2 == 0)
      {  
         p1.setVisible(true);
         p2.setVisible(false);
         if(source == button[0])
         {
            button[0].setText("O");
            frt2++;
            vertA2++;
            diagA2++;
         }
         else if(source == button[1])
         {
            button[1].setText("O");
            frt2++;
            vertB2++;
         }
         else if(source == button[2])
         {
            button[2].setText("O");
            frt2++;
            vertC2++;
            diagB2++;
         }
         else if(source == button[3])
         {
            button[3].setText("O");
            snd2++;  
            vertA2++;
         }
         else if(source == button[4])
         {
            button[4].setText("O");
            snd2++;
            vertB2++;
            diagA2++;
            diagB2++;
         }
         else if(source == button[5])
         {
            button[5].setText("O");
            snd2++;
            vertC2++;
         }
         else if(source == button[6])
         {
            button[6].setText("O");
            trd2++;
            vertA2++;
            diagB2++;
         }
         else if(source == button[7])
         {
            button[7].setText("O");
            trd2++;
            vertB2++;
         }
         else if(source == button[8])
         {
            button[8].setText("O");
            trd2++;
            vertC2++;
            diagA2++;
         }
      }
      else
      {
         p1.setVisible(false);
         p2.setVisible(true);
         if(source == button[0])
         {
            button[0].setText("X");
            frt++;
            vertA++;
            diagA++;
         }
         else if(source == button[1])
         {
            button[1].setText("X");
            frt++;
            vertB++;
         }
         else if(source == button[2])
         {
            button[2].setText("X");
            frt++;
            vertC++;
            diagB++;
         }
         else if(source == button[3])
         {
            button[3].setText("X");
            snd++;  
            vertA++;
         }
         else if(source == button[4])
         {
            button[4].setText("X");
            snd++;
            vertB++;
            diagA++;
            diagB++;
         }
         else if(source == button[5])
         {
            button[5].setText("X");
            snd++;
            vertC++;
         }
         else if(source == button[6])
         {
            button[6].setText("X");
            trd++;
            vertA++;
            diagB++;
         }
         else if(source == button[7])
         {
            button[7].setText("X");
            trd++;
            vertB++;
         }
         else if(source == button[8])
         {
            button[8].setText("X");
            trd++;
            vertC++;
            diagA++;
         }
      }
   
      /*_____________________________________________________________________________*/
   
      //PLAYER 1
      //Counter Output
      //horizontal
      if(frt == 3)
      {
         countA++;
      }
      if(snd == 3)
      {
         countB++;
      }
      if(trd == 3)
      {
         countC++;
      }
      //vertical
      if(vertA == 3)
      {
         countD++;
      }
      else if(vertB == 3)
      {
         countE++;
      }
      else if(vertC == 3)
      {
         countF++;
      }
      //diagonal
      if(diagA == 3)
      {
         countG++;   
      }
      else if(diagB == 3)
      {
         countH++;
      }
      
      //PLAYER 2
      //Counter Output
      //horizontal
      if(frt2 == 3)
      {
         countA2++;
      }
      if(snd2 == 3)
      {
         countB2++;
      }
      if(trd2 == 3)
      {
         countC2++;
      }
      //vertical
      if(vertA2 == 3)
      {
         countD2++;
      }
      else if(vertB2 == 3)
      {
         countE2++;
      }
      else if(vertC2 == 3)
      {
         countF2++;
      }
      //diagonal
      if(diagA2 == 3)
      {
         countG2++;   
      }
      else if(diagB2 == 3)
      {
         countH2++;
      }
      
      
      //PLAYER 1
      //limiter
      //horizal
      if(countA == 1)
      {  
         score1++;
         winRes1();
      }
      if(countB == 1)
      {
         score1++;
         winRes1();
      }
      if(countC == 1)
      {
         score1++;
         winRes1();
      }
      //vertical
      if(countD == 1)
      {
         score1++;
         winRes1();
      }
      if(countE == 1)
      {
         score1++;
         winRes1();
      }
      if(countF == 1)
      {
         score1++;
         winRes1();
      }
      //diagonal
      if(countG == 1)
      {
         score1++;
         winRes1();
      }
      if(countH == 1)
      {
         score1++;
         winRes1();
      }
      
      //PLAYER 2
      //limiter
      //horizal
      if(countA2 == 1)
      {  
         score2++;
         winRes2();
      }
      if(countB2 == 1)
      {
         score2++;
         winRes2();
      }
      if(countC2 == 1)
      {
         score2++;
         winRes2();
      }
      //vertical
      if(countD2 == 1)
      {
         score2++;
         winRes2();
      }
      if(countE2 == 1)
      {
         score2++;
         winRes2();
      }
      if(countF2 == 1)
      {
         score2++;
         winRes2();
      }
      //diagonal
      if(countG2 == 1)
      {
         score2++;
         winRes2();
      }
      if(countH2 == 1)
      {
         score2++;
         winRes2();
      }
   }
   
  
   public void restart()
   {
      for(int i = 0; i<button.length; i++)
      {
         button[i].setEnabled(true);
         button[i].setText(buttonNames[i]);
      }
      //PLAYER 1
      //connections
      frt = 0; snd = 0; trd = 0;   //horizontal
      vertA = 0; vertB = 0; vertC = 0;   //vertical
      diagA = 0; diagB = 0;  //diagonal
   
   //limiter
      countA = 0; countB = 0; countC = 0;   //horizontal
      countD = 0; countE = 0; countF = 0;   //vertical
      countG = 0; countH = 0;   //diagonal
      /*________________________________________________*/
      //PLAYER 2
      //connections
      frt2 = 0; snd2 = 0; trd2 = 0;   //horizontal
      vertA2 = 0; vertB2 = 0; vertC2 = 0;   //vertical
      diagA2 = 0; diagB2 = 0;  //diagonal
   
   //limiter
      countA2 = 0; countB2 = 0; countC2 = 0;   //horizontal
      countD2 = 0; countE2 = 0; countF2 = 0;   //vertical
      countG2 = 0; countH2 = 0;   //diagonal
      /*____________________________________________________*/
   }
   
   public void fullRes()
   {
      for(int i = 0; i<button.length; i++)
      {
         button[i].setEnabled(true);
         button[i].setText(buttonNames[i]);
      }
      //PLAYER 1
      //connections
      frt = 0; snd = 0; trd = 0;   //horizontal
      vertA = 0; vertB = 0; vertC = 0;   //vertical
      diagA = 0; diagB = 0;  //diagonal
   
   //limiter
      countA = 0; countB = 0; countC = 0;   //horizontal
      countD = 0; countE = 0; countF = 0;   //vertical
      countG = 0; countH = 0;   //diagonal
      /*________________________________________________*/
      //PLAYER 2
      //connections
      frt2 = 0; snd2 = 0; trd2 = 0;   //horizontal
      vertA2 = 0; vertB2 = 0; vertC2 = 0;   //vertical
      diagA2 = 0; diagB2 = 0;  //diagonal
   
   //limiter
      countA2 = 0; countB2 = 0; countC2 = 0;   //horizontal
      countD2 = 0; countE2 = 0; countF2 = 0;   //vertical
      countG2 = 0; countH2 = 0;   //diagonal
      /*____________________________________________________*/
      //scores
      score1 = 0; score2 = 0;
   }
   
   
   //JOptionPane
   public void reset()
   {
      int choice;
      choice = JOptionPane.showConfirmDialog(null, "You Will Lose your Score Data, Do You still Wish to Reset?", 
                                             "RESET?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
      if(choice == 0)
      {
         JOptionPane.showMessageDialog(null, "Successfully Reset!", "RESET", 
                                       JOptionPane.INFORMATION_MESSAGE);
         fullRes();
      }
      else if(choice == 1)
      {
         JOptionPane.showMessageDialog(null, "Reset has been Canceled!", "CANCELED", 
                                       JOptionPane.ERROR_MESSAGE);
         JOptionPane.showMessageDialog(null, "Click \"Play Again\" button in the Menu is the best choice if you're stucked", 
                                       "HINT!", JOptionPane.INFORMATION_MESSAGE);
      }
   }
   
   public void scores()
   {
      JOptionPane.showMessageDialog(null, "[(Player 1) Score: " + score1 + "]" + 
                                    "    [(Player 2) Score: " + score2 + "]",  "PLAYER SCORES" , JOptionPane.INFORMATION_MESSAGE);  
   }

   public void win1()
   {
      JOptionPane.showMessageDialog(null, "Player 1 WIN!", "WINNER", 
                                    JOptionPane.INFORMATION_MESSAGE);
   }
   
   public void win2()
   {
      JOptionPane.showMessageDialog(null, "Player 2 WIN!", "WINNER", 
                                    JOptionPane.INFORMATION_MESSAGE);
   }
   
   public void winRes1()
   {
      win1();
      restart();
   }
   
   public void winRes2()
   {
      win2();
      restart();
   }
   
}