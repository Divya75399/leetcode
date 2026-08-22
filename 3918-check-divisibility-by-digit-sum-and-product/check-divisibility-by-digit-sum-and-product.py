class Solution(object):
    def checkDivisibility(self, n):
        temp=n
        sum=0
        product=1
        while temp>0:
            digit=temp%10
            sum=sum+digit
            product=product*digit
            temp=temp//10
        return n%(product+sum)==0

        