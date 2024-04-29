package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {

        Member memberA = new Member(1L, "memberA", Grade.VIP);

        memberService.join(memberA);

        Member findMemberA = memberService.findById(1L);

        Assertions.assertThat(memberA).isEqualTo(findMemberA);
    }

    @Test
    void findById() {
    }
}