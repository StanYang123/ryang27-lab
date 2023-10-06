Question 1:

My business area is zoos.

My entity also includes animal entities and administrator entities. Administrator ->Zoo ->Animals

@SpringBootTest
@Transactional
public class Junit01 {

    @Autowired
    private EventMapper eventMapper;

    private static EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction tx;


    @BeforeEach
    public void beforeEach() {
        em = emf.createEntityManager();
        tx = em.getTransaction();
        Event event =new Event();
        tx.begin();
        em.persist(event);
        tx.commit();
    }

    /**
     * Add data
     */
    @Test
    public void testCreate(){
        Event event = new Event();
        event.setDate(new Date());
        event.setName("Zoo");
        event.setRemark("New York Zoo");
        event.setType("openness");
        eventMapper.insert(event);
    }

    /**
     * query data
     */
    @Test
    public void testRead(){
        LambdaQueryWrapper<Event> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Event::getName,"Zoo");
        Event event = eventMapper.selectOne(queryWrapper);
        System.out.println(event.toString());
        assertNotNull(event);
        assertEquals("Fluffykins", event.getName());
    }

    /**
     * update data
     */
    @Test
    public void testUpdate(){
        Event event = new Event();
        event.setDate(new Date());
        event.setName("Zoo1");
        event.setRemark("New York Zoo");
        event.setType("openness");
        LambdaUpdateWrapper<Event> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(Event::getName,"Zoo");
        eventMapper.update(event,wrapper);
    }

    /**
     * delete data
     */
    @Test
    public void testDelete(){
        LambdaQueryWrapper<Event> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Event::getName,"Zoo");
        eventMapper.delete(wrapper);
    }

}