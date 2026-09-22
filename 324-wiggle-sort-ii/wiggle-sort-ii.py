class Solution:
    def wiggleSort(self, nums):
        arr = sorted(nums)

        n = len(nums)
        mid = (n + 1) // 2

        left = mid - 1
        right = n - 1

        for i in range(n):
            if i % 2 == 0:
                nums[i] = arr[left]
                left -= 1
            else:
                nums[i] = arr[right]
                right -= 1
        