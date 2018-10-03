1. give an order condition(array, etc.), it could use two pointers method probably
2. [Entrance-Increment-Exit-Decrement is a typical way to solve interval problem. Another typical way is using binary search for a sorted interval array](http://leetcode.com/problems/my-calendar-ii/discuss/109522/Simplified-winner's-solution/111426)
3. scala variable initialization e.g., val str, s1, s2, s3 = "chenfh5_scala_test"
4. int mid=start+(end-start)/2 is better than int mid=(start+end)/2. since start+end would be too large, but (end-start)/2 would cut many at first. @see https://leetcode.com/problems/first-bad-version/discuss/71311/A-good-warning-to-me-to-use-start+(end-start)2-to-avoid-overflow
5. substring is consecutive, but subsequence is not. like, raw=abcdefg, substring=cde(not cdf), subseq=cde(or cdf)

