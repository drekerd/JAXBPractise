/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author mariosilva
 */
public class PersonService {

    JAXBContext jaxbContext;

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    /*public String getName() throws FileNotFoundException, JAXBException, IOException {

        String file = "Person.xml";
        JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);

        // Read
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        InputStream inputStream = new FileInputStream(file);
        Person person = (Person) unmarshaller.unmarshal(inputStream);
        inputStream.close();

        System.out.println(person.getName());

        return person.getName();

    }*/

    public String getPerson() throws FileNotFoundException, JAXBException, IOException {
   
        this.jaxbContext = JAXBContext.newInstance(Person.class);
        String file = "/home/mariosilva/NetBeansProjects/mavenproject2/personJAXB/PersonFile.xml";
       

        // Read
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
         InputStream inputStream = new FileInputStream(file);
         Person person = (Person)unmarshaller.unmarshal(inputStream);
         inputStream.close();
    

       // System.out.println("ASDASDADAS" + person.getName());      
        return person.toString();

    }

    /*        Marshaller marshaller = jaxbContext.createMarshaller();
     OutputStream outputStream = new FileOutputStream(file);
     marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
     marshaller.marshal(device, outputStream);
     outputStream.close();*/
}
