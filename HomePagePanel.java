import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;

public class HomePagePanel
{
   public static void main(String[] args)
   { 
      JFrame frame = new JFrame("CROSSY GALLUS");
      //frame.setSize(600, 430);
      frame.setLocation(20, 20);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new HomeSwapPanel(frame));  //Pass "frame" to PanelSwapPanel so it can give frame commands (!)
      frame.pack();  //Allow PanelSwapPanel to decide the size
      frame.setVisible(true);
   }
}

class HomeSwapPanel extends JPanel
{
   private JFrame myOwner;  //The JFrame that contains this panel (!)
   
   private SwapperOne subOne;  //A subpanel that will get swapped out for...
   private SwapperTwo subTwo;  //...a different subpanel
   private SwapperThree subThree;
   private SwapperFour subFour; 
    //for picture
   

   public HomeSwapPanel(JFrame f)
   {
      myOwner = f;  //Store a reference to the JFrame that I belong to (!)
      
      //Add some text in the north
//       setLayout(new GridLayout(3, 1));
//       add(new JLabel("Why is this the same? Welcome to the Gallus Game!"));
//       add(new JLabel("The Gallus Gallus Domesticus, otherwise known as the chicken, needs to cross the road (don't ask why...)"));
      
      //Make and add first subpanel
      subOne = new SwapperOne(this);  //Pass **MYSELF** to SwapperOne (!)
      add(subOne);
      
      subTwo = new SwapperTwo(this);
      subThree = new SwapperThree(this);
      subFour = new SwapperFour(this);
      //We **don't** add subTwo!  Just make sure it's ready.
   }
   public void switchSubpanels1()
   {
      //All of these commands are necessary, in this order, to remove a subpanel,
      //add another one, then cause the JFrame to figure itself out again, including
      //resizing if necessary.  If you leave something out, you'll get weird behavior.
      remove(subOne);
      add(subTwo);
      repaint();
      revalidate();
      myOwner.pack(); 
      subTwo.start(); //FOR EasyMODE
      //Again, note - I'm giving the JFrame that contains this panel a command! (!)
   }

   public void RESETswitchSubpanels1()
   {
      //All of these commands are necessary, in this order, to remove a subpanel,
      //add another one, then cause the JFrame to figure itself out again, including
      //resizing if necessary.  If you leave something out, you'll get weird behavior.
      //remove(subOne);
      remove(subTwo);
      //add(subTwo);
      add(subOne);
      repaint();
      revalidate();
      myOwner.pack(); 
      subTwo.start(); //FOR EasyMODE
      //Again, note - I'm giving the JFrame that contains this panel a command! (!)
   }

   
   public void switchSubpanels2()
   {
      remove(subOne);
      add(subThree);
      repaint();
      revalidate();
      myOwner.pack();  //Again, note - I'm giving the JFrame that contains this panel a command! (!)
      subThree.start(); //FOR MediumMODE
   }


   public void RESETswitchSubpanels2()
   {
      //remove(subOne);
      remove(subThree);
      //add(subThree);
      add(subOne);
      repaint();
      revalidate();
      myOwner.pack();  //Again, note - I'm giving the JFrame that contains this panel a command! (!)
      subThree.start(); //FOR MediumMODE
   }
   
   public void switchSubpanels3()
   {
      remove(subOne);
      add(subFour);
      repaint();
      revalidate();
      myOwner.pack();  //Again, note - I'm giving the JFrame that contains this panel a command! (!)
      subFour.start(); //FOR HardMODE
   }
   public void RESETswitchSubpanels3()
   {
      remove(subFour);
      add(subOne);
      repaint();
      revalidate();
      myOwner.pack();  //Again, note - I'm giving the JFrame that contains this panel a command! (!)
      subFour.start(); //FOR HardMODE
   }


}

class SwapperOne extends JPanel
{
   private HomeSwapPanel myOwner;  //The PanelSwapPanel that contains this panel (!)
      
   public SwapperOne(HomeSwapPanel p)
   {
      myOwner = p;  //Store a reference to the PanelSwapPanel that I belong to (!)
      //setFont(new Font("Serif", Font.PLAIN, 40));
      setPreferredSize(new Dimension(1000, 500)); //Set size here.
      setBackground(new Color(152, 255, 150)); //background
      
      //new Font("Serif", Font.PLAIN, 8)
      //new Font("SansSerif", Font.BOLD, 20)
      //new Font("Monospaced", Font.ITALIC, 12)
      //new Font("Arial", Font.BOLD | Font.ITALIC, 60)
      
      setLayout(new BorderLayout());
      JLabel banana = new JLabel("Welcome to. . . CROSSY GALLUS"); //Why is this the same? Welcome to the gallus game!
      //banana.setColor(Color.BLACK); --> why isn't it working? 
      banana.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 50));      
      banana.setHorizontalAlignment(SwingConstants.CENTER);
      add(banana, BorderLayout.NORTH);
      
      // JLabel image = new JLabel("IMAGE = soon!"); //REPLACE WITH IMAGE LATER 
