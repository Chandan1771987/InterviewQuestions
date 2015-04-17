public class RainyRoad {
    public String isReachable(String[] road) {
           String temp1 = road[0];
            String temp2 = road[1];

            int firstRoadLength = temp1.length();
            int secondRoadLength = temp2.length();

         int destinationCount = 0;
        if (road.length ==2 ) {

            if (firstRoadLength == secondRoadLength && temp1.charAt(0)!= 'W') {


                while (destinationCount <2*secondRoadLength) {

                    for (int i = 0; i < 2; i++) {


                        for (int j = 0; j < secondRoadLength; j++) {

                            if (temp1.charAt(j) == 'W' && temp2.charAt(j) == 'W' || temp2.charAt((j+1)%secondRoadLength)=='W' && temp1.charAt((j+1)%secondRoadLength) == 'W')
                                                 return "NO";

                            else if (temp1.charAt(j) == 'W' && temp2.charAt((j+1)%secondRoadLength) == '.' || temp2.charAt(j) == '.' && temp1.charAt((j+1)%secondRoadLength) == 'W') {

                               destinationCount++;

                            }

                            else if(temp1.charAt(j)=='.' || temp2.charAt(j)=='.'){
                                  destinationCount++;
                                }

                        }

                    }
                }

    if(destinationCount<2*secondRoadLength && destinationCount>secondRoadLength)
    {  System.out.println("Destination count is : "+destinationCount);
        return "NO";
    }
        else return "YES";
            }
            else
               return "NO";

        }

    else
        {

            return "NO";
        }



}

}



