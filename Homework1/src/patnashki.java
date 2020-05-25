class patnashki{
    private static int[][] move(int x, int y, int[][] Array, String direct) {
        int old = Array[x][y];
        int newest;
            switch (direct){
                case "вверх":
                    newest = Array[x-1][y];
                    Array[x-1][y] = old;
                    Array[x][y] = newest;
                    break;
                case "вниз":
                    newest = Array[x+1][y];
                    Array[x+1][y] = old;
                    Array[x][y] = newest;
                    break;
                case "влево":
                    newest = Array[x][y-1];
                    Array[x][y-1] = old;
                    Array[x][y] = newest;
                    break;
                case "вправо":
                    newest = Array[x][y+1];
                    Array[x][y+1] = old;
                    Array[x][y] = newest;
                    break;
            }
        return Array;
    }

    private static boolean isSolve(int[][] older){
        int[][] testMassive = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(testMassive[i][j] == older[i][j]){
                    count++;
                }
            }
        }
        if (count == 9){
            return true;
        }
        return false;
    }

        public static void main(String[] args) {
        int[][] oldMassive = {{2, 4, 6}, {5, 7, 1}, {3, 8, 0}};
        String[] moving = { "влево", "вверх", "вправо", "вверх", "влево", "вниз", "влево", "вниз", "вправо", "вверх",
                            "влево", "вверх", "вправо", "вниз", "влево", "вниз", "вправо", "вправо", "вверх", "вверх",
                            "влево", "вниз", "влево", "вниз", "вправо", "вправо", "вверх", "влево", "влево", "вниз",
                            "вправо", "вправо", "вверх", "влево", "вниз", "влево", "вверх", "вправо", "вниз", "вправо",
                            "вверх", "влево", "вниз", "вправо", "вверх", "влево", "влево", "вниз", "вправо", "вправо",
                            "вверх", "влево", "влево", "вниз", "вправо", "вверх", "вправо", "вниз", "влево", "вверх",
                            "влево", "вниз", "вправо", "вправо", "вверх", "влево", "вниз", "вправо", "вверх", "влево",
                            "вниз", "влево", "вверх", "вправо", "вниз", "вправо", "вверх", "влево", "влево", "вниз",
                            "вправо", "вверх", "вправо", "вниз", "влево", "влево", "вверх", "вправо", "вниз",  "влево",
                            "вверх", "вправо",  "вниз", "вправо", "вверх", "влево", "влево", "вниз", "вправо", "вправо"};
        int  step = 0;
        System.out.println("Исходное расположение фишек следующее:");
        System.out.print("{ ");
        for (int x[] : oldMassive) {
            for (int y : x) {
                System.out.print(y + " ");
            }
        }
        System.out.println("}");
        while (isSolve(oldMassive) != true) {
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    if (oldMassive[x][y] == 0) {
                        oldMassive = move(x, y, oldMassive, moving[step]);
                        step++;
                        break;
                    }
                }
            }
        }
        System.out.println("Окончательное расположение фишек следующее:");
        System.out.print("{ ");
        for (int x[] : oldMassive) {
            for (int y : x) {
                System.out.print(y + " ");
            }
        }
        System.out.println("}");
        System.out.println("Шагов было сделано: " + step);
    }
}