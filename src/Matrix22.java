public class Matrix22 {
    private double[][] array = new double[2][2];

    Matrix22(double a, double b, double c, double d) {
        this.array[0][0] = a;
        this.array[0][1] = b;
        this.array[1][0] = c;
        this.array[1][1] = d;
    }

    Matrix22(double[][] a) {
        this.array = a;
    }


    double trace() {
        return this.array[0][0] - this.array[1][1];
    }

    double discriminant() {
        return this.array[0][0] * this.array[1][1] - this.array[0][1] * this.array[1][0];
    }

    public double[][] getArray() {
        return array;
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                result += array[i][j] + " ";
            }
            result +="\n";
        }
        return result;
    }

    public void print() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public Matrix22 add(Matrix22 b){
        return new Matrix22(array[0][0] + b.getArray()[0][0], array[0][1] + b.getArray()[0][1],
                array[1][0] + b.getArray()[1][0],array[1][1] + b.getArray()[1][1]);
    }

    public Matrix22 mul(Matrix22 b){
        Matrix22 res = new Matrix22(0,0,0,0);
        for (int i = 0; i < array.length; ++i) { // т.к. матрицы квадратные, все граничные значения у нас равны
            for (int j = 0; j < array.length; ++j) {
                for (int k = 0; k < array.length; ++k) {
                    res.getArray()[i][j] += array[i][k] * b.getArray()[k][j];
                }
            }
        }
        return res;

    }

    public Matrix22 pow(int n){
        Matrix22 arr = new Matrix22(this.array);
        Matrix22 res = new Matrix22(this.array);
        for (int i = 0; i < n - 1; i++) {
            res = res.mul(arr);
        }
        return res;

    }

    public static void main(String args[]) {
        new Matrix22(1,2,3,4).print();
        new Matrix22(new double[][]{{1, 2}, {3, 4}}).print();
        System.out.print(new Matrix22(1,2,3,4).toString());
        Matrix22 a = new Matrix22(1,2,3,1);
        Matrix22 b = new Matrix22(-1,3,1,1);
        a.add(b).print();
        a.mul(b).print();
        a.pow(2).print();

    }
}