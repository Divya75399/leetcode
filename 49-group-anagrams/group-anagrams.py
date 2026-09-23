class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        d={}
        for s in strs:
            key=''.join(sorted(s))
            if key in d:
                d[key].append(s)
            else:
                d[key]=[s]
        return list(d.values())

                
        