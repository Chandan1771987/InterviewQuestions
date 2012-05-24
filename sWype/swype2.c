#include<stdio.h>
#include<string.h>
#include<stdlib.h>
void initialize(int countElementsOfRow[3][255])
{
	int i,j;
	for(i=0;i<3;i++)
	{
		for(j=0;j<255;j++)
		{
		countElementsOfRow[i][j]=0;
		}
	}	
}

void swype(int countElementsOfRow[3][255],char givenString[255])
{
	int i=0,j=0,count=0,flag=1,row;
	char rows[3][255];
	char suggestedString[255]={};
	char temp2[3][255]={"qwertyuiop","asdfghjkl","zxcvbnm"};
	for(i=0;i<3;i++)
	{
		for(j=0;j<255;j++)
		{
			rows[i][j]=' ';
		}
	}
	initialize(countElementsOfRow);
	for(i=0;i<3;i++)
	{
//		printf("%d is length of temp2[%d]\n",strlen(temp2[i]),i);
		for(j=0;j<strlen(temp2[i]);j++)
		{	
			rows[i][temp2[i][j]]=temp2[i][j];
			countElementsOfRow[i][temp2[i][j]]=0;
//			printf("rows[%d][%c] = %c ",i,temp2[i][j],rows[i][temp2[i][j]]);
		}
		printf("\n");
	}
	i=0;j=0;
	for(;;)
	{	
		flag=0;
		for(row=0;row<3;row++)
		{
				while(givenString[i]==rows[row][givenString[i]] && i<strlen(givenString))
				{
					count++;
					if(i==0 || (count==1 && givenString[i-1]!=rows[row][givenString[i-1]]) )
					{
						suggestedString[j++]=givenString[i++];
						if(givenString[i]!=rows[row][givenString[i]] && i<strlen(givenString))
						{
							suggestedString[j++]=givenString[i++];
						}
						continue;
					}						
					else if(givenString[i]==rows[row][givenString[i]] && givenString[i+1]!=rows[row][givenString[i+1]] && (i+1)<strlen(givenString))
					{
						suggestedString[j++]=givenString[i++];
						count=0;
						initialize(countElementsOfRow);			
						continue;
					}					
					else if( givenString[i]==rows[row][givenString[i]] && (countElementsOfRow[row][givenString[i]]%2) == (countElementsOfRow[row][givenString[i+1]]%2) && i<strlen(givenString))
					{
//						printf("it entered ths loop\n");
						countElementsOfRow[row][givenString[i++]]++;
						flag=1;
						continue;
					}
					else if( givenString[i]==rows[row][givenString[i]] && (countElementsOfRow[row][givenString[i]]%2)!=(countElementsOfRow[row][givenString[i+1]]%2) && i<strlen(givenString))
					{
						if(countElementsOfRow[row][givenString[i]]<countElementsOfRow[row][givenString[i+1]])
						{
							countElementsOfRow[row][givenString[i]]++;
							suggestedString[j]=givenString[i++];
						}
						else
						{
							countElementsOfRow[row][givenString[i]]++;
							suggestedString[j]=givenString[i+1];
							i=i+2;
						}								
//						printf("%c is the second touched character \n",suggestedString[j]);			
						j++;
						flag=1;
						continue;
					}	
			
				}//while	
				count=0;
				initialize(countElementsOfRow);			
				if(i>=strlen(givenString))
				{
			
					printf("\n%s is the suggested character ",suggestedString);
					return;
				}
		}//for
	}//for

}//swype

int main()
{
int i;
char strings[10][255]={"chgfdsandsan","poiunbvctyuatyuion","srtyuinivasa","samarthuytrs","qwertyuytrertyuytrertyuytre","krtyuisdfghna","guytrtyuytrasdfghjhgfdsa","googhjkle"};
int countElementsOfRow[3][255]={};
for(i=0;i<8;i++)
{
	swype(countElementsOfRow,strings[i]);
}
return 0;
}


