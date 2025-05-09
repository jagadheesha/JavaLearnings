import java.util.ArrayList;

public class CarCollection {
    public void main(String[] args) {
        ArrayList l1 = new ArrayList();

//        l1.add(new car("kia",2000000,"white","petrol"));
        Car  c1= new Car("kia",2000000,"white","petrol");
        Car  c2= new Car("kia",2000000,"white","petrol");
        Car  c3= new Car("kia",2000000,"white","petrol");
        Car  c4= new Car("kia",2000000,"white","petrol");
        l1.add(c1);
        l1.add(c2);
        l1.add(c3);
        l1.add(c4);
        Bike b = new Bike();
        Bike b1=new bike("hinda",100000,"black","petrol")


                

    }
}

    class car {

        String name;
        int price;
        String color;
        String type;

        public car(String name, int price, String color, String type) {
            this.name = name;
            this.price = price;
            this.color = color;
            this.type = type;
        }


        class bike {

            String name;
            int price;
            String color;
            String type;

            public bike(String name, int price, String color, String type) {
                this.name = name;
                this.price = price;
                this.color = color;
                this.type = type;
            }
        }
        @Override
        public String toString() {
            return "bike{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    ", color='" + color + '\'' +
                    ", type='" + type + '\'' +
                    '}';
        }


        @Override
        public String toString() {
            return "car{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    ", color='" + color + '\'' +
                    ", type='" + type + '\'' +
                    '}';
        }
    }
}