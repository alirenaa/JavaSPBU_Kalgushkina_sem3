import java.util.Arrays;

public class MultidimentionalArrays {
    public static void main(String args[]) {
        int[][] a = new int[][]{
                {10, 20, 30},
                {40, 50, 60, 70, 80, 90},
                {100, 200}
        };
        System.out.println("Задача printTable");
        printTable(a);
        System.out.println("Задача printTableAligned");
        printTableAligned(a);

        System.out.println("Задача заполнение массива");
        char[][] c = createTable(20, '.');
        printTable(c);

        System.out.println("============ Заполним строки: ==========");
        fillFirstAndLastLines(c, '#');
        printTable(c);

        System.out.println("============ Заполним столбцы: =========");
        fillFirstAndLastColumns(c, '#');
        printTable(c);
    }

    public static void printTable(int[][] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static void printTable(char[][] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static void printTableAligned(int[][] a){
        int max_len = a[0].length; // длина самой длинной строки
        for (int i = 0; i < a.length; i++) {
            if (max_len < a[i].length) max_len = a[i].length;
        }
        int[] max_numbers = new int[max_len]; // массив максимальных чисел в каждом столбце
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (max_numbers[j] < a[i][j]) max_numbers[j] = a[i][j];
            }
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                int x = String.valueOf(Math.abs(max_numbers[j])).length() - String.valueOf(Math.abs(a[i][j])).length();
                System.out.print(" ".repeat(x) + a[i][j] + "  ");
            }
            System.out.print("\n");
        }
    }

    public static char[][] createTable(int n, char ch){
        char[][] table = new char[n][n];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = ch;
            }
        }
        return table;
    }

    public static void fillFirstAndLastLines(char[][] table, char ch){
        Arrays.fill(table[0], ch);
        Arrays.fill(table[table.length-1], ch);
    }

    public static void fillFirstAndLastColumns(char[][] table, char ch){
        for (int i = 0; i < table.length; i++) {
            table[i][0] = ch;
            table[i][table[i].length - 1] = ch;
        }
    }
}

