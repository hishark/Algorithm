class Solution:
    def isPalindrome(x):
        array = list(str(x))
        length = len(array)
        flag = True
        for index, value in enumerate(array):
            if array[index] == array[length-index-1]:
                continue
            else:
                flag = False
        return flag