def fibonacci(n):
	
	a,b,c,sum=0,1,2,2
	
	while c<n:
		a,b=b,c
		c=a+b
		if(c>=n):
			break
		if(c%2==0):
			sum+=c
        print(sum)			
fibonacci(4000000)
	
