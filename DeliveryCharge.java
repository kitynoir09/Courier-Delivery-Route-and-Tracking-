package WORK.PROJECT;

import java.util.*;
public class DeliveryCharge {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int i = 0; i< t; i++){
            int w = s.nextInt();
            System.out.println(50 + (w*10));        
        }
    }
    
}

class DeliveryStatus{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int i = 0; i <t; i++){
            int w = s.nextInt();

            switch(w) {
                case 1 :
                    System.out.println("PACKAGE CREATED");
                break;

                case 2 :
                    System.out.println("IN TRANSIT");
                break;

                case 3:
                    System.out.println("OUT FOR DELIVERY");
                break;

                default :
                    System.out.println("DELIVERED");
                break;

            }

        }

    
    }
}

class DeliveryEligibility{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        for(int i = 0; i <t; i++){
            int d = s.nextInt();

            if(d <= 500){
                System.out.println("ELIGIBLE");
            }
            else{
                System.out.println("NOT ELIGIBLE");
            }
        }
    }
}


class TrackTheCourier{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int[] ids = new int[t];
        for(int i = 0; i< ids.length; i++){
            ids[i] = s.nextInt();
        }

        int search = s.nextInt();
        boolean isFound = false;

        for(int x: ids){
            if(x == search){
                isFound = true;
                break;
            }

            else{
                isFound = false;
            }
           
            
            
        }
        
        if(isFound ){
            System.out.print("FOUND");
        }
        else{
            System.out.print("NOT FOUND");
        }


    }
}