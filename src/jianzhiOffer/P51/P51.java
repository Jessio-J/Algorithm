package jianzhiOffer.P51;

public class P51 {
    int cnt;
    public int InversePairs(int[] array) {
        cnt = 0;
        if (array != null)
            mergeSortUp2Down(array, 0, array.length - 1);
        return cnt;
    }

    /*
     * 归并排序(从上往下)
     */
    public void mergeSortUp2Down(int[] a, int start, int end) {
        if (start >= end)
            return;
        int mid = (start + end) >> 1;

        //先裂开成左右两端数组
        mergeSortUp2Down(a, start, mid);
        mergeSortUp2Down(a, mid + 1, end);
        //再合并成一个数组
        merge(a, start, mid, end);
    }

    /*
     * 将一个数组中的两个相邻有序区间合并成一个
     * 进入合并过程的左右两端都是排列好的
     */
    public void merge(int[] a, int start, int mid, int end) {
        //中间辅助数组
        int[] tmp = new int[end - start + 1];

        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            if (a[i] <= a[j])
                //如果是正序
                tmp[k++] = a[i++];
            else {
                //如果是逆序
                tmp[k++] = a[j++];
                //左端a[i]后面的都算是对a[j]的逆序对
                cnt += mid - i + 1;
            }
        }
        //将剩下的加入到辅助数组中
        while (i <= mid)
            tmp[k++] = a[i++];
        while (j <= end)
            tmp[k++] = a[j++];
        //将辅助数组编程合并后的排序数组
        for (k = 0; k < tmp.length; k++)
            a[start + k] = tmp[k];
    }
}
