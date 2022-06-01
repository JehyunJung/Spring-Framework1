package hello.hellospring;

import hello.hellospring.repository.JDBCTemplateMemberRepositry;
import hello.hellospring.repository.JPAMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {
    private EntityManager entityManager;
    @Autowired
    public SpringConfig(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /*
    private DataSource dataSource;


    public SpringConfig(DataSource dataSource){
        this.dataSource=dataSource;
    }*/
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository(){
        /*return  new MemoryMemberRepository();
        return new JDBCMemberRepositry(dataSource);
        return new JDBCTemplateMemberRepositry(dataSource);*/
        return new JPAMemberRepository(entityManager);
    }
}
