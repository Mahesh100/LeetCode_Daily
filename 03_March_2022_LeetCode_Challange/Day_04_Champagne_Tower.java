class Solution {
    
    public double champagneTower(int poured, int row, int query) {
    List<Double>[] list = new List[row + 1];
    for (int i = 0; i <= row; i++) {
        list[i] = new ArrayList<>(i + 1);
        for (int j = 0; j < i + 1; j++) {
            list[i].add(0D);
        }
    }
    list[0].set(0, poured * 1.0D);
    for (int i = 0; i < row; i++) {
        for (int j = 0; j < i + 1; j++) {
            double t = list[i].get(j);
            if (t <= 1) continue;
            t = t - 1;
            list[i + 1].set(j, list[i + 1].get(j) + t / 2);
            list[i + 1].set(j + 1, list[i + 1].get(j + 1) + t / 2);
        }
    }
    double res =  list[row].get(query);
    return res > 1D ? 1.0D : res;
}
}