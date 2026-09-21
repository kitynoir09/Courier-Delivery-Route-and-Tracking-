package WORK.PROJECT;

import java.util.*;

public class FinalProject {

    static int CreateDelivery( Scanner s){
     
       s.nextLine();
        System.out.println("ENTER NAME: ");
         String name = s.nextLine();

        System.out.print("ENTER DESTINATION: ");
        String dest = s.nextLine();

        System.out.print("ENTER WEIGHT OF THE PACKAGE: ");
        int weight = s.nextInt();

        System.out.print("ENTER THE DISTANCE: ");
        int dist = s.nextInt();

        System.out.println("NAME: " + name);
        System.out.println("DESTINATION: " +dest);
        System.out.println("WEIGHT OF THE PACKAGE: "+ weight);
        System.out.println("DISTANCE: "+ dist);
        
        return weight;

            
     }

    static int DeliveryCharge( int weight){
        int charge = 50 + (weight*10);
        return charge;
    }

    static int[] charges = {500, 200, 560, 600, 340};

    static int[] ids = {101,102,103,104,105};
    static String[] status = {
        "DELIVERED",
        "IN TRANSIT",
        "OUT FOR DELIVERY",
        
        "PACKAGE CREATED",
        "IN TRANSIT"
    };
    static int courierCount = 5;
    static int nextId = 106;

    static void TotalIncome(){
        int total = 0;

        for(int i = 0; i < courierCount; i++){
            total = total + charges[i];
        }
        System.out.println("TOTAL INCOME: "+total);
    }
   
    static int CreateId(){

     int id = nextId;
     int[] newIds = new int[courierCount + 1];
     String[] newStatus = new String[courierCount + 1];
     int[] newCharges = new int[courierCount + 1];
     for(int i = 0; i <courierCount; i++){
        newIds[i] = ids[i];
        newStatus[i] = status[i];
        newCharges[i] = charges[i];

     }

     newIds[courierCount] = id;
     newStatus[courierCount] = "PACKAGE CREATED";
     newCharges[courierCount] = 0;

     ids = newIds;
     status = newStatus;
     charges = newCharges;

     courierCount++;
     nextId++;

     
    return id;
    } 

   

    static String CourierTracking( int Track_id){
                
        
        
        for(int i = 0; i < courierCount; i++){
            if(ids[i] == Track_id){
                return status[i];
                
            }
            
       
        }

        return "ID NOT FOUND";
            
        

    }

    static void UpdateStatus(Scanner s){
        System.out.print("ENTER COURIER ID: ");
        int id = s.nextInt();

        for(int i = 0; i < courierCount; i++){
            if(ids[i] == id){
                System.out.println("-------------------");
                System.out.println("SELECT THE NEW STATUS: ");
                System.out.println("1. IN TRANSIT");
                System.out.println("2. OUT FOR DELIVERY");
                System.out.println("3. DELIVERED");
                System.out.println("-------------------");

                    int choice = s.nextInt();

                    switch(choice) {
                        case 1 :
                            status[i] = "IN TRANSIT";
                        break;

                        case 2 :
                            status[i] = "OUT FOR DELIVERY";
                        break;

                        case 3 :
                            status[i] = "DELIVERED";
                        break;

                        default :
                            System.out.println("INVALID OPTION");
                            return;
                    }
                System.out.println("STATUS UPDATED!");
                return;
            }
        }

        System.out.println("INVALID ID");

    }

    static void DeliveryEligibility(int d){
        if(d <= 500){
                System.out.println("ELIGIBLE");
            }
            else{
                System.out.println("NOT ELIGIBLE");
            }

    }

    static void ViewCouriers(){

        System.out.println("ALL ORDERS");

        for(int i = 0; i < courierCount; i++){
            System.out.println("-----------------");
            System.out.println("COURIER ID: "+ ids[i]);
            System.out.println("STATUS: "+ status[i]);
            System.out.println("CHARGE: "+ charges[i]);
            System.out.println("-----------------");
        }
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
         while(true){

            System.out.print("WELCOME TO SM COURIER SERVICE");
            System.out.println("CHOOSE YOUR ROLE");
            System.out.println("----------------");
            System.out.println("1. CUSTOMER");
            System.out.println("2. ADMIN");
            System.out.println("3. EXIT PROGRAM");
            System.out.println("----------------");
            int identity = s.nextInt();

            switch(identity) {

                case 1 :

                    while(true){
           
                        System.out.println("ENTER WHICH SERVICE TO AVAIL: ");
                        System.out.println("1. CREATE NEW COURIER\n2. TRACK COURIER\n3. BACK TO MAIN MENU");
                        int option = s.nextInt();

                        switch(option){

                        case 1:
                            int weight = CreateDelivery(s);
                            int id = CreateId();
                            System.out.println("YOUR PACKAGE ID: "+ id);
                            int charge = DeliveryCharge(weight);
                            charges[courierCount - 1] = charge;
                            System.out.println("COST: "+charge);
                
                        break; 

                        case 2 :
                            System.out.print("ENTER THE ID OF THE PACKAGE: ");
                            int Track_id = s.nextInt();
                            String status = CourierTracking(Track_id);
                            System.out.println("STATUS: "+status);
                        break;
            
                        case 3 :
                        break;

                        default :
                            System.out.println("INVALID OPTION");
                }
                        if(option == 3){
                            break;
                        } 
                
                    }
                break;
                
                
                
            
            
        
                case 2 :
                    while(true){
                        System.out.println("\nWELCOME ADMIN!");
                        System.out.println("CHOOSE YOUR TASK TODAY: ");
                        System.out.println("1. VIEW ALL COURIERS");
                        System.out.println("2. UPDATE OCURIER STATUS");
                        System.out.println("3. VIEW TOTAL REVENUE");
                        System.out.println("4. BACK TO MAIN MENU");
                
                        int option = s.nextInt();

                        switch (option) {
                            case 1 :
                                ViewCouriers();
                            break;

                            case 2 :
                                UpdateStatus(s);
                            break;

                            case 3 :
                                TotalIncome();
                            break;

                            case 4 :
                                break;

                            default : 
                                System.out.println("INVALID INPUT");
                        }

                        if(option == 4){
                        break;
                        }   
                    }
                break;
                
                case 3 :
                    System.out.println("--------------");
                    System.out.println("THANK YOU FOR CHOOSING SM COURIER SERVICE");
                    System.out.println("--------------");
                    s.close();
                    System.exit(0);
                break;

                default :
                    System.out.println("INVALID INPUT");
            }         
        } 
    
    }
}    

