import java.util.Scanner;
import java.util.HashMap;
import java.util.*;

class Employee
{
    String eName;
    int eAge;
    int eID;
    String ePosition;
    int eSalary;

    Employee()
    {
        eName="New";
        eAge=24;
        eID=0000;
        ePosition="Fresher";
        eSalary=10000;
    }

    Employee(String name, int age, int ID, String position, int salary)
    {
        eName=name;
        eAge=age;
        eID=ID;
        ePosition=position;
        eSalary=salary;
    }

    public void printDetails()
    {
        System.out.println(" ___________________________________");
        System.out.println("|---------EMPLOYEE DETAILS---------|");
        System.out.println("|NAME:"+eName);
        System.out.println("|AGE:"+eAge);
        System.out.println("|ID:"+eID);
        System.out.println("|POSITION:"+ePosition);
        int z=this.printSalary();
        System.out.println("|SALARY:"+z);
        System.out.println("|___________________________________");
    }

    public int printSalary()
    {

    if(ePosition.equals("CEO"))
    {
        eSalary=5000000;
    }
    else if(ePosition.equals("Manager"))
    {
        eSalary=1000000;
    }
    else if(ePosition.equals("Fresher"))
    {
        eSalary=400000;
    }
    return eSalary;
    }
}

class opList
{
    public void printOp()
    {
            System.out.println("____________________________________________________________________________________");
            System.out.println("------------------------EMPLOYEE MANAGEMENT SYSTEM----------------------------------");
            System.out.println("____________________________________________________________________________________");
            System.out.println("_____________________________________");
            System.out.println("|(1)Get Salary                      |");
            System.out.println("|(2)Elligible for business trips    |");
            System.out.println("|(3)Remove employee                 |");
            System.out.println("|(4)Search Employee                 |");
            System.out.println("|(5)Get Details                     |");
            System.out.println("|(6)EXIT                            |");
            System.out.println("_____________________________________");
           
            System.out.println("------------------------------------------------------------------------------------");
           
    }
}

class Main
{
    public static void main(String[] args)
    {
        String name,position;
        int ID, age;
        HashMap<Integer,Employee>eList= new HashMap<Integer,Employee>();
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter number of employees: ");
        int n= sc.nextInt();

        while(eList.size()<n)
        {
            System.out.println("Enter ID:");
            ID= sc.nextInt();

            System.out.println("Enter employee name:");
            name= sc.next();

            System.out.println("Enter age:");
            age= sc.nextInt();

            System.out.println("Enter employee position:");
            position= sc.next();

            int sal=10000;
            eList.put(ID,new Employee(name, age, ID, position, sal));
        }
        int choice=1;
        while(choice!=6)
        {
            opList op=new opList();
            op.printOp();
            System.out.println("Enter the operation to perform:");
            choice=sc.nextInt();
            System.out.println("--------------------------------------------");
             
                if(choice==1)
                {
                    System.out.println("Enter the ID of employee:");
                    int x=sc.nextInt();
                   
                     Employee e1=eList.get(x);
                     if(e1 != null)
                     {
                        int getsal=e1.printSalary();
                        System.out.println("Salary:"+getsal);
                     }
                     else{
                        System.out.println("Employee with ID "+x+" not found!");
                     }
                     
                }
                else if(choice==2)
                {
                    System.out.println("Enter work experience:");
                    int exp=sc.nextInt();
                    if(exp>5)
                    {
                        System.out.println("Elligible for business trip.");
                    }
                    else
                    {
                        System.out.println("Not elligible for business trip.");
                    }
                }
                else if(choice==3)
                {
                    System.out.println("Enter no. of incomplete tasks:");
                    int incomp=sc.nextInt();
                    System.out.println("Enter employee ID:");
                    int remID=sc.nextInt();
                    Employee temp=eList.get(remID);
                    if(temp != null)
                    {
                        if(incomp>=1 && incomp<=5)
                        {
                            System.out.println("Warning!Finish task~"+temp.eName);
                        }
                        else if(incomp==0)
                        {
                            System.out.println("No pending works.Good job~"+temp.eName);
                        }
                        else
                        {
                            eList.remove(remID);
                            System.out.println("Due to inconsistent work "+temp.eName+" has been removed.");
                        }
                    }
                    else
                    {
                        System.out.println("Employee with ID "+remID+" not found!");
                    }
                   
                }
                else if(choice==4)
                {
                    System.out.println("Enter employee ID to search:");
                    int sID=sc.nextInt();
                    if(eList.containsKey(sID))
                    {
                        System.out.println("Employee found.");
                    }
                    else
                    {
                        System.out.println("Employee not found.");    
                    }
                   
                }
                else if(choice==5)
                {
                    System.out.println("Enter the ID of employee:");
                    int x=sc.nextInt();
                   
                     Employee e1=eList.get(x);
                     if(e1==null)
                     {
                         System.out.println("Employee(ID:"+x+") not found.");
                     }
                     else
                     {
                     e1.printDetails();
                     }
                }
                else
                {
                    System.out.println("Invalid choice.");
                }
        }
    }
} 
