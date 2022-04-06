package lambda;

public class Drawing implements Printable{

    char[][] array;

    Drawing(int x, int y, char sym) {
        this.array = new char[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                this.array[i][j] = sym;
            }
        }
    }

    @Override
    public void print() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.print("\n");
        }
    }

    public void setPoint(int x, int y, char sym) {
        array[y][x] = sym;
    }

    public void drawVerticalLine(int x, int y1, int y2, char sym) {
        for (int i = y1; i <= y2; i++) {
            setPoint(x, i, sym);
        }
    }

    public void drawHorizontalLine(int x1, int x2, int y, char sym) {
        for (int i = x1; i <= x2; i++) {
            setPoint(i, y, sym);
        }
    }

    public void drawRectangle(int x1, int y1, int x2, int y2, char sym) {
        drawVerticalLine(x1, y1, y2, sym);
        drawVerticalLine(x2, y1, y2, sym);

        drawHorizontalLine(x1, x2, y2, sym);
        drawHorizontalLine(x1, x2, y1, sym);
    }

    public void drawCircle(int x, int y, int r, char sym) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (Math.pow(i - x, 2) + Math.pow(j - y, 2) <= Math.pow(r, 2))
                    setPoint(i, j, sym);
            }
        }
    }

    public void draw(int x, int y, oop.Drawing d) {
        for (int i = y; i < array.length; i++) {
            for (int j = x; j <array[i].length; j++) {
                setPoint(j, i, d.array[i-y][j-x]);
            }
        }
    }

}
