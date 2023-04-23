package estructuras_control.repetitivas;

public class BucleFor {
    public static void main(String[] args) {
        int[] nums = { 2, 4, -1, 5, 8 };

        for (int i = 0; i < nums.length - 1; ++i)
            System.out.print(nums[i] + " ");

        System.out.print('\n');
    }
}
