public class Main {
    public static void main(String[] args) {
        System.out.println(validMountainArray(new int[]{0, 3, 2, 1}));;
    }

    private static boolean validMountainArray(int[] arr) {
        int n = arr.length - 1;
        if(arr.length < 3) {
            return false;
        }
        int i = 0;
        for(int k = i+1;k< n;k++) {
            if(arr[i] > arr[i+1]) {
                break;
            }
            i++;
        }
        for(int j = n; j > 0;j--) {
            if(arr[j] > arr[j-1]) {
                break;
            }
        }
        //kiem tra xem den cuoi mang chua
        if(i == n) {
            return true;
        }
        return false;
    }
}