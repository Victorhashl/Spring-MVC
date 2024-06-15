package org.firstgradle.firstgradle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstGradleApplication implements CommandLineRunner {


//  Field injection is not preferred due to possibility of NullPointer Exception
//  @Autowired
    DB myDB;

//  Instead prefer constructor injection which reduces the chances of getting an Exception
    @Autowired
    public FirstGradleApplication(DB myDB) {
        this.myDB = myDB;
    }

    public static void main(String[] args) {

        SpringApplication.run(FirstGradleApplication.class, args);
        //tight coupling as at every time of testing we need to change the DB type
        ProdDB myProdDB = new ProdDB();
        System.out.println(myProdDB.getData());

        DevDB myDevDB = new DevDB();
        System.out.println(myDevDB.getData());
    }

    @Override
    public void run(String... args) throws Exception {
//      myDB =new ProdDB();
        System.out.println("Ye pehle run hoga");
        System.out.println(myDB.getData());
    }
}
