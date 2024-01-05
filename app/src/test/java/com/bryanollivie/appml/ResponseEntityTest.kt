package com.bryanollivie.appml

import com.bryanollivie.appml.data.local.entity.ResponseEntity
import com.bryanollivie.appml.data.local.entity.ResultsItemEntity
import org.mockito.Mockito

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class ResponseEntityTest {

    private val productFakeList: List<ResultsItemEntity> = Mockito.mock(List::class.java) as List<ResultsItemEntity>

    @Before
    fun init(){
        Mockito.`when`(productFakeList.size).thenReturn(5)
    }
    @Test
    fun `isQueryValid_returns_true_when_query_is_notNullorBrank`() {
        val responseQuery = ResponseEntity(id = 1, query = "Test Product",results = productFakeList, country_default_time_zone = "")
        assertTrue(!responseQuery.query.isNullOrBlank())
    }
/*
    @Test
    fun `isPricePositive returns false when price is zero`() {
        val product = Product(id = 1, name = "Test Product", price = 0.0)
        assertFalse(product.isPricePositive())
    }

    @Test
    fun `isPricePositive returns false when price is negative`() {
        val product = Product(id = 1, name = "Test Product", price = -10.0)
        assertFalse(product.isPricePositive())
    }*/
}
