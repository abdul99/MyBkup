package com.springprojects.blog.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springprojects.blog.domain.User;
import com.springprojects.blog.repositories.UserMongoRepository;
 
@SpringBootTest
public class UserMongoRepositoryTest {
    @Autowired
    private UserMongoRepository userMongoRepository;
 
 
    @Before
    public void setUp() throws Exception {
        User user1= new User("Alice", 23);
        User user2= new User("Bob", 38);
        //save product, verify has ID value after save
        assertNull(user1.getId());
        assertNull(user2.getId());//null before save
        this.userMongoRepository.save(user1);
        this.userMongoRepository.save(user2);
        assertNotNull(user1.getId());
        assertNotNull(user2.getId());
    }
 
    @Test
    public void testFetchData(){
        /*Test data retrieval*/
        User userA = userMongoRepository.findByName("Bob");
        assertNotNull(userA);
        assertEquals(38, userA.getAge());
        /*Get all products, list should only have two*/
        Iterable<User> users = userMongoRepository.findAll();
        int count = 0;
        for(User p : users){
            count++;
        }
        assertEquals(count, 2);
    }
 
    @Test
    public void testDataUpdate(){
        /*Test update*/
        User userB = userMongoRepository.findByName("Bob");
        userB.setAge(40);
        userMongoRepository.save(userB);
        User userC= userMongoRepository.findByName("Bob");
        assertNotNull(userC);
        assertEquals(40, userC.getAge());
    }
 
    @After
    public void tearDown() throws Exception {
      this.userMongoRepository.deleteAll();
    }
 
}
