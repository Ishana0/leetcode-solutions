class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        HashSet<Integer> set = new HashSet<>();

        for(int friend : friends) {
            set.add(friend);
        }

        int[] result = new int[friends.length];

        int index = 0;

        for(int racer : order) {
            if(set.contains(racer)) {
                result[index] = racer;
                index++;
            }
        }
        return result;
    }
}