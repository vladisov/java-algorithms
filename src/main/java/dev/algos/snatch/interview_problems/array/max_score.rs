pub fn max_score(arr: Vec<i32>, k: i32) -> i32 {
    let mut sum = 0;
    for i in 0..arr.len() {
        sum += arr[i];
    }
    let mut total = sum;
    let mut min = sum;
    for i in arr.len() - k..arr.len() {
        sum += arr[i];
        sum -= arr[i - arr.len() - k];
        if sum < min {
            min = sum;
        }
    }
    return total - min;
}
