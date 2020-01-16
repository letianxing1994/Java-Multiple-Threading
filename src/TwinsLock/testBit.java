package TwinsLock;

public class testBit {
    private static final int tableSizeFor(int c) {
        int n = c - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= (1<<30)) ? (1<<30) : n + 1;
    }

    public static void main(String[] args){
        System.out.println(testBit.tableSizeFor(10));
    }
}
