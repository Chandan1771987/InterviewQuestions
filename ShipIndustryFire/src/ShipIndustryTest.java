import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Test Class to bootStrap and test the maxCostSaved.
 */
public class ShipIndustryTest {

    Employee employee = new Employee("test",5,1);
    Employee employee2 = new Employee("test",3,50000);
    Employee employee3 = new Employee("test",3,40000);
    Employee employee4 = new Employee("test",4,50000);
    Employee employee5 = new Employee("test",5,50000);

    Employee employee6 = new Employee("",3,10000);
    Employee employee7 = new Employee("",5,20000);
    Employee employee8 = new Employee("",4,30000);
    Employee employee9 = new Employee("",4,30000);


    Employee employee10 = new Employee("",5,22000);
    Employee employee11 = new Employee("",2,30000);
    Employee employee12 = new Employee("",3,40000);

    Employee employee13 = new Employee("",3,10000);
    Employee employee14 = new Employee("",3,12000);

    ArrayList<Employee> employees = new ArrayList<Employee>();
    ArrayList<Employee> employees2 = new ArrayList<Employee>();
    ArrayList<Employee> employees3 = new ArrayList<Employee>();
    ArrayList<Employee> employees4 = new ArrayList<Employee>();

    @Test
    public void testOne(){
       ShipIndustry shipIndustry = new ShipIndustry();
       int headCount = 1;
       initializeData();
       shipIndustry.setOrgHierarchy(employee5);
       shipIndustry.findCostRecursively(employee5, headCount);
       Assert.assertEquals(42000,shipIndustry.getCostSaved());
    }

    @Test
    public void testTwo(){
        ShipIndustry shipIndustry = new ShipIndustry();
        int headCount = 2 ;
        initializeData();
        shipIndustry.setOrgHierarchy(employee);
        shipIndustry.findCostRecursively(employee, headCount);
        Assert.assertEquals(222000,shipIndustry.getCostSaved());
    }



    public  void initializeData(){

        employees4.add(employee13);
        employees4.add(employee14);
        employee10.setReportees(employees4);


        employees2.add(employee10);
        employees2.add(employee11);
        employees2.add(employee12);
        employee5.setReportees(employees2);

        employees3.add(employee6);
        employees3.add(employee7);
        employees3.add(employee8);
        employees3.add(employee9);
        employee2.setReportees(employees3);

        employees = new ArrayList<Employee>();
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);
        employee.setReportees(employees);

    }
    public  void bootStrap(ShipIndustry shipIndustry,int headCount){
        initializeData();
    }

}