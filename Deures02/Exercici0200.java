package com.exercicis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Exercici0200 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(addImaginaries("1+2i", "4+5i"));

        drawPascal(5);

        ArrayList<Double> list = new ArrayList<>(Arrays.asList(1.5, 2.3, 3.7));
        System.out.println(addList(list));

        int[][] matrixA = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        printMatrix(matrixA);

        int[][] matrixB = { { 1, 2, 3 }, { 4, 5, 6 } };
        int[][] matrixC = {
                { 1, 2, 3, 4, 5 },
                { 6, 7, 8, 9, 10 },
                { 11, 12, 13, 14, 15 },
                { 16, 17, 18, 19, 20 }
        };

        printMatrix(transpose(matrixB));
        printMatrix(transpose(matrixC));

        System.out.println(firstNonRepeated("swiss")); // w
        System.out.println(firstNonRepeated("redivider")); // v
        System.out.println(firstNonRepeated("aabbcc")); // _

        System.out.println(inverInt(3645));

        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(3, 6, 1, 5, 0));
        System.out.println(minMaxAdd(nums));

        System.out.println(sumaSenseSumar(5, 6) + ":" + sumaSenseSumar(-3, 3) + ":" + sumaSenseSumar(10, -4));

        System.out.println(minDistances("algoritmo", 'o'));
        System.out.println(minDistances("abcdefga", 'a'));

        System.out.println(findUniqueNumber(new ArrayList<>(Arrays.asList(2.0, 2.0, 1.0))));
        System.out.println(findUniqueNumber(new ArrayList<>(Arrays.asList(4.0, 1.0, 2.0, 1.0, 2.0))));

        scanner.close();
    }

    /**
     * Fes una funció que sumi números inmaginaris
     * definits per una cadena de text
     * 
     * "1+2i" + "4+5i" = "5+7i"
     * 
     * @param String el primer número imaginari
     * @param String el segon número imaginari
     * @return String el resultat de la suma
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0200#testAddImaginariesSimple
     * @test ./runTest.sh com.exercicis.TestExercici0200#testAddImaginariesNegative
     * @test ./runTest.sh com.exercicis.TestExercici0200#testAddImaginariesZero
     * @test ./runTest.sh
     *       com.exercicis.TestExercici0200#testAddImaginariesWithZeroRealPart
     * @test ./runTest.sh
     *       com.exercicis.TestExercici0200#testAddImaginariesWithZeroImaginaryPart
     * @test ./runTest.sh
     *       com.exercicis.TestExercici0200#testAddImaginariesLargeNumbers
     */
    public static String addImaginaries(String num0, String num1) {
        String[] part0 = num0.split("\\+");
        String[] part1 = num1.split("\\+");
        int real0 = Integer.parseInt(part0[0].trim());
        int imag0 = Integer.parseInt(part0[1].trim());
        int real1 = Integer.parseInt(part1[0].trim());
        int imag1 = Integer.parseInt(part1[1].trim());
        int real = real0 + real1;
        int imag = imag0 + imag1;
        return real + "+" + imag + "i";
    }

    /**
     * Fes un programa que dibuixi el triangle de pascal
     * 
     * @param int nivells del triangle (0 fins a n)
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0200#testDrawPascalZero
     * @test ./runTest.sh com.exercicis.TestExercici0200#testDrawPascalOne
     * @test ./runTest.sh com.exercicis.TestExercici0200#testDrawPascalTwo
     * @test ./runTest.sh com.exercicis.TestExercici0200#testDrawPascalThree
     * @test ./runTest.sh com.exercicis.TestExercici0200#testDrawPascalFive
     */
    public static void drawPascal(int n) {
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();
        for (int row = 0; row < n; row++) {
            ArrayList<Integer> currentRow = new ArrayList<>();
            for (int col = 0; col <= row; col++) {
                if (col == 0 || col == row) {
                    currentRow.add(1);
                } else {
                    int value = triangle.get(row - 1).get(col - 1) + triangle.get(row - 1).get(col); 
                    currentRow.add(value); 
                }
            }
            triangle.add(currentRow); 
        }

        // Print the Pascal's Triangle
        for (ArrayList<Integer> row : triangle) {
            for (Integer num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    /**
     * Fes una funció que sumi els valors d'un ArrayList<double>
     * 
     * @param llista de valors
     * @return resultat de la suma
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0200#testAddListEmpty
     * @test ./runTest.sh com.exercicis.TestExercici0200#testAddListSingleElement
     * @test ./runTest.sh com.exercicis.TestExercici0200#testAddListMultipleElements
     * @test ./runTest.sh com.exercicis.TestExercici0200#testAddListNegativeNumbers
     * @test ./runTest.sh com.exercicis.TestExercici0200#testAddListMixedNumbers
     * @test ./runTest.sh com.exercicis.TestExercici0200#testAddListDecimals
     */
    public static double addList(ArrayList<Double> list) {
        Double rst = 0.0;
        for (Double num : list) {
            rst += num;
        }
        return rst;
    }

    /**
     * Fes una funció que dibuixi els valors d'una matriu
     * int[][] entrada = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
     * 
     * @param int[][] matriu a dibuixar
     * 
     * @test ./runTest.sh
     *       com.exercicis.TestExercici0200#testPrintMatrixSingleElement
     * @test ./runTest.sh com.exercicis.TestExercici0200#testPrintMatrixRow
     * @test ./runTest.sh com.exercicis.TestExercici0200#testPrintMatrixColumn
     * @test ./runTest.sh com.exercicis.TestExercici0200#testPrintMatrixSquare
     * @test ./runTest.sh com.exercicis.TestExercici0200#testPrintMatrixRectangular
     * @test ./runTest.sh com.exercicis.TestExercici0200#testPrintMatrixEmpty
     */
    public static void printMatrix(int[][] matrix) {
        for (int[] mtrx : matrix) {
            for (int j = 0; j < mtrx.length; j++) {
                if (j != (mtrx.length) - 1) {
                    System.out.print(mtrx[j] + ", ");
                } else {
                    System.out.println(mtrx[j]);
                }
            }
        }
    }

    /**
     * Fes una funció que retorni la trasposada d'una matriu
     * 
     * int[][] entrada = { {1, 2, 3}, {4, 5, 6} };
     * int[][] sortida = { {1, 4}, {2, 5}, {3, 6} };
     * 
     * int[][] entrada = {
     * {1, 2, 3, 4, 5},
     * {6, 7, 8, 9, 10},
     * {11, 12, 13, 14, 15},
     * {16, 17, 18, 19, 20} };
     * 
     * int[][] sortida = {
     * {1, 6, 11, 16},
     * {2, 7, 12, 17},
     * {3, 8, 13, 18},
     * {4, 9, 14, 19},
     * {5, 10, 15, 20}
     * };
     * 
     * @param int[][] matriu a transposar
     * @return int[][] matriu transposada
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0200#testTransposeSquareMatrix
     * @test ./runTest.sh
     *       com.exercicis.TestExercici0200#testTransposeRectangularMatrix
     * @test ./runTest.sh com.exercicis.TestExercici0200#testTransposeColumnMatrix
     * @test ./runTest.sh com.exercicis.TestExercici0200#testTransposeSingleElement
     */
    public static int[][] transpose(int[][] matrix) {
        int fils = matrix.length;
        int cols = matrix[0].length;
        int[][] transposedMatrix = new int[cols][fils];

        for (int i = 0; i < fils; i++) {
            for (int j = 0; j < cols; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < fils; j++) {
                System.out.print(transposedMatrix[i][j]);
                if (j != (fils - 1)) {
                    System.out.print(",");
                }
            }
            System.out.println();
        }

        return transposedMatrix;
    }

    /**
     * Fes una funció que troba el primer caràcter que
     * no es repeteix dins d'una cadena de text
     * si totes les lletres es repeteixen torna '_'
     * 
     * Exemple:
     * 
     * Entrada: "swiss"
     * Sortida: 'w'
     * 
     * Entrada: "redivider"
     * Sortida: 'v'
     * 
     * @param String cadena de text
     * @return char primer caràcter que no es repeteix
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0200#testFirstNonRepeatedBasic
     * @test ./runTest.sh
     *       com.exercicis.TestExercici0200#testFirstNonRepeatedAllRepeated
     * @test ./runTest.sh
     *       com.exercicis.TestExercici0200#testFirstNonRepeatedLongString
     */
    public static char firstNonRepeated(String str) {

        HashMap<Character, Integer> count = new HashMap<>();

        for (char letter : str.toCharArray()) {
            count.put(letter, count.getOrDefault(letter, 0) + 1);
        }

        for (char letter : str.toCharArray()) {
            if (count.get(letter) == 1) {
                return letter;
            }
        }

        return '_';
    }

    /**
     * Fes una funció que inverteixi els caràcters
     * d'un número enter: 3645 > 5463
     * 
     * @param int número a invertir
     * @return int número resultant
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0200#testInverIntPositive
     * @test ./runTest.sh com.exercicis.TestExercici0200#testInverIntWithZeros
     * @test ./runTest.sh com.exercicis.TestExercici0200#testInverIntSingleDigit
     */
    public static int inverInt(int num) {
        String numstr = Integer.toString(num);
        String rst = "";
        for (int i = numstr.length() - 1; i >= 0; i--) {
            rst += numstr.charAt(i);
        }

        return Integer.parseInt(rst);
    }

    /**
     * Fes una funció que rebi una llista (`ArrayList`) amb 5 números
     * i calculi el número més petit i el número més gran
     * que es poden calcular sumant 4 dels 5 números rebuts.
     * 
     * Exemple:
     * 
     * Entrada: [3, 6, 1, 5, 0]
     * Sortida: [9, 15]
     * 
     * Explicació:
     * 9 = 0 + 1 + 3 + 5 (sumant els quatre números més petits)
     * 15 = 1 + 3 + 5 + 6 (sumant els quatre números més grans)
     * 
     * @param ArrayList<Integer> nums Llista de números d'entrada (exactament 5
     *                           números)
     * @return ArrayList<Integer> Llista amb els dos números de sortida [mínim,
     *         màxim]
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0200#testMinMaxAddBasic
     * @test ./runTest.sh com.exercicis.TestExercici0200#testMinMaxAddWithNegatives
     * @test ./runTest.sh com.exercicis.TestExercici0200#testMinMaxAddWithDuplicates
     */
    public static ArrayList<Integer> minMaxAdd(ArrayList<Integer> nums) {
        int number = 0;
        int final_number = 0;

        nums.sort((a, b) -> a.compareTo(b));

        System.out.println(nums);

        for (int i = 0; i < nums.size() - 1; i++) {
            number = number + nums.get(i); // petits
        }

        nums.sort((a, b) -> b.compareTo(a));

        System.out.println(nums);

        for (int i = 0; i < nums.size() - 1; i++) {
            final_number = final_number + nums.get(i);
        }

        return new ArrayList<>(Arrays.asList(number, final_number));
    }

    /**
     * Fes una funció que sumi dos números sense fer servir
     * la operació de suma.
     * 
     * Exemple:
     * 
     * Entrada: 5, 7
     * Sortida: 12
     * 
     * Entrada: -3, 3
     * Sortida: 0
     * 
     * @param int a Primer número a sumar
     * @param int b Segon número a sumar
     * @return int Resultat de la suma de a i b sense utilitzar l'operació de suma
     * 
     * @test ./runTest.sh
     *       com.exercicis.TestExercici0200#testSumaSenseSumarPositiveNumbers
     * @test ./runTest.sh
     *       com.exercicis.TestExercici0200#testSumaSenseSumarNegativeNumbers
     * @test ./runTest.sh
     *       com.exercicis.TestExercici0200#testSumaSenseSumarPositiveAndNegative
     * @test ./runTest.sh com.exercicis.TestExercici0200#testSumaSenseSumarZero
     * @test ./runTest.sh
     *       com.exercicis.TestExercici0200#testSumaSenseSumarLargeNumbers
     */
    public static int sumaSenseSumar(int a, int b) {

        String ax = "x".repeat(a);
        String bx = "x".repeat(b);
        Integer al = ax.length();
        Integer bl = bx.length();
        if (a < 0 && b > 0 || a > 0 && b < 0) {
            if (a < 0) {
                return bl - al;
            } else {
                return al - bl;
            }
        } else if (a < 0 && b < 0) {
            Integer suma = al + bl;
            return -(suma);
        } else {
            return al + bl;
        }
    }

    /**
     * Fes una funció que retorni les distàncies mínimes
     * de cada lletra fins a un caràcter d'una cadena de text.
     * 
     * Exemple:
     * 
     * Entrada: "algoritmo", 'o'
     * Sortida: [3, 2, 1, 0, 1, 2, 2, 1, 0]
     * 
     * Entrada: "abcdefga", 'a'
     * Sortida: [0, 1, 2, 3, 3, 2, 1, 0]
     * 
     * @param String text Cadena de text d'entrada
     * @param char   target Caràcter objectiu
     * @return ArrayList<Integer> Llista de distàncies mínimes de cada lletra fins
     *         al caràcter objectiu
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0200#testMinDistancesBasic
     * @test ./runTest.sh
     *       com.exercicis.TestExercici0200#testMinDistancesMultipleTargets
     * @test ./runTest.sh
     *       com.exercicis.TestExercici0200#testMinDistancesNoTargetFound
     */
    public static ArrayList<Integer> minDistances(String text, char target) {
        int textLength = text.length();
        int[] left = new int[textLength];
        int[] right = new int[textLength];

        // Inicialitzar els arrays amb la longitud de la cadena
        Arrays.fill(left, textLength);
        Arrays.fill(right, textLength);

        // Distàncies mínimes de l'esquerra a la dreta
        int lastTargetIndex = -textLength;
        for (int cntChar = 0; cntChar < textLength; cntChar = cntChar + 1) {
            if (text.charAt(cntChar) == target)
                lastTargetIndex = cntChar;
            left[cntChar] = cntChar - lastTargetIndex;
        }

        // Distàncies mínimes de la dreta a l'esquerra
        lastTargetIndex = 2 * textLength;
        for (int cntChar = (textLength - 1); cntChar >= 0; cntChar = cntChar - 1) {
            if (text.charAt(cntChar) == target)
                lastTargetIndex = cntChar;
            right[cntChar] = lastTargetIndex - cntChar;
        }

        // Formar la llista de distàncies mínimes
        ArrayList<Integer> distances = new ArrayList<>(textLength);
        for (int cntChar = 0; cntChar < textLength; cntChar = cntChar + 1) {
            distances.add(Math.min(left[cntChar], right[cntChar]));
        }

        return distances;
    }

    /**
     * A partir d'una llista de números on cada
     * número es repeteix dos cops excepte un, troba
     * el número que no es repeteix.
     * 
     * Exemple:
     * 
     * Entrada: [2.0, 2.0, 1.0]
     * Sortida: 1.0
     * 
     * Entrada: [4.0, 1.0, 2.0, 1.0, 2.0]
     * Sortida: 4.0
     * 
     * @param ArrayList<Double> nums Llista de números d'entrada
     * @return Double Número que no es repeteix
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0200#testFindUniqueNumberBasic
     * @test ./runTest.sh
     *       com.exercicis.TestExercici0200#testFindUniqueNumberMultiplePairs
     * @test ./runTest.sh
     *       com.exercicis.TestExercici0200#testFindUniqueNumberNoUnique
     */
    public static Double findUniqueNumber(ArrayList<Double> nums) {
        HashMap<Double, Integer> rst = new HashMap<>();
        for (Double num : nums) {
            if (rst.containsKey(num)) {
                rst.put(num, rst.get(num) + 1);
            } else {
                rst.put(num, 1);
            }
        }
        for (HashMap.Entry<Double, Integer> entry : rst.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return null;
    }
}
