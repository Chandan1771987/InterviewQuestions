a = [x for x in range(1,16)]
count=0
k = len(a)
l = len(a)//3
for i in range(k):
	j = (i % 3) * l + i//3
	while(j<i):
		j = (j % 3) * l + j//3
		count+=1
	a[i],a[j] = a[j],a[i]
print a
print count