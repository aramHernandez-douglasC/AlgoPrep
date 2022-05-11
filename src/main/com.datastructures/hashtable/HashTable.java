package hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * HASH TABLES (hash map in java)
 * It's a derived form an array.
 *
 * Insertion: instead of indexing the array from 0 to n (let's call this a key), it stores a key so that the key is associated with the value
 *
 * Find: Instead of linearly go through every item of the array, the hash table performs a hash function which calculates the position of the key based on
 * the value itself
 *
 * HASHING ALGORITHM
 * Calculation applied to a key to transform it into an address
 *
 * i.e :
 * For numeric values
 *
 *      address = key % n
 *
 *      where n = number of available addresses
 *
 * For alphanumeric values
 *
 *      address = sum(asciiCodes) % n
 *
 *      where n = number of available addresses
 *
 * It should minimize collisions
 * uniform distribution of hash values
 * easy to calculate
 *
 * COLLISIONS
 *
 * sometimes the algorithms return the same address for different values which will cause a collision. the way to solve this is to add an open addressing which means
 * to put the item any other open space. for example linear proving which uses a linear search to find the next available slot
 *
 * How to avoid them:
 *      - Using linear proving BUT this could provoke clustering (having empty slots on the array)
 *      - Increasing the size of the array once a certain limit is reach so that the array is always at 70% capacity or less
 *      - using Chaining
 *
 *
 *      CHAINING
 *      Adding a linked list to the hash table so that each address is the beginning of a linked list
 *
 *      CLOSE ADDRESSING
 *
 *
 *
 *
 * */
public class HashTable {

    private static final int STEP_DISTANCE = 7;
    private static final String NULL_STRING = "-1";

    public String[] theArray;
    private int arraySize;
    private int itemsInArray = 0;




    public HashTable(int size){
        arraySize = size;
        theArray = new String[size];
        fillArrayWithNeg1();
    }

    /**
     * Assumptions:
     * 0 <= stringsForArray[i] < theArray.size
     * */
    public void insertHashFunction1(String[] stringsForArray, String[] theArray){

        for(int n = 0; n< stringsForArray.length;n++){
            String newElement = stringsForArray[n];
            theArray[Integer.parseInt(newElement)] = newElement;
        }

    }

    /*
     * Insert function avoiding clustering
     * Instead of inserting value in the next available spot instead we will randomize where we put the value
     * */
    public void doubleHashFunction (String[] stringsForArray, String[] theArray){
        for(int n = 0; n< stringsForArray.length;n++){
            String newElement = stringsForArray[n];
            //Makes sure the index won't be bigger than array size
            int arrayIndex = Integer.parseInt(newElement) % arraySize;
            int stepDistance = STEP_DISTANCE - (Integer.parseInt(newElement) % STEP_DISTANCE);

            System.out.println("Modulus index = " + arrayIndex + " for value " + newElement);

            while(theArray[arrayIndex] != NULL_STRING){
                arrayIndex += stepDistance;

                System.out.println("Collison occured trying "+ arrayIndex + " for value " + newElement);

                arrayIndex %= arraySize;

            }

            theArray[arrayIndex] = newElement;
        }
    }


    /**
     * This function is a LINEAR PROVING example
     *
     * Assumptions:
     * - 0 < stringsForArray[i] < 999
     * - stringsForArray.length < 15
     * */
    public void insertHashFunction2(String[] stringsForArray, String[] theArray){
        for(int n = 0; n< stringsForArray.length;n++){
            String newElement = stringsForArray[n];
            //Makes sure the index won't be bigger than arraySize
            int arrayIndex = Integer.parseInt(newElement) % arraySize;
            System.out.println("Modulus index = " + arrayIndex + " for value " + newElement);

            while(theArray[arrayIndex] != NULL_STRING){
                ++arrayIndex;

                System.out.println("Collison occured trying "+ arrayIndex + " for value " + newElement);

                arrayIndex %= arraySize;

            }

            theArray[arrayIndex] = newElement;
        }
    }


    public void increaseArraySize(int minArraySize){
        int newArraySize = getNextPrime(minArraySize);
        moveOldArray(newArraySize);
    }

    private void moveOldArray(int newArraySize) {
        String [] cleanArray = removeEmptySpacesInArray(theArray);

        theArray = new String[newArraySize];

        arraySize = newArraySize;

        fillArrayWithNeg1();

        insertHashFunction2(cleanArray, theArray);

    }

    private String[] removeEmptySpacesInArray(String[] theArray) {
        ArrayList<String> stringList = new ArrayList<>();

        for(String theString: theArray){
            if(!theString.equals(NULL_STRING) && !theString.equals("")){
                stringList.add(theString);
            }
        }
        return stringList.toArray(new String[stringList.size()]);
    }

    public void fillArrayWithNeg1() {
        Arrays.fill(theArray, NULL_STRING);
    }

    public boolean isPrime(int number){

        if( number % 2 == 0){
            return false;
        }

        for (int i = 3; i * i <= number ; i+=2){
            if (number % i == 0){
                return false;
            }
        }
        return true;
    }

    /**
     * This method will get the next prime number bigger than the minNumberToCheck which will be the array.length
     *
     * @Parameter minNumberToCheck : minimum number to check
     *
     * */
    private int getNextPrime(int minNumberToCheck){
        for(int i = minNumberToCheck ; true; i++){
            if(isPrime(i)){
                return i;
            }
        }
    }

    public String findKey(String key){

        int arrayIndexHash = Integer.parseInt(key) % arraySize;

        while(theArray[arrayIndexHash] != NULL_STRING ){
            if (theArray[arrayIndexHash] == key){
                System.out.println(key + " was found in index " + arrayIndexHash);
                return theArray[arrayIndexHash];
            }

            ++arrayIndexHash;
            arrayIndexHash %= arraySize;
        }
        return null;
    }

    public String findKeyDoubleHash(String key){

        int arrayIndexHash = Integer.parseInt(key) % arraySize;

        int stepDistance = STEP_DISTANCE - (Integer.parseInt(key) % STEP_DISTANCE);

        while(theArray[arrayIndexHash] != NULL_STRING ){
            if (theArray[arrayIndexHash] == key){
                System.out.println(key + " was found in index " + arrayIndexHash);
                return theArray[arrayIndexHash];
            }

            arrayIndexHash += stepDistance;
            arrayIndexHash %= arraySize;
        }
        return null;
    }

    public void displayTheStack() {
        int increment = 0;
        int numberOfRows = (arraySize / 10) + 1;
        for (int m = 0; m < numberOfRows; m++) {
            increment += 10;
            for (int n = 0; n < 71; n++)
                System.out.print("-");
            System.out.println();
            for (int n = increment - 10; n < increment; n++) {
                System.out.format("| %3s " + " ", n);
            }
            System.out.println("|");

            for (int n = 0; n < 71; n++)
                System.out.print("-");
            System.out.println();
            for (int n = increment - 10; n < increment; n++) {
                if (n >= arraySize)
                    System.out.print("|      ");

                else if (theArray[n].equals(NULL_STRING))
                    System.out.print("|      ");


                else
                    System.out.print(String.format("| %3s " + " ", theArray[n]));
            }

            System.out.println("|");
            for (int n = 0; n < 71; n++)
                System.out.print("-");
            System.out.println();
        }
    }


}
