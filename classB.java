/**
   Created By: Jonathan F Gubot
   Created On: January 19, 2021
*/

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;

public class classB extends JFrame implements ActionListener
{
   private JMenuBar mainBar = new JMenuBar();
   private JMenu menu = new JMenu("Menu");
   private JMenu color = new JMenu("Colors");
   private JMenu light = new JMenu("Light");
   private JMenu dark = new JMenu("Dark");
   private String[] lightNames = {"Blue", "Cyan", "Green", "Light Gray", "Magenta", "Orange", "Pink", "Red", "Yellow"};
   private String[] darkNames = {"Black", "Dark Gray", "Gray"};
   private JMenuItem[] lightColors = new JMenuItem[9]; //BLUE, CYAN, GREEN, LIGHT_GRAY, MAGENTA, ORANGE, PINK, RED, YELLOW
   private JMenuItem[] darkColors = new JMenuItem[3];  //BLACK, DARK_GRAY, GRAY
   private JMenuItem plain = new JMenuItem("Plain");
   private JMenuItem again = new JMenuItem("Play Again");
   private JMenuItem scores = new JMenuItem("Scores");
   private JMenuItem reset = new JMenuItem("Reset");
   private JMenuItem exit = new JMenuItem("Exit");        
         
   classA A = new classA();

   public classB()
   {
      setJMenuBar(mainBar);
      mainBar.add(menu);
      mainBar.add(color);
      menu.add(again);
      menu.add(scores);
      menu.add(reset);
      menu.add(exit);
      color.add(light);
      color.add(dark);
      color.add(plain);
      again.addActionListener(this);
      scores.addActionListener(this);
      reset.addActionListener(this);
      exit.addActionListener(this);
      plain.addActionListener(this);
      //method call
      arrays();
      add(A);
      /*_______________________________________________*/
      setVisible(true);
      setSize(300, 450);
      setResizable(false);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
   
   public void arrays()
   {
      for(int i = 0; i<lightColors.length; i++)
      {
         lightColors[i] = new JMenuItem(lightNames[i]);
         light.add(lightColors[i]);
         lightColors[i].addActionListener(this);   
      }
      for(int j = 0; j<darkColors.length; j++)
      {
         darkColors[j] = new JMenuItem(darkNames[j]);
         dark.add(darkColors[j]);
         darkColors[j].addActionListener(this);
      }
   }
   
   
   @Override
   public void actionPerformed(ActionEvent e)
   {
      Object source = e.getSource();
      
      //Change color for lightColors menu
      if(source == lightColors[0])
      {
         mainBar.setBackground(Color.BLUE);
         A.setBackground(Color.BLUE);
      }
      else if(source == lightColors[1])
      {
         mainBar.setBackground(Color.CYAN);
         A.setBackground(Color.CYAN);
      }
      else if(source == lightColors[2])
      {
         mainBar.setBackground(Color.GREEN);
         A.setBackground(Color.GREEN);
      }
      else if(source == lightColors[3])
      {
         mainBar.setBackground(Color.LIGHT_GRAY);
         A.setBackground(Color.LIGHT_GRAY);
      }
      else if(source == lightColors[4])
      {
         mainBar.setBackground(Color.MAGENTA);
         A.setBackground(Color.MAGENTA);
      }
      else if(source == lightColors[5])
      {
         mainBar.setBackground(Color.ORANGE);
         A.setBackground(Color.ORANGE);
      }
      else if(source == lightColors[6])
      {
         mainBar.setBackground(Color.PINK);
         A.setBackground(Color.PINK);
      }
      else if(source == lightColors[7])
      {
         mainBar.setBackground(Color.RED);
         A.setBackground(Color.RED);
      }
      else if(source == lightColors[8])
      {
         mainBar.setBackground(Color.YELLOW);
         A.setBackground(Color.YELLOW);
      }
      
      //Change color for darkColors menu
      if(source == darkColors[0])
      {
         mainBar.setBackground(Color.BLACK);
         A.setBackground(Color.BLACK);   
      }
      else if(source == darkColors[1])
      {
         mainBar.setBackground(Color.DARK_GRAY);
         A.setBackground(Color.DARK_GRAY);
      }
      else if(source == darkColors[2])
      {
         mainBar.setBackground(Color.GRAY);
         A.setBackground(Color.GRAY);
      }
      
      //Change color for plain Menu Item
      if(source == plain)
      {
         mainBar.setBackground(Color.WHITE);
         A.setBackground(Color.WHITE);
      }
      
      if(source == again)
      {
         A.restart();
      }
      
      if(source == scores)
      {
         A.scores();
      }
      
      if(source == reset)
      {
         A.reset();
      }
      
      if(source == exit)
      {
         System.exit(0);
      }
   }
   
   public static void main(String[] args)
   {
      new classB();
   }
}