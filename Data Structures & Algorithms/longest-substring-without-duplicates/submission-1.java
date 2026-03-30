class Solution {
  public int lengthOfLongestSubstring(String s) {
    int[] last = new int[256];                  // ASCII
    java.util.Arrays.fill(last, -1);

    int left = 0, best = 0;                     // window = [left, r]
    for (int r = 0; r < s.length(); r++) {
      int c = s.charAt(r);
      if (last[c] >= left) left = last[c] + 1;  // jump left inside window
      last[c] = r;                              // update last seen
      best = Math.max(best, r - left + 1);      // r inclusive
    }
    return best;
  }
}
