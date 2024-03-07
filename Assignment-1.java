import java.util.*


public class Assignment-1.java{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Long> telephone;
        long[] list;
        System.out.println("(A)dd list number(delimited by comma");
        telephone=addElement();
        System.out.println("Enter the type of Hashing you would like to perform");
        System.out.println("(W)ithout Replacement");
        System.out.println("(R)eplacement");
        System.out.println("(Q)uadratic");
        var choice1 = scanner.next();
            list = Hashing(choice1.toUpperCase().charAt(0),telephone);

        System.out.println("(S)earch number");
        System.out.println("(P)rint");
        //long[] list;
        while(true) {
            System.out.println("Enter choice");
            var choice = scanner.next().toUpperCase();
            int switchChoice = "SPQ".indexOf(choice.charAt(0));
            switch (switchChoice+2){
                case 2->{
                    System.out.println("Enter Number to be searched");
                    long num = Long.parseLong(scanner.next());
                    boolean flag = false;
                    for(var ele:list){
                        if(ele==num){
                            System.out.println("Found");
                            flag=true;
                        }
                    }
                    if(!flag){
                        System.out.println("Not Found");
                    }
                }
                case 3->{
                    System.out.println(Arrays.toString(list));
                }
                case 4-> {
                    return;
                }
            }
            //return;
        }
    }

    public static List<Long> addElement(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the list of telephone number");
        List<String> listTele = new ArrayList<>(List.of(scanner.next().split(",")));
        List<Long> list = new ArrayList<>();
        listTele.forEach(s->list.add(Long.parseLong(s)));
        return list;
    }
    public static long[] Hashing(char choice,List<Long> a){
        return switch (choice){
            case 'W'->without(a);
            case 'R'->replacement(a);
            case 'Q'->quadratic(a);
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        };
    }

    public static long[] without(List<Long> a){
        long[] list = new long[a.size()];
        Arrays.fill(list,-1);
        a.forEach((s)->{
            int key = (int) (s%a.size());
            if(list[key]==-1){
                list[key]=s;
            }else{
                var j=key;
                while(list[j]!=-1){
                    j = (j==list.length-1) ? 0 : j+1;
                    if(list[j]==-1){
                        list[j]=s;
                        break;
                    }
                }
            }
        });
        return list;
    }

    public static long[] replacement(List<Long> a){
        long[] list = new long[a.size()];
        Arrays.fill(list,-1);
        a.forEach((s)->{
            int key = (int) (s%a.size());
            if(list[key]==-1){
                list[key]=s;
            }else{
                var j=key;
                while(list[j]!=-1){
                    j = (j==list.length-1) ? 0 : j+1;
                    if(list[j]==-1){
                        if(list[key]%list.length!=key){
                            list[j]=list[key];
                            j=key;
                        }
                        list[j]=s;
                        break;
                    }
                }
            }
        });
        return list;
    }

    public static long[] quadratic(List<Long> a){
        long[] list = new long[a.size()];
        Arrays.fill(list,-1);
        a.forEach((s)->{
            int count = 0;
            while(count<list.length){
                int key = (int) ((s*s) + count)%list.length;
                if(list[key]==-1){
                    list[key]=s;
                    break;
                }
                count++;
            }
        });
        return list;
    }

}