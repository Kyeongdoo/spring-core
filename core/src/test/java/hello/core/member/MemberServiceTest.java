package hello.core.member;

import hello.core.AppConfig;
import hello.core.order.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class MemberServiceTest {

//    MemberService memberService = new MemberServiceImpl();

    MemberService memberService;
    OrderService orderService;


    @BeforeEach
    void setUp() {

        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void join() {

        Member memberA = new Member(1L, "memberA", Grade.VIP);
        Member memberB = new Member(2L, "memberB", Grade.VIP);

        memberService.join(memberA);
        memberService.join(memberB);

        Member findMemberA = memberService.findById(1L);
        Member findMemberB = memberService.findById(2L);

        Assertions.assertThat(memberA).isEqualTo(findMemberA);
        Assertions.assertThat(memberA).isNotEqualTo(findMemberB);
    }

    @Test
    void findById() {
    }
}