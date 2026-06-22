class Solution {
    /**
     * @param {string[]} strs
     * @return {string[][]}
     */
    groupAnagrams(strs: string[]): string[][] {
        const resultMap = new Map<string, Array<string>>();

        for(let i=0;i<strs.length;i++){
            let alphs = new Array(26).fill(0);
            let str = strs[i];
            for(let j=0;j<str.length;j++){
                alphs[str.charCodeAt(j)-97]++;
            }
            const key = alphs.join(',');
            if(!resultMap.has(key)) resultMap.set(key,[]);
            resultMap.get(key).push(str);
        }

        return Array.from(resultMap.values());

        
    }
}
