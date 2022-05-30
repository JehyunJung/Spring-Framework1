package hello.hellospring;

import hello.hellospring.repository.JDBCMemberRepositry;
import hello.hellospring.repository.JDBCTemplateMemberRepositry;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import javax.swing.*;

@Configuration
public class SpringConfig {
    private DataSource dataSource;

    public SpringConfig(DataSource dataSource){
        this.dataSource=dataSource;
    }
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository(){
        //return  new MemoryMemberRepository();
        //return new JDBCMemberRepositry(dataSource);
        return new JDBCTemplateMemberRepositry(dataSource);
    }
}
