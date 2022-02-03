# ActiveUsers

This program counts the "daily active users" from a file stream.\
It can be easily adjusted to count "monthly", "yearly" or many others time-frames.

---

### Time Complexity:
O(n) - where n is the number of loggins, since we only iterate once over the input and save it in HashTable which has O(1) insertion on average.\
and getting the "active users" only cost us O(1) since it's a simple method which returns the size of a HashSet.
  
### Time Complexity:
O(n) - where n is the number of loggins, since we keep our data in an HashTable of HashSets so we only need O(1) space for every logging.
