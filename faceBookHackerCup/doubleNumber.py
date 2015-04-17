import math

"""def doubleNumber():
	f = open("/Users/achandan/Downloads/double_squares.txt","r")
	count=0	
	solution=[]
	total=int(f.readline())
	for l in range(1,total+1):
		n=int(f.readline())
		temp4=int(math.sqrt(n))
		print "number is ",temp4
		for i in range(temp4):
			temp1 = i*i;
			temp2 = n - temp1;
			for j in range(temp4):
				if i!=j :
					if j!=0:	
						if temp2%j==0:
							temp3 = temp2/j
							if  temp3%j==0 and temp3/j==1 and not([j,i] in solution) :
								count=count+1
								solution+=[[i,j]]
					else:
						if temp2==0 and not([j,i] in solution) :
							count=count+1
							solution+=[[i,j]]
	print count,solution
#doubleNumber()

"""

def doubleNumberAlternative():
	reader = open("/Users/achandan/Downloads/double_squares.txt","r")
	writer=open("/Users/achandan/Downloads/double_squares_output3.txt","a")
	total=int(reader.readline())
	print total
	for l in range(1,total+1):
		n=int(reader.readline())
		temp4=int(math.sqrt(n))
		count=0	
		solution=[]
		for i in range(temp4+1):
			temp1 = i*i;
			temp2 = n - temp1;
			temp5 = int(math.sqrt(temp2))
			for j in range(temp5+1):
				if i!=j :
					if j*j == temp2 : 
						if not([j,i] in solution):
							print temp2
							count=count+1
							solution+=[[i,j]]
		writer.write(str(count)+"\n")
#doubleNumberAlternative()


"""
Provides i , j such that givenNumber = iSquare + jSquare
"""

def doubleSquare(n):
		totalInputSets=int(math.sqrt(n))
		count=0	
		solution=[]
		for i in range(totalInputSets+1):
			iSquare = i*i;
			nMinusISquare = n - iSquare;
			jComparator = int(math.sqrt(nMinusISquare))
			for j in range(jComparator+1):
				if i!=j :
					if j*j == nMinusISquare : 
						if not([j,i] in solution):
							count=count+1
							solution+=[[i,j]]
		print count,solution
doubleSquare(2500000000)



