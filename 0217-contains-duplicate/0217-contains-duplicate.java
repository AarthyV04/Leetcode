class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hs=new HashSet<>();
        for(int val:nums){
            if(hs.contains(val)){
                return true;
            }
            hs.add(val);
        }
        return false;
    }
}