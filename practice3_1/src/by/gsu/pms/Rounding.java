package by.gsu.pms;

public enum Rounding {
    DOWN {
        public double round(double d) {
            return Math.floor(d);
        }
    },
    MATH {
        public double round(double d) {
            return Math.round(d);
        }
    },
    UP {
        public double round(double d) {
            return Math.ceil(d);
        }
    };

    public abstract double round(double d);
    public int round(double value, int n) {
        int pow = pow10(n);
        return (int) round(value / pow) * pow;
    }

    private static int pow10(int n) {
        int res = 1;
        while (n-- > 0) {
            res *= 10;
        }
        return res;
    }
}
