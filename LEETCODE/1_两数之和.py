class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        if not nums:
            return None
        dict ={}
        for index, num in enumerate(nums):
            another_num = target - num
            # 如果字典中存在的话就直接返回，不存在的话就一直添加啦，反正之后会碰到的
            # in关键字用于字典时，只会检查key，不会检查value
            if another_num in dict:
                return [dict[another_num], index]
            dict[num] = index
        return None