class Solution:
    def longestCommonPrefix(strs):
        if len(strs) == 0:
            return ""
        prefix = ''
        minlen = len(strs[0])
        length = len(strs)
        for str in strs:
            if len(str) < minlen:
                minlen = len(str)
        k = 0
        while k < minlen:
            char = strs[0][k]
            i = 1
            flag = True
            while i < length:
                if k == 0:
                    if strs[i][k] != char:
                        return ""
                if strs[i][k] == char:
                    i += 1
                    continue
                else:
                    flag = False
                    break
            if flag:
                prefix += char
            k += 1
        return prefix
