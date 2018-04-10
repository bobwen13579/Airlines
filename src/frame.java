import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import static java.awt.Color.gray;
import static javafx.scene.input.KeyCode.G;

public class frame {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        JFrame frame = new TestSelectFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
class TestSelectFrame extends JFrame {
    public TestSelectFrame() {
        setTitle("南航行李计算器");
        setSize(1200, 600);
        Container con = this.getContentPane();
        con.setLayout(new FlowLayout());
        add(new jPanel_contain());
      //  add(new jPanel_bag());
       // add(new JPanel_output());
        //add(new JPanel_table());
    }

    public double text_to_int(String a){
        double b=0;
        try {
            b = Integer.valueOf(a).intValue();
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
        return b;
    }


    class jPanel_contain extends  JPanel{

        private DefaultTableModel model = null;

        public jPanel_contain(){

            Passenger passenger = new Passenger();

            JPanel jPanel_passenger = new JPanel();
            jPanel_passenger.setLayout(new BoxLayout(jPanel_passenger, BoxLayout.Y_AXIS));
            add(jPanel_passenger);

            Box box1=Box.createHorizontalBox();
            jPanel_passenger.add(box1);
            Box box2=Box.createHorizontalBox();
            jPanel_passenger.add(box2);
            Box box3=Box.createHorizontalBox();
            jPanel_passenger.add(box3);
            Box box4=Box.createHorizontalBox();
            jPanel_passenger.add(box4);
            Box box5=Box.createHorizontalBox();
            jPanel_passenger.add(box5);
            Box box6=Box.createHorizontalBox();
            jPanel_passenger.add(box6);

            Border passenger_title = BorderFactory.createTitledBorder("请输入乘客信息");
            jPanel_passenger.setBorder(passenger_title);

            JLabel passenger_name = new JLabel("乘客姓名:          ");
            JTextField name_text = new JTextField(15);
            name_text.setText("jack");
            box1.add(passenger_name);
            box1.add(name_text);

            JLabel route_name = new JLabel("飞行路线:          ");
            JComboBox jcb_route = new JComboBox();
            jcb_route.addItem("国内");
            jcb_route.addItem("区域一");
            jcb_route.addItem("区域二");
            jcb_route.addItem("区域三");
            jcb_route.addItem("区域四");
            box2.add(route_name);
            box2.add(jcb_route);

            JLabel  seat_type_txt= new JLabel("座位类型:          ");
            JComboBox jcb_seat_type = new JComboBox();
            jcb_seat_type.addItem("经济舱");
            jcb_seat_type.addItem("明珠经济舱");
            jcb_seat_type.addItem("公务舱");
            jcb_seat_type.addItem("头等舱");
            box3.add(seat_type_txt);
            box3.add(jcb_seat_type);

            JLabel  vip_type_txt= new JLabel("vip类型:             ");
            JComboBox jcb_vip_type = new JComboBox();
            jcb_vip_type.addItem("普通乘客");
            jcb_vip_type.addItem("留学生、劳务、海员");
            jcb_vip_type.addItem("南航明珠银卡会员、天合联盟精英");
            jcb_vip_type.addItem("南航明珠金卡会员、天合联盟超级精英");
            box4.add(vip_type_txt);
            box4.add(jcb_vip_type);

            JLabel  is_baby_txt= new JLabel("是否携带婴儿: ");
            JComboBox jcb_is_baby=new JComboBox();
            jcb_is_baby.addItem("不带婴儿");
            jcb_is_baby.addItem("带婴儿");
            box5.add(is_baby_txt);
            box5.add(jcb_is_baby);

            JLabel label1 = new JLabel("机票价格：      ");
            JTextField ticket_price = new JTextField(15);
            ticket_price.setText("3000");
            box6.add(label1);
            box6.add(ticket_price);

            JTextArea information=new JTextArea();

            JButton passenger_submit=new JButton("确认乘客信息");
            jPanel_passenger.add(passenger_submit);
            passenger_submit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    //按钮添加乘客信息
                    passenger.setName(name_text.getText());
                    passenger.setRoute(jcb_route.getSelectedIndex()+1);
                    passenger.setVip_type(jcb_vip_type.getSelectedIndex()+1);
                    passenger.setSeat_type(jcb_seat_type.getSelectedIndex()+1);
                    passenger.setBring_bady(jcb_is_baby.getSelectedIndex());
                    passenger.setTicket_Price(text_to_int(ticket_price.getText()));

                }
            });


