import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by papadave on 2015/12/16.
 */
public class WTF1 extends JFrame implements ActionListener {
    JLabel JLabelpic, JLabeluser, JLabelpass, jLabelauto, jLabelremember,JLabelNetCard;
    JTextField JTextFielduser;
    JPasswordField JPasswordField;
    JCheckBox JCheckBoxauto, JCheckBoxremember;
    JButton JButtonlogin, JButtonClean;
    JComboBox JComboBoxNetType,JComboBoxNetCard;

    public WTF1(String title){
        super(title);
        //调用父类的构造方法，完成标题初始化
        Container cp = this.getContentPane();
        //null的layout方法，可以自定义组件位置和长度
        cp.setLayout(null);
        //网络类型
        String[] NetType = {"教育网2M", "联通20M", "联通合约30M", "电信合约10M"};
        String[] NetCard = {"eth0"};
        //组件信息
        JLabelpic = new JLabel(new ImageIcon("image/1.png"));
        JLabelpic.setBounds(0, 0, 300, 80);
        JLabeluser = new JLabel("账号:");
        JLabeluser.setBounds(10, 100, 35, 15);
        JLabelpass = new JLabel("密码:");
        JLabelpass.setBounds(10, 135, 35, 15);
        JTextFielduser = new JTextField();
        JTextFielduser.setBounds(50, 100, 140, 25);
        JPasswordField = new JPasswordField();
        JPasswordField.setBounds(50, 135, 140, 25);
        JComboBoxNetType = new JComboBox<>(NetType);
        JComboBoxNetType.setBounds(200, 100, 90, 25);
        JButtonClean = new JButton("清除账号");
        JButtonClean.setBounds(200, 135, 90, 25);
        JCheckBoxauto = new JCheckBox();
        JCheckBoxauto.setBounds(10, 180, 18, 15);
        JCheckBoxremember = new JCheckBox();
        JCheckBoxremember.setBounds(100, 180, 18, 15);
        jLabelauto = new JLabel("自动登录");
        jLabelauto.setBounds(30, 180, 60, 15);
        jLabelremember = new JLabel("记住密码");
        jLabelremember.setBounds(120, 180, 60, 15);
        JButtonlogin = new JButton("登录 (L)");
        JButtonlogin.setBounds(180, 185, 100, 40);
        JLabelNetCard = new JLabel("网卡:");
        JLabelNetCard.setBounds(10,200,30,15);
        JComboBoxNetCard = new JComboBox<>(NetCard);
        JComboBoxNetCard.setBounds(55,200,115,25);
        cp.add(JLabelpic);
        cp.add(JLabeluser);
        cp.add(JTextFielduser);
        cp.add(JComboBoxNetType);
        cp.add(JLabelpass);
        cp.add(JPasswordField);
        cp.add(JButtonClean);
        cp.add(JCheckBoxauto);
        cp.add(jLabelauto);
        cp.add(JCheckBoxremember);
        cp.add(jLabelremember);
        cp.add(JButtonlogin);
        cp.add(JLabelNetCard);
        cp.add(JComboBoxNetCard);

        JButtonlogin.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event){
        if (event.getSource()==JButtonlogin){
            JOptionPane.showMessageDialog(this,"我们的功能尚未完善 XD",
                    "我们非常抱歉", JOptionPane.INFORMATION_MESSAGE);
        }
    }


    public static void main(String[] args) {
        WTF1 frame = new WTF1("WTF客户端");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(300, 270);
        frame.setResizable(false);
    }
}