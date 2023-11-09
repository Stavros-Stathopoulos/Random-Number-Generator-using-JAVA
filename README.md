# Random-Number-Generator-using-JAVA
This is a Generator tha tgenerates random numbers with two different aproaches

Random Number Generators are not fully random. Thas why they also called pseudorandom number generator (PRNG).

This Generators in this project cannot be used for Cryptography, because may not meet the standads.

With the method nextInt_LFSR, running for 10 minutes, we found this diagram:

![image](https://github.com/Stavros-Stathopoulos/Random-Number-Generator-using-JAVA/assets/38631315/6eced3e7-b705-4805-99f9-90646f2575fb)

this implements that there are some patterns in the numbers produced from this method
When re run the method for 25 seconds, the graph was like that:
![image](https://github.com/Stavros-Stathopoulos/Random-Number-Generator-using-JAVA/assets/38631315/b883d4c7-dcfb-4ce2-9f54-ebbd0be5740a)

So that can implement that the patern may be something like that.


In Any case, with further tests we are going to improve the function, so that the patern will not be so obvious.


In the future, we are going to:

  increce the period of this patern to make it less obvious
  