//       image.setFont(new Font("SansSerif", Font.PLAIN, 50));
//       image.setHorizontalAlignment(SwingConstants.CENTER);
//       add(image, BorderLayout.EAST);
      
      ImageIcon image1 = new ImageIcon("homepageGallus.png");
      Image getBigger = image1.getImage();
      Image getBiggerPlease = getBigger.getScaledInstance(450, 450, java.awt.Image.SCALE_SMOOTH);
      image1 = new ImageIcon(getBiggerPlease);
      //frame.add(new JLabel(image1));
      add(new JLabel(image1), BorderLayout.EAST);
      //frame.pack();
      
//       JImage image1 = new JImage("homepageGallus.png"); 
//       add(image1, BorderLayout.EAST);
      
      
      
      JPanel longLeftPanel = new JPanel();
      longLeftPanel.setLayout(new GridLayout(9, 1));
      longLeftPanel.setBackground(new Color(152, 255, 150));
      
      //setFont(new Font("Serif", Font.PLAIN, 10));
      
      JLabel berry = new JLabel("The Gallus Gallus Domesticus, otherwise known as the");
      berry.setFont(new Font("SansSerif", Font.PLAIN, 20));
      berry.setVerticalAlignment(JLabel.BOTTOM);
      longLeftPanel.add(berry);
      
      JLabel grape = new JLabel(" chicken, needs to cross the road (don't ask why...).");
      grape.setFont(new Font("SansSerif", Font.PLAIN, 20));
      grape.setVerticalAlignment(JLabel.TOP);
      longLeftPanel.add(grape);
      
      JLabel peach = new JLabel("It is now YOUR task to help the gallus cross the road!");
      peach.setFont(new Font("SansSerif", Font.PLAIN, 20));
      peach.setVerticalAlignment(JLabel.BOTTOM);
      longLeftPanel.add(peach);
      
      JLabel rose = new JLabel("Remember, a life is in your hands. ^_~");
      rose.setFont(new Font("SansSerif", Font.PLAIN, 20));
      rose.setVerticalAlignment(JLabel.TOP);
      longLeftPanel.add(rose);
      
      JLabel lion = new JLabel("Press the UP arrow to jump!");
      lion.setFont(new Font("SansSerif", Font.BOLD, 25));
      //lion.setVerticalAlignment(JLabel.CENTER);
      longLeftPanel.add(lion);
      
      JLabel empty2 = new JLabel("");
      add(empty2, BorderLayout.CENTER);
      
      //setLayout (new GridLayout(4, 1));
      
      JLabel orange = new JLabel("Choose a difficulty to start:"); //part 4, difficulty chosen
      orange.setFont(new Font("Arial", Font.PLAIN, 25));
      longLeftPanel.add(orange);
      
      JButton switcheroo1 = new JButton("EASY");
      switcheroo1.addActionListener(new SwitchListenerEasy());
      switcheroo1.setFont(new Font("Arial", Font.PLAIN, 25)); //font

      //for my dumb mac
      switcheroo1.setOpaque(true);
      switcheroo1.setBorderPainted(true);


      switcheroo1.setBackground(new Color(255, 200, 0)); //background color
      switcheroo1.setForeground(Color.WHITE); //foreground (text?)
      longLeftPanel.add(switcheroo1);
      
      JButton switcheroo2 = new JButton("MEDIUM"); //medium button
      switcheroo2.addActionListener(new SwitchListenerMed());
      switcheroo2.setFont(new Font("SansSerif", Font.BOLD, 25));

      //for my dumb mac
      switcheroo2.setOpaque(true);
      switcheroo2.setBorderPainted(true);

      switcheroo2.setBackground(new Color(0, 136, 255));
      switcheroo2.setForeground(Color.WHITE);
      longLeftPanel.add(switcheroo2);
      
      JButton switcheroo3 = new JButton("HARD"); //hard button
      switcheroo3.addActionListener(new SwitchListenerHard());
      switcheroo3.setFont(new Font("Monospaced", Font.BOLD, 30));

      //for my dumb mac
      switcheroo3.setOpaque(true);
      switcheroo3.setBorderPainted(true);

      switcheroo3.setBackground(new Color(255, 0, 0));
      switcheroo3.setForeground(Color.WHITE);      
      longLeftPanel.add(switcheroo3);     
      
      add(longLeftPanel, BorderLayout.WEST);
      
      //JLabel empty = new JLabel("");  //Use an empty label to fill the bottom center space...
      //add(empty, BorderLayout.SOUTH);


      //RESET BUTTON

      JButton revive = new JButton("REVIVE THE CHICKENS");
      //reset.addActionListener(new reset());
      //reset.preferredSize();
      revive.setBounds(500,500,200,100);
      revive.setEnabled(true);
      //add(reset);
      add(revive, BorderLayout.SOUTH);


   }

   private class SwitchListenerEasy implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         myOwner.switchSubpanels1();  //Send a command to the PanelSwapPanel that contains this one (!)
      }
   }
   
   private class SwitchListenerMed implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         myOwner.switchSubpanels2();  //Send a command to the PanelSwapPanel that contains this one (!)
      }
   }
   
   private class SwitchListenerHard implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         myOwner.switchSubpanels3();  //Send a command to the PanelSwapPanel that contains this one (!)
      }
   }

   
}

