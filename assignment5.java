// Convert 1D Array Into 2D Array

// You are given a **0-indexed** 1-dimensional (1D) integer array original, and two integers, m and n. You are tasked with creating a 2-dimensional (2D) array with  m rows and n columns using **all** the elements from original.

// The elements from indices 0 to n - 1 (**inclusive**) of original should form the first row of the constructed 2D array, the elements from indices n to 2 * n - 1 (**inclusive**) should form the second row of the constructed 2D array, and so on.

// Return *an* m x n *2D array constructed according to the above procedure, or an empty 2D array if it is impossible*.
public class assignment5 {
    public static int[][] convertTo2DArray(int[] original, int m, int n) {
        int[][] result = new int[m][n];

        if (original.length != m * n) {
            // If the number of elements in the original array is not equal to m * n,
            // it is impossible to construct a valid 2D array, so return an empty array.
            return new int[0][0];
        }

        for (int i = 0; i < original.length; i++) {
            int row = i / n;  // Calculate the row index based on the current index i
            int col = i % n;  // Calculate the column index based on the current index i
            result[row][col] = original[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] original = {1, 2, 3, 4, 5, 6};
        int m = 2;
        int n = 3;

        int[][] result = convertTo2DArray(original, m, n);

        // Print the resulting 2D array
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
// You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where the ith row has exactly i coins. The last row of the staircase **may be** incomplete.

// Given the integer n, return *the number of **complete rows** of the staircase you will build*.
public class assignment5 {
    public static int countCompleteRows(int n) {
        int count = 0;
        int i = 1;

        while (n >= i) {
            n -= i;
            count++;
            i++;
        }

        return count;
    }

    public static void main(String[] args) {
        int n = 10;
        int completeRows = countCompleteRows(n);
        System.out.println("Number of complete rows: " + completeRows);
    }
}
// Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
import java.util.Arrays;

public class assignment5 {
    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;
        int i = n - 1;

        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                result[i] = leftSquare;
                left++;
            } else {
                result[i] = rightSquare;
                right--;
            }

            i--;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-4, -2, 0, 2, 4};
        int[] result = sortedSquares(nums);
        System.out.println(Arrays.toString(result));
    }
}
/*Given two **0-indexed** integer arrays nums1 and nums2, return *a list* answer *of size* 2 *where:*

- answer[0] *is a list of all **distinct** integers in* nums1 *which are **not** present in* nums2*.*
- answer[1] *is a list of all **distinct** integers in* nums2 *which are **not** present in* nums1. */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class assignment5 {
    public static List<List<Integer>> findDistinctIntegers(int[] nums1, int[] nums2) {
        List<List<Integer>> answer = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            set2.add(num);
        }

        List<Integer> distinctInNums1 = new ArrayList<>();
        for (int num : set1) {
            if (!set2.contains(num)) {
                distinctInNums1.add(num);
            }
        }

        List<Integer> distinctInNums2 = new ArrayList<>();
        for (int num : set2) {
            if (!set1.contains(num)) {
                distinctInNums2.add(num);
            }
        }

        answer.add(distinctInNums1);
        answer.add(distinctInNums2);

        return answer;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 3, 4};
        int[] nums2 = {2, 3, 5, 6};

        List<List<Integer>> distinctIntegers = findDistinctIntegers(nums1, nums2);

        System.out.println("Distinct integers in nums1 but not in nums2: " + distinctIntegers.get(0));
        System.out.println("Distinct integers in nums2 but not in nums1: " + distinctIntegers.get(1));
    }
}
/*Given two integer arrays arr1 and arr2, and the integer d, *return the distance value between the two arrays*.

The distance value is defined as the number of elements arr1[i] such that there is not any element arr2[j] where |arr1[i]-arr2[j]| <= d */
public class assignment5 {
    public static int distanceValue(int[] arr1, int[] arr2, int d) {
        int distance = 0;

        for (int num1 : arr1) {
            boolean hasCloseElement = false;
            
            for (int num2 : arr2) {
                if (Math.abs(num1 - num2) <= d) {
                    hasCloseElement = true;
                    break;
                }
            }

            if (!hasCloseElement) {
                distance++;
            }
        }

        return distance;
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 5, 8};
        int[] arr2 = {10, 9, 1, 3};
        int d = 3;

        int distance = distanceValue(arr1, arr2, d);
        System.out.println("Distance value: " + distance);
    }
}
/*Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears **once** or **twice**, return *an array of all the integers that appears **twice***.

You must write an algorithm that runs in O(n) time and uses only constant extra space */
import java.util.ArrayList;
import java.util.List;

public class assignment5 {
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                duplicates.add(index + 1);
            } else {
                nums[index] = -nums[index];
            }
        }

        return duplicates;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> duplicates = findDuplicates(nums);
        System.out.println("Duplicates: " + duplicates);
    }
}
/*Suppose an array of length n sorted in ascending order is **rotated** between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

- [4,5,6,7,0,1,2] if it was rotated 4 times.
- [0,1,2,4,5,6,7] if it was rotated 7 times.

Notice that **rotating** an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of **unique** elements, return *the minimum element of this array*.

You must write an algorithm that runs in O(log n) time. */
public class assignment5 {
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int min = findMin(nums);
        System.out.println("Minimum element: " + min);
    }
}
/*An integer array original is transformed into a **doubled** array changed by appending **twice the value** of every element in original, and then randomly **shuffling** the resulting array.

Given an array changed, return original *if* changed *is a **doubled** array. If* changed *is not a **doubled** array, return an empty array. The elements in* original *may be returned in **any** order*. */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class assignment5 {
    public static int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 != 0) {
            return new int[0]; // If the length is odd, it can't be a doubled array
        }

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : changed) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int[] original = new int[changed.length / 2];
        int index = 0;

        Arrays.sort(changed);

        for (int num : changed) {
            if (frequencyMap.containsKey(num) && frequencyMap.containsKey(num * 2)) {
                original[index++] = num;
                frequencyMap.put(num, frequencyMap.get(num) - 1);
                frequencyMap.put(num * 2, frequencyMap.get(num * 2) - 1);

                if (frequencyMap.get(num) == 0) {
                    frequencyMap.remove(num);
                }

                if (frequencyMap.get(num * 2) == 0) {
                    frequencyMap.remove(num * 2);
                }
            }
        }

        return frequencyMap.isEmpty() ? original : new int[0];
    }

    public static void main(String[] args) {
        int[] changed = {4, 2, 8, 10, 6, 12};
        int[] original = findOriginalArray(changed);

        if (original.length == 0) {
            System.out.println("No valid original array exists.");
        } else {
            System.out.println("Original array: " + Arrays.toString(original));
        }
    }
}
