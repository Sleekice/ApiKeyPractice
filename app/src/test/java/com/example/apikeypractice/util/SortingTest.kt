package com.example.apikeypractice.util

import junit.framework.TestCase
import org.junit.Test

class SortingTest {

    @Test
    fun testProcessArray() {
        val arrayInput = "2 3 6 2 3 2"
        val sorting = Sorting()

        // Test with "2" replaced by "1"
        val expectedOutput = "111363"
        val actualOutput = sorting.processArray("6", arrayInput, "2")
        TestCase.assertEquals(expectedOutput, actualOutput)

        // Test with "3" replaced by "1"
        val expectedOutput2 = "211323"
        val actualOutput2 = sorting.processArray("6", arrayInput, "3")
        TestCase.assertEquals(expectedOutput2, actualOutput2)
    }

    @Test
    fun testConvertInputToInt() {
        val sorting = Sorting()

        val result = sorting.convertInputToInt("6", "2 3 6 2 3 2", "2")
        TestCase.assertEquals(6, result.first)
        TestCase.assertEquals(listOf(2, 3, 6, 2, 3, 2), result.second)
        TestCase.assertEquals(2, result.third)
    }

    @Test
    fun testReplaceNumberWithOne() {
        val sorting = Sorting()
        val arrayItems = mutableListOf(2, 3, 6, 2, 3, 2)
        sorting.replaceNumberWithOne(arrayItems, 2)
        TestCase.assertTrue(arrayItems.all { it == 1 || it == 3 || it == 6 })
    }

    @Test
    fun testConcatenateArrayToString() {
        val sorting = Sorting()
        val arrayItems = listOf(1, 3, 6, 1, 3, 1)
        val result = sorting.concatenateArrayToString(arrayItems)
        TestCase.assertEquals("136131", result)
    }


}