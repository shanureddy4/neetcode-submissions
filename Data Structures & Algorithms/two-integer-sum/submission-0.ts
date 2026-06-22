class Solution {
    /**
     * @param {number[]} nums
     * @param {number} target
     * @return {number[]}
     */
    twoSum(nums: number[], target: number): number[] {
        const map = new Map<number, number>();
        const arr = [];
       for(let i=0;i<nums.length;i++){
        let complement = target-nums[i];
        if(map.has(complement)){
            arr.push(i);
            arr.push(map.get(complement));
        }
        map.set(nums[i],i)
       }
       return arr;
    }
}
