package pgdp.arrayfun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.*;

public class ArrayFunctions {

    protected ArrayFunctions() {
        throw new IllegalStateException("Don't create objects of type 'ArrayFunctions'!");
    }

    public static void main(String[] args) {
        //example call
        //System.out.println(Arrays.toString(zipMany(new int[][] {{1, 4}, {2, 5}, {3,6}, {9}})));
       // int[] array = new int[] {1286753231,5345865,655867680,65976867,78597585,5749658,648596};
       // System.out.println(sumOfSquares(array));
    // int[] array = new int[] {-1, 0, 1, 2, 3};
    // System.out.println(Arrays.toString(filter(array,0, 3)));
        //int[] array = new int[] {};
      //rotate(array, 1);
       int[] array = new int[] {1, 2, 4, 4, 4,  3, 3, 10, 9, 9};
        System.out.println(Arrays.deepToString(quantities(array)));
    }

    /** Berechnet für das übergebene Array die Summe der Quadrate der Einträge.
     *  Gibt dabei einen Fehler aus und -1 zurück, wenn ein Overflow entsteht.
     *
     * @param array Ein beliebiges Integer-Array.
     * @return Die Summe der Quadrate, wenn diese in einen 'long' passt, -1 sonst.
     */
    public static long sumOfSquares(int[] array) {
        // TODO
       long sum = 0;
       long square = 1;
        for (int i = 0; i < array.length; i++) {
            square = (long) array[i] * array[i];
            sum += square;
        }
        if (sum < 0) {
            System.out.println("Overflow!");
        return -1;
        }
        return sum;
    }
    /** Methode, die zwei Arrays zu einem verbindet, indem sie abwechselnd Einträge des ersten und des zweiten Input-
     *  Arrays verwendet.
     *
     * @param a Ein beliebiges Integer-Array.
     * @param b Ein beliebiges Integer-Array.
     * @return 'a' und 'b' zusammengezipped.
     */
    public static int[] zip(int[] a, int[] b) {
        // TODO
        if (a.length == b.length) {
            int k = a.length + b.length;
            int[] aundb = new int[a.length + b.length];
            int j = 0;
            for (int i = 0; i < k; i += 2) {
                aundb[i] += a[j];
                j++;
            }
            int w = 0;
            for (int i = 1; i < k; i += 2) {
                aundb[i] += b[w];
                w++;
            }
            return aundb;
        }
        else if (a.length > b.length) {
            int k = a.length + b.length;
            int[] aundb = new int[a.length + b.length];
            int j = 0;
            int w = 0;
            for (int i = 0; i < b.length * 2; i += 2) {
                    aundb[i] += a[j];
                    j++;
            }
            for (int q = 1; q < (b.length * 2); q += 2) {
                    aundb[q] += b[w];
                    w++;
            }
            int e = b.length;
            int u = b.length * 2;
            for (int i = 0; i < a.length - b.length; i++) {
                aundb[u] += a[e];
                u++;
                e++;
            }
            return aundb;
        }
        else {
            int k = a.length + b.length;
            int[] aundb = new int[a.length + b.length];
            int j = 0;
            int w = 0;
            for (int i = 0; i < (a.length * 2); i += 2) {
                aundb[i] += a[j];
                j++;
            }
            for (int q = 1; q < (a.length * 2); q += 2) {
                aundb[q] += b[w];
                w++;
            }
            int e = a.length;
            int u = a.length * 2;
            for (int i = 0; i < b.length - a.length; i++) {
                aundb[u] += b[e];
                u++;
                e++;
            }
            return aundb;
        }
    }

    /** Methode, die eine beliebige Zahl an Arrays (dargestellt als Array von Arrays) zu einem einzigen Array verbindet,
     *  indem sie abwechselnd von jedem Array einen Eintrag nimmt, bis alle aufgebraucht sind.
     *
     * @param arrays Array von Integer-Arrays
     * @return Die Arrays in 'arrays' zusammengezipped
     */

    public static int[] zipMany(int[][] arrays) {
            // TODO
            int k = 0;//Neue Array Länge
        for (int[] ints : arrays) {//Summe der einzelnen Elemente aller Arrays wird berechnet
            k += ints.length;
        }
        int[] newArray = new int[k];
        int d = 0;
        for (int c = 0; d < k; c++) {
                for (int[] array : arrays) {//geht bis zur Länge des Arrays bzw. Anzahl der Reihen
                    if (array.length > c) {
                        newArray[d] = array[c];
                        d++;
                    }
                }

        }
        return newArray;
    }


