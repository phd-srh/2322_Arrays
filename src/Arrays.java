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
        int kleinsterWert = array[0];
        for (int i=1; i < array.length; i++) {
            if (array[i] < kleinsterWert)
                kleinsterWert = array[i];
        }
        return kleinsterWert;
    }

    public static boolean istArraySortiert(int[] array) {
        for (int i=1; i < array.length; i++) {
            if (array[i-1] > array[i])
                return false;
        }
        return true;
    }

    public static void sortierArrayBubbleSort(int[] array) {
        boolean wurdenDatenGetauscht;
        do {
            wurdenDatenGetauscht = false;
            for (int i = 1; i < array.length; i++) {
                if (array[i - 1] > array[i]) {
                    // swap - zwei Elemente im Array tauschen
                    int temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    wurdenDatenGetauscht = true;
                }
            }
        } while (wurdenDatenGetauscht);
    }

    public static void ausgabeArray(int[] array) {
        System.out.print("[");
        for (int i=0; i < array.length; i++) {
            if (i>0) System.out.print(", ");
            System.out.print(array[i]);
        }
        System.out.println("]");
    }

    /* Vorher-Aufgabe
     * Eine Methode, die eine ├╝bergebenes Array kopiert!
     */
    public static int[] erstelleKopieDesArray(int[] array) {
        int[] neuesArray = new int[ array.length ];
        for (int i=0; i < array.length; i++)
            neuesArray[i] = array[i];
        return neuesArray;
    }

    /* Neue Aufgabe: Entferne
     *  z.B. array = [ 3, 7, 13, 25 ], zahl = 13
     *  Ergebnis = [ 3, 7, 25 ]
     * Achtung: Es soll ein neues(!) Array generiert werden und nicht
     *          das ├╝bergebene manipuliert!!
     */
    public static int[] entferneZahlAusArray(int[] array, int zahl) {
        int l├ĄngeDesNeuenArrays = array.length;
        if ( sucheImArray(array, zahl) ) l├ĄngeDesNeuenArrays--;

        int[] neuesArray = new int[ l├ĄngeDesNeuenArrays ];
        int neuerIndex = 0;
        for (int i=0; i < array.length; i++) {
            if (array[i] != zahl) {
                neuesArray[neuerIndex] = array[i];
                neuerIndex++;
            }
        }
        return neuesArray;
    }

    /*
     *  z.B. a = [ 3, 13, 25, 7 ], b = [ 17, 25, 3 ]
     *  die beiden Arrays sind unsortiert und unterschiedlicher L├Ąnge
     *  Ergebnis = 2
     */
    public static int z├ĄhleGleicheEintr├Ąge(int[] a, int[] b) {
        int z├ĄhleGleiche = 0;
        for (int i=0; i < a.length; i++) {
            if ( sucheImArray(b, a[i]) )
                z├ĄhleGleiche++;
        }
        return z├ĄhleGleiche;
    }

    /*
     *  z.B. a = [ 3, 13, 25, 7 ], b = [ 17, 25, 3 ]
     *  die beiden Arrays sind unsortiert und unterschiedlicher L├Ąnge
     *  Ergebnis = [ 3, 25 ]
     */
    public static int[] findeGleicheEintr├Ąge(int[] a, int[] b) {
        int gleichElemente = z├ĄhleGleicheEintr├Ąge(a, b);
        int[] neuesArray = new int[ gleichElemente ];
        int neuerIndex = 0;
        for (int i=0; i < a.length; i++) {
            if (sucheImArray(b, a[i])) {
                neuesArray[neuerIndex] = a[i];
                neuerIndex++;
            }
        }
        return neuesArray;
    }

    public static void main(String[] args) {
        int[] datenreihe = { 17, 3, 29, 22, 5, 11, 9, 13, 7, 12 };
        int[] sortierteFolge = { 3, 5, 5, 7, 11, 22, 29, 37, 55, 103 };

        System.out.println("Die 12 ist in der Datenreihe: " +
                sucheImArray(datenreihe, 12) );
        System.out.println("Die 23 ist in der Datenreihe: " +
                sucheImArray(datenreihe, 23) );
        System.out.println("Kleinster Wert: " +
                minimalerWertImArray(datenreihe));
        System.out.println("Ist das Array (datenreihe )sortiert? " +
                istArraySortiert(datenreihe));
        System.out.println("Ist das Array (sortierteFolge )sortiert? " +
                istArraySortiert(sortierteFolge));
        sortierArrayBubbleSort(datenreihe);
//        java.util.Arrays.sort( datenreihe ); // <- was ist das denn???
        ausgabeArray(datenreihe);

        int[] arrayOhne13 = entferneZahlAusArray(datenreihe, 13);
        ausgabeArray(arrayOhne13);

        int[] a = { 3, 13, 25, 7 }, b = { 17, 25, 3 };
        int[] gleicheVonAundB = findeGleicheEintr├Ąge(a, b);
        ausgabeArray(gleicheVonAundB);
    }
}
