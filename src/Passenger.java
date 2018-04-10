import java.util.ArrayList;

public class Passenger {
        private String name;

        //座位类型,头等4，公务3，明珠2，经济1
        private int seat_type;
        //婴儿0/1
        private int isBring_bady;

        //经济舱票价
        private double Ticket_Price;

        //金卡4,银卡3,留学生2,普通1
        private int vip_type;

        //区域1234,国内0
        private int route;

        public Passenger(){};
        public Passenger(String name,int seat_type,int isBring_bady,double Ticket_Price,int vip_type,int route){
            this.name=name;
            this.seat_type=seat_type;
            this.isBring_bady=isBring_bady;
            this.Ticket_Price=Ticket_Price;
            this.vip_type=vip_type;
            this.route=route;
        }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public int isBring_bady() {
        return isBring_bady;
    }
    public void setBring_bady(int isBring_bady) {
        this.isBring_bady = isBring_bady;
    }

    public void setTicket_Price(double ticket_Price) {
        Ticket_Price = ticket_Price;
    }
    public double getTicket_Price() {
        return Ticket_Price;
    }

    public void setVip_type(int vip_type) {
        this.vip_type = vip_type;
    }
    public int getVip_type() {
        return vip_type;
    }

    public void setSeat_type(int seat_type) {
        this.seat_type = seat_type;
    }
    public int getSeat_type() {
        return seat_type;
    }

    public void setRoute(int route) {
        this.route = route;
    }
    public int getRoute() {
        return route;
    }

    private ArrayList<Baggage>list_bag=new ArrayList();

    public ArrayList<Baggage> getList_bag() {
        return list_bag;
    }
    public void setList_bag(ArrayList<Baggage> list_bag) {
        this.list_bag = list_bag;
    }

    public void add_to_list(Baggage a){

        if(route==0){
            if(a.bag_weight<=50 &&a.bag_length<=60&&a.bag_width<=40&&a.bag_height<=100)
                list_bag.add(a);
            else
                System.out.println("添加失败");
        }
        else {
            if(a.bag_weight<=45&&(a.bag_width+a.bag_length+a.bag_height)<=300)
                list_bag.add(a);
            else
                System.out.println("添加失败");
        }
    }

    public void delete_all_list(){
        list_bag.clear();
    }
    //国内 直接输出超重价格
        double Check_China_weight(){
            double bag_out_weight=0;
            for(int j=0;j<list_bag.size();j++) {
                Baggage temp = list_bag.get(j);
                bag_out_weight += temp.bag_weight;
            }


            switch (seat_type){
                case (4):bag_out_weight-=40;break;
                case (3):bag_out_weight-=30;break;
                case (2):bag_out_weight-=20;break;
                case (1):bag_out_weight-=20;break;
            }

            switch (vip_type){
                case (4):bag_out_weight-=20;break;
                case (3):bag_out_weight-=10;break;
                case (2):System.out.println("国内不存在");break;
            }

            if(isBring_bady==1)bag_out_weight-=10;

            if (bag_out_weight>0)return bag_out_weight*Ticket_Price*0.015;
            else return 0;
            }

//国际
    //对单个行李计算尺寸和超重
        double count_internation_single_weight(Baggage temp_class){
            double out_price=0;
            double out_weight=temp_class.bag_weight;

            //超尺寸
            if ((temp_class.bag_width+temp_class.bag_length+temp_class.bag_height)>158)out_price+=1000;

            //对行李超重计算
            if(temp_class.bag_weight<23) return out_price;

            else if(temp_class.bag_weight<32) {
                if(seat_type==2||seat_type==1||(route==4&&seat_type==3)){
                    switch (route){
                        case 1: case 4:out_price+=1000;break;
                        case 3:out_price+=2000;break;
                    }
                }}
             else out_price+=3000;
return out_price;
            }

//最后对超件行李总计算
double count_inter_all_price(){
            double out_price=0;
            int count_bag=list_bag.size();
            //先计算超重和超尺寸
            for (int i=0;i<count_bag;i++){
             out_price+=count_internation_single_weight(list_bag.get(i)) ;
            }
            if(vip_type==4||vip_type==3||vip_type==2)count_bag-=1;
            switch (route){
                case 1:case 3:{
                    if(seat_type==4)count_bag-=3;
                    else count_bag-=2;
                    if (count_bag>0){
                        out_price+=1000;
                        count_bag--;
                        while (count_bag>0){out_price+=2000;
                            count_bag--;
                        }
                    }
                    break;
                }
                case 2:{
                    if(seat_type==4)count_bag-=3;
                    else if(seat_type==3)count_bag-=2;
                    else count_bag-=1;
                    if (count_bag>0){
                        out_price+=450;
                         count_bag--;
                        while (count_bag>0){out_price+=1300;
                            count_bag--;
                        }
                    }
                    break;
                }
                case 4:{
                    if(seat_type==4||seat_type==3)count_bag-=3;
                    else if(seat_type==2)count_bag-=2;
                    else count_bag-=1;
                    if (count_bag>0){
                        out_price+=450;
                        count_bag--;
                        while (count_bag>0){out_price+=1300;
                            count_bag--;
                        }
                    }
                    break;
                }

            }
            return out_price;
}
        }


