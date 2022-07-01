/* #Problem6

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows 
like this: (you may want to display this pattern in a fixed font for better  legibility.)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of 
rows:

string convert(string s, int numRows);

*/

class Solution {
    public String sconvert(String s, int numRows) {
        Map<Integer, StringBuilder> map = new HashMap<>();
        int pos = 0;
        boolean incr = true;
        for (char c : s.toCharArray()) {
            if (pos == numRows)
                incr = false;
            if (pos == 1)
                incr = true;
            if (incr)
                pos++;
            else
                pos--;

            if (!map.containsKey(pos))
                map.put(pos, new StringBuilder());
            map.get(pos).append(c);
        }
        StringBuilder res = new StringBuilder();
        for (int i : map.keySet()) {
            res.append(map.get(i));
        }

        return res.toString();

    }
}

