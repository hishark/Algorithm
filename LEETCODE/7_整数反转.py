class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        if x == 0:
            return 0
        temp = ''
        if x < 0:
            temp += '-'
            x = -x
        s = str(x)[::-1]
        if s[0] == '0':
            s = s[1:]
        temp += s
        result = int(temp)
        if -2**31<=result<=2**31-1:
            return result
        else:
            return 0