package userInterface;


import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;

public class GUI{
    public static void main(String args[])throws Exception{
        MyUberFrame frame1 = new MyUberFrame();
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// get it close
 
        frame1.setVisible(true);
    }
}
class MyUberFrame extends JFrame{
    private JLabel label1;
    private JLabel passwordLabel;
    private JButton button1;
    private JTextField text1;
    private JTextField password;
    private JComboBox box;
    private JMenuBar menuBar;
    private JSlider slider;
    private JSpinner spinner;
    private JToolBar toolBar;
    
    public MyUberFrame(){
        super();
        this.setSize(500,600);
        this.getContentPane().setLayout(null);//set layout
 
//        this.getContentPane().setLayout(new FlowLayout());//
 
//        this.getContentPane().setLayout(new GridLayout(1,2));//
 
//        this.getContentPane().setLayout(new BorderLayout());//
 
//        this.getContentPane().setLayout(new GridBagLayout());//
 
        this.add(this.getTextField(),null);// text
        this.add(this.getPassword(),null);
 
        this.add(this.getButton(),null);//bouton
 
        this.add(this.getLabel(),null);//
        this.add(this.getPasswordLabel(),null);
 
        this.add(this.getBox(),null);//
 
        this.setJMenuBar(this.getMenu());//
 
//        this.add(this.getSlider(),null);
        //this.add(this.getSpinner(),null);
//        this.add(this.getToolBar(),null);
        this.setTitle("MyUber");//
 
    }
    private JToolBar getToolBar(){
        if(toolBar==null){
            toolBar = new JToolBar();
            toolBar.setBounds(103,260,71,20);
            toolBar.setFloatable(true);
        }
        return toolBar;
    }
    
    /**
    private JSpinner getSpinner(){
        if(spinner==null){
            spinner = new JSpinner();
            spinner.setBounds(103,220, 80,20);
            spinner.setValue(100);
        }
        return spinner;
    }
    */
    
    private JSlider getSlider(){
        if(slider==null){
            slider = new JSlider();
            slider.setBounds(103,200,100, 20);
            slider.setMaximum(100);
            slider.setMinimum(0);
            slider.setOrientation(0);
            slider.setValue(0);
        }
        return slider;
    }

    private JMenuBar getMenu(){
        if(menuBar==null){
            menuBar = new JMenuBar();
            JMenu m1 = new JMenu();
            m1.setText("customer");
            JMenu m2 = new JMenu();
            m2.setText("driver");
            JMenu m3 = new JMenu();
            m3.setText("supervisor");
            
            JMenuItem item11 = new JMenuItem();
            item11.setText("book a ride");
            JMenuItem item12 = new JMenuItem();
            item12.setText("give remark");
            JMenuItem item13 = new JMenuItem();
            item13.setText("exit");
            
            JMenuItem item21 = new JMenuItem();
            item21.setText("accept book");
            JMenuItem item22 = new JMenuItem();
            item22.setText("offline");
            JMenuItem item23 = new JMenuItem();
            item23.setText("online");
            
            JMenuItem item31 = new JMenuItem();
            item31.setText("bla");
            JMenuItem item32 = new JMenuItem();
            item32.setText("blabla");
            JMenuItem item33 = new JMenuItem();
            item33.setText("blablabla");
            
            m1.add(item11);
            m1.add(item12);
            m1.add(item13);
            
            m2.add(item21);
            m2.add(item22);
            m2.add(item23);
            
            m3.add(item31);
            m3.add(item32);
            m3.add(item33);
            
            menuBar.add(m1);
            menuBar.add(m2);
            menuBar.add(m3);
        }
        return menuBar;
    }

    
    private JComboBox getBox(){
        if(box==null){
            box = new JComboBox();
            box.setBounds(103,140,71,27);
            box.addItem("1");
            box.addItem("2");
            box.addActionListener(new comboxListener());//
 
        }
        return box;
    }
    private class comboxListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Object o = e.getSource();
            System.out.println(o.toString());
        }
    }

/**
 * set label
 * @return
 */
    private JLabel getLabel(){
        if(label1==null){
            label1 = new JLabel();
            label1.setBounds(34,49,53,18);
            label1.setText("Login");
            label1.setToolTipText("JLabel login");
        }
        return label1;
    }
    
    private JLabel getPasswordLabel() {
    	if(passwordLabel==null){
            passwordLabel = new JLabel();
            passwordLabel.setBounds(34,72,53,18);
            passwordLabel.setText("password");
            passwordLabel.setToolTipText("JLabel password");
        }
        return passwordLabel;
    }

    
    private JButton getButton(){
        if(button1==null){
            button1 = new JButton();
            button1.setBounds(103,110,71,27);
            button1.setText("OK");
            button1.setToolTipText("OK");
            button1.addActionListener(new HelloButton());//
 
        }
        return button1;
    }


    // do action
    private class HelloButton implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.out.println("you click ok");
        }
    }
    
    
    private JTextField getTextField(){
        if(text1==null){
            text1 = new JTextField();
            text1.setBounds(96,49,160,20);
        }
        return text1;
    }
    private JTextField getPassword(){
        if(password==null){
            password = new JTextField();
            password.setBounds(96,73,160,20);
        }
        return password;
    }
}
