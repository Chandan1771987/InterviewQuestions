This puzzle aims at providing an algorithm for image pattern matching out of the rawData provided.


ENCODING MECHANISM :
Proposed solution to this problem aims at encoding the available patterns to a compressed format.

The encoding mechanism works in this fashion. The file is parsed and the are identified.
The pattern is then considered to be in the rectangular form with M rows and N Columns.

The character + is considered to be 1. The character ' ' is considered to be 0.

Each row is then represented in terms of 0's and 1's. Now each row is converted to decimal equivalent of the binary digit.

So the encoded data is an array of Strings where each string is decimal equivalent of binaryRepresentation.

In this fashion both Proton Patterns and Ravage patterns are encoded into arrayOf strings.


PATTERN MATCHING :
Given rawData is too huge to be searched for the patterns. Hence, the proposed solution first
preprocess this rawData to a suitable encoded format and stores it.
This rawData is in terms of Array of Strings. This is stored inMemory.
We then start matching the pattern at everyIndex in this rawData(Array of Strings)


HOW A DETECTED_PATTERN IS MATCHED WITH THE PROTON_PATTERN OR RAVAGE_PATTERN :
Lets consider the detectedPattern is like this {234,334,456,678}
Proton_Pattern is {230,334,456,678}

Now every number in detectedPattern is bitWiseXOred with every number of Proton_Pattern.
If the pixels differ, then the result will be a decimal number. Number of 1's in that result gives the total
number of pixels differ.


TOLERANCE :
The definition which I have assumed for coding purpose is the confidence level >= which the pattern
is considered to be matched.


CONFIDENCE_METRIC:
confidence = ((totalPixels - totalPixelsNotMatching)*100/totalPixels)











