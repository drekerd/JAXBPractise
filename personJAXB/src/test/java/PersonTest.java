
import com.sun.xml.internal.ws.util.Pool;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.junit.Assert;
import org.junit.Test;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mariosilva
 */
public class PersonTest {
   
    private JAXBContext context;
    
    @Test
    public void perstonTestResutlTrue() throws JAXBException{
        this.context = JAXBContext.newInstance(Person.class);
        
        String file = "../personJAXB/PersonFile.xml";
        
        Person insertPerson = new Person();
        insertPerson.setName("Mario");
        insertPerson.setAge(29);
        insertPerson.setChocolate("Toblerone");
        
        Marshaller marshaller = this.context.createMarshaller();
        marshaller.marshal(insertPerson, new File(file));
        
        Unmarshaller unmarshaller = this.context.createUnmarshaller();
        
        Person returnedPerson = (Person)unmarshaller.unmarshal(new File(file));
        
        System.out.println("Unmarshaller\n"+ insertPerson+"\n"+returnedPerson);
        
        /*Needed to make the test argument by argument, 
        because it was failing comparing ("insertedPerson, returnedPerson")
        */
        
        Assert.assertEquals(insertPerson.getName(), returnedPerson.getName());
        Assert.assertEquals(insertPerson.getAge(), returnedPerson.getAge());
        Assert.assertEquals(insertPerson.getChocolate(), returnedPerson.getChocolate());
        
        
    }
    
   
}
