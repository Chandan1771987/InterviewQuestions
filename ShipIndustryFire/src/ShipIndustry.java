import java.util.ArrayList;

/**
 * Created by chandan.marathe on 11/21/2015.
 */

/**
 * SHipINdustry class which houses employees in the form of composition.
 * Sets the industryHead and finds the maxCost recursively.
 */
public class ShipIndustry {


    private Employee industryHead;

    public int getCostSaved() {
        return costSaved;
    }

    private static int costSaved = 0;

    public void setOrgHierarchy(Employee boss){
        this.industryHead = boss;
    }

    public void findCostRecursively(Employee employee,int headCount){
        if(employee.getReportees()==null || employee.getReportees().size()==0){
            return;
        }
        else {
            costSaved += employee.getCostSavings(headCount);
            for (Employee e : employee.getReportees()) {
                findCostRecursively(e, headCount);
            }
        }
    }

}
