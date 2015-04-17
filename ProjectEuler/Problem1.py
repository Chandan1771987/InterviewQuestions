
"""
def func(x):
	return x%3==0 or x%5 ==0
	
def add(x,y):
	return x+y


filter(func, range(1,1000))

map(add,filter(func,range(1,1000)))

"""
		
reduce(lambda m,n : m+n,filter(lambda x: x%3==0 or x%5==0,range(1,1000)))