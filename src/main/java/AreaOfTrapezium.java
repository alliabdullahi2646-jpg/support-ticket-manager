import java.util.Scanner;

public class AreaOfTrapezium {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter length of first parallel sides: ");
        double a = scanner.nextDouble();
        System.out.println("Enter length of second parallel sides: ");
        double b = scanner.nextDouble();
        System.out.println("Enter height: ");
        double h = scanner.nextDouble();
        double area = 0.5 * (a+b) * h;
        System.out.println("Area of trapezium is " + area);
        for (int i = 0; i<11; i++){
            System.out.println("count: " + i);
        }
        String[] names = {"Alli", "Qasim", "Abdullahi"};
        for (String name:names){
           System.out.println(name);
        }
        scanner.close();
    }
}