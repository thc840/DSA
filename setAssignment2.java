import java.util.Scanner;

public class setAssignment2{
    public static void main(String[] args) {
        Set mySet1 = new Set(50);
        Set mySet2 = new Set(50);
        Scanner sc = new Scanner(System.in);
        int choice;
        do{
            System.out.println("\n#-----------------------------------------#");
            System.out.println("\nEnter your choice: ");
            System.out.println("1. Add element to set 1");
            System.out.println("2. Add element to set 2");
            System.out.println("3. Remove element from set 1");
            System.out.println("4. Remove element from set 2");
            System.out.println("5. Check if element is present in set 1");
            System.out.println("6. Check if element is present in set 2");
            System.out.println("7. Display elements in set 1");
            System.out.println("8. Display elements in set 2");
            System.out.println("9. Total number of elements in set 1");
            System.out.println("10. Total number of elements in set 2");
            System.out.println("11. Intersection of sets");
            System.out.println("12. Union of sets");
            System.out.println("13. Difference of sets");
            System.out.println("");
            System.out.print("00. Exit\n"+"> ");
            choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.out.print("Enter element to add: ");
                    mySet1.add(sc.nextInt());
                    break;
                case 2:
                    System.out.print("Enter element to add: ");
                    mySet2.add(sc.nextInt());
                    break;
                case 3:
                    System.out.print("Enter element to remove: ");
                    mySet1.remove(sc.nextInt());
                    break;
                case 4:
                    System.out.print("Enter element to remove: ");
                    mySet2.remove(sc.nextInt());
                    break;
                case 5:
                    System.out.print("Enter element to check: ");
                    if(mySet1.isPresent(sc.nextInt())){
                        System.out.println("Element is Present in set.");
                    }
                    else{
                        System.out.println("Element is NOT Present in set.");
                    }
                    break;
                case 6:
                    System.out.print("Enter element to check: ");
                    if(mySet2.isPresent(sc.nextInt())){
                        System.out.println("Element is Present in set.");
                    }
                    else{
                        System.out.println("Element is NOT Present in set.");
                    }
                    break;
                case 7:
                    System.out.println("Set 1: ");
                    mySet1.display();
                    break;
                case 8:
                    System.out.println("Set 2: ");
                    mySet2.display();
                    break;
                case 9:
                    System.out.print("Total Number of elements in set 1: "+mySet1.count());
                    break;
                case 10:
                    System.out.println("Total number of elements in set 2: "+ mySet2.count());
                    break;
                case 11:
                    mySet1.intersection(mySet2);
                    break;
                case 12:
                    mySet1.union(mySet2);
                    break;
                case 13:
                    mySet1.difference(mySet2);
                    break;
                case 00:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }while(true);
    }
}

class Set{
    int size;
    int set[];
    int index;

    public Set(int size){ // Creates set of size specified by user
        this.size = size;
        set = new int[size];
        index = 0;
        for(int i = 0; i < size; i++){
            set[i] = 0;
        }
    }

    public Set(){ // Creates set of default size of 50
        size = 50;
        set = new int[size];
        index = 0;
        for(int i = 0; i < size; i++){
            set[i] = 0;
        }
    }

    public boolean isPresent(int key){ // Check if key is present in the set
        for(int i = 0; i < size; i++){
            if (set[i] == key)
                return true;
            }
        return false;
    }

    public void add(int key){ // Adds value to set
        if(!isPresent(key))
        {
            if((index < size) && (set[index] == 0))
            {
                set[index] = key;
                System.out.println(key+" added successfully.");
                index++;
                if(index == size){
                    index = 0;
                }
            }else{
                System.out.print("Error: Set is full !");
            }
        }else
            System.out.println(key+" already Present in set.");        
    }

    public void remove(int value){ //remove element from set
        for(int i = 0; i < size; i++){
            if (set[i] == value){
                set[i] = 0;
                System.out.println(value+" removed successfully.");
            }
        }
        System.out.println(value+" not found in set.");
    }

    public int count(){
        int count = 0;
        for(int i = 0; i < size; i++){
            if(set[i] != 0)
                count++;
        }
        return count;
    }

    public void display(){
        for(int i = 0; i < size; i++){
            if(set[i] != 0)
                System.out.print(set[i]+" ");
        }
        System.out.println();
    }

    public void search(int value){
        for(int i = 0; i < size; i++){
            if(set[i] == value){
                System.out.println(value+" Found in set.");
                return;
            }else{
                System.out.println(value+" NOT Found in set.");
            }
        }
    }

    public void intersection(Set s){
        Set temp = new Set();
        for (int i = 0; i < size ; i++)
            for (int ii = 0; ii < size ; ii++)
                if(set[i] == s.set[ii])        
                    temp.add(set[i]);
        System.out.println("Intersection of both sets is: ");
        temp.display();
    }

    public void union(Set s){
        Set temp = new Set();
        for(int i = 0; i < size; i++)
            temp.add(set[i]);
        for(int i = 0; i < s.size; i++)
            temp.add(s.set[i]);
        System.out.println("Union of both sets is: ");
        temp.display();
    }

    public void difference(Set s){
        Set temp = new Set();
        for (int i = 0; i < size; i++)
            temp.set[i] = set[i];
        for (int i = 0; i < s.size; i++)
            for(int ii = 0; ii < size; ii++)
                if(temp.set[i] == s.set[ii])
                    temp.remove(temp.set[i]);
        System.out.println("Difference of both sets is: ");
        temp.display();
    }
}