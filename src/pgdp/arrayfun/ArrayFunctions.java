package pgdp.arrayfun;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.*;

public class ArrayFunctions {

    protected ArrayFunctions() {
        throw new IllegalStateException("Don't create objects of type 'ArrayFunctions'!");
    }

    public static void main(String[] args) {
        //example call
       System.out.println(Arrays.toString(zip(new int[]{1, 3, 5, 7, 9, 11}, new int[]{2, 4, 6, 8, 10, 12, 14})));
        //int[] array = new int[] {2000000000, 2000000000, 2000000000};
        //System.out.println(sumOfSquares(array));

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
        return null;
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
        return null;
    }

    /** Rotiert das übergebene Array um die übergebene Anzahl an Schritten nach rechts.
     *  Das Array wird In-Place rotiert. Es gibt keine Rückgabe.
     *
     * @param array Ein beliebiges Integer-Array
     * @param amount Ein beliebiger Integer
     */
    public static void rotate(int[] array, int amount) {
        //TODO
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
        return null;
    }
}
