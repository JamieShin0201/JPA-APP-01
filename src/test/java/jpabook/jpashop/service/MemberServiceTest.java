package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Transactional
@SpringBootTest
public class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Test
    void 회원가입() {
        Member member = new Member();
        member.setName("shin");

        Long savedId = memberService.join(member);
        Member foundMember = memberRepository.findOne(savedId);

        assertThat(member).isEqualTo(foundMember);
    }

    @Test
    void 중복_회원_예외() {
        Member member1 = new Member();
        member1.setName("shin");

        Member member2 = new Member();
        member2.setName("shin");

        memberService.join(member1);

        assertThrows(IllegalStateException.class, () -> memberService.join(member2));
    }
}
