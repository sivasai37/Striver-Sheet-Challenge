import java.util.Scanner;

public class Solution {

    // Function to count students needed for given max pages
    public static int countStudents(int[] nums, int pages) {
        int students = 1;
        int pagesStudent = 0;

        for (int i = 0; i < nums.length; i++) {
            if (pagesStudent + nums[i] <= pages) {
                pagesStudent += nums[i];
            } else {
                students++;
                pagesStudent = nums[i];
            }
        }
        return students;
    }

    // Main logic to find minimum maximum pages
    public static int findPages(int[] nums, int m) {
        int n = nums.length;
        if (m > n) return -1;

        int low = Integer.MIN_VALUE;
        int high = 0;

        for (int i = 0; i < n; i++) {
            low = Math.max(low, nums[i]);
            high += nums[i];
        }
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int students = countStudents(nums, mid);

            if (students > m) {
                low = mid + 1;
            } else {
                ans =  mid;
                high = mid - 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       
        int n = sc.nextInt();
        int[] books = new int[n];

       
        for (int i = 0; i < n; i++) {
            books[i] = sc.nextInt();
        }

        
        int m = sc.nextInt();

      
        int result = findPages(books, m);

        System.out.println(result);
    }
}
