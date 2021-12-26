/* https://leetcode.com/problems/intervals-between-identical-elements/ 
*/
//Method:1
class Solution {
    public long[] getDistances(int[] arr) {
        int n = arr.length;
        long[] result = new long[n];
        long[] prefixSum=new long[n];
        long[] suffixSum=new long[n];
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i=0; i<n; i++) {
            ArrayList<Integer> list = map.getOrDefault(arr[i], new ArrayList<>());
            list.add(i);
            map.put(arr[i], list);
        }
        for (Map.Entry<Integer, ArrayList<Integer>> entry: map.entrySet()) {
            ArrayList<Integer> temp=entry.getValue();
            for(int i=1;i<temp.size();i++) {
                prefixSum[temp.get(i)]=prefixSum[temp.get(i-1)]+i*(temp.get(i)-temp.get(i-1));
            }
            for(int i=temp.size()-2; i>=0;i--) {
                suffixSum[temp.get(i)]=suffixSum[temp.get(i+1)]+(temp.size()-1-i)*(temp.get(i+1)-temp.get(i));
            }
            }
        for(int j=0; j<n; j++) {
            result[j]=suffixSum[j]+prefixSum[j];
        }
        return result;
        
    }
}

//Method:2
class Solution {
    public long[] getDistances(int[] arr) {
        int n = arr.length;
        long[] result = new long[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i=0; i<n; i++) {
            List<Integer> list = map.getOrDefault(arr[i], new ArrayList<>());
            list.add(i);
            map.put(arr[i], list);
        }
        for (Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
            List<Integer> list = entry.getValue();
            long sum = 0;
            for (int num: list) {
                sum += (long) num;
            }
            long preSum = 0;
            int size = list.size();
            for (int i=0; i<size; i++) {
                int num = list.get(i);
                preSum += num;
                result[num] = sum + (2*i+2-size)*(long)num - 2*preSum;
            }
        }
        return result;
        
    }
}
