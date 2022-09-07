//이분탐색을 활용한 upper bound lower bound
//이진 탐색은 정확히 같은 값의 index를 찾는 것에 비해 
//Lower Bound는 target 값보다 같거나 큰 값이 처음으로 나올 때 Return
//Upper Bound의 경우 target 값보다 큰 값이 처음 나온 index를 반환한다.

class UpperBoundLowerBound {
    static int lowerBound(int[] array,  int value) {
        int start = 0;
        int end = array.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (value > array[mid]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }
    static int upperBound(int[] array, int value) {
        int start = 0;
        int end = array.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (value >= array[mid]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }
}
