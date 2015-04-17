"""
Read the input from the file line by line.

Sort the words and append them. 

Write them back to the output file.

"""
reader = open("/Users/achandan/Downloads/studious_student.txt","r")
writer = open("/Users/achandan/Downloads/studious_output.txt","a")
totalNumberOfInput = int(reader.readline())
for i in range(totalNumberOfInput+1):
	inputWords = reader.readline().split()[1:]
	inputWords.sort()
	temp=""
	for i in inputWords:
		temp+=i
	writer.write(str(temp)+"\n")
	print temp
	