/*
Given an an unsorted array, sort the given array. You are allowed to do only following operation on array.

flip(arr, i): Reverse array from 0 to i 

[1,2,3,4] flip(3); - > [1,3,2,1]
*/

o(n^2)
public static int pancakeSort(int arr[], int n) {
    // Start from the complete array and one by one
    // reduce current size by one
    for (int curr_size = n; curr_size > 1; --curr_size) {
        // Find index of the maximum element in
        // arr[0..curr_size-1]
        int mi = findMax(arr, curr_size);

        // Move the maximum element to end of current
        // array if it's not already at the end
        if (mi != curr_size-1) {
            // To move at the end, first move maximum
            // number to beginning
            flip(arr, mi);

            // Now move the maximum number to end by
            // reversing current array
            flip(arr, curr_size-1);
        }
    }
    return 0;
}

static int findMax(int arr[], int n) {
    int mi, i;
    for (mi = 0, i = 0; i < n; ++i)
        if (arr[i] > arr[mi])
            mi = i;
    return mi;
}







nlgn
void insertionSort(int arr[], int size){
    int i, j;
 
    // Start from the second element and one by one insert arr[i]
    // in already sorted arr[0..i-1]
    for(i = 1; i < size; i++) {
        // Find the smallest element in arr[0..i-1] which is also greater than
        // or equal to arr[i]
        int j = ceilSearch(arr, 0, i-1, arr[i]);
 
        // Check if there was no element greater than arr[i]
        if (j != -1) {
            // Put arr[i] before arr[j] using following four flip operations
            flip(arr, j-1);
            flip(arr, i-1);
            flip(arr, i);
            flip(arr, j);
        }
    }
}
