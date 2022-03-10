package com.LuoZhiHao.GUI;

import com.LuoZhiHao.GUI.userGUI.MainFrame;
import com.LuoZhiHao.service.Impl.UserServiceImpl;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JPanel contentPane;
    private JTextField userTel;
    private JPasswordField userPassword;

    public Login(){
        setTitle("电视台信息管理系统");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200,200,450,250);
        CardLayout cardLayout = new CardLayout();

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(cardLayout);

        JPanel userPanel = new JPanel();
        contentPane.add(userPanel);
        userPanel.setLayout(null);

        userTel = new JTextField();
        userTel.setBounds(148,55,122,21);
        userPanel.add(userTel);
        userTel.setColumns(10);

        userPassword = new JPasswordField();
        userPassword.setBounds(148,96,122,21);
        userPanel.add(userPassword);

        JButton userButton1 =new JButton("登入");
        userButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userLoginActionPerformed(e);
            }
        });
        userButton1.setBounds(72,159,93,23);
        userPanel.add(userButton1);

        JButton userButton2 =new JButton("退出系统");
        userButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("成功退出系统");
                setVisible(false);
                dispose();
            }
        });
        userButton2.setBounds(220,159,93,23);
        userPanel.add(userButton2);


        JLabel label = new JLabel("用户名：");
        label.setBounds(72,58,54,15);
        userPanel.add(label);

        JLabel label1 = new JLabel("密码：");
        label1.setBounds(72,99,54,15);
        userPanel.add(label1);

    }

    private void userLoginActionPerformed(ActionEvent e) {
        String uTel = userTel.getText();
        String uPassword = userPassword.getText();
        UserServiceImpl userService = new UserServiceImpl();
        try {
            if (userService.certifyUser(uTel,uPassword)){
                JOptionPane.showMessageDialog(this,"登入成功！\n欢迎用户：" + userTel.getText() +
                        " 登入系统。","登入成功",JOptionPane.INFORMATION_MESSAGE);
                MainFrame mainFrame = new MainFrame();
                mainFrame.setBounds(600,400,800,600);
                mainFrame.setVisible(true);
                System.out.println("用户"+uTel +"登入成功");
                System.out.println("登入成功，正在关闭登入页面。");
                this.setVisible(false);
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(this,"登入失败，请检查手机号或密码是否正确！","登入失败",JOptionPane.ERROR_MESSAGE);
                System.out.println("登入失败请重新登入。");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this,"登入失败，系统内部错误！","登入失败",JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Login frame = new Login();
                frame.setVisible(true);
            }
        });
    }
}
