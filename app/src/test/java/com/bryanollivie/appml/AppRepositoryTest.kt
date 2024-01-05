package com.bryanollivie.appml

import com.bryanollivie.appml.data.local.LocalRepository
import com.bryanollivie.appml.data.local.entity.ResponseEntity
import com.bryanollivie.appml.data.remote.RemoteProdRepository
import com.bryanollivie.appml.domain.repository.AppRepository
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import javax.inject.Inject

/*

class AppRepositoryTest {
    private lateinit var fakeLocalDataSource: FakeLocalDataSource
    private lateinit var repository: AppRepository

    @Before
    fun setup() {
        fakeLocalDataSource = FakeLocalDataSource()
        repository = AppRepository(fakeLocalDataSource)
    }

    @Test
    fun testSaveAndRetrieveData() = runBlocking {
        val testData = MyData("id1", "Test Data")
        repository.saveData(testData)

        val retrievedData = repository.getData("id1")
        assertEquals(testData, retrievedData)
    }

    // Outros testes...
}
*/

//
/*class AppRepositoryTest {

    *//*@get:Rule
    var hiltRule = HiltAndroidRule(this)*//*

    private lateinit var repository: AppRepository
    private val localDataSource: LocalRepository = Mockito.mock(LocalRepository::class.java)
    private val remoteDataSource: RemoteProdRepository = Mockito.mock(RemoteProdRepository::class.java)

    *//*@Inject
    lateinit var localDataSource: LocalRepository*//*

  *//*  @Inject
    lateinit var remoteDataSource: RemoteProdRepository*//*

    //private lateinit var repository: AppRepository

    @Before
    fun init() {
        //hiltRule.inject()

        repository = AppRepository(localDataSource,remoteDataSource)

        // Configurando o comportamento do mock
        Mockito.`when`(localDataSource.getSearchByQuery(Mockito.mock(String::class.java))).thenReturn(Mockito.mock(ResponseEntity::class.java))
        //Mockito.`when`(localDataSource.getSearchByQuery(Mockito.mock(String::class.java))).thenReturn(listOf(MyData(...)))


    }

    @Test
    fun testGetData() {
        // Teste para verificar se os dados são obtidos corretamente
        val data = repository.getAllProductsBySearch(Mockito.mock(String::class.java))
        Assert.assertEquals(data, ResponseEntity::class.java)
    }
}*/

