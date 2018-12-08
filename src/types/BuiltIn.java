package types;

import java.util.Vector;

public class BuiltIn {

    public Number add(Vector<Number> nums) {
        if (nums.size() == 0) {
            return 0;
        }
        float total = 0;
        for (int i = 0; i < nums.size(); i++) {
            total += nums.get(i).floatValue();
        }
        return total;
    }

    public Number sub(Vector<Number> nums) {
        if (nums.size() == 0) {
            return 0;
        } else if (nums.size() == 1) {
            return 0 - nums.get(0).floatValue();
        } else {
            float first = nums.get(0).floatValue();
            for (int i = 1; i < nums.size(); i++) {
                first -= nums.get(i).floatValue();
            }
            return first;
        }
    }

    public Number mult(Vector<Number> nums) {
        if (nums.size() == 0) {
            return 1;
        } else if (nums.size() == 1) {
            return nums.get(0);
        } else {
            float first = nums.get(0).floatValue();
            for (int i = 1; i < nums.size(); i++) {
                first *= nums.get(i).floatValue();
            }
            return first;
        }
    }

}
