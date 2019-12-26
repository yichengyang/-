public class BinarySearch {
    public static int solution(int[] array, int target) {
        // if (array.length == 0) {
        // return -1;
        // }
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static int solution2(int[] array, int target) {
        return searchInternally(array, target, 0, array.length - 1);
    }

    private static int searchInternally(int[] array, int target, int left, int right) {
        if (right < left) {
            return -1;
        }

        int mid = left + (right - left) / 2;
        if (target == array[mid]) {
            return mid;
        } else if (target > array[mid]) {
            return searchInternally(array, target, mid + 1, right);
        } else {
            return searchInternally(array, target, left, mid - 1);
        }
    }

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 4, 5 };
        System.out.println(solution2(array, 5));
    }

}