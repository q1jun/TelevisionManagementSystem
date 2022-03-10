package com.LuoZhiHao.GUI.userGUI;

import com.LuoZhiHao.model.User;
import com.LuoZhiHao.service.Impl.UserServiceImpl;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertUserJFrame extends JFrame {
    private JPanel contentPane;
    //员工编号
    private JTextField uId;
    //员工姓名
    private JTextField uName;
    //员工职位
    private JTextField uPosition;
    //员工性别
    private JTextField uGender;
    //员工生日
    private JTextField uBirthday;
    //员工电话
    private JTextField uTel;
    //员工住址
    private JTextField uAddress;
    //员工的登入密码
    private JTextField uPassword;

    public InsertUserJFrame(){
        setTitle("插入员工信息");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100,100,426,600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel uIdLabel = new JLabel("员工编号：");
        uIdLabel.setBounds(91,60,66,15);
        contentPane.add(uIdLabel);
        uId = new JTextField();
        uId.setBounds(195,57,128,21);
        contentPane.add(uId);
        uId.setColumns(10);

        JLabel uNameLabel = new JLabel("员工姓名：");
        uNameLabel.setBounds(91,113,66,15);
        contentPane.add(uNameLabel);
        uName = new JTextField();
        uName.setBounds(195,110,128,21);
        contentPane.add(uName);
        uName.setColumns(10);

        JLabel uPositionLabel = new JLabel("职位：");
        uPositionLabel.setBounds(91,155,66,15);
        contentPane.add(uPositionLabel);
        uPosition = new JTextField();
        uPosition.setBounds(195,152,128,21);
        contentPane.add(uPosition);
        uPosition.setColumns(10);

        JLabel uGenderLabel = new JLabel("性别：");
        uGenderLabel.setBounds(91,203,66,15);
        contentPane.add(uGenderLabel);
        uGender = new JTextField();
        uGender.setBounds(195,200,128,21);
        contentPane.add(uGender);
        uGender.setColumns(10);

        JLabel uBirthdayLabel = new JLabel("员工出生日期：");
        uBirthdayLabel.setBounds(91,252,95,15);
        contentPane.add(uBirthdayLabel);
        uBirthday = new JTextField();
        uBirthday.setBounds(195,249,128,21);
        contentPane.add(uBirthday);
        uBirthday.setColumns(10);

        JLabel uTelLabel = new JLabel("电话号码：");
        uTelLabel.setBounds(91,303,66,15);
        contentPane.add(uTelLabel);
        uTel = new JTextField();
        uTel.setBounds(195,300,128,21);
        contentPane.add(uTel);
        uTel.setColumns(10);

        JLabel uAddressLabel = new JLabel("员工住址：");
        uAddressLabel.setBounds(91,353,66,15);
        contentPane.add(uAddressLabel);
        uAddress = new JTextField();
        uAddress.setBounds(195,350,128,21);
        contentPane.add(uAddress);
        uAddress.setColumns(10);

        JLabel uPasswordLabel = new JLabel("员工登入密码：");
        uPasswordLabel.setBounds(91,403,95,15);
        contentPane.add(uPasswordLabel);
        uPassword = new JTextField();
        uPassword.setBounds(195,400,128,21);
        contentPane.add(uPassword);
        uPassword.setColumns(10);

        JButton buttonAdd = new JButton("添加");
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    addUserActionPerformed(e);
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
            }
        });
        buttonAdd.setBounds(91,457,93,23);
        contentPane.add(buttonAdd);

        JButton buttonCancel = new JButton("取消");
        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cancelActionPerformed(e);
            }
        });
        buttonCancel.setBounds(230, 457, 93, 23);
        contentPane.add(buttonCancel);


    }

    private void cancelActionPerformed(ActionEvent e) {
        this.setVisible(false);
        this.dispose();
    }

    private void addUserActionPerformed(ActionEvent e) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = simpleDateFormat.parse(uBirthday.getText());
        User user = new User();
        UserServiceImpl userService = new UserServiceImpl();
        user.setuId(Integer.parseInt(uId.getText()));
        user.setuName(uName.getText());
        user.setuPosition(uPosition.getText());
        user.setuGender(uGender.getText());
        user.setuBirthday(uBirthday.getText());
        user.setuTel(uTel.getText());
        user.setuAddress(uAddress.getText());
        try {
            userService.addUser(user);
            JOptionPane.showMessageDialog(this,"添加用户 "+ user.getuName()+" 成功","添加成功",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this,"添加用户 "+ uName.getText()+" 失败","添加失败",JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InsertUserJFrame frame = new InsertUserJFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