class SwapperTwo extends JPanel
{
   private HomeSwapPanel myOwner;
   private KeyInputPanel game;
   public SwapperTwo(HomeSwapPanel p)
   {

      //setLayout(new GridLayout(2,1));
      //GridLayout grid = new GridLayout(2,1);
      myOwner=p;
      game = new KeyInputPanel(); //FOR EasyMODE
      add(game);

      setPreferredSize(new Dimension(500, 550));  //Different size!
   
      //RESET BUTTON

      JButton reset = new JButton("back to homepage");
      reset.addActionListener(new reset());
      //reset.preferredSize();
      reset.setBounds(200,100,200,100);
      reset.setEnabled(true);
      add(reset);

      //setLayout(new GridLayout(1, 1));
      //add(new JLabel("THIS IS WHERE THE NEW PANEL GOES... but do i have to start with a new panel/layout everytime?"));
   }
   public void start() //FOR EasyMODE
      {
         game.startTimer();
         game.requestFocus();
      }
        
      // private class reset implements ActionListener{
      //    public void actionPerformed(ActionEvent e){
      //   System.out.println("RESET");
      //    myOwner.RESETswitchSubpanels1();  //Send a command to the PanelSwapPanel that contains this one (!)

      // }

      // }

      private class reset implements ActionListener{
         public void actionPerformed(ActionEvent e){
        System.out.println("RESET");
        //game.stopMusic();
         myOwner.RESETswitchSubpanels1();  //Send a command to the PanelSwapPanel that contains this one (!)

         }
      }



}

class SwapperThree extends JPanel
{
   private HomeSwapPanel myOwner;
   private MediumKeyInputPanel game1;
   public SwapperThree(HomeSwapPanel p)
   {
      myOwner=p;
      game1 = new MediumKeyInputPanel(); //FOR EasyMODE
      add(game1);

      setPreferredSize(new Dimension(500, 550));  //Different size!
   
      //RESET BUTTON

      JButton reset = new JButton("back to homepage");
      reset.addActionListener(new reset());
      //reset.preferredSize();
      reset.setBounds(200,100,200,100);
      reset.setEnabled(true);
      add(reset);
      //setLayout(new GridLayout(1, 1));
      //add(new JLabel("THIS IS WHERE THE NEW PANEL GOES... but do i have to start with a new panel/layout everytime?"));
   }
   public void start() //FOR EasyMODE
      {
         game1.startTimer();
         game1.requestFocus();
      }
        
      // private class reset implements ActionListener{
      //    public void actionPerformed(ActionEvent e){
      //   System.out.println("RESET");
      //    myOwner.RESETswitchSubpanels1();  //Send a command to the PanelSwapPanel that contains this one (!)

      // }

      // }

      private class reset implements ActionListener{
         public void actionPerformed(ActionEvent e){
        System.out.println("RESET");
        //game.stopMusic();
         myOwner.RESETswitchSubpanels2();  //Send a command to the PanelSwapPanel that contains this one (!)

         }
      }
   


   }

class SwapperFour extends JPanel
{
   private HomeSwapPanel myOwner;
   private HardKeyInputPanel game2;
   public SwapperFour(HomeSwapPanel p)
   {
      myOwner=p;
      game2 = new HardKeyInputPanel(); //FOR EasyMODE
      add(game2);

      setPreferredSize(new Dimension(500, 550));  //Different size!
   
      //RESET BUTTON

      JButton reset = new JButton("back to homepage");
      reset.addActionListener(new reset());
      //reset.preferredSize();
      reset.setBounds(200,100,200,100);
      reset.setEnabled(true);
      add(reset);
      //setLayout(new GridLayout(1, 1));
      //add(new JLabel("THIS IS WHERE THE NEW PANEL GOES... but do i have to start with a new panel/layout everytime?"));
   }
   public void start() //FOR EasyMODE
      {
         game2.startTimer();
         game2.requestFocus();
      }
        
      // private class reset implements ActionListener{
      //    public void actionPerformed(ActionEvent e){
      //   System.out.println("RESET");
      //    myOwner.RESETswitchSubpanels1();  //Send a command to the PanelSwapPanel that contains this one (!)

      // }

      // }

      private class reset implements ActionListener{
         public void actionPerformed(ActionEvent e){
        System.out.println("RESET");
        //game.stopMusic();
         myOwner.RESETswitchSubpanels3();  //Send a command to the PanelSwapPanel that contains this one (!)

         }
      }
}