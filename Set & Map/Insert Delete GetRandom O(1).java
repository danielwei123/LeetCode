class RandomizedSet {

    // nums: int val
    // loc: key - int val; value - location
    List<Integer> nums;
    Map<Integer, Integer> loc;
    java.util.Random rand = new java.util.Random();
    
    public RandomizedSet() {
        loc = new HashMap<>();
        nums = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if (loc.containsKey(val)) {
            return false;
        } else {
            loc.put(val, nums.size());
            nums.add(val);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if (!loc.containsKey(val)) {
            return false;
        } else {
            // swap the val that needs to removed with the last element
            // so that we can always remove the last element in the nums list
            int l = loc.get(val);
            if (l < nums.size() - 1) {
                int lastone = nums.get(nums.size() - 1);
                nums.set(l, lastone);
                loc.put(lastone, l);
            }
            loc.remove(val);
            nums.remove(nums.size() - 1);
            return true;
        }
    }
    
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */