/*
 * *
 *  * Copyright (c) 2015 Ivan Hristov
 *  * <p/>
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  * <p/>
 *  * http://www.apache.org/licenses/LICENSE-2.0
 *  * <p/>
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package org.ingini.spring.boot.mongodb;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.net.UnknownHostException;
import java.util.Collection;


@SpringBootApplication
public class InginiMain {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(InginiMain.class, args);
    }

    //@Bean
    /*public Jongo jongo() throws UnknownHostException {
        DB db;
        db = new MongoClient("127.0.0.1", 27017).getDB("world");
        return new Jongo(db);
    }
   */
    
    @Bean
    public MongoClient createConnection() {
 
        return new MongoClient("127.0.0.1:27017");
    }
    
    
    @Bean
    public Collection<DB> users() {
    	Collection<DB> coll = createConnection().getUsedDatabases();
    	return coll;
       // return jongo().getCollection("users");
    }

}
