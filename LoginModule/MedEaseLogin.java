/*
 *  login interface
 *  
 */
package MedEaseNavigator.LoginModule;

import java.awt.Color;
import java.awt.Font;
import java.util.concurrent.Semaphore;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import MedEaseNavigator.DataBaseModule.DBOperation;
import MedEaseNavigator.MedEaseComponent.MedEaseBtn;
import MedEaseNavigator.MedEaseComponent.MedPannel;
import MedEaseNavigator.UtilityModule.GUIUtil;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class MedEaseLogin  extends MouseAdapter {
    JFrame LoginFrame;
    MedEaseBtn LoginBtn; // Btn to login
    MedEaseBtn SetupBtn; // setup Btn
    LoginEventHandeler LogEvent;
    MedPannel UserDetailsPannel;

    JLabel UsernameLabel, UserPasswordLabel, warn;
    JLabel MedEaselabel, NavigatorLabel;
    JTextField UserName;
    JTextField Password;
    DBOperation DBO;
    Semaphore sema;

    public MedEaseLogin(DBOperation dbo, Semaphore sema) {
        this.DBO = dbo;
        this.sema = sema;
        setLoginInterface(this);

    }

    public void setLoginInterface(MedEaseLogin loginobj) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                /* Design Implemntaion of Login Frame */
                LoginFrame = new JFrame();
                LoginFrame.setBounds(200, 200, 600, 300);
                LoginFrame.setVisible(true);
                LoginFrame.setLayout(null);
                LoginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                LogEvent = new LoginEventHandeler(loginobj);

                LoginFrame.setResizable(false);
                LoginFrame.getContentPane().setBackground(GUIUtil.Dark_BLue);
                LoginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                UserDetailsPannel = new MedPannel(GUIUtil.WhiteClr, GUIUtil.WhiteClr, null, 0);
                UserDetailsPannel.setBounds(300, 0, 300, 300);
                UserDetailsPannel.setLayout(null);
                LoginFrame.add(UserDetailsPannel);
                MedEaselabel = new JLabel("MedEase");
                MedEaselabel.setForeground(GUIUtil.WhiteClr);
                MedEaselabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
                MedEaselabel.setBounds(70, 80, 200, 30);
                LoginFrame.add(MedEaselabel);
                NavigatorLabel = new JLabel("Navigator");
                NavigatorLabel.setForeground(GUIUtil.WhiteClr);
                NavigatorLabel.setBounds(80, 130, 200, 40);
                NavigatorLabel.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 30));
                warn = new JLabel();
                warn.setVisible(false);
                warn.setBounds(10, 20, 400, 20);
                warn.setFont(GUIUtil.TimesItalic);
                warn.setForeground(GUIUtil.WarningColor);
                UserDetailsPannel.add(warn);
                LoginFrame.add(NavigatorLabel);
                UsernameLabel = new JLabel("User Name");
                UsernameLabel.setFont(GUIUtil.TimesBoldS2);
                UsernameLabel.setBounds(30, 40, 100, 30);
                UserDetailsPannel.add(UsernameLabel);
                UserName = new JTextField();
                UserName.setBounds(30, 70, 170, 30);
                UserName.setFont(GUIUtil.TimesBoldS2);
                // UserName.setBackground(GUIUtil.MedEaseGrey);
                UserName.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                UserDetailsPannel.add(UserName);
                UserPasswordLabel = new JLabel("Password");
                UserPasswordLabel.setFont(GUIUtil.TimesBoldS2);
                UserPasswordLabel.setBounds(30, 105, 100, 30);
                UserDetailsPannel.add(UserPasswordLabel);
                Password = new JTextField();
                Password.setBounds(30, 135, 170, 30);
                Password.setFont(GUIUtil.TimesBoldS2);
                Password.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                Password.addKeyListener(LogEvent);
                UserDetailsPannel.add(Password);

                // SetupBtn = new MedEaseBtn(GUIUtil.Dark_BLue, GUIUtil.BlueColor, null, 5);
                // SetupBtn.setBounds(130, 190, 100, 30);
                // SetupBtn.setText("SIGNUP");
                // SetupBtn.setForeground(Color.WHITE);
                // SetupBtn.setFont(GUIUtil.TimesBold);
                // SetupBtn.addActionListener(LogEvent);
                // SetupBtn.addKeyListener(LogEvent);
                // UserDetailsPannel.add(SetupBtn);

                LoginBtn = new MedEaseBtn(GUIUtil.Dark_BLue, GUIUtil.BlueColor, null, 5);
                LoginBtn.setBounds(60, 190, 150, 30);
                LoginBtn.setText("LOGIN");
                LoginBtn.setForeground(Color.WHITE);
                LoginBtn.setFont(GUIUtil.TimesBold);
                LoginBtn.addActionListener(LogEvent);
                LoginBtn.addKeyListener(LogEvent);
                UserDetailsPannel.add(LoginBtn);

            }
        });

    }
    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource()==LoginBtn){
            LoginBtn.Background=GUIUtil.BlackClr;
            LoginBtn.repaint();


        }
    }
    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource()==LoginBtn) {
            LoginBtn.Background=GUIUtil.Dark_BLue;
            LoginBtn.repaint();
        }
    }

}
