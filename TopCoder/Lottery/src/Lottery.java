import java.util.ArrayList;
import java.util.Hashtable;
import java.util.StringTokenizer;

import static java.util.Collections.sort;

public class Lottery {

    StringTokenizer str;
    Hashtable ruleSet = new Hashtable();
    ArrayList<Double> probabilitiesOfRules = new ArrayList<Double>();
    String resultingLotteryRules[] ={};
    int m,listLength;
	public String[] sortByOdds(String[] rules) {

        if(rules.length!=0){
        for(String test:rules){

            String temp[]=test.split(":");
            str = new StringTokenizer(temp[1]);
            ArrayList<String> values = new ArrayList<String>();
            while(str.hasMoreTokens()){
                values.add(str.nextToken());
            }

            double probability= calculateScore(values);
            ruleSet.put(probability,temp[0]);
            probabilitiesOfRules.add(probability);

        }

            sort(probabilitiesOfRules);
            resultingLotteryRules = new String[probabilitiesOfRules.size()];
            m=0;
            listLength = resultingLotteryRules.length;
            for(Double temp:probabilitiesOfRules) {
                if(m<listLength){

                     resultingLotteryRules[m]=ruleSet.get(temp).toString();
                    System.out.println("String is :"+resultingLotteryRules[m]+"  Temp is :"+temp);
                }
                m++;
            }

            return resultingLotteryRules;
        }
        else

		return new String[] { };
	}



     public double calculateScore(ArrayList<String> values){
         double result=0;
         if(values.size()!=0 && values.size()==4){
           if(values.get(2).equalsIgnoreCase("T") && values.get(3).equalsIgnoreCase("F")){
               System.out.println("I am inside 1");
               //If its a 2 digit case, total repititions are 10. (11,22,33,44,55,66,77,88,99,00)
               //If its a 3 digit case, total repititions are 10 + 111,222,333,444,... which is
               //10 + 9
               //If its a 4 digit case is 10 + 9 X 2
               // If its an n digit case then it is 10 + 9 X (n - 2)
               if(Double.parseDouble(values.get(1))>1)
                   result=nCr(Double.parseDouble(values.get(0)),Double.parseDouble(values.get(1)))+(10 + (9 * (Double.parseDouble(values.get(1))  - 2)));
               System.out.println("Result is :"+result);
               //result=nCr(Double.parseDouble(values.get(0)),Double.parseDouble(values.get(1))) + Math.pow(Double.parseDouble(values.get(0)),Double.parseDouble(values.get(1))) - nPr(Double.parseDouble(values.get(0)),Double.parseDouble(values.get(1)));
               //result=nCr(Double.parseDouble(values.get(0)),Double.parseDouble(values.get(1))) + Double.parseDouble(values.get(0));
               return result;
           }

           else if(values.get(2).equalsIgnoreCase("T") && values.get(3).equalsIgnoreCase("T")){
               System.out.println("I am inside 2");
               result=nCr(Double.parseDouble(values.get(0)),Double.parseDouble(values.get(1)));
               return result;
           }
           else if(values.get(2).equalsIgnoreCase("F") && values.get(3).equalsIgnoreCase("F")){
               System.out.println("I am inside 3");
             result = Math.pow(Double.parseDouble(values.get(0)),Double.parseDouble(values.get(1)));
             return  result;
           }
            else if(values.get(2).equalsIgnoreCase("F") && values.get(3).equalsIgnoreCase("T")){
               System.out.println("I am inside 4");
               result = nPr(Double.parseDouble(values.get(0)),Double.parseDouble(values.get(1)));
               return result;
           }

         }

            return 0;
        }

    public double nCr(double n,double r){
      double result=0;
        result = nPr(n,r)/factorial(r);
        return result;
    }

    public double nPr(double n,double r){
        double result=0;
        result = factorial(n)/(factorial(n-r));
        return result;
    }

    public double factorial(double n){
        double result=0;
        if(n==0 || n==1) return 1;

        else
            return n * factorial(n-1);

    }
}
