package MedEaseNavigator.DoctorDashBoard;


import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import MedEaseNavigator.DataBaseModule.DBOperation;
import MedEaseNavigator.MedEaseComponent.MedEaseBtn;
import MedEaseNavigator.MedEaseComponent.MedPannel;
import MedEaseNavigator.UtilityModule.GUIUtil;
public class DocLogin  {
    JFrame LoginFrame;
    MedEaseBtn LoginBtn; // Btn to login
    MedEaseBtn SetupBtn; // setup Btn
    MedPannel UserDetailsPannel;
    JLabel DocNameLabel, DocPswdLabel, warn,DocNumberLabel;
    JLabel MedEaselabel, NavigatorLabel;
    JTextField DocNameFeild;
    JTextField DocPswdFeild;
    DBOperation DBO;

    public DocLogin(DBOperation dbo) {
        this.DBO = dbo;
        LoginFrame = new JFrame();
    }

    public void setLoginInterface() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                /* Design Implemntaion of Login Frame */
                LoginFrame.setBounds(200, 200, 650, 400);
                LoginFrame.setVisible(true);
                LoginFrame.setLayout(null);
                LoginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                LoginFrame.setResizable(false);
                LoginFrame.getContentPane().setBackground(GUIUtil.Dark_BLue);
                LoginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                UserDetailsPannel = new MedPannel(GUIUtil.WhiteClr, GUIUtil.WhiteClr, null, 0);
                UserDetailsPannel.setBounds(300, 0, 350, 400);
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
                DocNameLabel = new JLabel("User Name");
                DocNameLabel.setFont(GUIUtil.TimesBoldS2);
                DocNameLabel.setBounds(30, 40, 100, 30);
                UserDetailsPannel.add(DocNameLabel);
                DocNameFeild = new JTextField();
                DocNameFeild.setBounds(30, 70, 170, 30);
                DocNameFeild.setFont(GUIUtil.TimesBoldS2);
                // DocNameFeild.setBackground(GUIUtil.MedEaseGrey);
                DocNameFeild.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                UserDetailsPannel.add(DocNameFeild);
                DocPswdLabel = new JLabel("DocPswdFeild");
                DocPswdLabel.setFont(GUIUtil.TimesBoldS2);
                DocPswdLabel.setBounds(30, 105, 100, 30);
                UserDetailsPannel.add(DocPswdLabel);
                DocPswdFeild = new JTextField();
                DocPswdFeild.setBounds(30, 135, 170, 30);
                DocPswdFeild.setFont(GUIUtil.TimesBoldS2);
                DocPswdFeild.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                UserDetailsPannel.add(DocPswdFeild);
                SetupBtn = new MedEaseBtn(GUIUtil.Dark_BLue, GUIUtil.BlueColor, null, 5);
                SetupBtn.setBounds(130, 190, 100, 30);
                SetupBtn.setText("SIGNUP");
                SetupBtn.setForeground(Color.WHITE);
                SetupBtn.setFont(GUIUtil.TimesBold);
                UserDetailsPannel.add(SetupBtn);
                LoginBtn = new MedEaseBtn(GUIUtil.Dark_BLue, GUIUtil.BlueColor, null, 5);
                LoginBtn.setBounds(20, 190, 100, 30);
                LoginBtn.setText("LOGIN");
                LoginBtn.setForeground(Color.WHITE);
                LoginBtn.setFont(GUIUtil.TimesBold);
                UserDetailsPannel.add(LoginBtn);

            }
        });

    }

    
}

