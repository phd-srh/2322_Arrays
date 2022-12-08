public class Arrays {

    // Methoden mit Arrays...
    public static boolean sucheImArray(int[] array, int datum) {
        for (int i = 0; i < array.length ; i++ ) {
            if (array[i] == datum) {
                return true;
            }
        }
        return false;
    }

    public static int minimalerWertImArray(int[] array) {
        // TODO
    }

    public static void main(String[] args) {
        int[] datenreihe = { 17, 3, 29, 22, 5, 11, 9, 13, 7, 12 };

        System.out.println("Die 12 ist in der Datenreihe: " +
                sucheImArray(datenreihe, 12) );
        System.out.println("Die 23 ist in der Datenreihe: " +
                sucheImArray(datenreihe, 23) );
    }
}
