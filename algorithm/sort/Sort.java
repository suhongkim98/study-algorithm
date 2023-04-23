public class Sort {
    //임시 배열을 선언하지 않고 정렬하려면 퀵소트를 써야함
    public static void mergeSort(int[] arr, int start, int end) {
        int listSize = end - start + 1;
        if(listSize <= 1) return; // 분할된 리스트 원소 수가 1개인 경우 원소 수 1개는 해결 가능한 이미 정렬된 상태이므로 분할 중단

        //미드를 구한다.
        int mid = (start + end) / 2;
        //미드를 기준으로 쪼갠다. (분할)
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);

        //병합한다.
        //임시 배열을 선언하고 임시배열에 할당할 시작점, 앞 배열 시작점, 뒤 배열 시작점을 정의한다.
        int[] temp = new int[arr.length]; // 임시 배열
        int tmpIndex = start; // 임시배열 시작점
        int left = start; //앞 배열 시작점
        int right = mid + 1; //뒤 배열 시작점

        //한쪽의 배열 비교가 끝날 때까지 둘이 비교하며 임시배열에 삽입한다.
        while(left <= mid && right <= end) {
            if(arr[left] < arr[right]) {
                temp[tmpIndex++] = arr[left++];
            } else {
                temp[tmpIndex++] = arr[right++];
            }
        }
        //앞 배열에 임시변수에 넣지 않은 나머지 값이 있으면 전부 넣어준다.
        while(left <= mid) {
            temp[tmpIndex++] = arr[left++];
        }
        //뒷 배열에 임시변수에 넣지 않은 나머지 값이 있으면 전부 넣어준다.
        while (right <= end) {
            temp[tmpIndex++] = arr[right++];
        }
        //arr에 임시변수 값을 반영한다. start -> tmpIndex 까지
        for(int index = start ; index < tmpIndex ; index++) {
            arr[index] = temp[index];
        }
    }

    // 중간값 퀵정렬은 이러한 이미 오름차순 또는 내림차순으로 정렬되어 있거나, 유사한 상황에서 최대한 중간 값으로 피벗을 선정하여,
    //피벗을 기준으로 최대한 비슷한 크기로 이분 파티셔닝을 하는 데 그 의의가 있다.
    // 피벗이 최대값이거나 최소값이면 최악 시간복잡도는 똑같이 n2
    public static void quickSort(int[] arr, int start, int end) {
        if(start >= end) return;
        //비벗값, 왼쪽 배열 시작점(++), 오른쪽 배열 시작점(--)
        int left = start;
        int right = end;
        int pivot = arr[(start + end) / 2];

        //left <= right 까지 반복, left right 는 엇갈려야 끝나는거다
        while (left <= right) {
            //왼쪽 배열은 ->로 이동하며 피벗보다 큰 값을 찾는다.
            while(arr[left] < pivot) left++;
            // 오른쪽 배열은 <-로 이동하며 피벗보다 작은 값을 찾는다
            while (arr[right] > pivot) right--;
            //아직 left 와 right 가 엇갈린게 아니라면 왼쪽에서 피벗보다 큰 값을 찾거나 || 오른쪽 배열에서 피벗보다 작은 값을 찾은 것이므로 교환
            if(left <= right) {
                int tmp = arr[right];
                arr[right] = arr[left];
                arr[left] = tmp;
                //교환했으니 이동시켜줘야한다.
                right--;
                left++;
            }
        }
        //두 배열 각각 재귀함수 호출해 퀵정렬
        quickSort(arr, start, right);
        quickSort(arr, left, end);
    }
}
