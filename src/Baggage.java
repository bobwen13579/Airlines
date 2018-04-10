public class Baggage {
    //行李重量
    double bag_weight;
    //行李长宽高
    double bag_length;
    double bag_width;
    double bag_height;

    public Baggage(){}
    public Baggage(double bag_weight,double bag_length,double bag_width,double bag_height){
        this.bag_weight=bag_weight;this.bag_height=bag_height;
        this.bag_length=bag_length;this.bag_width=bag_width;

    }

    public double getBag_height() {
        return bag_height;
    }

    public double getBag_length() {
        return bag_length;
    }

    public double getBag_weight() {
        return bag_weight;
    }

    public double getBag_width() {
        return bag_width;
    }

    public void setBag_height(double bag_height) {
        this.bag_height = bag_height;
    }

    public void setBag_length(double bag_length) {
        this.bag_length = bag_length;
    }

    public void setBag_weight(double bag_weight) {
        this.bag_weight = bag_weight;
    }

    public void setBag_width(double bag_width) {
        this.bag_width = bag_width;
    }


    //判断行李是否超过最大规格
  /*  public boolean check_bag(int route){
        if(route==0){
            if(bag_height<50 &&bag_length<60&&bag_weight<40&&bag_height<100)
                return true;
            else
                return false;
        }
        else if(route==1||route==2||route==3||route==4){
            if(bag_weight<32&&(bag_width+bag_length+bag_height)<300)
                return true;
            else
                return false;
        }
        else {
            System.out.print("路线错误");
            return false;
        }
    }*/
}