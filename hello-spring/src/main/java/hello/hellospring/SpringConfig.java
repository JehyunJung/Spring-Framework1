package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.JPAMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    /* Jpa
    private EntityManager entityManager;
    @Autowired
    public SpringConfig(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
*/
    /* JDBC
    private DataSource dataSource;


    public SpringConfig(DataSource dataSource){
        this.dataSource=dataSource;
    }*/
    @Autowired
    private MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }
   /* @Bean
    public MemberRepository memberRepository(){
        *//*return  new MemoryMemberRepository();
        return new JDBCMemberRepositry(dataSource);
        return new JDBCTemplateMemberRepositry(dataSource);*//*
        return new JPAMemberRepository(entityManager);
    }*/
    /*@Bean
    public TimeTraceAop timeTraceAop() {
        return new TimeTraceAop();
    }*/
}
