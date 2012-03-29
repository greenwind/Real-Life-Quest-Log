package pl.greenwind.reallifequestlog;

import java.util.logging.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.greenwind.reallifequestlog.dao.DAO;

public class Main 
{
    
    private final static Logger log = Logger.getLogger(Main.class.getName());
    
    public static void main( String[] args )
    {
        String path = "file:src/main/resources/pl/greenwind/reallifequestlog/";
        ApplicationContext ac = new ClassPathXmlApplicationContext(
                path + "applicationContext.xml", 
                path + "applicationContext-datasource.xml", 
                path + "applicationContext-transactions.xml");
        
        DAO dao = ac.getBean(DAO.class);
        
 /*              Quest quest = new Quest();
        quest.setDateStart(new Date());
        quest.setName("Create Real Life Quest Log application");
        quest.setTypeId(0); //mental
        quest.setXp(50);
        Serializable quest1Id = dao.save(quest);
        Quest quest2 = new Quest();
        quest2.setDateStart(new Date());
        quest2.setName("Create spring configuration");
        quest2.setTypeId(0); //mental
        quest2.setXp(5);
        quest2.setParent(quest);
        Serializable quest2Id = dao.save(quest2);
         
        Collection<Quest> parents = dao.getByParentQuestId(null);
        
        System.out.println(parents);
        
        Quest quest3 = new Quest();
        quest3.setDateStart(new Date());
        quest3.setName("Create mappings and dao");
        quest3.setTypeId(0); //mental
        quest3.setXp(5);
        quest3.setParent(parents.iterator().next());
        Serializable quest3Id = dao.save(quest3);
        */
        
        System.out.println(dao.getAll());
        
        System.out.println( "Hello World!" );
    }
    
    
}
