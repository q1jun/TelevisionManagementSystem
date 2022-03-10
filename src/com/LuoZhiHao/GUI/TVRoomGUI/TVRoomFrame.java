package com.LuoZhiHao.GUI.TVRoomGUI;

import com.LuoZhiHao.GUI.ADGUI.ADFrame;
import com.LuoZhiHao.GUI.ColumnGUI.ColumnFrame;
import com.LuoZhiHao.GUI.DispatchGUI.DispatchFrame;
import com.LuoZhiHao.GUI.userGUI.MainFrame;
import com.LuoZhiHao.model.TelevisionRoom;
import com.LuoZhiHao.service.Impl.TVRoomServiceImpl;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TVRoomFrame extends JFrame {
    private JPanel contentPane;
    private List<String> tvrCols;
    private List<TelevisionRoom> tvrRows;
    private TVRoomServiceImpl tvRoomService;
    private SimpleTableModel<TelevisionRoom> simpleTableModel;
    private JTable jTable;

    public TVRoomFrame(){
        setTitle("电视台信息管理系统");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600,400,800,600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setLayout(new BorderLayout(0,0));
        setContentPane(contentPane);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        tvrCols = new ArrayList<>();
        tvrCols.add("演播厅房间号");
        tvrCols.add("演播厅面积大小(mˆ2)");
        tvRoomService = new TVRoomServiceImpl();
        try {
            tvrRows = tvRoomService.getAllTvRoom();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        simpleTableModel = new SimpleTableModel<TelevisionRoom>(tvrCols, tvrRows);

        JLabel jLabel = new JLabel();
        jLabel.setText("演播厅信息表");
        jLabel.setFont(new Font("Lucida Grande", Font.PLAIN,36));
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(jLabel,BorderLayout.PAGE_START);
        JScrollPane jScrollPane = new JScrollPane();
        jTable = new JTable();

        jTable.setModel(simpleTableModel);
        jScrollPane.setViewportView(jTable);
        getContentPane().add(jScrollPane, BorderLayout.CENTER);

        JLabel jLabel2 = new JLabel();
        jLabel2.setText("Design BY LuoZhiHao ");
        getContentPane().add(jLabel2, BorderLayout.PAGE_END);

        JMenuBar jMenuBar = new JMenuBar();

        JMenu edit = new JMenu();
        edit.setText("编辑");
        edit.setToolTipText("");
        JMenuItem insert = new JMenuItem();
        insert.setText("插入数据");
        insert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertUserActionPerformed(e);
            }
        });
        edit.add(insert);

        JMenuItem update = new JMenuItem();
        update.setText("修改数据");
        update.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                updateUserActionPerformed(evt);
            }
        });
        edit.add(update);

        JMenuItem refresh = new JMenuItem();
        refresh.setText("刷新");
        refresh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        edit.add(refresh);

        JMenuItem delete = new JMenuItem("删除");
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delUserActionPerformed(e);
            }
        });
        edit.add(delete);
        jMenuBar.add(edit);

        JMenu query = new JMenu();
        query.setText("查询");
        JMenuItem queryAll = new JMenuItem("查询所有演播厅数据");
        queryAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                queryAllActionPerformed(e);
            }
        });
        query.add(queryAll);
        JMenuItem queryByUid = new JMenuItem("通过编号查询");
        query.add(queryByUid);
        queryByUid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                queryByUidActionPerformed(e);
            }
        });
        jMenuBar.add(query);

        JMenu User = new JMenu("员工");
        JMenuItem userQuery = new JMenuItem("员工管理");
        userQuery.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showUserActionPerformed(e);
            }
        });
        User.add(userQuery);
        jMenuBar.add(User);

        JMenu Column = new JMenu("栏目");
        JMenuItem columnQuery = new JMenuItem("栏目管理");
        columnQuery.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showColumnsActionPerformed(e);
            }
        });
        Column.add(columnQuery);
        jMenuBar.add(Column);

        JMenu AD = new JMenu("广告");
        JMenuItem adQuery = new JMenuItem("广告管理");
        adQuery.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showADActionPerformed(e);
            }
        });
        AD.add(adQuery);
        jMenuBar.add(AD);

        JMenu DP = new JMenu("调度单");
        JMenuItem dpQuery = new JMenuItem("调度单管理");
        dpQuery.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDPActionPerformed(e);
            }
        });
        DP.add(dpQuery);
        jMenuBar.add(DP);

        JMenu help = new JMenu("帮助");
        JMenuItem about = new JMenuItem("关于");
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aboutActionPerformed(e);
            }

            private void aboutActionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(contentPane,"欢迎使用电视台信息管理系统","by LuoZhiHao",JOptionPane.PLAIN_MESSAGE);
            }
        });
        help.add(about);
        jMenuBar.add(help);
        setJMenuBar(jMenuBar);
        pack();
    }

    //转到调度单管理界面
    private void showDPActionPerformed(ActionEvent e) {
        DispatchFrame dispatchFrame = new DispatchFrame();
        dispatchFrame.setBounds(600,400,800,600);
        dispatchFrame.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }

    private void showUserActionPerformed(ActionEvent e) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setBounds(600,400,800,600);
        mainFrame.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }

    private void showADActionPerformed(ActionEvent e) {
        ADFrame adFrame = new ADFrame();
        adFrame.setBounds(600,400,800,600);
        adFrame.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }

    private void showColumnsActionPerformed(ActionEvent e) {
        ColumnFrame columnFrame = new ColumnFrame();
        columnFrame.setBounds(600,400,800,600);
        columnFrame.setVisible(true);
        this.setVisible(false);
        this.dispose();

    }

    private void queryByUidActionPerformed(ActionEvent e) {
        try {
            tvrRows = tvRoomService.getAllTvRoom();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        simpleTableModel.setRows(tvrRows);
        new QueryByTvrIdFrame(jTable).setVisible(true);
    }

    private void queryAllActionPerformed(ActionEvent e) {
        try {
            tvrRows = tvRoomService.getAllTvRoom();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        simpleTableModel.setRows(tvrRows);
        simpleTableModel.fireTableDataChanged();
    }

    private void delUserActionPerformed(ActionEvent e) {
        TelevisionRoom tvr = tvrRows.get(jTable.getSelectedRow());
        try {
            tvRoomService.delTVRoomById(tvr.getTvrId());
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("删除失败，系统错误");
        }
        try {
            tvrRows = tvRoomService.getAllTvRoom();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("查询失败，系统错误");
        }
        simpleTableModel.setRows(tvrRows);
        simpleTableModel.fireTableDataChanged();
        JOptionPane.showMessageDialog(this,"删除演播厅"+tvr.getTvrId() +"信息成功！","删除成功",JOptionPane.INFORMATION_MESSAGE);
    }

    private void refreshActionPerformed(ActionEvent evt){
        try {
            tvrRows = tvRoomService.getAllTvRoom();
        } catch (Exception e) {
            e.printStackTrace();
        }
        simpleTableModel.setRows(tvrRows);
        simpleTableModel.fireTableDataChanged();
    }

    private void updateUserActionPerformed(ActionEvent evt){
        try {
            tvrRows = tvRoomService.getAllTvRoom();
        } catch (Exception e) {
            e.printStackTrace();
        }
        simpleTableModel.setRows(tvrRows);
        if (jTable.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this,"请先用鼠标选中数据");
        }
        TelevisionRoom tvr = tvrRows.get(jTable.getSelectedRow());
        new UpdateTvRoomFrame(tvr).setVisible(true);
    }

    private void insertUserActionPerformed(ActionEvent e) {
        new InsertTvrJFrame().setVisible(true);
    }


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TVRoomFrame frame = new TVRoomFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
