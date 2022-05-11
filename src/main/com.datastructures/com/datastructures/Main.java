package com.datastructures;

import hashtable.HashTable;

public class Main {


    public static void main(String[] args) {
	// write your code here
        HashTable hashTable = new HashTable(30);
        String[] elementsToAdd = {"100", "510", "170", "214", "268", "398","235", "802", "900", "723", "699",
                "1", "16", "999", "890","725", "998", "978", "988", "990", "989", "984", "320", "321",
                "400", "415", "450", "50", "660", "624"};

        String[] elementsToAdd2 = {"30", "60", "90", "120", "150", "180",
                "210", "240", "270", "300", "330", "360", "390", "420", "450",
                "480", "510", "540", "570", "600", "989", "984", "320", "321",
                "400", "415", "450", "50", "660", "624"};

        hashTable.insertHashFunction2(elementsToAdd2, hashTable.theArray);

//        hashTable.findKey("660");
        hashTable.increaseArraySize(60);


        hashTable.displayTheStack();

        hashTable.fillArrayWithNeg1();

        hashTable.doubleHashFunction(elementsToAdd2, hashTable.theArray);

        hashTable.displayTheStack();

        hashTable.findKeyDoubleHash("989");
    }
}
