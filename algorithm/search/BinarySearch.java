//이진탐색
class BinarySearch {
    static boolean search(int[] arr, int target, int start, int end) {
        if(start > end) return false;

        int mid = (start + end) / 2;
        if(arr[mid] == target) return true;
        else if(arr[mid] > target) return search(arr, target, start, mid - 1);
        return search(arr, target, mid + 1, end);
    }
}
