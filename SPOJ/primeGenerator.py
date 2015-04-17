
"""

SPOJ Problem Set (classical)

2. Prime Generator

Problem code: PRIME1

Peter wants to generate some prime numbers for his cryptosystem. Help him! Your task is to generate all prime numbers between two given numbers!

Input

The input begins with the number t of test cases in a single line (t<=10). In each of the next t lines there are two numbers m and n (1 <= m <= n <= 1000000000, n-m<=100000) separated by a space.

Output

For every test case print all prime numbers p such that m <= p <= n, one number per line, test cases separated by an empty line.

Example

Input:
2
1 10
3 5

Output:
2
3
5
7

3
5




"""




def generatePrimeNumbers(endNumber):
	i=0
	divisor=2
	primeNumbers=[]
	for i in range(int(endNumber)+1):
		primeNumbers.append(1)
		
	while divisor*divisor<=int(endNumber):
		j=divisor*divisor
		while j<=int(endNumber):
			primeNumbers[j]=0
			j+=divisor
		divisor=divisor+1
	return primeNumbers
	
def printInMentionedRange(primeNumbers,x,y):
	result=[]
	for i in range(int(x),int(y)+1):
		if  primeNumbers[i]==1:
			result+=[i]
	return result


startNumber=[]
endNumber=[]




if __name__ == '__main__':
		
		count=0
		startNumber=[]
		endNumber=[]
		totalTestCases=input()
		for count in range(totalTestCases):
			testData=input()
			startNumber+= [testData.split()[0]]
			endNumber += [testData.split()[1]]

		if int(totalTestCases)>10:
				exit()	
		else:
			
			for i,j in zip(startNumber,endNumber):
				primeNumbers=[]
				diff=int(j)-int(i)
				if(int(i)>=1 and int(i)<=int(j) and int(j)>=1 and int(j)<=1000000000 and int(diff)<=100000):
					primeNumbers=generatePrimeNumbers(j)			           
					result=printInMentionedRange(primeNumbers,i,j)
					for temp in result:
						print(temp)
					print("\n")
					
				else:
					exit()


	




	


