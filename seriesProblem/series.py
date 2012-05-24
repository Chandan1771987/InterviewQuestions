
a =[x for x in range(2400)]

for i in range(len(a)/3):
	a[i],a[3*i+0]=a[3*i+0],a[i]
	a[i+len(a)/3],a[3*i+1]=a[3*i+1],a[i+len(a)/3]
	a[i+2*len(a)/3],a[3*i+2]=a[3*i+2],a[i+2*len(a)/3]
	
print a