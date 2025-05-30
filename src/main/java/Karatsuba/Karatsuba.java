package Karatsuba;

public class Karatsuba {
    public static void main(String[] args) {

        String x = "1110";
        String y = "110";

        String res = karatsuba(x, y);
        System.out.println(binaryToDecimal(res));
    }


    public static String karatsuba(String x, String y){
        int n = Math.max(x.length(), y.length());

        int newLength = nextPowerOfTwo(n);

        x = addNull(x, newLength);
        y = addNull(y, newLength);

        n = newLength;

        if (n == 1){
            return multiplyOneBit(x, y);
        }

        int m = n / 2;

        String a = x.substring(0, m);
        String b = x.substring(m);
        String c = y.substring(0, m);
        String d = y.substring(m);

        String P1 = karatsuba(a, c);
        String P2 = karatsuba(b, d);
        String P3 = karatsuba(sumBinary(a, b), sumBinary(c, d));

        String temp = subtractBinary(subtractBinary(P3, P1), P2);

        String term1 = P1 + zeros(2 * m);
        String term2 = temp + zeros(m);
        String sum = sumBinary(term1, term2);
        return sumBinary(sum, P2);
    }

    public static String addNull(String s, int length){
        while (s.length() < length){
            s = "0" + s;
        }
        return s;
    }

    public static int nextPowerOfTwo(int n) {
        int power = 1;
        while (power < n) power *= 2;
        return power;
    }


    public static String multiplyOneBit(String a, String b){
        return (a.charAt(0) == '1' && b.charAt(0) == '1') ? "1" : "0";
    }

    public static String sumBinary(String a, String b){
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;

        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0){
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }

        return sb.reverse().toString();
    }

     public static String subtractBinary(String a, String b){
        a = addNull(a, Math.max(a.length(), b.length()));
        b = addNull(b, Math.max(a.length(), b.length()));

        StringBuilder sb = new StringBuilder();
        int borrow = 0;

        for (int i = a.length() - 1; i >= 0; --i){
            int sub = (a.charAt(i) - '0') - (b.charAt(i) - '0') - borrow;
            if (sub < 0){
                sub += 2;
                borrow = 1;
            } else {
                borrow = 0;
            }
            sb.append(sub);
        }
        return sb.reverse().toString().replaceFirst("^0+(?!$)", "");
    }


    public static String zeros( int n){
        return new String(new char[n]).replace('\0', '0');
    }

     private static int binaryToDecimal(String binary) {
        return Integer.parseInt(binary, 2);
    }
}
