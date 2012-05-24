#include<stdio.h>
#include<math.h>
#include<stdlib.h>
void spiral( int a[100][100],int m,int n)
 { 
int total=0,i=0,j=0,k; 
int start_row=0,start_col=0; 
int temp1=m; 
int temp2=n; 
int order=m*n;
printf(" %d is the order of the matrix\n\n",order); 
//  while(total<order-1) 

  for(;;)
  { 
   i=start_row; 
   j=start_col; 
 	
	

   	while(j<temp2&&total<order)//traversing the row keeping row constant and column increasing 
   	{	
   		 printf("%4d ",a[i][j]);
   		 total++;
   		 j++;
   	}
	printf("\n");
		j=j-1; // because j would have been equal to temp2 so decementing it. 
	
   	while(i<temp1-1&&total<order)// traversing the column keeping column constant and row increasing
   	{
   		 i++;
   		 printf("%4d ",a[i][j]);
   		 total++;
   	}
		
	printf("\n");
		
   	while(j>start_col&&total<order)  // traversing row by keeping row constant and decrementing the column
   	{
   		 j--;
   		 printf("%4d ",a[i][j]);
		 total++;
   	} 
	
	printf("\n");
   	while(i>start_row+1&&total<order) // traversing the column by keeping column constant and decrementing the row.  
   	{ 
   		 i--; 
   		 printf("%4d ",a[i][j]);  
		 total++;

   	} 
	printf("\n");
	if(total>=order)
	{
		printf("total number of elements is %5d\n",total);
		exit(0);
	}
  	start_col++; 
	start_row++; 
	temp1--; 
	temp2--;
  } 

} // end of spiral 
 	
int main() 
 { 
int i,j,m,n; 
int array[100][100];
printf("Enter the value of m \n");
scanf("%d",&m);
printf("Enter the value of n \n");
scanf("%d",&n);
printf("Accepting the elements of the matrix\n");
	for(i=0;i<m;i++)
	{	
		for(j=0;j<n;j++)
		{
			array[i][j]=rand()%(m*n);
			//scanf("%d",&array[i][j]);
		}
	
	}
	printf(" The matrix you have entered is shown below \n");
	for(i=0;i<m;i++)
	{
		for(j=0;j<n;j++)
		{
			printf("%5d",array[i][j]);
	
		}
		printf("\n");
	}

	if (m==1 && n==1)
	{	
		printf("The Spiral order the matrix is shown below :\n");
		printf(" %d \n",array[0][0]);
		printf("The matrix contains only only one element\n");
		return 0;
	}
	
	if(m==1 && n !=1)
	{
		j=0;
		printf("The Spiral order the matrix is shown below :\n");
		while(j<n)
		{
			printf("%d ",array[0][j]);
			j++;
		}
		printf("\nThis is a Row Matrix and number of elements are %d \n",(1*n));
		return 0;
	}
	if (m!=1 && n==1) 
	{	
		i=0;
		printf("The Spiral order the matrix is shown below :\n");
		while(i<m)
		{
			printf("%d \n",array[i][0]);
			i++;
		}
		printf("This is a Column Matrix and number of elements are %d \n",(m*1));
		return 0;
	}

	else
		spiral(array,m,n); 
return 0;
} 



