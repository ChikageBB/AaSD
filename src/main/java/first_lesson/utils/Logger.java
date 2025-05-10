package first_lesson.utils;

/**
 * A helper class to write information into the system console
 */
public class Logger {
    /**
     * Write all arguments sequentially in a single line
     * @param args A sequence of arguments
     */
    public static void write(Object... args) {
        for (int i = 0; i < args.length; i++) {
            System.out.print(args[i]);
            if (i < args.length - 1) {
                System.out.print("; ");
            }
        }
    }

    /**
     * Write all arguments starting from a new line
     * @param args A sequence of arguments
     */
    public static void writeLine(Object... args) {
        if (args.length == 0) {
            System.out.println();
            return;
        }

        for (Object arg : args) {
            System.out.println(arg);
        }
    }
}