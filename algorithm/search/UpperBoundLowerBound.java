//이분탐색을 활용한 upper bound lower bound
//이진 탐색은 정확히 같은 값을 찾는 것에 비해 Lower Bound는 주어진 인자 값보다 작거나 큰 값이 처음으로 나올 때 Return
//Lower Bound와 마찬가지의 방식이지만 Upper Bound의 경우 인자 값보다 큰 첫번째 위치를 반환한다.
class UpperBoundLowerBound {
	static int lowerBound(int[] array,  int value) {
        int low = 0;
        int high = array.length;
        while (low < high) {
            int mid = low + (high - low)/2;
            if (value <= array[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
	static int upperBound(int[] array, int value) {
        int low = 0;
        int high = array.length;
        while (low < high) {
            int mid = low + (high - low)/2;
            if (value >= array[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}