    /** Behält aus dem übergebenen Array nur die Einträge, die innerhalb der übergebenen Grenzen liegen.
     *  Gibt das Ergebnis als neues Array zurück.
     *
     * @param array Ein beliebiges Integer-Array
     * @param min Ein beliebiger Integer
     * @param max Ein beliebiger Integer
     * @return Das gefilterte Array
     */
    public static int[] filter(int[] array,int min,int max) {
        // TODO
        int[] newArray = new int[array.length];
        if (min > max) {
            int[] newArray0 = new int[0];
            return newArray0;
        }
        int d = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= min && array[i] <= max) {
                newArray[i] = array[i];
                d++;
            }
        }
        int m = 0;
        int[] realArray = new int[d];
        for (int i = 0; i < array.length; i++) {
            if (array[i] <= max && array[i] >= min) {
                    realArray[m] = array[i];
                    m++;
            }
        }
        return realArray;
    }


    /** Rotiert das übergebene Array um die übergebene Anzahl an Schritten nach rechts.
     *  Das Array wird In-Place rotiert. Es gibt keine Rückgabe.
     *
     * @param array Ein beliebiges Integer-Array
     * @param amount Ein beliebiger Integer
     */
    public static void rotate(int[] array, int amount) {
        //TODO
        for (int w = 0; w < 1; w++) {
            if (amount == Integer.MIN_VALUE) {
                amount += array.length;
            }
            if (array.length == 0) {
                System.out.println(Arrays.toString(array));
                break;
            }
            if (amount > 0) {
                int[] newArray = new int[array.length];
                for (int i = 0; i < array.length; i++) {//Werte des ursprünglichen Arrays ins neue Array
                    newArray[i] = array[i];
                }
                for (int i = 0; i < amount; i++) {
                    int y; //letzte Array index
                    y = newArray[newArray.length - 1];
                    for (int j = newArray.length - 1; j > 0; j--) {//Array Stelle wechselt um 1
                        newArray[j] = newArray[j - 1];
                    }
                    newArray[0] = y;
                }
                for (int i = 0; i < newArray.length; i++) {
                    array[i] = newArray[i];
                }
                System.out.println(Arrays.toString(array));
            }
            else if (amount < 0) {
                int[] newArray = new int[array.length];
                for (int i = 0; i < array.length; i++) {//Werte des ursprünglichen Arrays ins neue Array
                    newArray[i] = array[i];
                }
                for (int i = 0; i < amount * -1; i++) {
                    int y; //erste Array index
                    y = newArray[0];
                    for (int j = 0; j < newArray.length - 1; j++) {//Array Stelle wechselt um 1
                        newArray[j] = newArray[j + 1];
                    }
                    newArray[newArray.length - 1] = y;
                }
                for (int i = 0; i < newArray.length; i++) {
                    array[i] = newArray[i];
                }
                System.out.println(Arrays.toString(array));

            }
            else {
                int[] newArray = new int[array.length];
                for (int i = 0; i < array.length; i++) {//Werte des ursprünglichen Arrays ins neue Array
                    newArray[i] = array[i];
                }
                for (int i = 0; i < newArray.length; i++) {
                    array[i] = newArray[i];
                }
                System.out.println(Arrays.toString(array));
            }
        }


    }

    /** Zählt die Anzahl an Vorkommen jeder Zahl im übergebenen Array, die in diesem mindestens einmal vorkommt.
     *  Die Rückgabe erfolgt über ein 2D-Array, bei dem jedes innere Array aus zwei Einträgen besteht: Einer Zahl,
     *  die im übergebenen Array vorkommt sowie der Anzahl an Vorkommen dieser.
     *  Für jede im übergebenen Array vorkommenden Zahl gibt es ein solches inneres Array.
     *  Diese tauchen im Rückgabewert in der gleichen Reihenfolge auf, in der die jeweils ersten Vorkommen der Zahlen
     *  im übergebenen Array auftauchen.
     *
     * @param array Ein beliebiges Integer-Array
     * @return Das Array mit den Vielfachheiten der einzelnen Zahlen, wiederum als Integer-Arrays mit zwei Einträgen dargestellt.
     */
    public static int[][] quantities(int[] array) {
        // TODO
        int z = 0;// Vorkommende Zahlen
        ArrayList<Integer> y = new ArrayList<>(); //unterschiedliche Zahlen
        for (int i = 0; i < array.length; i++) {
            if (!y.contains(array[i])) {
                y.add(array[i]);
            }
        }
        z = y.size();

        int[][] array2d = new int[z][2];
        for (int i = 0; i < z; i++) {
           array2d[i][0] = y.get(i);
        }


        int i = 0;
        for (int k = 0; k < z; k++) {
            int c = 0;
            for (int j = 0; j < array.length; j++) {
                if (y.get(k) == array[j]) {
                        c++;
                }
            }
            if (i < z) {
            array2d[i][1] = c;
            }
            i++;
        }
        return array2d;
    }
}
