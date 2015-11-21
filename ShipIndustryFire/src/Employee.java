import java.util.*;

/**
 * Created by chandan.marathe on 11/21/2015.
 * Employee domain class with its attribues.
 * Uses priorityQueue approach to find the minpriority and max salary so that it takes log(n) time.
 */

public class Employee {

    private int empID;
    private String name;
    private int rating;
    private int salary;
    private ArrayList<Employee> reportees;
    private GlobalCounter globalCounter = GlobalCounter.getInstance();


    TreeMap<Integer,TreeSet<Integer>> ratingEmployeeMap = new TreeMap<Integer, TreeSet<Integer>>();

    public void setEmpID() {
        this.empID = globalCounter.getNext();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public ArrayList<Employee> getReportees() {
        return reportees;
    }

    public void setReportees(ArrayList<Employee> reportees) {
        for(Employee reportee : reportees){
            this.addReportee(reportee);
        }
    }

    public Employee(String name, int rating, int salary) {

        setEmpID();
        this.name = name;
        this.rating = rating;
        this.salary = salary;
        this.reportees = new ArrayList<Employee>();
    }

    private void addReportee(Employee employee){
        this.reportees.add(employee);
        TreeSet treeSet;
        if(ratingEmployeeMap.containsKey(employee.getRating())){
             treeSet = ratingEmployeeMap.get(employee.getRating());
        }
        else{
            treeSet = new TreeSet();
        }
        treeSet.add(employee.getSalary());
        ratingEmployeeMap.put(employee.getRating(),treeSet);
    }

    public int getCostSavings(int numberOfEmployees){
        int counter = 0;
        int savings=0;
        while(counter<numberOfEmployees){
            if(ratingEmployeeMap.size()>0) {
                TreeSet<Integer> treeset = (TreeSet) ratingEmployeeMap.remove(ratingEmployeeMap.firstKey()).descendingSet();
                if (treeset != null && treeset.size() > 0) {
                    for (int salary : treeset) {
                        if (counter < numberOfEmployees) {
                            savings = savings + salary;
                        } else {
                            return savings;
                        }
                        counter++;
                    }
                }
            }
            else{
                return savings;
            }
        }
        return savings;
    }

    public int getEmpID() {
        return empID;
    }

    @Override
    public String toString() {

        return "Employee{" +
                "empID=" + empID +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                ", salary=" + salary +
                ", reportees=" + reportees +
                '}';
    }
}
