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

public class UpdateUserFrame extends JFrame {
    private JPanel contentPane;
    private User user;
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

    public UpdateUserFrame(){
        setTitle("修改员工信息");
        initComponents();
    }

    public void initComponents(){
        setTitle("修改员工信息");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
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

        JButton buttonAdd = new JButton("更新");
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateUserActionPerformed(e);
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


    public UpdateUserFrame(User user) {
        super();
        initComponents();
        this.user = user;
        uId.setText(Integer.toString(user.getuId()));
        uName.setText(user.getuName());
        uPosition.setText(user.getuPosition());
        uGender.setText(user.getuGender());
        uTel.setText(user.getuTel());
        uBirthday.setText(user.getuBirthday());
        uAddress.setText(user.getuAddress());
        uPassword.setText(user.getuPassword());
    }

    private void updateUserActionPerformed(ActionEvent e) {
        UserServiceImpl userService = new UserServiceImpl();
        user.setuId(Integer.parseInt(this.uId.getText()));
        user.setuName(this.uName.getText());
        user.setuPosition(this.uPosition.getText());
        user.setuGender(this.uPosition.getText());
        user.setuTel(this.uTel.getText());
        user.setuBirthday(this.uBirthday.getText());
        user.setuAddress(this.uAddress.getText());
        user.setuPassword(this.uPassword.getText());
        try {
            userService.updateUser(user);
            JOptionPane.showMessageDialog(this, "修改成功");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "修改失败");
        }

    }
    private void cancelActionPerformed(ActionEvent e) {
        this.setVisible(false);
        this.dispose();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UpdateUserFrame frame = new UpdateUserFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
