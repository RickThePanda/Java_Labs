import by.gsu.pms.BusinessTrip;

public class Runner {
    public static void main(String[] args) {
        BusinessTrip[] businessTrips = new BusinessTrip[]{
                new BusinessTrip("Anton Shumsky", 1620, 5),
                new BusinessTrip("Ivan Ivanov", 1500, 7),
                null,
                new BusinessTrip("Petr Petrov", 2500, 14),
                new BusinessTrip("Roman Romanov", 3000, 21),
                new BusinessTrip("Sergey Sergeev", 1800, 7),
                new BusinessTrip()};

        //2. Print the array content to the console, using show( ) method.
        for (BusinessTrip businessTrip : businessTrips) {
            if (businessTrip != null) {
                businessTrip.show();
            }
        }

        //3. Change the employee`s transportaion expenses for the last object of the array.
        businessTrips[businessTrips.length - 1].setTransportExpenses(4000);

        //4. Print the duration of two initial business trips by the single operator.
        System.out.println("Duration = " + (businessTrips[0].getNumberOfDays() + businessTrips[1].getNumberOfDays()));
        System.out.println("\n");

        //Print the array content to the console (one element per line), using toString( ) method implicitly.
        for (BusinessTrip businessTrip : businessTrips) {
            System.out.println(businessTrip);
        }

        //6. Find the sum of total expenses
        //7. Find and print account name employee’s with maximum total expenses
        int totalSum = 0;
        int maxCost = 0;
        String employee = "";

        for (BusinessTrip businessTrip : businessTrips) {
            if (businessTrip != null) {
                totalSum += businessTrip.getTotal();

                if (businessTrip.getTotal() > maxCost) {
                    maxCost = businessTrip.getTotal();
                    employee = businessTrip.getAccount();
                }
            }
        }

        System.out.println("\nSum of total expenses = " + totalSum + '\n'
                + "Employee with maximum total cost is: " + employee);
    }
}