            JPanel jPanel_bag=new JPanel();
            jPanel_bag.setLayout(new BoxLayout(jPanel_bag, BoxLayout.Y_AXIS));
            add(jPanel_bag);



            Border bag_title = BorderFactory.createTitledBorder("请输入背包信息");
            jPanel_bag.setBorder(bag_title);

            Box bag_box1 = Box.createHorizontalBox();
            jPanel_bag.add(bag_box1);
            Box bag_box2 = Box.createHorizontalBox();
            jPanel_bag.add(bag_box2);
            Box bag_box3 = Box.createHorizontalBox();
            jPanel_bag.add(bag_box3);
            Box bag_box4 = Box.createHorizontalBox();
            jPanel_bag.add(bag_box4);
            Box bag_box5 = Box.createHorizontalBox();
            jPanel_bag.add(bag_box5);
            Box bag_box6 = Box.createHorizontalBox();
            jPanel_bag.add(bag_box6);

            JLabel jLabel_weight = new JLabel("重量：");
            JTextField bag_weight = new JTextField(10);

            JLabel jLabel_length = new JLabel("长度：");
            JTextField bag_length = new JTextField(10);

            JLabel jLabel_width = new JLabel("宽度：");
            JTextField bag_width = new JTextField(10);

            JLabel jLabel_height = new JLabel("高度：");
            JTextField bag_height = new JTextField(10);

            bag_box1.add(jLabel_weight);
            bag_box1.add(bag_weight);

            bag_box2.add(jLabel_length);
            bag_box2.add(bag_length);

            bag_box3.add(jLabel_width);
            bag_box3.add(bag_width);

            bag_box4.add(jLabel_height);
            bag_box4.add(bag_height);


            String[] columnName = {"编号","重量","长度","宽度","高度"};
            String[][]datas={};
            model = new DefaultTableModel(datas,columnName);
            JTable tab = new JTable(model);
            JScrollPane jsc = new JScrollPane(tab);

            JButton add_bag_button = new JButton("添加行李");
            JButton delete_all_bag =new JButton("清空行李");
            bag_box5.add(add_bag_button);
            bag_box5.add(delete_all_bag);
            JLabel count_label=new JLabel("背包个数");
            JTextField bag_count=new JTextField(3);
            bag_count.setEnabled(false);
            //bag_count.setBackground(new Color(135,206,250));
            bag_box6.add(count_label);
            bag_box6.add(bag_count);


            add_bag_button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Baggage bag=new Baggage();
                    bag.setBag_weight(text_to_int(bag_weight.getText()));
                    bag.setBag_length(text_to_int(bag_length.getText()));
                    bag.setBag_width(text_to_int(bag_width.getText()));
                    bag.setBag_height(text_to_int(bag_height.getText()));
                    passenger.add_to_list(bag);
                    bag_count.setText(""+passenger.getList_bag().size());

                    ArrayList<String[]> table_list=new ArrayList<>();
                    String[] data= {""+passenger.getList_bag().size(),bag_weight.getText(),bag_length.getText(),bag_width.getText(),bag_height.getText()};
                    model.addRow(data);
                    tab.setModel(model);
                }
            });
            delete_all_bag.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    passenger.delete_all_list();
                    bag_count.setText(""+passenger.getList_bag().size());
                    model.setRowCount(0);
                    tab.setModel(model);
                }
            });




            JPanel count_jpanel=new JPanel();

            JButton count_Button=new JButton("计算结果：");
            JTextField out_txt=new JTextField(10);
            out_txt.setEnabled(false);
            //out_txt.setBackground(new Color(135,206,250));
            count_jpanel.add(count_Button);
            count_jpanel.add(out_txt);
            add(count_jpanel);

            count_Button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    double count_price=0;

                    if(passenger.getRoute()==0)
                        count_price=passenger.Check_China_weight();
                    else count_price=passenger.count_inter_all_price();
                    out_txt.setText(""+count_price);
                }
            });
            add(jsc);
        }
    }
}
