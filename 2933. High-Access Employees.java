/**2933. High-Access Employees
 * You are given a 2D 0-indexed array of strings, access_times, with size n. For each i where 0 <= i <= n - 1, access_times[i][0] represents the name of an employee, and access_times[i][1] represents the access time of that employee. All entries in access_times are within the same day.

The access time is represented as four digits using a 24-hour time format, for example, "0800" or "2250".

An employee is said to be high-access if he has accessed the system three or more times within a one-hour period.

Times with exactly one hour of difference are not considered part of the same one-hour period. For example, "0815" and "0915" are not part of the same one-hour period.

Access times at the start and end of the day are not counted within the same one-hour period. For example, "0005" and "2350" are not part of the same one-hour period.

Return a list that contains the names of high-access employees with any order you want.
 */

import java.util.*;
class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        Map<String,List<Integer>> map = new HashMap<>();
        for(List<String> a:access_times)
        {
            if(!map.containsKey(a.get(0))){
                map.put(a.get(0), new ArrayList<>());
            }
            char[] s = a.get(1).toCharArray();
            int h = (s[0]-'0')*10 + s[1]-'0';
            int m = (s[2]-'0')*10 + s[3]-'0';
            map.get(a.get(0)).add(h*60+m);
        }
        List<String> ans = new ArrayList<>();
        for(String key: map.keySet())
        {
            List<Integer> val = map.get(key);
            Collections.sort(val);
            for(int i=0;i<val.size()-2;i++)
            {
                if(val.get(i+2)-val.get(i)<=59)
                {
                    ans.add(key);
                    break;
                }
            }
        }
        return ans;
    }
}