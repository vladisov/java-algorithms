package dev.algos.snatch.data_structures.consistent_hashing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;

public class ConsistentHashing_II {

    private final TreeMap<Integer, Integer> tm = new TreeMap<>();
    private final int[] nums; //machines
    private final int k; // microShards
    private int size = 0;

    public ConsistentHashing_II(int n, int k) {
        this.nums = new int[n];
        for (int i = 0; i < n; i++) this.nums[i] = i;

        //shuffle
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int j = random.nextInt(i + 1);
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
        this.k = k;
    }

    //number of machines and number of micro shards
    public static ConsistentHashing_II create(int n, int k) {
        return new ConsistentHashing_II(n, k);
    }

    // @param machine_id an integer
    // @return a list of shard ids
    public List<Integer> addMachine(int machine_id) {
        List<Integer> ids = new ArrayList<>();
        for (int i = 0; i < this.k; i++) {
            int id = this.nums[size++ % this.nums.length];
            ids.add(id);
            this.tm.put(id, machine_id);
        }
        return ids;
    }

    // @param hashcode an integer
    // @return a machine id
    public int getMachineIdByHashCode(int hashcode) {
        if (tm.isEmpty()) return 0;
        Integer ceiling = tm.ceilingKey(hashcode);
        if (ceiling != null) return tm.get(ceiling);
        return tm.get(tm.firstKey());
    }
}
