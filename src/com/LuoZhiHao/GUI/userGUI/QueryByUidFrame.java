package com.LuoZhiHao.GUI.userGUI;

import com.LuoZhiHao.model.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class QueryByUidFrame extends JFrame{
    private JPanel contentPane;
    private JTextField idJTextField;
    private JTable jTable;

    public QueryByUidFrame() {
        setTitle("输入编号查询员工");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 180);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblId = new JLabel("员工编号:");
        lblId.setFont(new Font("黑体", Font.PLAIN, 16));
        lblId.setBounds(80, 48, 100, 15);
        contentPane.add(lblId);

        idJTextField = new JTextField();
        idJTextField.setBounds(155, 46, 166, 21);
        contentPane.add(idJTextField);
        idJTextField.setColumns(10);

        JButton buttonSearch = new JButton("查询");
        buttonSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SearchActionPerformed(e);
            }
        });
        buttonSearch.setBounds(169, 96, 93, 23);
        contentPane.add(buttonSearch);
    }

    public QueryByUidFrame(JTable jTable){
        super();
        this.jTable = jTable;
        setTitle("输入编号查询员工");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 180);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblId = new JLabel("员工编号:");
        lblId.setFont(new Font("黑体", Font.PLAIN, 16));
        lblId.setBounds(80, 48, 100, 15);
        contentPane.add(lblId);

        idJTextField = new JTextField();
        idJTextField.setBounds(155, 46, 166, 21);
        contentPane.add(idJTextField);
        idJTextField.setColumns(10);

        JButton buttonSearch = new JButton("查询");
        buttonSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SearchActionPerformed(e);
            }
        });
        buttonSearch.setBounds(169, 96, 93, 23);
        contentPane.add(buttonSearch);
    }

    private void SearchActionPerformed(ActionEvent e) {
        try {
            jTable.clearSelection();
            int id=Integer.parseInt(this.idJTextField.getText());
            SimpleTableModel<User> simpleTableModel=(SimpleTableModel<User>)jTable.getModel();
            List<User> rows=simpleTableModel.getRows();
            int index=-1;
            for(int i=0;i<rows.size();i++)
            {
                if(id==rows.get(i).getuId()) index=i;
            }
            if(index==-1) {
                JOptionPane.showMessageDialog(this, "查询失败，不存在此员工", "查询失败",JOptionPane.WARNING_MESSAGE );
            }
            else {
                jTable.changeSelection(index, 0, false, false);
            }
        } catch (Exception ex) {
            // TODO: handle exception
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "查询失败，系统出错", "查询失败",JOptionPane.ERROR_MESSAGE );
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    QueryByUidFrame frame = new QueryByUidFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
