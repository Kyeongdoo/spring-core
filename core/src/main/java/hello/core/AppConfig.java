package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemortMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;

public class AppConfig {

//    //생성자 주입
//    public MemberService memberService() {
//        return new MemberServiceImpl(new MemortMemberRepository());
//    }
//    //생성자 주입
//    public OrderService orderService() {
//        return new OrderServiceImpl(new MemortMemberRepository(), new FixDiscountPolicy());

    //저장소 역할
    @Bean
    public MemberRepository memberRepository(){
         return  new MemortMemberRepository();
    }
    //할인 정책의 역할
    @Bean
    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }
    // MemberService 역할 (생성자 주입)
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl( memberRepository() );
    }
    //OrderService 역할 (생성자 주입)
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
}
